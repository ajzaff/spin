package com.alanjz.spin.transfer;

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

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public abstract class AbstractRequestProtocol implements RequestProtocol {

  /**
   *
   */
  protected String name;

  /**
   *
   */
  protected String version;

  /**
   *
   */
  protected Set<String> methods;

  /**
   *
   * @param name
   * @param version
   * @param methods
   */
  protected AbstractRequestProtocol(
      String name,
      String version,
      final Collection<String> methods)
  {
    setName(name);
    setVersion(version);
    setMethods(Collections.unmodifiableSet(
        new HashSet<String>(methods.size()) {{
          this.addAll(methods);
        }}));
  }

  /**
   *
   * @param methods
   */
  protected void setMethods(Set<String> methods) {
    this.methods = methods;
  }

  /**
   *
   * @return
   */
  protected Set<String> getMethods() {
    return methods;
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
   * @param version
   */
  protected void setVersion(String version) {
    this.version = version;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getVersion() {
    return version;
  }

  @Override
  public boolean supportsMethod(String method) {
    return getMethods().contains(method);
  }
}
