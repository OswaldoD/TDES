
#include <stdio.h>
#include "tdes_TDES.h"
#include "main.c"
#include <string.h>

JNIEXPORT int JNICALL Java_tdes_TDES_pruebaConexion
  (JNIEnv *env, jobject obj, jstring opcion, jstring nombreArchivo, jstring tipo_llave, jstring archivoSalida, jstring llave){
	
	/* Se obtienen los parametros desde java */
    char *option = (*env)->GetStringUTFChars(env, opcion, 0);
    const char *fileInput = (*env)->GetStringUTFChars(env, nombreArchivo, 0);
    const char *typeKey = (*env)->GetStringUTFChars(env, tipo_llave, 0);
    const char *fileOutput = (*env)->GetStringUTFChars(env, archivoSalida, 0);
    char *key = (*env)->GetStringUTFChars(env, llave, 0);
    

    /* Se hacen las operaciones necesarias con los parametros */
    printf("codigo de C : ");
    
    printf(option);
    printf("\n");/*
    printf(fileInput);
    printf("\n");
    printf(typeKey);
    printf("\n");
    printf(fileOutput);
    printf("\n");
    printf(key);
    printf("\n");*/
    
    char *argv[5];
    
    
    argv[0] = "./tdes";
    if(strcmp(option, "-e") == 0){
		argv[1] = "-e";
	}
	if(strcmp(option, "d") == 0){
		argv[1] = "-d";
		//printf("\nEsto guarda : ");
//printf(argv[1]);
		//printf("\n");
	}
    
    if(strcmp(typeKey, "-x") == 0){
		 argv[2] = fileInput;
		 argv[3] = typeKey;
		 argv[4] = "-o";
		 argv[5] = fileOutput;	
	}
	else{
	     argv[2] = fileInput;
		 //argv[3] = typeKey;
		 argv[3] = "-o";
		 argv[4] = fileOutput;	
	}
	
    int resultado;
    
	if(strcmp(typeKey, "-x") == 0){ 
		resultado = main(6, argv, key); 
	}
	else{
		resultado = main(5, argv, key);
	}
    

    /* Limpieza de la memoria, debido que el recolector de basura no se deshace de estos punteros */
    (*env)->ReleaseStringUTFChars(env, opcion, option);
    (*env)->ReleaseStringUTFChars(env, nombreArchivo, fileInput);
	(*env)->ReleaseStringUTFChars(env, tipo_llave, typeKey);
	(*env)->ReleaseStringUTFChars(env, archivoSalida, fileOutput);
	(*env)->ReleaseStringUTFChars(env, llave, key);

	/* Return para manejar mensajes de exito en java */
	return resultado;
}
