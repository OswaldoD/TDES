
#include <stdio.h>
#include "tdes_TDES.h"

//void pruebaConexion(){
JNIEXPORT void JNICALL Java_tdes_TDES_pruebaConexion
  (JNIEnv *env, jobject obj){
	printf("Hola estoy conectado desde otro lado");
	
}
