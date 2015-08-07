package com.alanjz.spin.cache;

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

import com.alanjz.spin.Resource;

import java.net.MalformedURLException;

public abstract class AbstractSpincache implements Spincache {

  /**
   * Attempts to load the resource
   * @param endpointName the name of a resource endpoint
   * @return a resource object
   * @throws ResourceNotFoundException when the specified resource could not be loaded.
   * @throws MalformedURLException when an unspecified protocol is included.
   */
  public Resource findResource(String endpointName) throws ResourceNotFoundException, MalformedURLException {
    return null;
  }
}
