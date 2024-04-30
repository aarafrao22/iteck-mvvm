package com.aarafrao.itecksamplekotlin.view

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.aarafrao.itecksamplekotlin.R
import com.aarafrao.itecksamplekotlin.databinding.ActivityMainBinding
import com.aarafrao.itecksamplekotlin.network.ApiInterface
import com.aarafrao.itecksamplekotlin.repository.DataRepository
import com.aarafrao.itecksamplekotlin.utilities.ApiUtils
import com.aarafrao.itecksamplekotlin.viewModel.MainViewModel
import com.aarafrao.itecksamplekotlin.viewModel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val apiInterface = ApiUtils.getInstance().create(ApiInterface::class.java)
        val dataRepository = DataRepository(apiInterface)
        viewModel = ViewModelProvider(
            this@MainActivity,
            MainViewModelFactory(dataRepository)
        )[MainViewModel::class.java]

        viewModel.data.observe(this) {
            Log.d("TAG", "onCreate: $it")
            binding.txtHello.text = it.toString()
        }
    }
}
