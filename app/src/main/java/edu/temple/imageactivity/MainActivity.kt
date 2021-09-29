package edu.temple.imageactivity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = GridLayoutManager(this, 3)

        // get the reference to the two main activity elements
        val textView = findViewById<TextView>(R.id.imageName)
        val imageView = findViewById<ImageView>(R.id.imageView)

        // it seems I need to set an adapter or some thing
        recyclerView.adapter = ImageAdapter(this, getImageData(), textView, imageView)
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
            Image("Bucegi Mountains",R.drawable.bucegi_mountains_romania),
            Image("Bushy Mountains",R.drawable.bushy_mountain),
            Image("Desert Mountains",R.drawable.desert_mountains),
            Image("Ozark",R.drawable.ozark),
            Image("Qinling Mountains",R.drawable.qinling_mountains),
            Image("Rocky Mountain Frozen Lake",R.drawable.rocky_mountain_national_park_frozen_lake),
            Image("Smokey Mountain",R.drawable.smokey_mountains),
            Image("Snowy Australian Mountain Range",R.drawable.snowy_mountains_range_in_new_south_wales_australia_wallpaper)
        );
        return images
    }
}