#include <jni.h>
#include <string>
#include "Processing.NDI.Lib.h"
#include "MainActivity.h"

extern "C"
JNIEXPORT jstring

JNICALL
Java_com_newtek_ndidemo_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

JNIEXPORT jboolean JNICALL Java_com_newtek_ndidemo_MainActivity_testNDIInitialize
        (JNIEnv *env, jobject){
    bool success = NDIlib_initialize();

    return (jboolean)success;
}
