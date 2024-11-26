package com.example.ipvcconnect.api

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.PropertyConversionMethod
import io.github.jan.supabase.realtime.Realtime
import io.github.jan.supabase.storage.Storage
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.time.Duration.Companion.seconds

object ApiClient {
    private const val BASE_URL = "https://ivvpzpqmkofpeznhjnym.supabase.co"

    private val client = OkHttpClient.Builder()
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }

//    val supabase = createSupabaseClient(
//        supabaseUrl = "https://ivvpzpqmkofpeznhjnym.supabase.co",
//        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Iml2dnB6cHFta29mcGV6bmhqbnltIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzI1NjEyNTUsImV4cCI6MjA0ODEzNzI1NX0.Gc-og5rl_hmnx1huhhf2wx32qkVGkRZ9ConejAascO8"
//    ) {
//        install(Postgrest) {
//            defaultSchema = "ipvconnect" // default: "public"
//            propertyConversionMethod = PropertyConversionMethod.SERIAL_NAME // default: PropertyConversionMethod.CAMEL_CASE_TO_SNAKE_CASE
//        }
//        install(Storage) {
//            transferTimeout = 90.seconds // Default: 120 seconds
//        }
//        install(Realtime) {
//            reconnectDelay = 5.seconds // Default: 7 seconds
//        }
//    }

}