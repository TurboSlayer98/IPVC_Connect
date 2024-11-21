package com.example.ipvcconnect.api

import com.example.ipvcconnect.models.Comment
import com.example.ipvcconnect.models.Company
import com.example.ipvcconnect.models.Course
import com.example.ipvcconnect.models.School
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    // Schools endpoints
    @GET("schools")
    fun getAllSchools(): Call<List<School>>

    @GET("schools/{id}")
    fun getSchoolById(@Path("id") id: Int): Call<School>

    // Courses endpoints
    @GET("courses")
    fun getAllCourses(): Call<List<Course>>

    @GET("courses/{id}")
    fun getCourseById(@Path("id") id: Int): Call<Course>

    // Companies endpoints
    @GET("companies")
    fun getAllCompanies(): Call<List<Company>>

    @GET("companies/{id}")
    fun getCompanyById(@Path("id") id: Int): Call<Company>

    // Comments endpoints
    @GET("companies/{companyId}/comments")
    fun getCompanyComments(@Path("companyId") companyId: Int): Call<List<Comment>>

    @POST("companies/{companyId}/comments")
    fun createComment(
        @Path("companyId") companyId: Int,
        @Body comment: Comment
    ): Call<Comment>

    @PUT("companies/{companyId}/comments/{commentId}")
    fun updateComment(
        @Path("companyId") companyId: Int,
        @Path("commentId") commentId: Int,
        @Body comment: Comment
    ): Call<Comment>
} 