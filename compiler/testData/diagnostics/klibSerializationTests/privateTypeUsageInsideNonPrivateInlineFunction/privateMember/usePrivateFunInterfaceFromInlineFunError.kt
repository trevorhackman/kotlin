// LANGUAGE: +ForbidExposureOfPrivateTypesInNonPrivateInlineFunctionsInKlibs
// IGNORE_FIR_DIAGNOSTICS
// DIAGNOSTICS: -NOTHING_TO_INLINE
// FIR_IDENTICAL

private fun interface I {
    fun foo(): Int
}

inline fun publicInlineFun(): Int = (<!IR_PRIVATE_TYPE_USED_IN_NON_PRIVATE_INLINE_FUNCTION_ERROR!>I { 1 }<!>).<!NON_PUBLIC_CALL_FROM_PUBLIC_INLINE!>foo<!>()

internal inline fun internalInlineFun(): Int = (<!IR_PRIVATE_TYPE_USED_IN_NON_PRIVATE_INLINE_FUNCTION_ERROR!><!LESS_VISIBLE_TYPE_IN_INLINE_ACCESSED_SIGNATURE_WARNING!>I<!> { 1 }<!>).<!LESS_VISIBLE_CONTAINING_CLASS_IN_INLINE_WARNING, PRIVATE_CLASS_MEMBER_FROM_INLINE!>foo<!>()
