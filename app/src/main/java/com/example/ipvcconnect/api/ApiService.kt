package com.example.ipvcconnect.api

import com.example.ipvcconnect.models.Comment
import com.example.ipvcconnect.models.Company
import com.example.ipvcconnect.models.Course
import com.example.ipvcconnect.models.School
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    // Schools endpoints
    @GET("schools")
    suspend fun getAllSchools(): Response<List<School>>

    @GET("schools/{id}")
    suspend fun getSchoolById(@Path("id") id: Int): Response<School>

    // Courses endpoints
    @GET("courses")
    suspend fun getAllCourses(): Response<List<Course>>

    @GET("courses/{id}")
    suspend fun getCourseById(@Path("id") id: Int): Response<Course>

    // Companies endpoints
    @GET("companies")
    suspend fun getAllCompanies(): Response<List<Company>>

    @GET("companies/{id}")
    suspend fun getCompanyById(@Path("id") id: Int): Response<Company>

    // Comments endpoints
    @GET("companies/{companyId}/comments")
    suspend fun getCompanyComments(@Path("companyId") companyId: Int): Response<List<Comment>>

    @POST("companies/{companyId}/comments")
    suspend fun createComment(
        @Path("companyId") companyId: Int,
        @Body comment: Comment
    ): Response<Comment>

    @PUT("companies/{companyId}/comments/{commentId}")
    suspend fun updateComment(
        @Path("companyId") companyId: Int,
        @Path("commentId") commentId: Int,
        @Body comment: Comment
    ): Response<Comment>
} 