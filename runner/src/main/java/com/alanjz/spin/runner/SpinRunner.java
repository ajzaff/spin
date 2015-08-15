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

import com.alanjz.spin.util.Spinfiles;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.*;
import java.util.logging.Logger;

/**
 *
 */
public class SpinRunner implements Runnable {

  /**
   *
   */
  private ExecutorService executorService;

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
  protected void setExecutorService(ExecutorService executorService) {
    this.executorService = executorService;
  }

  /**
   *
   * @return
   */
  protected ExecutorService getExecutorService() {
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
    getLogger().info("starting Spin peer runner...");
    getLogger().info("\n\n   ____/ ___ \\   /  __  \\\n" +
      "  __  ) /__/ /  /  / /  /\n" +
      "_____/  ____/__/__/ /__/  (c)\n" +
      "     __/\n");
    try {
      getLogger().info("loading Spinfile.json...");
      if(Spinfiles.searchRecursive(new File(System.getProperty("user.dir"))) == null) {
        getLogger().severe("Spin runner did not find Spinfile.json in directory tree");
        getLogger().severe("shutting down...");
        System.exit(0);
      }
    }
    catch (IOException e) {
      getLogger().severe(e.getMessage());
      return;
    }
    getLogger().info("starting Spin thread pool...");
    setExecutorService(Executors.newWorkStealingPool());
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
