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
\file spinfile.c
\brief Implements structures and functions for writing and reading the `Spinfile` project configuration file
*/

#include "include/spinfile.h"
#include "include/error.h"

SPINXPI_RESULT spinfile_init(SPINXPI_OPTIONS * o_flags) {
  FILE file;

  if(spinfile_find(NULL, NULL, &file, 0) == RESULT_OK) {
    SPINXPI_ERRINFO e_info;
    
    e_info.msg = "`Spinfile` already exists in this directory. Remove it before running `spin init`.";
    e_info.lineno = __LINE__;
    e_info.fileno = __FILE__;
    e_info.level = LL_ERROR;
    error_log(stderr, &e_info);
    return RESULT_FAIL;
  }
  
  return RESULT_OK;
}

SPINXPI_RESULT spinfile_find(const char * dir, const char * filename, FILE * buf, int recursive) {
  return RESULT_FAIL;
}

SPINXPI_RESULT spinfile_parse(FILE * file, SPINXPI_SPINFILE * buf) {
}
