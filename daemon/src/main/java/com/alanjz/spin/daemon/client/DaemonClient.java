package com.alanjz.spin.daemon.client;

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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class DaemonClient implements Runnable {

  public static void main(String[] args) throws IOException {
    DaemonClient daemonClient;
    Thread th;

    daemonClient = new DaemonClient();
    th = new Thread(daemonClient);
    th.setDaemon(true);
    th.start();
  }

  boolean running = true;

  static int nid = 1;
  int id = nid++;

  @Override
  public void run() {
    try {

      while(running) {
        Socket s = new Socket("localhost", 9090);
        BufferedReader input =
          new BufferedReader(new InputStreamReader(s.getInputStream()));
        String answer = input.readLine();
        System.out.println("[" + id + "] " + answer);
        try {
          Thread.sleep(1000);
        }
        catch (InterruptedException e) {
          return;
        }
        s.close();
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
