package teka.android.retrfitapitemplate.keys

object AppKeys {

    init{
        System.loadLibrary("native-lib")
    }

    external fun tmdbKey(): String
}