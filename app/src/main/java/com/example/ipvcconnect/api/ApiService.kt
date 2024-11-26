package com.example.ipvcconnect.api

import com.example.ipvcconnect.models.Comment
import com.example.ipvcconnect.models.Course
import com.example.ipvcconnect.models.Course_Company
import com.example.ipvcconnect.models.School
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("/schools")
    fun getAllSchools(): Call<List<School>>

    @GET("schools/{id}/courses")
    fun getCoursesBySchool(@Path("id") id: Int): Call<List<Course>>

    @GET("courses/{id}/companies")
    fun getCompaniesByCourse(@Path("id") courseId: Int): Call<List<Course_Company>>

    // Comments endpoints
    @GET("companies/{companyId}/comments")
    fun getCompanyComments(@Path("companyId") companyId: Int): Call<List<Comment>>

    @POST("companies/{companyId}/comments")
    fun createComment(
        @Path("companyId") companyId: Int,
        @Body comment: Comment
    ): Call<Comment>
} 