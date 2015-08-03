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
\file error.h
\brief Cross-platform error utilities
*/

#ifndef SPINXPI_ERROR_H
#define SPINXPI_ERROR_H

#include "types.h"
#include <stdio.h>

/**
 * @brief A log level structure
 */
typedef enum SPINXPI_LOGLEVEL {
  LL_INFO, /**< @brief Info-level message */
  LL_DEBUG, /**< @brief Debug-level message */
  LL_WARN, /**< @brief Warn-level message */
  LL_ERROR, /**< @brief Error-level message */
  LL_FATAL /**< @brief Fatal-level message */
} SPINXPI_LOGLEVEL;

/**
 * @brief Array containing log level names
 */
static const char * LLNAME[] = {
  "INFO", "DEBUG", "WARN", "ERROR", "FATAL"
};

/**
 * @brief Color tags
 */
static const char * LLCOLOR[] = {
  "", "", "\033[33m", "\033[31m", "\033[31m"
};

/**
 * @brief Color tags
 */
static const char * LLECOLOR[] = {
  "", "", "\033[0m", "\033[0m", "\033[0m"
};

/**
 * @brief A structure used for logging detailed error messages
 */
typedef struct SPINXPI_ERRINFO {
  char * msg; /**< @brief An error message to display before anything else */
  int lineno; /**< @brief Offending line number usually set to `__LINE__` */
  char * fileno; /**< @brief Offending file name usually set to `__FILE__` */
  SPINXPI_LOGLEVEL level; /**< @brief Log level information */
} SPINXPI_ERRINFO;

/**
 * @brief Logs an error to the given log file
 * @param file a log file to log the result to
 * @param e_info an error info structure
 * @return whether the info could be written
 */
SPINXPI_RESULT error_log(FILE * file, SPINXPI_ERRINFO * e_info);

#endif /* SPINXPI_ERROR_H */
