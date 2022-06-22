package com.omdeep.movieapifetching.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.omdeep.movieapifetching.adapter.MainAdapter
import com.omdeep.movieapifetching.databinding.ActivityMainBinding
import com.omdeep.movieapifetching.factory.MyViewModelFactory
import com.omdeep.movieapifetching.repository.MovieRepository
import com.omdeep.movieapifetching.retrofitService.RetrofitService
import com.omdeep.movieapifetching.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel : MainViewModel

    private val retrofitService = RetrofitService.getInstance()
    val adapter = MainAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TODO: Get VieModel instance using ViewModelProvider.Factory
        viewModel = ViewModelProvider(this, MyViewModelFactory(MovieRepository(retrofitService))).get(
            MainViewModel::class.java
        )

        //TODO: SetAdapter in Recycler View
        binding.recyclerView.adapter = adapter

        //TODO: The observer will only receive events if the owner(activity) is in active state
        //TODO: invoked when movieList data changes
        viewModel.movieList.observe(this, Observer {
            adapter.setMoviesList(it)
        })

        //TODO: Invoked when a network exception occurred
        viewModel.errorMessage.observe(this, Observer {
//            Log.d(TAG, "errorMessage: $it")
            //TODO: Method to show the Toast message through ViewModel
            Toast.makeText(this, "errorMessage: $it", Toast.LENGTH_SHORT)
        })

        viewModel.getAllMovies()
    }
}