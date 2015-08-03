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
\file help.c
\brief Implements help contents
*/

#include "include/help.h"
#include <stdio.h>

void help_usage_general(char * pname) {
  printf("Usage: %s [VERBS]... [OPTIONS]...\n", pname);
}

void help_usage_init(char * pname) {
  printf("Usage: %s init [OPTIONS]...\n", pname);
}

void help_topic_general(char * pname) {
  help_usage_general(pname);
  printf("VERBS\n");
  printf("  %-25s%s\n", "init", "INITIALIZES a SPIN project here");
  printf("OPTIONS\n");
  printf("  %-25s%s\n", "-V, --version", "displays VERSION information");
  printf("  %-25s%s\n", "-h, --help", "prints this HELP page");
  printf("\n");
}

void help_topic_init(char * pname) {
  help_usage_init(pname);
  printf("ARGUMENTS\n");
  printf("  %-25s%s\n", "-f, --force", "OVERWRITE existing Spinfile");
  printf("  %-25s%s\n", "-m, --minimal", "output a BARE-BONES Spinfile (no help comments)");
  printf("  %-25s%s\n", "-o, --output=FILE", "OUTPUT path for Spinfile. '-' for stdout");
  printf("OPTIONS\n");
  printf("  %-25s%s\n", "-V, --version", "displays VERSION information");
  printf("  %-25s%s\n", "-h, --help", "prints this HELP page");
  printf("\n");
}

void help_topic(SPINXPI_VERBS * v_flags, char * pname) {
  if(v_flags == NULL) {
    help_topic_general(pname);
  }
  if(v_flags->init) {
    help_topic_init(pname);
  }
  else {
    help_topic_general(pname);
  }
}

void help_usage(SPINXPI_VERBS * v_flags, char * pname) {
  if(v_flags == NULL) {
    help_usage_general(pname);
  }
}

void help_suggest_general(char * pname) {
  printf("Try %s --help for more information.\n", pname);
}

void help_suggest(SPINXPI_VERBS * v_flags, char * pname) {
  if(v_flags == NULL) {
    help_suggest_general(pname);
  }
}
