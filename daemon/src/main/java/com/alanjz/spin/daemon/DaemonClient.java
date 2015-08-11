package com.alanjz.spin.daemon;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import sun.misc.BASE64Encoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Random;

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
