package com.alanjz.spin.runner.request;

/*
    ____/ ___ \   /  __  \
   __  ) /__/ /  /  / /  /
 _____/  ____/__/__/ /__/  (c)
      __/

A P2P distributed compute and storage framework.
Copyright (C) 2015 Alan J. Zaffetti

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

import com.alanjz.spin.runner.server.SpinTimeServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;

/**
 *
 */
public class SpinRequestWorker implements Runnable {

  /**
   *
   */
  volatile protected static int cid = 1;

  /**
   *
   */
  protected SpinTimeServer spinTimeServer;

  /**
   *
   */
  protected int id;

  /**
   *
   * @param spinTimeServer
   */
  public SpinRequestWorker(SpinTimeServer spinTimeServer) {
    super();
    setSpinTimeServer(spinTimeServer);
    setId(nextId());
  }

  protected static synchronized int nextId() {
    return cid++;
  }

  protected SpinTimeServer getSpinTimeServer() {
    return spinTimeServer;
  }

  protected void setSpinTimeServer(SpinTimeServer spinTimeServer) {
    this.spinTimeServer = spinTimeServer;
  }

  public int getId() {
    return id;
  }

  protected void setId(int id) {
    this.id = id;
  }

  @Override
  public void run() {
    try {

      while(true) {
        try {
          Socket s = new Socket("localhost", 9090);
          BufferedReader input =
            new BufferedReader(new InputStreamReader(s.getInputStream()));
          String answer = input.readLine();
          System.out.println("[client " + id + "] " + answer);
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            return;
          }
          s.close();
        }
        catch (ConnectException e) {
          System.out.println("[client " + id + "]" + " cannot connect to server...");
          break;
        }
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("[client " + id + "]" + " shutting down...");
  }
}
