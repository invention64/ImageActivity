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
        val imgArr = resources.getStringArray(R.array.mountains)
        val images = arrayOf(Image(imgArr[0],R.drawable.chinamountain),
            Image(imgArr[1],R.drawable.foggymountain),
            Image(imgArr[2],R.drawable.gravelmountain),
            Image(imgArr[3],R.drawable.icespike),
            Image(imgArr[4],R.drawable.mountainreflection),
            Image(imgArr[5],R.drawable.mountaintrail),
            Image(imgArr[6],R.drawable.orangecanyon),
            Image(imgArr[7],R.drawable.orangemountain),
            Image(imgArr[8],R.drawable.switzerland),
            Image(imgArr[9],R.drawable.bucegi_mountains_romania),
            Image(imgArr[10],R.drawable.bushy_mountain),
            Image(imgArr[11],R.drawable.desert_mountains),
            Image(imgArr[12],R.drawable.ozark),
            //Image(imgArr[13],R.drawable.qinling_mountains),
            Image(imgArr[14],R.drawable.rocky_mountain_national_park_frozen_lake),
            Image(imgArr[15],R.drawable.smokey_mountains),
            Image(imgArr[16],R.drawable.snowy_mountains_range_in_new_south_wales_australia_wallpaper)
        );
        return images
    }
}