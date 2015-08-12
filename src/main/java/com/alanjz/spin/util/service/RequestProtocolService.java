package com.alanjz.spin.util.service;

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

import com.alanjz.spin.mpi.request.RequestProtocol;

import javax.management.ServiceNotFoundException;
import java.lang.reflect.InvocationTargetException;

/**
 *
 */
public class RequestProtocolService extends AbstractService<RequestProtocol> {

  /**
   *
   */
  private static final RequestProtocolService instance =
      new RequestProtocolService(RequestProtocol.class);

  /**
   * @param serviceClass
   */
  protected RequestProtocolService(Class<RequestProtocol> serviceClass) {
    super(serviceClass);
  }

  /**
   *
   * @param name
   * @return
   * @throws ClassNotFoundException
   * @throws NoSuchMethodException
   * @throws InvocationTargetException
   * @throws InstantiationException
   * @throws IllegalAccessException
   */
  @Override
  public RequestProtocol getService(String name)
    throws ClassNotFoundException, NoSuchMethodException,
    InvocationTargetException, InstantiationException, IllegalAccessException
  {
    for(RequestProtocol protocol : this) {
      if(protocol.getName().equalsIgnoreCase(name)) {
        return protocol;
      }
    }
    System.out.println("Default fallback...");
    return getDefaultService(name);
  }

  /**
   *
   * @param name
   * @return
   * @throws ClassNotFoundException
   * @throws NoSuchMethodException
   * @throws InvocationTargetException
   * @throws InstantiationException
   * @throws IllegalAccessException
   */
  @Override
  public RequestProtocol getDefaultService(String name)
    throws ClassNotFoundException, NoSuchMethodException,
    InvocationTargetException, InstantiationException, IllegalAccessException
  {
    Object o;

    if(name.equalsIgnoreCase("mmap")) {
      o = Class.forName("com.alanjz.spin.mmap.MMAPRequestProtocol").getDeclaredMethod("getInstance").invoke(null);
    }
    else {
      throw new ClassNotFoundException("could not load named service '" + name + "'");
    }

    return (RequestProtocol) o;
  }


  /**
   *
   * @return
   */
  public static RequestProtocolService getInstance() {
    return instance;
  }
}
