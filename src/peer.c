#include "help.c"
#include "options.c"
#include <signal.h>

void print_version();

int main(int argc, char ** argv) {
	if(argc < 2) {
		help_usage(NULL, argv[0]);
		exit(0);
	}
	
	SPINXPI_OPTIONS o_flags;
	SPINXPI_VERBS v_flags;

	options_parseall(&v_flags, &o_flags, argc, argv);

	if(o_flags.help) {
		help_topic(&v_flags, argv[0]);
	}
	else if(o_flags.version) {
		print_version();
	}
	else if(v_flags.init) {
    
	}

	return 0;
}

void print_version() {
  printf("SPIN (Framework) 0.1.0-SNAPSHOT\n");
  printf("Copyright (C) 2015 Alan Zaffetti.\n");
  printf("License GPLv3+: GNU GPL version 3 or later <http://gnu.org/licenses/gpl.html>.\n");
  printf("This is free software: you are free to change and redistribute it.\n");
  printf("There is NO WARRANTY, to the extent permitted by law.\n");
  printf("\n");
  printf("Written by Alan Zaffetti <spin.alanjz.com>.\n");
}
