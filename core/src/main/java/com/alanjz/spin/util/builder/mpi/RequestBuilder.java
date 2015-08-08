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

import com.alanjz.spin.mpi.Request;
import com.alanjz.spin.mpi.RequestVerb;
import com.alanjz.spin.util.builder.Builder;

/**
 *
 */
public interface RequestBuilder extends Builder<Request> {

  /**
   *
   * @param requestVerb
   * @return
   */
  RequestBuilder setRequestVerb(RequestVerb requestVerb);

  /**
   *
   * @param scheme
   * @return
   */
  RequestBuilder setScheme(String scheme);

  /**
   *
   * @param userInfo
   * @return
   */
  RequestBuilder setUserInfo(String userInfo);

  /**
   *
   * @param hostName
   * @return
   */
  RequestBuilder setHost(String hostName);

  /**
   *
   * @param port
   * @return
   */
  RequestBuilder setPort(int port);

  /**
   *
   * @param path
   * @return
   */
  RequestBuilder setPath(String path);

  /**
   *
   * @param query
   * @return
   */
  RequestBuilder setQuery(String query);

  /**
   *
   * @param fragment
   * @return
   */
  RequestBuilder setFragment(String fragment);
}
