package edu.temple.imageactivity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter (val _context: Context, _imageObjects: Array<Image>) : RecyclerView.Adapter<Image>() {
    // https://developer.android.com/guide/topics/ui/layout/recyclerview
    // Implement this. It's a slightly different pattern than the in class example
    val images = _imageObjects
    val inflater = LayoutInflater.from(_context) // idk what this does

    // ViewHolder class that will be custom for my image layout
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView : ImageView
        init {

        }
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun getItem(pos: Int): Any {
        return images[pos]
    }

    // kinda redundant, maybe could be used to
    override fun getItemId(pos: Int): Long {
        return pos.toLong()
    }

    override fun getView(pos: Int, convertView: View?, viewGroup: ViewGroup?): View {
        var layout : View
        var imageName: TextView
        var imageView: ImageView

        // Reuses a view if one is provided through convertView, else it makes a new one
        if (convertView is ConstraintLayout)
            layout = convertView
        else
            layout = inflater.inflate(R.layout.activity_main, null) // What's the right layout here?
            // layout = inflater.inflate(r.layout.spinner_layout, null)

        // I also don't see where the imageViews come from... I thought this view was for the big display
        imageView = layout.findViewById(R.id.imageView)
        imageName = layout.findViewById(R.id.imageName)

        imageView.setImageResource(images[pos].resource)
        imageName.text = images[pos].name

        return layout.apply{ alpha = .3f}
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return getView(position, convertView, parent).apply { alpha = 1f }
    }
}