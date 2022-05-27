package com.androidsolutions.activityforresult

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.androidsolutions.activityforresult.databinding.ActivityEditProfileBinding


class EditProfileActivity : AppCompatActivity() {

    private val binding by lazy { ActivityEditProfileBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getInputs()
        binding.btnUpdate.setOnClickListener(onClick)
    }

    private fun getInputs() {
        intent?.extras?.getString("data")?.let {
            binding.etInput.setText(it)
        }
    }

    private val onClick = View.OnClickListener {
        setResult(Activity.RESULT_OK, Intent().apply {
            putExtra("result", binding.etInput.text.toString())
        })
        finish()
    }


}