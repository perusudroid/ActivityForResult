package com.androidsolutions.activityforresult

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.androidsolutions.activityforresult.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private val binding by lazy { ActivityProfileBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnEdit.setOnClickListener(onClick)
    }

    private val onClick = View.OnClickListener {
        result.launch(Intent(this, EditProfileActivity::class.java).apply {
            putExtra("data", binding.tv2.text)
        })
    }

    private val result = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK)
            binding.tv2.text = result.data?.getStringExtra("result")
    }
}