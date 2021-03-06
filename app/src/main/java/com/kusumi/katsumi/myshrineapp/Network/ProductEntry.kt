package com.kusumi.katsumi.myshrineapp.Network

import android.content.res.Resources
import android.net.Uri
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kusumi.katsumi.myshrineapp.R
import java.io.BufferedReader

class ProductEntry(
	val title: String, dynamicUrl: String,val url: String, val price: String, val description: String){
	val dynamicUrl: Uri = Uri.parse(dynamicUrl)
	
	companion object {
		/**
		 * A product entry in the list of products.
		 */
		fun initProductEntryList(resources: Resources): List<ProductEntry> {
			val inputStream = resources.openRawResource(R.raw.products)
			val jsonProductsString = inputStream.bufferedReader().use(BufferedReader::readText)
			val gson = Gson()
			val productListType = object: TypeToken<ArrayList<ProductEntry>>() {}.type
			return gson.fromJson<List<ProductEntry>>(jsonProductsString, productListType)
		}
	}
}