package com.example.tasks.service.repository.local

import androidx.room.Dao
import androidx.room.Insert
import com.example.tasks.service.model.PriorityModel
import retrofit2.http.Query

@Dao
interface PriorityDAO {
    @Insert
    fun save(list: List<PriorityModel>)

    @androidx.room.Query("SELECT * FROM priority")
    fun list():List<PriorityModel>

    @androidx.room.Query("SELECT description FROM priority WHERE id = :id")
    fun getDescription(id:Int):String

   @androidx.room.Query("DELETE FROM priority")
    fun clear()
}