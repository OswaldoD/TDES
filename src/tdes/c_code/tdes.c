
#include <stdio.h>
#include "tdes_TDES.h"

//void pruebaConexion(){
JNIEXPORT void JNICALL Java_tdes_TDES_pruebaConexion
  (JNIEnv *env, jobject obj, jstring opcion, jstring nombreArchivo, jstring tipo_llave, jstring archivoSalida, jstring llave){
	  //  (JNIEnv *, jobject, jstring, jstring, jstring, jstring, jstring);
	  //String opcion, String nombreArchivo, String tipo_llave, String archivoSalida, String llave

	
	/*Get the native string from javaString*/
    const char *option = (*env)->GetStringUTFChars(env, opcion, 0);
    const char *fileInput = (*env)->GetStringUTFChars(env, nombreArchivo, 0);
    const char *typeKey = (*env)->GetStringUTFChars(env, tipo_llave, 0);
    const char *fileOutput = (*env)->GetStringUTFChars(env, archivoSalida, 0);
    const char *key = (*env)->GetStringUTFChars(env, llave, 0);
    

    /*Do something with the nativeString*/
    printf("Hola estoy conectado desde otro lado: ");
    printf(option);
    printf("\n");
    printf(fileInput);
    printf("\n");
    printf(typeKey);
    printf("\n");
    printf(fileOutput);
    printf("\n");
    printf(key);
    printf("\n");

    /*DON'T FORGET THIS LINE!!!*/
    (*env)->ReleaseStringUTFChars(env, opcion, option);
    (*env)->ReleaseStringUTFChars(env, nombreArchivo, fileInput);
	(*env)->ReleaseStringUTFChars(env, tipo_llave, typeKey);
	(*env)->ReleaseStringUTFChars(env, archivoSalida, fileOutput);
	(*env)->ReleaseStringUTFChars(env, llave, key);

}
