package com.kusumi.katsumi.myshrineapp.Util

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class ProductGridItemDecoration(private val largePadding: Int, private val smallPadding: Int): RecyclerView.ItemDecoration() {
	override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
		outRect.left =smallPadding
		outRect.right = largePadding
	}
}
