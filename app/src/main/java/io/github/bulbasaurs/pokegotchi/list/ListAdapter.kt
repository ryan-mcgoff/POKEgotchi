package io.github.bulbasaurs.pokegotchi.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.bulbasaurs.pokegotchi.database.data.VenueEntity
import io.github.bulbasaurs.pokegotchi.databinding.ViewHolderListItemBinding

class ListAdapter: RecyclerView.Adapter<ListItemViewHolder>() {

    var data:List<VenueEntity> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val binding = ViewHolderListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListItemViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.bind(text = data[position].headerLocation)
    }

    override fun getItemCount(): Int = data.size
}