package edu.zut.wi.planttactic.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.firebase.auth.FirebaseAuth
import edu.zut.wi.planttactic.R
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment(R.layout.fragment_register) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_register.setOnClickListener {
            val username = register_text_username.text.toString().trim { it <= ' ' }
            val password = register_text_password.text.toString().trim { it <= ' ' }

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(username, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            this.activity,
                            getString(R.string.account_created),
                            Toast.LENGTH_SHORT
                        ).show()
                        view.findNavController()
                            .navigate(R.id.action_registerFragment_to_loginFragment)
                    } else {
                        Toast.makeText(
                            this.activity,
                            task.exception!!.message.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }

    }
}