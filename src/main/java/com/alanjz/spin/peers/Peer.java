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
public interface Peer {

  /**
   * Gets a Base64 unique identifier for this peer.
   * The ID is randomly generated, and static at peer runtime.
   * The current standard computes a SHA1 from a secret,
   * a crypto-secure random number generated at startup
   * and held until the peer exits.
   * @return a Base64 unique identifier for this peer
   */
  String getID();

  /**
   * The multicasting on which to discover new peers
   * @return a multicasting IP used to discover new peers
   */
  String getDiscoveryAddress();

  /**
   * The port on which discovery of peers happens
   * @return a port on which to discover peers
   */
  int getDiscoveryPort();
}
