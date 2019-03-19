package com.kusumi.katsumi.myshrineapp.Util

import android.app.Application
import android.support.v7.app.AppCompatDelegate

class ShrineApplication: Application() {
	companion object {
		lateinit var instance: ShrineApplication
		private set
	}
	
	override fun onCreate() {
		super.onCreate()
		instance = this
		
		AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
	}
}