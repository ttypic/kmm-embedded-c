@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    // trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.android.library).apply(false)
    alias(libs.plugins.kotlin.android).apply(false)
    alias(libs.plugins.kotlin.multiplatform).apply(false)
    alias(libs.plugins.cklib).apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
