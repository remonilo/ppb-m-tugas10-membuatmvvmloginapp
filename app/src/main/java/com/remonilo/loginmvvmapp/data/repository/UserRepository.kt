package com.remonilo.loginmvvmapp.data.repository
import com.remonilo.loginmvvmapp.data.local.dao.UserDao
import com.remonilo.loginmvvmapp.data.local.entity.User

class UserRepository(
    private val dao: UserDao,
) {
    suspend fun insert(user: User) {
        dao.insert(user)
    }

    suspend fun login(
        username: String,
        password: String,
    ): User? = dao.login(username, password)
}
