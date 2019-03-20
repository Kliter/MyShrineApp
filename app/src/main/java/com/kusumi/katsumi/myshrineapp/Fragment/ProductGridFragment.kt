package com.kusumi.katsumi.myshrineapp.Fragment

import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.*
import android.view.animation.AccelerateDecelerateInterpolator
import com.kusumi.katsumi.myshrineapp.Network.ProductEntry
import com.kusumi.katsumi.myshrineapp.R
import com.kusumi.katsumi.myshrineapp.Util.NavigationIconClickListener
import com.kusumi.katsumi.myshrineapp.Util.ProductGridItemDecoration
import com.kusumi.katsumi.myshrineapp.Util.StaggeredProductCardRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_product_grid.view.*

class ProductGridFragment: Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        
        // Inflate the layout for this fragment with the ProductGrid theme
        val view: View = inflater.inflate(R.layout.fragment_product_grid, container, false)
        
        // Setup the toolbar
        (activity as AppCompatActivity).setSupportActionBar(view.app_bar)
        view.app_bar.setNavigationOnClickListener(NavigationIconClickListener(
            activity!!,
            view.product_grid,
            AccelerateDecelerateInterpolator(),
            ContextCompat.getDrawable(context!!, R.drawable.branded_menu),
            ContextCompat.getDrawable(context!!, R.drawable.close_menu)))
         
        // Set up the RecyclerView
        view.recycler_view.setHasFixedSize(true)
        val gridLayoutManager = GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false)
        gridLayoutManager.spanSizeLookup = object: GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (position % 3 ==2) 2 else 1
            }
        }
        view.recycler_view.layoutManager = gridLayoutManager
        val adapter = StaggeredProductCardRecyclerViewAdapter(ProductEntry.initProductEntryList(resources))
        view.recycler_view.adapter = adapter
        val largePadding = resources.getDimensionPixelSize(R.dimen.staggered_product_grid_spacing_large)
        val smallPadding = resources.getDimensionPixelSize(R.dimen.staggered_product_grid_spacing_small)
        view.recycler_view.addItemDecoration(ProductGridItemDecoration(largePadding, smallPadding))
        
        // Set cut corner background for API 23+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            view.product_grid.background = context?.getDrawable(R.drawable.shr_product_grid_background_shape)
        }
        
        return view
    }
    
    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.shr_toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}