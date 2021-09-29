package edu.temple.imageactivity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.core.graphics.drawable.toBitmap
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class ImageAdapter (val _context: Context, _imageObjects: Array<Image>, _textView : TextView, _imageView : ImageView) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {
    // https://developer.android.com/guide/topics/ui/layout/recyclerview
    // Implement this. It's a slightly different pattern than the in class example
    private val images = _imageObjects
    private val context = _context
    private val topImageView = _imageView
    private val topTextView = _textView

    // ViewHolder class that will be custom for my image layout
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView : ImageView

        init {
            imageView = view.findViewById(R.id.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.grid_image, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // resize image to avoid bugs with larger image sizes drawing on canvas
        var img = images[position].resource
        holder.imageView.setImageResource(img)
        // it's actually easier to get the bitmap once it's been loaded into the image view so I'm gonna use that
        var bitmap = holder.imageView.drawable.toBitmap(600,300)
        var largeBitmap = holder.imageView.drawable.toBitmap(1200, 600)
        // so setting this should resize the images bitmap
        holder.imageView.setImageBitmap(bitmap)

        //  set image call back to set the big image and the text
        holder.imageView.setOnClickListener{
            // was still getting crashes since I'm using wallpapers, so I figure I have no choice but to resize the big image too
//            topImageView.setImageBitmap(largeBitmap)
//
//            // add image content details
//            topImageView.contentDescription = images[position].name
//            topTextView.text = images[position].name
            val intent = Intent(context, DisplayActivity::class.java).apply {
                putExtra("text", images[position].name)
                putExtra("image", img)
            }
            // need to call the start activity from the top level context
            context.startActivity(intent)
        }
    }

    // I love this syntax.
    override fun getItemCount() = images.size

    // kinda redundant, maybe could be used tho
    override fun getItemId(pos: Int): Long {
        return pos.toLong()
    }

   // Probably can reuse some of this code for the callback function

//    override fun getView(pos: Int, convertView: View?, viewGroup: ViewGroup?): View {
//        var layout : View
//        var imageName: TextView
//        var imageView: ImageView
//
//        // Reuses a view if one is provided through convertView, else it makes a new one
//        if (convertView is ConstraintLayout)
//            layout = convertView
//        else
//            layout = inflater.inflate(R.layout.activity_main, null) // What's the right layout here?
//            // layout = inflater.inflate(r.layout.spinner_layout, null)
//
//        // I also don't see where the imageViews come from... I thought this view was for the big display
//        imageView = layout.findViewById(R.id.imageView)
//        imageName = layout.findViewById(R.id.imageName)
//
//        imageView.setImageResource(images[pos].resource)
//        imageName.text = images[pos].name
//
//        return layout.apply{ alpha = .3f}
//    }

}