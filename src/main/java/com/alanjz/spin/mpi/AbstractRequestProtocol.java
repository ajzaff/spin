package com.alanjz.spin.mpi;

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

import java.util.Set;

/**
 *
 */
public class AbstractRequestProtocol implements RequestProtocol {

  /**
   *
   */
  protected Set<RequestVerb> supportedVerbs;

  /**
   *
   */
  protected String name;

  /**
   *
   */
  protected AbstractRequestProtocol(String name, Set<RequestVerb> supportedVerbs) {
    setSupportedVerbs(supportedVerbs);
    setName(name);
  }

  /**
   *
   * @param name
   */
  protected void setName(String name) {
    this.name = name;
  }

  /**
   *
   * @param supportedVerbs
   */
  protected void setSupportedVerbs(Set<RequestVerb> supportedVerbs) {
    this.supportedVerbs = supportedVerbs;
  }

  @Override
  public Set<RequestVerb> getSupportedVerbs() {
    return supportedVerbs;
  }

  @Override
  public String getName() {
    return name;
  }
}
