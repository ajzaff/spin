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

SPINXPI_RESULT error_log(FILE * file, SPINXPI_ERRINFO * e_info) {
  char * fmt;
  char e_str[128];
  
  fmt = "%s[%-5s]%s @%s:%d: %s%s\n";
  sprintf(e_str, "%s%s", errno == 0? "" : " ", errno == 0? "" : strerror(errno));
  if(e_info == NULL) {
    SPINXPI_ERRINFO e;
    e.msg = "unspecified error";
    e.lineno = __LINE__;
    e.fileno = __FILENAME__(__FILE__);
    e.level = LL_ERROR;
    if(fprintf(file, fmt, LLCOLOR[e.level], LLNAME[e.level], e_str, __FILENAME__(e.fileno), e.lineno, e.msg, LLECOLOR[e.level]) < 0) {
      return RESULT_FAIL;
    }
  }
  else if(fprintf(file, fmt, LLCOLOR[e_info->level], LLNAME[e_info->level], e_str, __FILENAME__(e_info->fileno), e_info->lineno, e_info->msg, LLECOLOR[e_info->level]) < 0) {
    return RESULT_FAIL;
  }
  return RESULT_OK;
}
