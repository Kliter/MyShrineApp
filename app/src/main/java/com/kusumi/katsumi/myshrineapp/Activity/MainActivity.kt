package com.kusumi.katsumi.myshrineapp.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.kusumi.katsumi.myshrineapp.Fragment.LoginFragment
import com.kusumi.katsumi.myshrineapp.Interface.NavigationHost
import com.kusumi.katsumi.myshrineapp.R

class MainActivity : AppCompatActivity(), NavigationHost {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container, LoginFragment())
                .commit()
        }
    }
    
    override fun navigateTo(fragment: Fragment, addToBackstack: Boolean) {
        val transaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
        
        if (addToBackstack) {
            transaction.addToBackStack(null)
        }
        
        transaction.commit()
    }
}
