package com.furkanterzi.retrofitandcompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.furkanterzi.retrofitandcompose.model.User
import com.furkanterzi.retrofitandcompose.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {

    private val repository = UserRepository()

    private val _userList = MutableStateFlow<List<User>>(emptyList())
    val userList: StateFlow<List<User>> = _userList

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            val users = repository.getUsers()
            _userList.value = users
        }
    }
}