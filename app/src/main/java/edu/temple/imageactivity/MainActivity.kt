package edu.temple.imageactivity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentContainerView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var selectionFragment = SelectionFragment.getInstance(getImageData())
        var displayFragment = DisplayFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.selectionFragmentContainerView, selectionFragment)
            .add(R.id.displayFragmentContainerView, displayFragment)
            .commit()
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