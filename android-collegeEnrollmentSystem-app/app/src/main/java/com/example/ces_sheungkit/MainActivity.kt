package com.example.ces_sheungkit

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.ces_sheungkit.database.EnrollmentDatabase
import com.example.ces_sheungkit.databinding.ActivityMainBinding
import com.example.ces_sheungkit.models.EnrollmentItem
import com.example.ces_sheungkit.ui.EnrollmentViewModel
import com.example.ces_sheungkit.ui.EnrollmentViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: EnrollmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val enrollmentItemDao = EnrollmentDatabase.getDatabase(this).enrollmentItemDao()
        val factory = EnrollmentViewModelFactory(enrollmentItemDao)
        viewModel = ViewModelProvider(this, factory)[EnrollmentViewModel::class.java]

        binding.btnEnroll.setOnClickListener {
            val studentName = binding.etName.text.toString()
            val className = binding.etClass.text.toString()

            if (studentName.isNotEmpty() && className.isNotEmpty()) {
                val enrollmentItem =
                    EnrollmentItem(
                        studentName = studentName,
                        className = className
                    )
                viewModel.insertItem(enrollmentItem)
                binding.etName.text.clear()
                binding.etClass.text.clear()
                binding.textResult.text = "Enrollment successful"
                binding.textResult.isVisible = true
            } else {
                binding.textResult.text = "All fields are required"
                binding.textResult.isVisible = true
            }
        }

        binding.btnViewDetails.setOnClickListener {
            val intent = Intent(this@MainActivity, Screen2::class.java)
            startActivity(intent)
            binding.textResult.isVisible = false
        }
    }
}