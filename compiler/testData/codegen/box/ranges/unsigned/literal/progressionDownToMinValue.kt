// KJS_WITH_FULL_RUNTIME
// TODO: muted automatically, investigate should it be ran for JVM_IR or not
// IGNORE_BACKEND: JVM_IR

// Auto-generated by org.jetbrains.kotlin.generators.tests.GenerateRangesCodegenTestData. DO NOT EDIT!
// WITH_RUNTIME


const val MinUI = UInt.MIN_VALUE
const val MinUB = UByte.MIN_VALUE
const val MinUS = UShort.MIN_VALUE
const val MinUL = ULong.MIN_VALUE

fun box(): String {
    val list1 = ArrayList<UInt>()
    for (i in (MinUI + 2u) downTo MinUI step 1) {
        list1.add(i)
        if (list1.size > 23) break
    }
    if (list1 != listOf<UInt>(MinUI + 2u, MinUI + 1u, MinUI)) {
        return "Wrong elements for (MinUI + 2u) downTo MinUI step 1: $list1"
    }

    val list2 = ArrayList<UInt>()
    for (i in (MinUB + 2u).toUByte() downTo MinUB step 1) {
        list2.add(i)
        if (list2.size > 23) break
    }
    if (list2 != listOf<UInt>((MinUB + 2u).toUInt(), (MinUB + 1u).toUInt(), MinUB.toUInt())) {
        return "Wrong elements for (MinUB + 2u).toUByte() downTo MinUB step 1: $list2"
    }

    val list3 = ArrayList<UInt>()
    for (i in (MinUS + 2u).toUShort() downTo MinUS step 1) {
        list3.add(i)
        if (list3.size > 23) break
    }
    if (list3 != listOf<UInt>((MinUS + 2u).toUInt(), (MinUS + 1u).toUInt(), MinUS.toUInt())) {
        return "Wrong elements for (MinUS + 2u).toUShort() downTo MinUS step 1: $list3"
    }

    val list4 = ArrayList<ULong>()
    for (i in (MinUL + 2u) downTo MinUL step 1) {
        list4.add(i)
        if (list4.size > 23) break
    }
    if (list4 != listOf<ULong>((MinUL + 2u), (MinUL + 1u), MinUL)) {
        return "Wrong elements for (MinUL + 2u) downTo MinUL step 1: $list4"
    }

    return "OK"
}
