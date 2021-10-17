package edu.temple.imageactivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelectionFragment : Fragment() {
    lateinit var layout: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        layout = inflater.inflate(R.layout.fragment_selection, container, false)
        var recycler = layout.findViewById<RecyclerView>(R.id.recyclerView)
        recycler.layoutManager = GridLayoutManager(layout.context, 3)
        var arr : ArrayList<Image> = ArrayList<Image>()
        val names = arguments?.getStringArrayList("names")!!

        // I am definitely doing this wrong
        for ((count, r) in arguments?.getIntegerArrayList("resources")!!.withIndex()) {
            arr.add(Image(names[count], r))
        }

        val onClickListener = View.OnClickListener {
            val itemPosition = recycler.getChildAdapterPosition(it)

        }

        recycler.adapter = ImageAdapter(layout.context, arr.toArray() as Array<Image>, onClickListener)
        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
