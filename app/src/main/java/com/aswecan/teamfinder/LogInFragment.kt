package com.aswecan.teamfinder

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.aswecan.teamfinder.databinding.FragmentLogInBinding

class LogInFragment : Fragment() {

    private lateinit var binding: FragmentLogInBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding = FragmentLogInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backButtonLogIn.setOnClickListener{
            findNavController().navigate(R.id.action_logInFragment_to_splashFragment)
        }

        binding.emailLogInEdittext.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0 != null) {
                    if(p0.isNotEmpty() && binding.passwordLogInEdittext.text.toString().isNotEmpty()
                        && !binding.logInButton.isVisible) {
                        binding.logInButton.visibility = View.VISIBLE
                    } else if(p0.isEmpty() && binding.logInButton.isVisible) {
                        binding.logInButton.visibility = View.INVISIBLE
                    }

                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        binding.passwordLogInEdittext.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(p0 != null) {
                    if(p0.isNotEmpty() && binding.emailLogInEdittext.text.toString().isNotEmpty()
                        && !binding.logInButton.isVisible) {
                        binding.logInButton.visibility = View.VISIBLE
                    } else if(p0.isEmpty() && binding.logInButton.isVisible) {
                        binding.logInButton.visibility = View.INVISIBLE
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }



}