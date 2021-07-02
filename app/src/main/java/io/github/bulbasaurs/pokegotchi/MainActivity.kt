package io.github.bulbasaurs.pokegotchi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import io.github.bulbasaurs.pokegotchi.databinding.ActivityMainBinding
import io.github.bulbasaurs.pokegotchi.list.ListAdapter
import io.github.bulbasaurs.pokegotchi.list.ListViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: ListViewModel by viewModels()

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        viewModel.load()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        val adapter = ListAdapter()
        binding.recyclerView.adapter = adapter

        viewModel.venues.observe(this){
            adapter.data = it
        }
    }
}