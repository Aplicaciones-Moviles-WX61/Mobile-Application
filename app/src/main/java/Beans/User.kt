package Beans

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
class User(@field:ColumnInfo(name = "name")var name: String,
           @field:ColumnInfo(name = "email")var email: String,
           @field:ColumnInfo(name = "password")var password: String,
           @field:ColumnInfo(name = "birthday")var birthday: String,
           ) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
}