package Interface

import Beans.Event
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EventDao {
    @Insert
    fun insert(event: Event?)

    @Query("SELECT * FROM events")
    fun eventList(): List<Event>
}