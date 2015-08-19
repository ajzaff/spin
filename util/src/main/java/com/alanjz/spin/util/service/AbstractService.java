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

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 *
 * @param <S>
 */
public abstract class AbstractService<S> implements Service<S> {

  /**
   *
   */
  protected Class<S> serviceClass;

  /**
   *
   */
  protected ServiceLoader<S> serviceLoader;

  /**
   *
   * @param serviceClass
   */
  protected AbstractService(Class<S> serviceClass) {
    setServiceLoader(ServiceLoader.load(serviceClass));
    getServiceLoader().reload();
  }

  /**
   *
   * @param serviceLoader
   */
  protected void setServiceLoader(ServiceLoader<S> serviceLoader) {
    this.serviceLoader = serviceLoader;
  }

  /**
   *
   * @param serviceClass
   */
  protected void setServiceClass(Class<S> serviceClass) {
    this.serviceClass = serviceClass;
  }

  /**
   *
   * @return
   */
  protected Class<S> getServiceClass() {
    return serviceClass;
  }

  @Override
  public ServiceLoader<S> getServiceLoader() {
    return serviceLoader;
  }

  @Override
  public Iterator<S> iterator() {
    return getServiceLoader().iterator();
  }
}
