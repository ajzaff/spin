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
\file spinfile.h
\brief Structures and functions for writing and reading the `Spinfile` project configuration file
*/

#ifndef _SPINXPI_SPINFILE_H
#define _SPINXPI_SPINFILE_H

#include "options.h"

/**
 * @brief A structure which models the Spinfile configuration
 */
typedef struct SPINXPI_SPINFILE {
} SPINXPI_SPINFILE;

/**
 * @brief Tries to create a new `Spinfile` in the current directory.
 *
 * A `Spinfile` will not be created if one already exists in the current
 * directory, unless the `-f`, `--force` option is supplied.
 * 
 * The output file can be changed with use of the `-o`, `--output` option.
 * `-o` will only overwrite files when paired with `-f` and never directories.
 * @param o_flags option flags including output files, project settings, etc.
 * @return 0 if the `Spinfile was created successfully; -1 otherwise
 */
SPINXPI_RESULT spinfile_init(SPINXPI_OPTIONS * o_flags);

/**
 * @brief Searches the directory `dir` for a `Spinfile`
 * 
 * It searches for a file matching `Spinfile` and then others in the following order:
 * - `Spinfile.*`
 * - `spinfile`
 * - `spinfile.*`
 * @param dir The directory in which to conduct the search
 * If `dir` doesn't exist, then the search fails.
 * If the directory is NULL, the current directory is used.
 * @param file A file buffer which gets set if a file is found.
 * If `file` is NULL, it gets allocated dynamically using `malloc`. The user is responsible for calling `free` to return the memory.
 * @param rec Whether to search parent folders recursively.
 * @return 0 if the Spinfile was found; -1 otherwise.
 */
SPINXPI_RESULT spinfile_find(FILE * dir, FILE * file, int rec);

/**
 * @brief Parses a `Spinfile` to a readable structure
 * @param file the `Spinfile`
 * @param buf the `Spinfile` structure to fill
 */
SPINXPI_SPINFILE * spinfile_parse(FILE * file, SPINXPI_SPINFILE * buf);

#endif /* _SPINXPI_SPINFILE_H */
