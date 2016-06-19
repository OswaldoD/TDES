
#include <stdio.h>
#include "tdes_TDES.h"

//void pruebaConexion(){
JNIEXPORT void JNICALL Java_tdes_TDES_pruebaConexion
  (JNIEnv *env, jobject obj, jstring nombreArchivo){
	
	/*Get the native string from javaString*/
    const char *nativeString = (*env)->GetStringUTFChars(env, nombreArchivo, 0);

    /*Do something with the nativeString*/
    printf("Hola estoy conectado desde otro lado: ");
    printf(nativeString);
    printf("\n");

    /*DON'T FORGET THIS LINE!!!*/
    (*env)->ReleaseStringUTFChars(env, nombreArchivo, nativeString);
}
