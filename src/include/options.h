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
\file options.h
\brief Interfaces for long and short command-line arguments
*/

#ifndef _SPINXPI_OPTIONS_H_
#define _SPINXPI_OPTIONS_H_

#include <getopt.h>

/**
 * @brief A structure containing option flags to be set by long and short options
 */
extern typedef struct SPINXPI_OPTS SPINXPI_OPTS;

/**
 * @brief A structure containing all long options
 * 
 * This structure must be terminated with a 0-row (i.e. `{0,0,0,0}`).
 */
extern struct option long_options[];

#endif /* _SPINXPI_OPTIONS_H_ */
