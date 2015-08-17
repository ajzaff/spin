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

import com.alanjz.spin.config.Spinfiles;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.*;

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
   * @param format
   * @param args
   */
  protected void info(String format, Object... args) {
    System.out.printf("[INFO] " + format + "\n", args);
  }

  /**
   *
   */
  protected void info() {
    System.out.printf("[INFO]\n");
  }


  protected void fail(String format, Object... args) {
    System.err.printf("[FAIL] " + format + "\n", args);
  }

  /**
   *
   */
  @Override
  public void run() {
    info("starting Spin peer runner...");
    info();
    info("   ____/ ___ \\   /  __  \\");
    info("  __  ) /__/ /  /  / /  /");
    info("_____/  ____/__/__/ /__/  (c)");
    info("     __/");
    info();
    try {
      info("loading configuration...");
      File file = Spinfiles.searchRecursive(new File(System.getProperty("user.dir")));
      if(file == null) {
        fail("Spin runner did not find Spinfile.json in directory tree");
        fail("shutting down...");
        System.exit(0);
      }
      info("loaded [%s]", file.getAbsolutePath());
    }
    catch (IOException e) {
      fail(e.getMessage());
      return;
    }
    info("starting Spin thread pool...");
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
