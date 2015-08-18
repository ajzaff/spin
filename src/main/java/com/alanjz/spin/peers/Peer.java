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

/**
 * Protocol which network peers use to route
 */
public class Peer {

  /**
   *
   */
  protected String id;

  /**
   *
   */
  protected int port;

  /**
   *
   */
  protected String name;

  /**
   *
   */
  protected String contentRoot;

  /**
   *
   */
  protected String cacheRoot;

  /**
   *
   */
  protected int parallelism;

  /**
   *
   * @param id
   * @param port
   * @param name
   * @param contentRoot
   * @param cacheRoot
   * @param parallelism
   */
  public Peer(String id, int port, String name, String contentRoot, String cacheRoot, int parallelism) {
    this.id = id;
    this.port = port;
    this.name = name;
    this.contentRoot = contentRoot;
    this.cacheRoot = cacheRoot;
    this.parallelism = parallelism;
  }

  /**
   * Gets a Base64 unique identifier for this peer.
   * The ID is randomly generated, and static at peer runtime.
   * The current standard computes a SHA1 from a secret,
   * a crypto-secure random number generated at startup
   * and held until the peer exits.
   * @return a Base64 unique identifier for this peer
   */
  public String getID() {
    return id;
  }

  /**
   * The port on which discovery of peers happens
   * @return a port on which to discover peers
   */
  public int getPort() {
    return port;
  }

  public void setID(String id) {
    this.id = id;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContentRoot() {
    return contentRoot;
  }

  public void setContentRoot(String contentRoot) {
    this.contentRoot = contentRoot;
  }

  public String getCacheRoot() {
    return cacheRoot;
  }

  public void setCacheRoot(String cacheRoot) {
    this.cacheRoot = cacheRoot;
  }

  public int getParallelism() {
    return parallelism;
  }

  public void setParallelism(int parallelism) {
    this.parallelism = parallelism;
  }
}
