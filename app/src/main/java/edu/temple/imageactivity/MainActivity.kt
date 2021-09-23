package edu.temple.imageactivity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = GridLayoutManager(baseContext, 3)

        // it seems I need to set an adapter or some thing
        recyclerView.adapter = ImageAdapter(this, getImageData())
    }

    // returns all the mountain images and their descriptions
    fun getImageData() : Array<Image> {
        val images = arrayOf(Image("Mountain in China",R.drawable.chinamountain),
            Image("Mountain Fog",R.drawable.foggymountain),
            Image("Gravelly Mountaintop",R.drawable.gravelmountain),
            Image("Spiky Icy Mountains",R.drawable.icespike),
            Image("Reflection in a lake",R.drawable.mountainreflection),
            Image("Mountain-top Trail",R.drawable.mountaintrail),
            Image("Orange Canyon",R.drawable.orangecanyon),
            Image("Orangish Mountain",R.drawable.orangemountain),
            Image("Swiss Alps",R.drawable.switzerland),
            Image("Yosemite",R.drawable.yosemite)
        );
        return images
    }
}