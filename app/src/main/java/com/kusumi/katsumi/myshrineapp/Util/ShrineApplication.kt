package com.kusumi.katsumi.myshrineapp.Util

import android.app.Application
import android.content.Context
import android.support.v7.app.AppCompatDelegate

class ShrineApplication : Application() {
	companion object {
		var instance: ShrineApplication = ShrineApplication()
	}
	
	override fun onCreate() {
		super.onCreate()
		instance = this
		
		AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
	}
}