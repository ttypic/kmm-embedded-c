# Extending a KMM Shared Module With C/C++ Code

This repository contains sample code for [tutotial I've written at Hackernoon](https://hackernoon.com/how-to-extend-a-kmm-shared-module-with-cc-code)

_This tutorial was inspired by [Zipline library](https://github.com/cashapp/zipline)._

## Content

This repository contains code for Kotlin Multiplatform library for iOS and Android targets, which
provides Kotlin bindings for C-implementations of SHA-256 hash function.

Build configuration doesn't contains custom gradle tasks or any shell-script. For iOS target
it uses [CKlib gradle plugin](https://github.com/touchlab/cklib) and for Android target it uses regular Android gradle plugin's NDK.
