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
\file error.c
\brief Cross-platform error utilities
*/

#include "include/error.h"
#include <stdio.h>
#include <errno.h>
#include <string.h>

#define __FILENAME__(f) (strrchr(f, '/') ? strrchr(f, '/') + 1 : f)

SPINXPI_RESULT append_message(FILE * file, SPINXPI_ERRINFO * e_info) {
  char * fmt;
  
  fmt = "[%-5s] %s\n%s:%d %s"
  if(e_info == NULL) {
    SPINXPI_ERRINFO e;
    e.msg = strerror(errno);
    e.lineno = __LINE__;
    e.fileno = __FILENAME__(__FILE__);
    e.level = ERROR;
    if(fprintf(file, fmt, LOG_LEVEL_NAME[e.level], "", e.fileno, e.lineno, e.msg) < 0) {
      return SPINXPI_FAIL;
    }
  }
  else if(fprintf(file, fmt, LOG_LEVEL_NAME[e.level], e.msg, e.fileno, e.lineno, strerror(errno) < 0) {
    return SPINXPI_FAIL;
  }
  return SPINXPI_OK;
}
