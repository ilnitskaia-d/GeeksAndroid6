package com.example.geeksandroid6

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

import com.bumptech.glide.Glide
import com.example.geeksandroid6.databinding.ItemModelBinding

class ModelAdapter(
    private val list: List<Character>?,
    onClick: (model: Character) -> Unit
): Adapter<ModelAdapter.ModelViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        return ModelViewHolder(ItemModelBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        holder.bind(list!![position])
    }

    inner class ModelViewHolder(private val binding: ItemModelBinding): ViewHolder(binding.root) {
        fun bind(model: Character) = with(binding) {
            tvName.text = model.name
            Glide
                .with(ivChar)
                .load(model.image)
                .centerCrop()
                .into(ivChar)

            itemView.setOnClickListener {  }

        }
    }
}