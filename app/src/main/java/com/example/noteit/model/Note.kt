package com.example.noteit.model

import android.os.Parcelable
import androidx.navigation.NavDestination
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val noteTitle: String,
    val noteDecs: String
):Parcelable
