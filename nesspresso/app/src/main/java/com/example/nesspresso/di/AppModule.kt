package com.example.nesspresso.di

import org.koin.core.module.Module

val appModule: List<Module> = listOf(dataModule, presentationModule)