package com.alanjz.spin;

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

import java.net.InetAddress;

/**
 * Protocol which network peers use to route
 */
public interface PeerProtocol {

  /**
   * Gets a Base64 unique identifier for this peer.
   * The ID is randomly generated, and static at peer runtime.
   * The current standard computes a SHA1 from a secret,
   * a crypto-secure random number generated at startup
   * and held until the peer exits.
   * @return a Base64 unique identifier for this peer
   */
  String getID64();

  /**
   * Returns a protocol version string for
   * The name is used for backwards compatibility
   * in standards of communicating between two peers.
   * @return a protocol version string
   */
  String getProtocolVersion();

  /**
   * Determines whether a private socket is enabled.
   * The private interface is used by local separate processes
   * to communicate with the peer program while
   * both running on the same machine.
   * @return `true` if the private interface is enabled; `false` otherwise
   */
  boolean hasPrivateInterface();

  /**
   * The multicasting on which to discover new peers
   * @return a multicasting IP used to discover new peers
   */
  InetAddress getDiscoveryAddress();

  /**
   * The port on which a private interface runs over
   * @return a port on which to access the private interface
   */
  int getPrivatePort();

  /**
   * The port on which discovery of peers happens
   * @return a port on which to discover peers
   */
  int getDiscoveryPort();
}
