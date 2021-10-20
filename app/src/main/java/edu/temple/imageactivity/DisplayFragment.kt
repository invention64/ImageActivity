package edu.temple.imageactivity

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class DisplayFragment : Fragment() {
    private lateinit var model: ImageViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = ViewModelProvider(this).get(ImageViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var imgView = view.findViewById<ImageView>(R.id.displayImage)
        var txtView = view.findViewById<TextView>(R.id.displayText)

        model.selected.observe(viewLifecycleOwner, Observer<Image>{ img ->
            imgView.setImageResource(img.resource)
            txtView.text = img.name
        })
    }
}