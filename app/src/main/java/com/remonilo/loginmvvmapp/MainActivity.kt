package com.remonilo.loginmvvmapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import com.remonilo.loginmvvmapp.data.local.database.AppDatabase
import com.remonilo.loginmvvmapp.data.repository.UserRepository
import com.remonilo.loginmvvmapp.ui.screen.LoginScreen
import com.remonilo.loginmvvmapp.ui.theme.LoginMVVMAppTheme
import com.remonilo.loginmvvmapp.viewmodel.LoginViewModel
import com.remonilo.loginmvvmapp.viewmodel.LoginViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val database =
            AppDatabase.getDatabase(this)
        val repository =
            UserRepository(
                database.userDao(),
            )
        val factory =
            LoginViewModelFactory(repository)
        setContent {
            val viewModel: LoginViewModel =
                viewModel(factory = factory)
            androidx.compose.runtime.LaunchedEffect(Unit) {
                viewModel.insertDummyUser()
            }
            LoginMVVMAppTheme {
                Surface { LoginScreen(viewModel) }
            }
        }
    }
}
