package com.example.ipvcconnect.api

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
//    private const val BASE_URL = "https://ivvpzpqmkofpeznhjnym.supabase.co"
//
//    private val client = OkHttpClient.Builder()
//        .build()
//
//    private val retrofit = Retrofit.Builder()
//        .baseUrl(BASE_URL)
//        .addConverterFactory(GsonConverterFactory.create())
//        .client(client)
//        .build()
//
//    fun <T> buildService(service: Class<T>): T {
//        return retrofit.create(service)
//    }
    val supabase = createSupabaseClient(
        supabaseUrl = "https://ivvpzpqmkofpeznhjnym.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Iml2dnB6cHFta29mcGV6bmhqbnltIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzI1NjEyNTUsImV4cCI6MjA0ODEzNzI1NX0.Gc-og5rl_hmnx1huhhf2wx32qkVGkRZ9ConejAascO8"
    ) {
        install(Postgrest)
    }

}