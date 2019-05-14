/*
 * Copyright 2010-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.platform

import org.jetbrains.kotlin.platform.js.JsPlatforms
import org.jetbrains.kotlin.platform.js.JsPlatforms.defaultJsPlatform
import org.jetbrains.kotlin.platform.jvm.JvmPlatforms
import org.jetbrains.kotlin.platform.jvm.JvmPlatforms.defaultJvmPlatform
import org.jetbrains.kotlin.platform.jvm.JvmPlatforms.jvm18
import org.jetbrains.kotlin.platform.konan.KonanPlatforms
import org.jetbrains.kotlin.platform.konan.KonanPlatforms.defaultKonanPlatform

object CommonPlatforms {
    @Suppress("DEPRECATION_ERROR")
    // Lazy is needed to avoid static initialization loop through CommonPlatform.INSTANCE
    val defaultCommonPlatform: TargetPlatform by lazy {
        object : TargetPlatform(
            setOf(
                defaultJvmPlatform.single(),
                defaultJsPlatform.single(),
                defaultKonanPlatform.single()
            )
        ),
            // Needed for backward compatibility, because old code uses INSTANCECHECKs instead of calling extensions
            org.jetbrains.kotlin.analyzer.common.CommonPlatform {}
    }

    val allSimplePlatforms: List<TargetPlatform>
        get() = sequence {
            yieldAll(JvmPlatforms.allJvmPlatforms)
            yieldAll(KonanPlatforms.allKonanPlatforms)
            yieldAll(JsPlatforms.allJsPlatforms)

            // TODO(dsavvinov): extensions points?
        }.toList()
}

