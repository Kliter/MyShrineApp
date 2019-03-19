package com.kusumi.katsumi.myshrineapp.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kusumi.katsumi.myshrineapp.Interface.NavigationHost
import com.kusumi.katsumi.myshrineapp.R
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*

class LoginFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //Inflate the layout or this fragment.
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        // Set an error if the password is less than 8 characters.
        view.button_next.setOnClickListener {
            if (!isPasswordValid(password_edit_text.text!!)) {
                password_text_input.error = getString(R.string.error_password);
            }
            else {
                password_text_input.error = null
                (activity as NavigationHost).navigateTo(ProductGridFragment(), false)
            }
        }

        view.password_edit_text.setOnKeyListener {
            _, _, _ ->
            if (isPasswordValid(password_edit_text.text!!)) {
                password_text_input.error = null
            }
            false
        }
        return view
    }

    // In reality, this will have more complex logic including, but not limited to actual authentication of the username and password.
    private fun isPasswordValid(text: Editable): Boolean {
        return  text != null && text.length >= 8
    }
}