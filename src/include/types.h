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
\file types.h
\brief Defines commonly used type names, wraps, includes system types when needed
*/

#ifndef _SPINXPI_TYPES_H_
#define _SPINXPI_TYPES_H_

/**
 * @brief A POSIX style return value with 0 bound to success, -1 to failure.
 */
typedef int SPINXPI_RESULT;

/**
 * @brief A result value constant meaning "no error"
 */
static const SPINXPI_RESULT SPINXPI_OK = 0;

/**
 * @brief A result value c
 */
static const SPINXPI_RESULT SPINXPI_FAIL = -1;

/**
 * @brief A boolean type modelled after standard libraries
 */
typedef bool SPINXPI_BOOL;

/**
 * @brief A constant corresponding to boolean `true`
 */
static const SPINXPI_BOOL SPINXPI_TRUE = 1;

/**
 * @brief A constant corresponsing to boolean `false`
 */
static const SPINXPI_BOOL SPINXPI_FALSE = 0;

#endif /* _SPINXPI_TYPES_H_ */
