package com.alanjz.spin.mmap;

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

import com.alanjz.spin.mpi.request.AbstractRequestProtocol;

import java.util.Arrays;

/**
 *
 */
public class MMAPRequestProtocol extends AbstractRequestProtocol {

  /**
   *
   */
  protected static final MMAPRequestProtocol instance =
      new MMAPRequestProtocol();

  /**
   *
   */
  private MMAPRequestProtocol() {
    super("mmap",
        Arrays.asList("GET", "HEAD", "POST", "PUT", "DELETE", "TRACE", "CONNECT"));
  }

  /**
   *
   * @return
   */
  public static MMAPRequestProtocol getInstance() {
    return instance;
  }
}