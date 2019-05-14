/*
 * Copyright 2010-2019 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.platform.konan

import org.jetbrains.kotlin.platform.SimplePlatform
import org.jetbrains.kotlin.platform.TargetPlatform
import org.jetbrains.kotlin.platform.toTargetPlatform

abstract class KonanPlatform : SimplePlatform("Native") {
    override val oldFashionedDescription: String
        get() = "Kotlin/Native "
}

object KonanPlatforms {
    private object DefaultSimpleKonanPlatform : KonanPlatform()

    @Suppress("DEPRECATION_ERROR")
    // Lazy is needed to avoid static initialization loop through KonanPlatform.INSTANCE
    val defaultKonanPlatform: TargetPlatform by lazy {
        object : TargetPlatform(setOf(DefaultSimpleKonanPlatform)),
            // Needed for backward compatibility, because old code uses INSTANCECHECKs instead of calling extensions
            org.jetbrains.kotlin.resolve.konan.platform.KonanPlatform {}
    }

    val allKonanPlatforms: List<TargetPlatform> = listOf(defaultKonanPlatform)
}

fun TargetPlatform?.isNative(): Boolean = this?.singleOrNull() is KonanPlatform