package com.example.ipvcconnect.dataaccessobjects

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.ipvcconnect.models.Comment
import kotlinx.coroutines.flow.Flow

@Dao
interface CommentsDao {
    @Query("SELECT * FROM comments WHERE company_id = :company_id ORDER BY id DESC")
    fun getCommentsByCompany(company_id: Int): Flow<List<Comment>>

    @Insert
    suspend fun insertComment(comment: Comment)
} 