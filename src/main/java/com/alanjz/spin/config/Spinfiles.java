package com.alanjz.spin.config;
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

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 *
 */
public final class Spinfiles {

  /**
   *
   * @param fileLocation
   * @return
   * @throws IOException
   */
  public static File searchRecursive(File fileLocation) throws IOException {
    String[] files;

    if(!fileLocation.isDirectory()) {
      throw new IOException("file location is not a directory.");
    }

    do {
      files = fileLocation.list();
      if (files == null) {
        throw new IOException("file location is not a directory.");
      }

      for (String f : files) {
        if (matchesSpinfile(f)) {
          return new File(fileLocation.getAbsolutePath() + "/" + f);
        }
      }

      fileLocation = fileLocation.getParentFile();
    } while(fileLocation != null);

    return null;
  }

  public static boolean matchesSpinfile(String fileName) {
    return fileName.matches("[Ss]pinfile(.json)?");
  }
}
