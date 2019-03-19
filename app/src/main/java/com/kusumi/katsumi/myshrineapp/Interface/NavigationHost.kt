package com.kusumi.katsumi.myshrineapp.Interface

import android.support.v4.app.Fragment

// A host that can display fragments and knows how to respond to navigation events.
interface NavigationHost {

    //Trigger a navigation to the specified fragment, optionally adding a transaction to the backstack to make this navigation reversible.
    fun navigateTo(fragment: Fragment, addToBackstack: Boolean)
}