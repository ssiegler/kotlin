/*
 * Copyright 2010-2018 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package kotlin.js

/**
 * Reinterprets this value as a value of the [dynamic type](/docs/reference/dynamic-type.html).
 */
@kotlin.internal.InlineOnly
public inline fun Any?.asDynamic(): dynamic = this

/**
 * Reinterprets this value as a value of the specified type [T] without any actual type checking.
 */
@kotlin.internal.InlineOnly
public inline fun <T> Any?.unsafeCast(): @kotlin.internal.NoInfer T = this.asDynamic()

/**
 * Reinterprets this `dynamic` value as a value of the specified type [T] without any actual type checking.
 */
@kotlin.internal.DynamicExtension
@JsName("unsafeCastDynamic")
@kotlin.internal.InlineOnly
public inline fun <T> dynamic.unsafeCast(): @kotlin.internal.NoInfer T = this
