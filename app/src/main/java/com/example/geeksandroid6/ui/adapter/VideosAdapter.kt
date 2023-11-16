package com.example.geeksandroid6.ui.adapter

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.geeksandroid6.data.model.PlaylistItem
import com.example.geeksandroid6.databinding.ItemVideoBinding
import org.koin.core.component.getScopeId

class VideosAdapter: ListAdapter<PlaylistItem, VideosAdapter.VideoViewHolder>(
    VideoItemDiffUtil()
) {
    class VideoViewHolder(private val binding: ItemVideoBinding): ViewHolder(binding.root) {
        fun onBind(item: PlaylistItem?) {
            binding.tvTitle.text = item?.snippet?.title
            Glide.with(itemView.context)
                .load(item?.snippet?.thumbnails?.url)
                .into(binding.ivVideo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder = VideoViewHolder(
        ItemVideoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class VideoItemDiffUtil: DiffUtil.ItemCallback<PlaylistItem>() {
        override fun areItemsTheSame(oldItem: PlaylistItem, newItem: PlaylistItem): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: PlaylistItem, newItem: PlaylistItem): Boolean = oldItem == newItem
    }
}