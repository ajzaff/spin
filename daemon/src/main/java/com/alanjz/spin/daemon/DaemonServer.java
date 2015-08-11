package com.alanjz.spin.daemon;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DaemonServer implements Runnable {

  public static void main(String[] args) throws IOException {
    DaemonServer daemonServer;
    Thread th;

    daemonServer = new DaemonServer();
    th = new Thread(daemonServer);
    th.setDaemon(true);
    th.start();
  }

  boolean running = true;


  @Override
  public void run() {
    try {
      ServerSocket listener = new ServerSocket(9090);
      while (running) {
        Socket socket = listener.accept();
        PrintWriter out =
          new PrintWriter(socket.getOutputStream(), true);
        try {
          out.println(System.nanoTime());
        } finally {
          socket.close();
        }
      }
      listener.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }

  }
}
