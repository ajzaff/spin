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
\file help.h
\brief Help utilities for the peer driver options
*/

#ifndef _SPINXPI_HELP_H
#define _SPINXPI_HELP_H

#include "options.h"

/**
 * @brief Prints help information to standard out
 * @param v_flags help topic, or NULL for general help
 * @param pname the name of the program to include in usage
 */
void help_topic(SPINXPI_VERBS * v_flags, char * pname);

/**
 * @brief Prints usage information to standard out
 * @param v_flags usage topic, or NULL for general usage
 * @param pname the name of the program to include in usage
 */
void help_usage(SPINXPI_VERBS * v_flags, char * pname);

/**
 * @brief Suggests help on a given topic
 * @param v_flags suggested help topic, or NULL for general help
 * @param pname the name of the program to include in suggestion
 */
void help_suggest(SPINXPI_VERBS * v_flags, char * pname);
 
 #endif /* _SPINXPI_HELP_H */
