package Interface

import Beans.User
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    fun insert(user: User?)

    @Query("SELECT * FROM users")
    fun userList(): List<User?>?

}