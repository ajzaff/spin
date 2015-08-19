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

import java.net.URI;

/**
 *
 */
public class Request {

  /**
   *
   */
  RequestProtocol protocol;

  /**
   *
   */
  RequestHeader header;

  /**
   *
   */
  URI requestURI;

  /**
   *
   * @param protocol
   * @param requestURI
   */
  public Request(RequestProtocol protocol, URI requestURI) {
    setRequestURI(requestURI);
    setProtocol(protocol);
  }

  /**
   *
   * @param requestURI
   */
  protected void setRequestURI(URI requestURI) {
    this.requestURI = requestURI;
  }

  /**
   *
   * @param protocol
   */
  protected void setProtocol(RequestProtocol protocol) {
    this.protocol = protocol;
  }

  /**
   *
   * @return
   */
  public RequestHeader getHeader() {
    return header;
  }

  /**
   *
   * @return
   */
  public RequestProtocol getProtocol() {
    return protocol;
  }

  /**
   *
   * @return
   */
  public URI getRequestURI() {
    return requestURI;
  }
}
