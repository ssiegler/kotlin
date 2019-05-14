/*
 * Copyright 2010-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.platform.js

import org.jetbrains.kotlin.platform.SimplePlatform
import org.jetbrains.kotlin.platform.TargetPlatform
import org.jetbrains.kotlin.platform.toTargetPlatform

abstract class JsPlatform : SimplePlatform("JS") {
    override val oldFashionedDescription: String
        get() = "JavaScript "
}

object JsPlatforms {
    private object DefaultSimpleJsPlatform : JsPlatform()

    @Suppress("DEPRECATION_ERROR")
    // Lazy is needed to avoid static initialization loop through JsPlatform.INSTANCE
    val defaultJsPlatform: TargetPlatform by lazy {
        object : TargetPlatform(setOf(DefaultSimpleJsPlatform)),
            // Needed for backward compatibility, because old code uses INSTANCECHECKs instead of calling extensions
            org.jetbrains.kotlin.js.resolve.JsPlatform {}
    }

    val allJsPlatforms: List<TargetPlatform> = listOf(defaultJsPlatform)
}

fun TargetPlatform?.isJs(): Boolean = this?.singleOrNull() is JsPlatform