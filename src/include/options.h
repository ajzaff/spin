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

#ifndef _SPINXPI_OPTIONS_H
#define _SPINXPI_OPTIONS_H

#include "types.h"
#include <getopt.h>

/**
 * @brief A structure containing verb flags
 */
typedef struct SPINXPI_VERBS {
  int init; /**< @brief Initializes a new SPIN project */
} SPINXPI_VERBS;

/**
 * @brief A structure containing option flags
 */
typedef struct SPINXPI_OPTIONS {
  int help, /**< @brief Help contents flag */
    version, /**< @brief Version info flag */
    verbose; /**< @brief Verbose debugging mode flag */
} SPINXPI_OPTIONS;

/**
 * @brief Parses all options into a flags structure
 * @param v_flags flags set when verbs are found
 * @param opts a structure containing option flags and values
 * @param argc the number of arguments
 * @param argv the array of string arguments
 * @return a result 0 on success, -1 on failure.
 */
SPINXPI_RESULT options_parseall(SPINXPI_VERBS * v_flags, SPINXPI_OPTIONS * o_flags, int argc, char ** argv);

#endif /* _SPINXPI_OPTIONS_H */
