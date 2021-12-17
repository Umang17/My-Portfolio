package com.up.myportfolio.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.announce.app.utilities.Constants

@Entity(tableName = Constants.profileEntityName)
data class ProfileEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = Constants.profileAutoId) var profile_auto_id: Int,
    @ColumnInfo(name = Constants.profileUserName) var profile_user_name: String?,
    @ColumnInfo(name = Constants.profileFirstName) var profile_first_name: String?,
    @ColumnInfo(name = Constants.profileLastName) var profile_last_name: String?,
    @ColumnInfo(name = Constants.profileUserPicture) var profile_user_picture: String?,
    @ColumnInfo(name = Constants.profileUserServerId) var profile_user_server_id: String?
)