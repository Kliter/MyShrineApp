package com.kusumi.katsumi.myshrineapp.Util

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kusumi.katsumi.myshrineapp.Network.ImageRequester
import com.kusumi.katsumi.myshrineapp.Network.ProductEntry
import com.kusumi.katsumi.myshrineapp.R

class ProductCardRecyclerViewAdapter internal constructor(
	private val productList: List<ProductEntry>): RecyclerView.Adapter<ProductCardViewHolder>() {
	
	override fun getItemCount(): Int {
		return productList.size
	}
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCardViewHolder {
		val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.snippet_product_card, parent, false)
		return ProductCardViewHolder(layoutView)
	}
	
	override fun onBindViewHolder(holder: ProductCardViewHolder, position: Int) {
		if (position < productList.size) {
			val product = productList[position]
			holder.productTitle.text = product.title
			holder.productPrice.text = product.price
			ImageRequester.setImageFromUrl(holder.productImage, product.url)
		}
	}
}