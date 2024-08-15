package com.example.ces_sheungkit

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ces_sheungkit.database.EnrollmentDatabase
import com.example.ces_sheungkit.databinding.ActivityScreen2Binding
import com.example.ces_sheungkit.models.EnrollmentItem
import com.example.ces_sheungkit.ui.EnrollmentAdapter
import com.example.ces_sheungkit.ui.EnrollmentViewModel
import com.example.ces_sheungkit.ui.EnrollmentViewModelFactory

class Screen2 : AppCompatActivity() {
    lateinit var binding: ActivityScreen2Binding
    lateinit var adapter: EnrollmentAdapter
    lateinit var viewModel: EnrollmentViewModel

    var dataToDisplay:MutableList<EnrollmentItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreen2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val enrollmentItemDao = EnrollmentDatabase.getDatabase(this).enrollmentItemDao()
        val factory = EnrollmentViewModelFactory(enrollmentItemDao)
        viewModel = ViewModelProvider(this, factory)[EnrollmentViewModel::class.java]

        adapter = EnrollmentAdapter(dataToDisplay)
        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )
        viewModel.enrollmentItems.observe(this) { items ->
            adapter.yourListData = items
            if (items.isEmpty()) {
                binding.textView1.isVisible = false
                binding.textView2.isVisible = false
            }
            adapter.notifyDataSetChanged()
        }
    }
}