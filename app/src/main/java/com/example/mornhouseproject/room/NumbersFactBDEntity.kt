package com.example.mornhouseproject.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mornhouseproject.room.NumbersFactBDEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME )
data class NumbersFactBDEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "fact", collate = ColumnInfo.NOCASE)
    val fact: String,
) {
    companion object{
       const  val TABLE_NAME="name"
    }
}