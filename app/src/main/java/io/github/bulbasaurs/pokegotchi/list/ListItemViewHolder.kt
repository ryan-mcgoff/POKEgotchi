package io.github.bulbasaurs.pokegotchi.list

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.bulbasaurs.pokegotchi.databinding.ViewHolderListItemBinding

class ListItemViewHolder(itemView: ViewGroup): RecyclerView.ViewHolder(itemView){

    fun bind(text:String){
        ViewHolderListItemBinding.bind(itemView).textView.text = text
    }
}