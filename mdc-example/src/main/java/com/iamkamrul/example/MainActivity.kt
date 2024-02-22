package com.iamkamrul.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.lifecycleScope
import com.iamkamrul.example.databinding.ActivityMainBinding
import com.iamkamrul.example.validator.EmailInput
import com.iamkamrul.example.validator.PasswordInput
import com.iamkamrul.formz.FormZ
import com.iamkamrul.formz.FormzSubmissionStatus2
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private  val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val emailInput = EmailInput()
    private val passwordInput = PasswordInput()

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        lifecycleScope.launch {
            viewModel.formZSubmissionStatus.onEach {
                when(it){
                    is FormzSubmissionStatus2.Failure -> {}
                    is FormzSubmissionStatus2.InProgress -> {
                        binding.progressBar.isVisible = it.isProgress
                        binding.linearLayout.isVisible = !it.isProgress
                    }
                    is FormzSubmissionStatus2.Success -> binding.resultTv.text = it.data
                }
            }.collect()
        }


        binding.emailTL.editText?.doAfterTextChanged {
            emailInput.dirty(it.toString())
            binding.emailTL.error = emailInput.displayError()
            checkFormIsValid()
        }

        binding.passwordTL.editText?.doAfterTextChanged {
            passwordInput.dirty(it.toString())
            binding.passwordTL.error = passwordInput.displayError()
            checkFormIsValid()
        }

        binding.loginBtn.setOnClickListener {
            viewModel.loginUser(email = emailInput.value, password = passwordInput.value)
        }
    }

    private fun checkFormIsValid(){
        binding.loginBtn.isEnabled = FormZ.validate(listOf(emailInput,passwordInput))
    }
}