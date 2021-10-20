package edu.temple.imageactivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelectionFragment : Fragment() {
    lateinit var layout: View

    lateinit var imageArray : Array<Image>
    private lateinit var model: ImageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        imageArray = getImageData()
        super.onCreate(savedInstanceState)
        model = ViewModelProvider(this).get(ImageViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // create the layout
        layout = inflater.inflate(R.layout.fragment_selection, container, false)
        var recycler = layout.findViewById<RecyclerView>(R.id.recyclerView)
        recycler.layoutManager = GridLayoutManager(layout.context, 3)

        /*
//        var arr : ArrayList<Image> = ArrayList<Image>()
//        val names : ArrayList<String> = arguments?.getStringArrayList("names")!!
//
//        // I am definitely doing this wrong
//        for ((count, r) in arguments?.getIntegerArrayList("resources")!!.withIndex()) {
//            arr.add(Image(names[count], r))
//        }
*/

        val onClickListener = View.OnClickListener {
            val pos = recycler.getChildAdapterPosition(it)
            println("Position clicked is: $pos")
            model.select(imageArray[pos])
        }

        recycler.adapter = ImageAdapter(layout.context, imageArray, onClickListener)

        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
    }

    // Wrong way to do this entirely my dudes!
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

    companion object {
        fun getInstance(imgs : Array<Image>) : SelectionFragment {
            val fragment = SelectionFragment()
            val bundle: Bundle = Bundle()
            // break the array in half, since I'm too lazy to implement it as parcelable
            var names : ArrayList<String> = ArrayList<String>()
            var resources : ArrayList<Int> = ArrayList<Int>()

            for (i in imgs) {
                names.add(i.name)
                resources.add(i.resource)
            }

            bundle.putStringArrayList("names", names)
            bundle.putIntegerArrayList("resources", resources)

            fragment.arguments = bundle
            return fragment
        }
    }
}
