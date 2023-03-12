package com.example.khabeertask.presentation

import android.graphics.*
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.khabeertask.R
import com.example.khabeertask.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpUi()
        setUpFollow()

    }

    private fun setUpFollow() {

    }

    private fun setUpUi() {
        val bitmap = Bitmap . createBitmap (500, 500, Bitmap.Config.ARGB_8888)

// Create a canvas from the bitmap
        val canvas = Canvas(bitmap)

// Define the bounds of the arcs using a RectF object
        val bounds = RectF(50f, 50f, 450f, 450f)

// Define the colors for the arcs using Paint objects
        val paint1 = Paint().apply { color = ContextCompat.getColor(this@MainActivity , R.color.garey) }
        val paint2 = Paint().apply { color = ContextCompat.getColor(this@MainActivity , R.color.yellow) }


// Draw the arcs using the canvas drawArc() method
        canvas.drawArc(bounds, -10f, 107f, true, paint1)
        canvas.drawArc(bounds, 90f, 260f, true, paint2)

// set bitmap as background to ImageView
        binding.ratioImage.setImageBitmap(bitmap)
    }
}