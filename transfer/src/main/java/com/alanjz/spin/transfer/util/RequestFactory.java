package com.alanjz.spin.transfer.util;

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

import com.alanjz.spin.mpi.request.Request;
import com.alanjz.spin.util.factory.Factory;

/**
 *
 */
public class RequestFactory implements Factory<Request> {

  /**
   *
   */
  protected String requestVerb;

  /**
   *
   */
  protected String scheme;

  /**
   *
   */
  protected String userInfo;

  /**
   *
   */
  protected String hostName;

  /**
   *
   */
  protected String path;

  /**
   *
   */
  protected String query;

  /**
   *
   */
  protected String fragment;

  /**
   *
   */
  protected String version;

  /**
   *
   */
  protected int port;

  /**
   *
   */
  public RequestFactory() {

  }

  /**
   *
   * @param requestVerb
   * @return
   */
  public RequestFactory setRequestVerb(String requestVerb) {
    this.requestVerb = requestVerb;
    return this;
  }

  /**
   *
   * @param scheme
   * @return
   */
  public RequestFactory setScheme(String scheme) {
    this.scheme = scheme;
    return this;
  }

  /**
   *
   * @param userInfo
   * @return
   */
  public RequestFactory setUserInfo(String userInfo) {
    this.userInfo = userInfo;
    return this;
  }

  /**
   *
   * @param hostName
   * @return
   */
  public RequestFactory setHost(String hostName) {
    this.hostName = hostName;
    return this;
  }

  /**
   *
   * @param port
   * @return
   */
  public RequestFactory setPort(int port) {
    this.port = port;
    return this;
  }

  /**
   *
   * @param path
   * @return
   */
  public RequestFactory setPath(String path) {
    this.path = path;
    return this;
  }

  /**
   *
   * @param query
   * @return
   */
  public RequestFactory setQuery(String query) {
    this.query = query;
    return this;
  }

  /**
   *
   * @param fragment
   * @return
   */
  public RequestFactory setFragment(String fragment) {
    this.fragment = fragment;
    return this;
  }

  /**
   *
   * @param version
   * @return
   */
  public RequestFactory setVersion(String version) {
    this.version = version;
    return this;
  }

  /**
   *
   * @return
   */
  protected String getRequestVerb() {
    return requestVerb;
  }

  /**
   *
   * @return
   */
  protected String getScheme() {
    return scheme;
  }

  /**
   *
   * @return
   */
  protected String getUserInfo() {
    return userInfo;
  }

  /**
   *
   * @return
   */
  protected String getHostName() {
    return hostName;
  }

  /**
   *
   * @return
   */
  protected int getPort() {
    return port;
  }

  /**
   *
   * @return
   */
  protected String getPath() {
    return path;
  }

  /**
   *
   * @return
   */
  protected String getQuery() {
    return query;
  }

  /**
   *
   * @return
   */
  protected String getFragment() {
    return fragment;
  }

  @Override
  public Request build() throws Exception {
    return null;
  }
}
