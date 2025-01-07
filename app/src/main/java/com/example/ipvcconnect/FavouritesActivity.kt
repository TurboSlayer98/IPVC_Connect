package com.example.ipvcconnect

import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ipvcconnect.adapter.CompaniesAdapter
import com.example.ipvcconnect.api.ApiClient
import com.example.ipvcconnect.api.ApiService
import com.example.ipvcconnect.dataaccessobjects.FavouritesDao
import com.example.ipvcconnect.database.AppDatabase
import com.example.ipvcconnect.models.Company
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FavouritesActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase
    private lateinit var favouritesDao: FavouritesDao
    private lateinit var adapter: CompaniesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_favourites)

        // Inicializar banco de dados
        database = AppDatabase.getDatabase(this)
        favouritesDao = database.FavouritesDao()

        // Configurar RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = CompaniesAdapter(emptyList()) // Inicializa com uma lista vazia
        recyclerView.adapter = adapter

        // Carregar empresas favoritas
        loadFavourites()

        // Configurar botão de voltar
        findViewById<ImageButton>(R.id.buttonBack).setOnClickListener {
            finish()
        }
    }

    private fun loadFavourites() {
        lifecycleScope.launch {
            favouritesDao.getFavourites().collect { favourites ->
                if (favourites.isNotEmpty()) {
                    // Aqui você deve buscar as empresas correspondentes aos IDs armazenados
                    val companyIds = favourites.map { it.company_id }
                    // Chame um metodo para buscar as empresas usando os IDs
                    fetchCompaniesByIds(companyIds)
                } else {
                    Toast.makeText(this@FavouritesActivity, "Nenhuma empresa favorita encontrada", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun fetchCompaniesByIds(companyIds: List<Int>) {
        val request = ApiClient.buildService(ApiService::class.java)
        // Create a call to fetch companies by their IDs
        val call = request.getAllCompanies() // Assuming this returns all companies
        call.enqueue(object : Callback<List<Company>> {
            override fun onResponse(call: Call<List<Company>>, response: Response<List<Company>>) {
                if (response.isSuccessful) {
                    // Filter the companies based on the favorite IDs
                    val allCompanies = response.body()!!
                    val favoriteCompanies = allCompanies.filter { company -> company.id in companyIds }
                    adapter = CompaniesAdapter(favoriteCompanies)
                    findViewById<RecyclerView>(R.id.recyclerView).adapter = adapter
                } else {
                    Toast.makeText(this@FavouritesActivity, "Failed to load companies", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Company>>, t: Throwable) {
                Toast.makeText(this@FavouritesActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
} 