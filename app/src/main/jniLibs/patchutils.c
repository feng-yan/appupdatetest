#include <jni.h>

JNIEXPORT jintJNICALL
Java_com_bobo_utils_PatchUtils_patch(JNIEnv
*env,
jclass type, jstring
oldApkPath_,
jstring newApkPath_, jstring
patchPath_)
{
const char *oldApkPath = (*env)->GetStringUTFChars(env, oldApkPath_, 0);
const char *newApkPath = (*env)->GetStringUTFChars(env, newApkPath_, 0);
const char *patchPath = (*env)->GetStringUTFChars(env, patchPath_, 0);

// TODO

(*env)->
ReleaseStringUTFChars(env, oldApkPath_, oldApkPath
);
(*env)->
ReleaseStringUTFChars(env, newApkPath_, newApkPath
);
(*env)->
ReleaseStringUTFChars(env, patchPath_, patchPath
);
}