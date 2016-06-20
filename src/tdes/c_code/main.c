/***************************************************************************
 *            main.c
 *
 *  Version 1.0.0
 *  Wed Sep 26 21:26:01 2012
 *  Copyright  2012  Jorge Vargas Calvo, ITCR, Costa Rica
 *  Email avargas@itcr.ac.cr
 ****************************************************************************/

/*
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Library General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
  
#include <stdio.h>
#include <string.h>
#include "des.c"

#define TRUE            1
#define FALSE           0
#define KEYLENGTH      24
#define SHOULD_ENCRYPT  1

void ShowHelp();

int ParseOptions(int argc, char *argv[],
				 int *hk, int *c, int *d, int *outf, int *inf,
				 int *noutf, int *ninf);
int GetKey(int hexkey, char *cp);
int GetAllArgs(int argc,char *argv[], int *m, char *chp,
				 unsigned long int *f1, unsigned long int *f2);

void TDESengine(int m,char *k,FILE *InputFile, FILE *OutputFile);
void CloseFiles(FILE *f1, FILE *f2);


int main(int argc, char *argv[], char *keyImported)
{
	printf("%d", argc);
	printf("    ");
	int h = 0;
	while(h < argc){
		printf(argv[h]);
		printf(" ");
		h++;
	}
	
	int  mode; // mode = 1: encryption; mode = 0: decryption
	char TDESkey[KEYLENGTH];
	FILE *InputFile, *OutputFile;
	
	int status;
	char *kp;
	unsigned long int fileptr1, fileptr2;
	
	
	kp = &TDESkey[0];
	//kp = keyImported;
	
	if ((status = GetAllArgs(argc,&argv[0],&mode,kp,&fileptr1,&fileptr2))){
		return status;
	} else {
		InputFile = fileptr1;
		OutputFile = fileptr2;
		
		//printf("Llave : ");
		//printf(kp);
		//printf("\n");
		
		TDESengine(mode,kp,InputFile,OutputFile);
		
		CloseFiles(InputFile, OutputFile);
		
		return 0;
	}
	
}

void ShowHelp()
{
	printf("Usage: tdes -e FILE [OPTIONS]\n");
	printf("  or   tdes -d FILE [OPTIONS]\n");
	printf("Applies Triple DES encryption or decryption to FILE.\n\n");
	printf("Options:\n");
	printf("  -e                       Encrypt FILE\n");
	printf("  -d                       Decrypt FILE\n");
	printf("  -x                       Key in hexadecimal format\n");
	printf("  -o <file>                Place the output into <file>\n");
	printf("  -h                       Display this information\n\n");
	printf("If -o <file> is not given, the output will be placed into a.out.\n\n");
	printf("Only one operation can be done: encryption or decryption, so the options\n");
	printf("`-e' and `-d' can't be given at the same time, but one of them must be given.\n");
	printf("An input file  name is mandatory also.\n\n");
	printf("Report bugs to <avargas@itcr.ac.cr>\n");
}

int ParseOptions(int argc, char *argv[],
				int *hk, int *c, int *d, int *outf, int *inf,
				int *noutf, int *ninf)
{
	int i;
	
	if (argc == 1){
		printf("tdes: usage: tdes infile -e [-x][-o outfile]\n");
		printf("		     tdes infile -d [-x][-o outfile]\n");
		printf("		     tdes -h\n");
		return 1;
	}
	
	if ((argc == 2)&&(strcmp(argv[1],"-h") == 0)){
		ShowHelp();
		return 1;
	} else if (argc == 2){
		printf("Wrong option or incomplete option list.\n");
		printf("Try `tdes -h' for more information.\n");
		return -1;
	}
	
	if (argc > 6){
		printf("Too many options\n");
		printf("Try `tdes -h' for more information.\n");
		return -2;
	}
	
	for(i = 1; i < argc; i++){
		if        (strcmp(argv[i],"-x") == 0) {
			*hk = TRUE;
			/*hexkey = TRUE;*/
		} else if (strcmp(argv[i],"-e") == 0) {
			*c = TRUE;
			/*encrypt = TRUE;*/
		} else if (strcmp(argv[i],"-d") == 0) {
			*d = TRUE;
			/*decrypt = TRUE;*/
		} else if ((strcmp(argv[i],"-o") == 0) &&
				(i < argc - 1) &&
				(*argv[i+1] != '-')){
					i += 1;
					*outf = TRUE;
					*noutf = i;
					/*outfileset = TRUE;*/
		} else if (*argv[i] != '-'){
			*inf = TRUE;
			*ninf = i;
			/* infileset = TRUE;*/
		} else {
			printf("Unknown or wrong option\n");
			printf("Try `tdes -h' for more information.\n");
			return -3;
		}
	}
	
	/* Check for invalid combination of options */
	
	if (*c == *d){
		printf("Error: -e and -d can't be set at the same time.\n");
		return -4;
	}
	
	if (*inf == FALSE){
		printf("Error: Must specify an input file.\n");
		return -5;
	}
	return 0;
}

