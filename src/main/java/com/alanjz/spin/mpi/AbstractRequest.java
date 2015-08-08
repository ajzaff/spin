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

import java.net.URI;

public abstract class AbstractRequest implements Request {

  protected RequestHeader requestHeader;

  protected RequestVerb requestVerb;

  protected URI requestURI;

  protected AbstractRequest(RequestVerb requestVerb, URI requestURI) {
    setRequestVerb(requestVerb);
    setRequestURI(requestURI);
  }

  protected void setRequestVerb(RequestVerb requestVerb) {
    this.requestVerb = requestVerb;
  }

  protected void setRequestURI(URI requestURI) {
    this.requestURI = requestURI;
  }

  @Override
  public RequestHeader getHeader() {
    return requestHeader;
  }

  @Override
  public RequestVerb getVerb() {
    return null;
  }

  @Override
  public RequestProtocol getProtocol() {
    return null;
  }

  @Override
  public RequestHost getHost() {
    return null;
  }

  @Override
  public RequestPath getPath() {
    return null;
  }

  @Override
  public int getPort() {
    return 0;
  }
}
