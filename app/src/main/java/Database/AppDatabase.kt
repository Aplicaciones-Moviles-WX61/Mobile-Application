package Database

import Beans.Event
import Beans.User
import Interface.EventDao
import Interface.UserDao
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class, Event::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun eventsDao(): EventDao
    abstract fun userDao(): UserDao

    companion object{
        var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java, "dbNextParty"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE as AppDatabase
        }
    }

}