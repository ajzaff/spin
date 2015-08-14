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

import java.io.IOException;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class SpinRunner implements Runnable {

  /**
   *
   */
  protected static ExecutorService executorService =
    Executors.newWorkStealingPool();

  /**
   *
   */
  protected static Logger logger =
    Logger.getLogger("com.alanjz.spin.runner");

  /**
   *
   */
  protected SpinRunner() {
  }

  /**
   *
   * @param executorService
   */
  protected static void setExecutorService(ExecutorService executorService) {
    SpinRunner.executorService = executorService;
  }

  /**
   *
   * @return
   */
  protected static ExecutorService getExecutorService() {
    return executorService;
  }

  /**
   *
   * @return
   */
  public static Logger getLogger() {
    return logger;
  }

  /**
   *
   */
  @Override
  public void run() {
    getLogger().log(Level.INFO, "starting Spin peer runner...");
  }

  /**
   *
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    new SpinRunner().run();
  }

}
