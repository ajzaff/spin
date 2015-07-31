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
@file strings.h
@brief Interface for cross-platform string utilities.
*/

#ifndef _SPINXPI_STRINGS_H_
#define _SPINXPI_STRINGS_H_

#include <string.h>

/**
 * @brief calculates the length of a string
 * @param str a string
 * @return an integer length
 */
int strlen(char * str);

#endif /* _SPINXPI_STRINGS_H_
