#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL

Java_teka_android_retrfitapitemplate_keys_AppKeys_tmdbKey(JNIEnv *env, jobject object) {

   std::string api_key = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmMzAxZWQ2MWRiNjk0Njk1NzRhMzA0YWRlOTJhODU1MSIsInN1YiI6IjYwMTJjMGJlMWI3MGFlMDAzZDViYmI4NyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.lvXCwI48a8vHHBBwSt6zTqof1qieOfAJvCW7mCJrmI4";

   return env->NewStringUTF(api_key.c_str());
}