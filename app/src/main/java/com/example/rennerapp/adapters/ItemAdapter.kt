package com.example.rennerapp.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rennerapp.R
import com.example.rennerapp.models.Product
import kotlinx.android.synthetic.main.list_item.view.*


class ItemAdapter(val itemClick: (position:Int,item: Product) -> Unit) : RecyclerView.Adapter<ItemViewHolder>() {

    private var items: List<Product> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
        holder.itemView.setOnClickListener {
            itemClick(position,items[position])
        }
    }

    override fun getItemCount() = items.size

    fun setItems(newItems: List<Product>) {
        items = newItems
        notifyDataSetChanged()
    }
}

class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: Product) {
        view.list_item_text.text = "${item.name}"
        view.list_item_icon.setImageResource(item.icon)
    }
}
