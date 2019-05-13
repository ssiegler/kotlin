/*
 * Copyright 2010-2019 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package kotlin.js

/**
 * Allows to iterate this `dynamic` object in the following cases:
 * - when it has an `iterator` function,
 * - when it is an array
 * - when it is an instance of [kotlin.collections.Iterable]
 */
@kotlin.internal.DynamicExtension
public operator fun dynamic.iterator(): Iterator<dynamic> {
    val r: Any? = this

    return when {
        this["iterator"] != null ->
            this["iterator"]()
        js("Kotlin").isArrayish(r) ->
            r.unsafeCast<Array<*>>().iterator()

        else ->
            (r as Iterable<*>).iterator()
    }
}