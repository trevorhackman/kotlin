// RUN_PIPELINE_TILL: BACKEND
// LANGUAGE: -ProhibitSimplificationOfNonTrivialConstBooleanExpressions
package test

// val prop4: true
val prop4 = !1.equals(2)
