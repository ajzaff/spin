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

import java.util.Map;

/**
 *
 */
public class RequestHeader {

  /**
   *
   */
  protected Map<String, String> headerMap;

  /**
   *
   */
  protected String headerString;

  /**
   *
   * @param headerMap
   */
  protected RequestHeader(Map<String, String> headerMap) {
    setHeaderMap(headerMap);
  }

  /**
   *
   * @return
   */
  protected Map<String, String> getHeaderMap() {
    return headerMap;
  }

  /**
   *
   * @return
   */
  protected String getHeaderString() {
    return headerString;
  }

  /**
   *
   * @param headerMap
   */
  protected void setHeaderMap(Map<String, String> headerMap) {
    this.headerMap = headerMap;
  }

  /**
   *
   * @param headerString
   */
  protected void setHeaderString(String headerString) {
    this.headerString = headerString;
  }

  /**
   *
   * @param key
   * @param value
   */
  void put(String key, String value) {
    getHeaderMap().put(key, value);
  }

  /**
   *
   * @return
   */
  public int size() {
    return getHeaderMap().size();
  }

  /**
   *
   * @return
   */
  public int length() {
    return getHeaderString().length();
  }

  /**
   *
   * @return
   */
  @Override
  public String toString() {
    return getHeaderString();
  }
}
