package com.alanjz.spin.runner.server;

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

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 */
public class SpinTimeServer implements Runnable {

  /**
   *
   */
  volatile protected static int sid = 1;

  /**
   *
   */
  protected int id;

  /**
   *
   */
  public SpinTimeServer() {
    super();
    setId(nextId());
  }

  protected static int nextId() {
    return sid++;
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
      ServerSocket listener = new ServerSocket(9090);
      int i = 0;
      while (i++ < 3) {
        Socket socket = listener.accept();
        PrintWriter out =
          new PrintWriter(socket.getOutputStream(), true);
        try {
          long nanoTime = System.nanoTime();
          System.out.println("[server " + getId() + "] " + nanoTime);
          out.println(nanoTime);
        } finally {
          socket.close();
        }
      }
      listener.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("[server " + getId() + "] shutting down...");
  }
}
