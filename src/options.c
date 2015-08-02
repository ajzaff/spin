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
\file options.c
\brief Implements options parsing for the peer
*/

#include "include/options.h"
#include "include/help.h"
#include <strings.h>
#include <string.h>
#include <stdlib.h>
#include <stdio.h>

SPINXPI_RESULT options_parseall(SPINXPI_VERBS * v_flags, SPINXPI_OPTIONS * o_flags, int argc, char ** argv) {
  char * verb;	
	int opt;

  memset(v_flags, 0, sizeof(SPINXPI_VERBS));
  memset(o_flags, 0, sizeof(SPINXPI_OPTIONS));
	
	struct option long_options[] = {
    {"help", no_argument, &o_flags->help, 1 },
    {"version", no_argument, &o_flags->version, 1 },
		{"verbose", no_argument, &o_flags->verbose, 1 },
		{0, 0, 0, 0}
  };
	for(opt=1; opt < 6 && opt < argc && strncmp(verb=argv[opt], "-", 1); opt++) {
		if(!strcasecmp(verb, "init")) {
			v_flags->init = 1;
		}
		else {
			printf("%s: unrecognized verb '%s'\n", argv[0], argv[opt]);
		  help_suggest(v_flags, argv[0]);
			exit(0);
		}
	}
	while((opt=getopt_long(argc, argv, "hV", long_options, NULL)) != -1) {
		switch(opt) {
			case 'h':
				o_flags->help = 1;
				break;
			case 'V':
				o_flags->version = 1;
				break;
			case '?':
				help_suggest(v_flags, argv[0]);
				exit(0);
				break;
			default:
				break;
		}
	}
}
