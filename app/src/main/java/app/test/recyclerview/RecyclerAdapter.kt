package app.test.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var titles = arrayOf("Chapter one", "Chapter two", "Chapter three", "Chapter four", "Chapter five", "Chapter six", "Chapter seven", "Chapter eight")

    private var details = arrayOf("Item one details", "Item two details", "Item three details", "Item four details", "Item five details", "Item six details", "Item seven details", "Item eight details")

    private var images = arrayOf(R.drawable.aaa, R.drawable.aaa, R.drawable.aaa, R.drawable.aaa, R.drawable.aaa, R.drawable.aaa, R.drawable.aaa, R.drawable.aaa)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemDetail.text = details[position]
        holder.itemImage.setImageResource(images[position])
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val itemImage: ImageView
        val itemTitle: TextView
        val itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)

            itemView.setOnClickListener {
                val position: Int = adapterPosition

                Toast.makeText(itemView.context, "You clicked on ${titles[position]}", Toast.LENGTH_SHORT).show()
            }

        }

    }

}