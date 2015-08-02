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
\brief Defines commonly used type names, enums, includes system types when needed
*/

#ifndef _SPINXPI_TYPES_H
#define _SPINXPI_TYPES_H

/**
 * @brief A POSIX style return value with 0 bound to success, -1 to failure.
 */
typedef enum SPINXPI_RESULT {
  SPINXPI_FAIL = -1, /**< @brief A result value constant meaning "failure" */
  SPINXPI_OK = 0 /**< @brief A result value constant meaning "no error" */
} SPINXPI_RESULT;

/**
 * @brief A boolean type modelled after standard libraries
 */
typedef enum SPINXPI_BOOL {
  SPINXPI_FALSE = 0, /**< @brief A constant corresponding to boolean `false` */
  SPINXPI_TRUE = 1 /**< @brief A constant corresponsing to boolean `true` */
} SPINXPI_BOOL;

/**
 * @brief A size type definition much like `size_t`
 */
typedef int SPINXPI_SIZE;

#endif /* _SPINXPI_TYPES_H */
