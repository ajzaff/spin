package com.alanjz.spin.util.builder.mpi;

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

import com.alanjz.spin.mpi.BaseRequest;
import com.alanjz.spin.mpi.Request;
import com.alanjz.spin.mpi.RequestVerb;
import com.alanjz.spin.util.parser.mpi.RequestSyntaxException;

import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 */
public class AbstractRequestBuilder implements RequestBuilder {

  /**
   *
   */
  protected RequestVerb requestVerb;

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
  protected int port;

  /**
   *
   */
  protected AbstractRequestBuilder() {

  }

  @Override
  public RequestBuilder setRequestVerb(RequestVerb requestVerb) {
    this.requestVerb = requestVerb;
    return this;
  }

  @Override
  public RequestBuilder setScheme(String scheme) {
    this.scheme = scheme;
    return this;
  }

  @Override
  public RequestBuilder setUserInfo(String userInfo) {
    this.userInfo = userInfo;
    return this;
  }

  @Override
  public RequestBuilder setHost(String hostName) {
    this.hostName = hostName;
    return this;
  }

  @Override
  public RequestBuilder setPort(int port) {
    this.port = port;
    return this;
  }

  @Override
  public RequestBuilder setPath(String path) {
    this.path = path;
    return this;
  }

  @Override
  public RequestBuilder setQuery(String query) {
    this.query = query;
    return this;
  }

  @Override
  public RequestBuilder setFragment(String fragment) {
    this.fragment = fragment;
    return this;
  }

  /**
   *
   * @return
   */
  protected RequestVerb getRequestVerb() {
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
  public Request build() throws RequestSyntaxException, URISyntaxException {
    URI requestURI;

    requestURI = new URI(getScheme(), getUserInfo(), getHostName(), getPort(), getPath(), getQuery(), getFragment());
    return new BaseRequest(getRequestVerb(), requestURI);
  }
}
