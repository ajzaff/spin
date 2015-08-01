#include <strings.h>
#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include <getopt.h>
#include <pthread.h>

struct t_verbs {
	char * names[6];
	int init;
	int destroy;
	int vc;
};

struct t_opts {
	int help, version, verbose;
};

void print_help(char **, struct t_verbs *);
void print_version();
void print_usage(char **, struct t_verbs *, int);
void print_suggest_help(char **);
void consume_args(struct t_opts *, struct t_verbs *, int, char **);

int main(int argc, char ** argv) {
	struct t_opts o_flags;
	struct t_verbs v_flags;

	if(argc < 2) {
		print_usage(argv, NULL, 1);
		exit(0);
	}

	consume_args(&o_flags, &v_flags, argc, argv);

	if(o_flags.help) {
		print_help(argv, &v_flags);
		exit(0);
	}

	if(o_flags.version) {
		print_version();
		exit(0);
	}

	if(v_flags.init) {
		// recursively descend for Spinfile
		/*
      if(!(fd=find_spinfile(...))) {
				create new...
			}

			parse_spinfile(&spin_, );

			...

			create .spin cache
		*/
	}

	if(v_flags.destroy) {
		// attempt to unload collateral, then delete local cache.
    /*
    get_clique(&clique_...)

    if(clique == NULL) {
      get_named_host(&host, "spin.alanjz.com/routes", 9000);
      request(&host, "GET /routes");
			*clique = &host;
    }

    BOOST_FOREACH(c, collateral) {
      chunk(&blocks, c);
      while(b=next(&blocks)) {
        unload(b, c);
      }
    }
    */
	}

	
}

void print_help(char ** argv, struct t_verbs * v_flags) {
	FILE * fd;
	char * file;
	char buf[1024];

	memset(&buf, 0, 1024);
	file = "spin_help";

	if(v_flags != NULL) {
		if(v_flags->init) {
			file = "spin_help_init";
		}
	}

	fd = fopen(file, "r");
	if(fd == NULL) {
		fprintf(stderr, "WARN: missing help file '%s'\n", file);	
		return;
	}

	print_usage(argv, v_flags, 0);
	while(fgets(buf, 1024, fd) != NULL) {
		printf("%s", buf);
	}
}

void print_version() {
	FILE * fd;
	char buf[256];

	memset(&buf, 0, 256);
	fd = fopen("spin_version", "r");

	if(fd == NULL) {
		fprintf(stderr, "WARN: missing file 'spin_version'\n");	
	}

	while(fgets(buf, 256, fd) != NULL) {
		printf("%s", buf);
	}
}

void print_usage(char ** argv, struct t_verbs * v_flags, int suggest_help) {
	int i;

	printf("Usage: %s ", argv[0]);
	if(v_flags != NULL) {
		for(i=0; i < v_flags->vc; i++) {
			printf("%s ", v_flags->names[i]);
		}
	}
	printf("[VERBS]... ");	

	printf("[OPTIONS]...\n");
	if(suggest_help) {
		print_suggest_help(argv);
	}
}

void print_suggest_help(char ** argv) {
	printf("Try %s --help for more information.\n", argv[0]);
}

void consume_args(struct t_opts * o_flags, struct t_verbs * v_flags, int argc, char ** argv) {
	char * verb;	
	int opt;

	*o_flags = (const struct t_opts) {0};
	*v_flags = (const struct t_verbs) {0};
	
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
			print_suggest_help(argv);
			exit(0);
		}
		v_flags->names[v_flags->vc++] = verb;
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
				print_suggest_help(argv);
				exit(0);
				break;
			default:
				break;
		}
	}
}
