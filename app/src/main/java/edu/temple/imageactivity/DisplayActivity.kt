package edu.temple.imageactivity

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        val text = intent.getStringExtra("text")
        val image = intent.getIntExtra("image", R.drawable.smokey_mountains)

        // get views
        val imageView = findViewById<ImageView>(R.id.displayImage)
        val textView = findViewById<TextView>(R.id.displayText)

        imageView.setImageResource(image)
        textView.text = text
    }
}