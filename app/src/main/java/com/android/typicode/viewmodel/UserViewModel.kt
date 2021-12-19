package com.android.typicode.viewmodel

import androidx.constraintlayout.motion.utils.ViewState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.typicode.UserRepositoryUseCase
import com.android.typicode.entity.Users
import com.android.typicode.repository.UserRepository
import com.android.typicode.utils.Result
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val userRepositoryUseCase: UserRepositoryUseCase
) : ViewModel() {
    private val _allUsers = MutableLiveData<Result<List<Users>>>()
    val observeAllUsers: LiveData<Result<List<Users>>>
        get() = _allUsers

    fun getAllUsers() {
        viewModelScope.launch {
            _allUsers.value = Result.Loading()
            userRepositoryUseCase.invoke().let { result ->
                when (result) {
                    is Result.Success -> {
                        _allUsers.value = Result.Success(result.value)
                    }
                    is Result.Error -> {
                        _allUsers.value = Result.Error(result.message)
                    }
                    else -> _allUsers.value = Result.Error(result.message)
                }
            }
        }
    }
}