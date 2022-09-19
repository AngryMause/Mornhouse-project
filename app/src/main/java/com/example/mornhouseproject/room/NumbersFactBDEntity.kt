package com.example.mornhouseproject.room

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mornhouseproject.model.NumberFactModel
import com.example.mornhouseproject.network.ApiModel
import kotlinx.parcelize.Parcelize

const val FACT_TABLE = "number_fact"

@Parcelize
@Entity(tableName = FACT_TABLE)
data class NumbersFactBDEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "number", collate = ColumnInfo.NOCASE)
    val number: Long,
    @ColumnInfo(name = "fact", collate = ColumnInfo.NOCASE)
    val fact: String,
) : Parcelable {
    fun toNumberFactModel(): NumberFactModel = NumberFactModel(
        id = id,
        number = number,
        fact = fact
    )


    companion object {
        fun fromApiModel(apiModel: ApiModel): NumbersFactBDEntity =
            NumbersFactBDEntity(
                id = 0,
                number = apiModel.number,
                fact = apiModel.text
            )

    }


}