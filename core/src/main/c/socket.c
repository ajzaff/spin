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
\file socket.c
\brief Implements cross-patform socket connections
*/

#include "include/socket.h"
#include "include/error.h"
#include <sys/socket.h>

SPINXPI_SOCK * socket_sock(SPINXPI_SOCK * sock) {
  if(sock == NULL) {
    sock = (SPINXPI_SOCK *)malloc(sizeof(SPINXPI_SOCK));
  }
  if((sock.fd=socket(AF_INET, SOCK_DGRAM, 0)) < 0) {
    char * err = stderror("", NULL);
    free(err);
    exit(0);
  }
}

SPINXPI_RESULT socket_sendto(SPINXPI_SOCK * sock, void * buf, SPINXPI_SIZE len, SPINXPI_SOCKADDR * addr, SPINXPI_LEN addr_len) {
  sendto(sock, buf, len, addr, addr_len);
}

SPINXPI_RESULT socket_sendto(SPINXPI_SOCK * sock, void * buf, SPINXPI_SIZE len) {
  send(sock, buf, len);
}
