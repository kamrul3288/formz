package com.iamkamrul.example

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.iamkamrul.example.ui.theme.FormzTheme
import com.iamkamrul.formz.FormzSubmissionStatus
import com.iamkamrul.formz.isInProgress
import com.iamkamrul.formz.isSuccess

@Composable
fun LoginScreen(
     viewModel: LoginViewModel = viewModel()
){
    val loginState by viewModel.formZSubmissionStatus.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(48.dp))
        Image(imageVector = ImageVector.vectorResource(R.drawable.ic_launcher_background), contentDescription = "Launcher")

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = viewModel.emailInput.value,
            label = {
              Text(text = "Enter email")
            },
            onValueChange = viewModel::onChangeEmailInput,
            supportingText = {
                if (viewModel.emailInput.displayError() != null){
                    Text(text = viewModel.emailInput.displayError()!!)
                }
            },
            isError = viewModel.emailInput.isError()
        )

        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = viewModel.passwordInput.value,
            label = {
                Text(text = "Enter password")
            },
            onValueChange = viewModel::onChangePasswordInput,
            supportingText = {
                if (viewModel.passwordInput.displayError() != null){
                    Text(text = viewModel.passwordInput.displayError()!!)
                }
            },
            isError = viewModel.passwordInput.isError()
        )

        Spacer(modifier = Modifier.height(32.dp))
        if (loginState.isInProgress()){
            CircularProgressIndicator()
        }else{
            FilledTonalButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {viewModel.loginUser()},
                enabled = viewModel.isFormValid
            ) {
                Text(text = "Login")
            }
        }

        if (loginState.isSuccess()){
            Text(text = (loginState as FormzSubmissionStatus.Success).data)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FormzTheme {
        LoginScreen()
    }
}