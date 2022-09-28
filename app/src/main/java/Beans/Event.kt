package Beans

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Events")
class Event (
    @field:ColumnInfo(name= "name")var name: String,
    @field:ColumnInfo(name= "eventDate")var eventDate: String){

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0

}