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
\file socket.h
\brief Interface for cross-patform socket connections
*/

#ifndef _SPINXPI_SOCKET_H
#define _SPINXPI_SOCKET_H

#include "types.h"

/**
 * @brief Contains a socket connection inforation.
 */
typedef struct SPINXPI_SOCKADDR {
  char * host; /**< @brief The host name for this socket */
  int port; /**< @brief The port number to bind this socket */
} SPINXPI_SOCKADDR;

/**
 * @brief Contains a socket inforation.
 */
typedef struct SPINXPI_SOCK {
  int fd; /**< @brief A file descriptor for this socket */
} SPINXPI_SOCK;

/**
 * @brief Creates a new socket connection
 * @param sock a socket connection object, or NULL
 * @return `sock` or NULL on failure
 */
SPINXPI_SOCK * socket(SPINXPI_SOCK * sock);

/**
 * @brief Binds a new socket connection
 * @param sock a socket connection instance
 * @param addr a socket address to bind to
 * @return `sock`; otherwise NULL on failure
 */
SPINXPI_RESULT bind(SPINXPI_SOCK * sock, SPINXPI_SOCKADDR * addr);

/**
 * @brief Marks the socket as a listener.
 * @param sock a socket instance
 * @return `sock`; otherwise NULL on failure, sets `errno`
 */
SPINXPI_RESULT listen(SPINXPI_SOCK * sock);

/**
 * @brief Accepts client connections to `sock` via the client address `cli_addr`
 * @param sock a socket instance
 * @param cli_addr a client address
 * @return the accepted socket or `NULL`, sets `errno`
 */
SPINXPI_SOCK * accept(SPINXPI_SOCK * sock, SPINXPI_SOCKADDR * cli_addr);

/**
 * @brief Closes the given socket
 * @param sock a socket instance
 * @return 0 on success, -1 on failure, `errno` set
 */
SPINXPI_RESULT close(SPINXPI_SOCK * sock);

#endif /* _SPINXPI_SOCKET_H */
