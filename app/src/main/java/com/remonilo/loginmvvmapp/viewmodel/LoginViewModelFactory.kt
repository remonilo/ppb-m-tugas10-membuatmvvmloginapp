package com.remonilo.loginmvvmapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.remonilo.loginmvvmapp.data.repository.UserRepository

class LoginViewModelFactory(
    private val repository: UserRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {
        return LoginViewModel(repository) as T
    }
}