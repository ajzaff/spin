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

/**
 * @brief A log level structure
 */
typedef enum SPINXPI_LOGLEVEL {
  INFO = 0, /**< @brief Info-level message */
  DEBUG = 0x1, /**< @brief Debug-level message */
  WARN = 0x2, /**< @brief Warn-level message */
  ERROR = 0x4, /**< @brief Error-level message */
  FATAL = 0x8 /**< @brief Fatal-level message */
} SPINXPI_LOGLEVEL;

/**
 * @brief Array containing log level names
 */
static const char * LEVEL_NAME[] = {
  "INFO", "DEBUG", "WARN", "ERROR", "FATAL"
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
SPINXPI_RESULT append_message(FILE * file, SPINXPI_ERRINFO * e_info);

#endif /* SPINXPI_ERROR_H */
