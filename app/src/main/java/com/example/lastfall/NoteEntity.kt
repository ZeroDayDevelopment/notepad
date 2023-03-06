package com.example.lastfall

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "notepadd")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val title:String,
    val text:String
    ):Parcelable
