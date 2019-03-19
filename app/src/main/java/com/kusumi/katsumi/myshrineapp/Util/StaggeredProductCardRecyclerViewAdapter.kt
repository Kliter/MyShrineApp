package com.kusumi.katsumi.myshrineapp.Util

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kusumi.katsumi.myshrineapp.Network.ImageRequester
import com.kusumi.katsumi.myshrineapp.Network.ProductEntry
import com.kusumi.katsumi.myshrineapp.R

class StaggeredProductCardRecyclerViewAdapter(private val productList: List<ProductEntry>?): RecyclerView.Adapter<StaggeredProductCardViewHolder>() {
	override fun getItemViewType(position: Int): Int {
		return position % 3
	}
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StaggeredProductCardViewHolder {
		var layoutId = R.layout.snippet_staggered_product_card_first
		
		if (viewType == 1) {
			layoutId = R.layout.snippet_staggered_product_card_second
		}
		else if (viewType == 2) {
			layoutId = R.layout.snippet_staggered_product_card_third
		}
		
		val layoutView = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
		return StaggeredProductCardViewHolder(layoutView)
	}
	
	override fun onBindViewHolder(holder: StaggeredProductCardViewHolder, position: Int) {
		if (productList != null && position < productList.size) {
			val product = productList[position]
			holder.productTitle.text = product.title
			holder.productPrice.text = product.price
			ImageRequester.setImageFromUrl(holder.productImage, product.url)
		}
	}
	
	override fun getItemCount(): Int {
		return productList?.size ?: 0
	}
}