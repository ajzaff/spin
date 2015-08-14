package com.alanjz.spin.runner;

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

import com.alanjz.spin.runner.client.SpinRequestWorker;
import com.alanjz.spin.runner.server.SpinServer;

import java.io.IOException;

/**
 *
 */
public class SpinRunner {

  /**
   *
   */
  protected Thread serverThread;

  /**
   *
   */
  protected Thread clientThread;

  /**
   *
   */
  protected SpinServer daemonServer;

  /**
   *
   */
  protected SpinRequestWorker daemonClient;

  /**
   *
   */
  protected SpinRunner() {
    setDaemonServer(new SpinServer());
    setDaemonClient(new SpinRequestWorker(getDaemonServer()));
    setServerThread(new Thread(getDaemonServer()));
    setClientThread(new Thread(getDaemonClient()));
  }

  /**
   *
   * @param daemonServer
   */
  protected void setDaemonServer(SpinServer daemonServer) {
    this.daemonServer = daemonServer;
  }

  /**
   *
   * @param daemonClient
   */
  protected void setDaemonClient(SpinRequestWorker daemonClient) {
    this.daemonClient = daemonClient;
  }

  /**
   *
   * @param serverThread
   */
  protected void setServerThread(Thread serverThread) {
    this.serverThread = serverThread;
  }

  /**
   *
   * @param clientThread
   */
  protected void setClientThread(Thread clientThread) {
    this.clientThread = clientThread;
  }

  /**
   *
   * @return
   */
  protected Thread getServerThread() {
    return serverThread;
  }

  /**
   *
   * @return
   */
  protected Thread getClientThread() {
    return clientThread;
  }

  /**
   *
   * @return
   */
  protected SpinServer getDaemonServer() {
    return daemonServer;
  }

  /**
   *
   * @return
   */
  protected SpinRequestWorker getDaemonClient() {
    return daemonClient;
  }

  /**
   *
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    SpinRunner spinRunner;

    spinRunner = new SpinRunner();
    spinRunner.getServerThread().start();
    spinRunner.getClientThread().start();
  }
}
