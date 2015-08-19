package com.alanjz.spin.peers;

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

import javafx.util.converter.BigIntegerStringConverter;

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class AbstractPeerRouter implements PeerRouter {

  /**
   *
   */
  protected Map<String, String> routes;

  /**
   *
   */
  public AbstractPeerRouter() {
    setRoutes(new HashMap<>());
  }

  public void setRoutes(Map<String, String> routes) {
    this.routes = routes;
  }

  @Override
  public Map<String, String> getRoutes() {
    return Collections.unmodifiableMap(routes);
  }

  @Override
  public void putRoute(String key, String value) {
    routes.put(key, value);
  }

  @Override
  public String getRoute(String key) {

    return null;
  }
}