int GetKey(int hexkey, char *cp)
{
	int i, j;
	char c, hb, *p;
	
	p = cp;
	for (i=0; i < KEYLENGTH; i++){
		*p = 0x01;
		p++;
	}
	*p = 0x00;
	
	i = 0;
	j = 0;

	printf("Key: ");
	
	if (hexkey == TRUE){
		while (((c = getchar()) != '\n')&&(i < KEYLENGTH)){
			if (((c <= '9')&&('0' <= c))||
				((c <= 'F')&&('A' <= c))||
				((c <= 'f')&&('a' <= c))){
				if (c > 0x39){
					c += 9;
				}
				c &= 0x0f;
				if (j == 1){
					j = 0;
					*cp = hb + c;
				} else {
					j = 1;
					hb = c << 4;
				}
				cp++;
			} else {
				printf("Bad hex digit\n");
				return -6;
			}
			i++;
		}
		if ((i < KEYLENGTH) && (j == 1)){
			*cp = c << 4;
		}
	} else {
		while (((c = getchar()) != '\n')&&(i < KEYLENGTH)){
			*cp = c;
			cp++;
			i++;
		}
	}
	return 0;
}

int GetAllArgs(int argc, char *argv[], int *m, char *chp,
				unsigned long int *f1, unsigned long int *f2)
{	
	int s, inf, outf;
	int hexkey, crypt, decrypt, outfileset, infileset;
	FILE *fp;
	
	hexkey = crypt = decrypt = outfileset = infileset = FALSE;
	
	if (((s = ParseOptions(argc,&argv[0],&hexkey,&crypt,&decrypt,&outfileset,
		&infileset, &outf, &inf))) == 0){
		*m = crypt;
		
		s = GetKey(hexkey,chp);
			
		if((fp = fopen(argv[inf],"r")) == NULL){
			printf("tdes: file not found: %s\n",argv[inf]);
			return -7;
		} else {
			*f1 = (unsigned long int)fp;
		}
		if (outfileset == TRUE){
			if ((fp = fopen(argv[outf],"w")) == NULL){
				printf("Output file error\n");
				return -8;
			}
		} else {
			if ((fp = fopen("a.out","w")) == NULL){
				printf("Output file error\n");
				return -8;
			} else {
				printf("Generic output file used: a.out\n");
			}
		}
		*f2 = (unsigned long int) fp;
	}
	return s;
}

void TDESengine(int m,char *k,FILE *InputFile, FILE *OutputFile)
{
	int c;
	
	unsigned char k1[8], k2[8], k3[8];
	unsigned char block[8];
	unsigned char ciphertext[8];
	unsigned char recoverd[8];
	tripledes_ctx context;
	
	int i, j, n;
	
	for (i = 0, j= 0;j < 8;i++, j++) k1[j] = k[i];
	
	for (j = 0; j < 8; i++, j++) k2[j] = k[i];
		
	for (j = 0; j < 8; i++, j++) k3[j] = k[i];
		
	n = tripledes_set3keys(context, k1, k2, k3);
	
	i = 0;
	while ((c = getc(InputFile)) != EOF) {
		block[i] = c;
		i = (i < 7) ? i + 1: 0;
		
		if (i == 0){
			if (m == SHOULD_ENCRYPT){
				tripledes_ecb_encrypt(context,block,ciphertext);
				for (j = 0; j < 8; putc((ciphertext[j]),OutputFile),j++);
			} else {
				tripledes_ecb_decrypt(context, block, recoverd);
				for (j = 0; j < 8; putc((recoverd[j]),OutputFile),j++);
			}
		}
	}
	// Processing the last (incomplete) block
	if (i < 7){
		for(;i<7;i++) block[i] = 0x00;
	}
	if (m == SHOULD_ENCRYPT){
		tripledes_ecb_encrypt(context,block,ciphertext);
		for (j = 0; j < 8; putc((ciphertext[j]),OutputFile),j++);
	} else {
		tripledes_ecb_decrypt(context, block, recoverd);
		for (j = 0; j < 8; putc((recoverd[j]),OutputFile),j++);
	}
	
	return;
}

void CloseFiles(FILE *f1, FILE *f2)
{
	fclose(f1);
	fclose(f2);
}
