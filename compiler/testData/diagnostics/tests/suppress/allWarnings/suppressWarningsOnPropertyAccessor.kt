// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
class C {
    val foo: String?
        @Suppress("warnings")
        get(): String?? = null as Nothing?
}