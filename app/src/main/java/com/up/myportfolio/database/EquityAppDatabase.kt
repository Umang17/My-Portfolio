package com.announce.app.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.announce.app.database.dao.ProfileDAO
import com.announce.app.database.entities.ProfileEntity
import com.announce.app.utilities.Constants
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory

@Database(
    entities = [ProfileEntity::class],
    version = 1
)
abstract class AnnounceAppDatabase : RoomDatabase() {
    abstract fun getProfile(): ProfileDAO

    companion object {

        @Volatile
        private var originalInstance: AnnounceAppDatabase? = null
        fun getDatabase(context: Context): AnnounceAppDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            val factory = SupportFactory(SQLiteDatabase.getBytes("PassPhrase".toCharArray()))
            return originalInstance ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AnnounceAppDatabase::class.java,
                    Constants.databaseName
                ).fallbackToDestructiveMigration()
                    .openHelperFactory(factory)
                    .build()
                originalInstance = instance
                // return instance
                instance
            }
        }
    }
}
