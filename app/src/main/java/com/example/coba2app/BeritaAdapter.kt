package com.example.coba2app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coba2app.databinding.ItemBeritaBinding

class BeritaAdapter(
    private val listBerita: List<Berita>,
    private val onItemClick: (Berita) -> Unit
) : RecyclerView.Adapter<BeritaAdapter.BeritaViewHolder>() {

    inner class BeritaViewHolder(
        private val binding: ItemBeritaBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(berita: Berita) {
            binding.berita = berita
            binding.executePendingBindings()

            binding.root.setOnClickListener {
                onItemClick(berita)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaViewHolder {
        val binding = ItemBeritaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return BeritaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BeritaViewHolder, position: Int) {
        holder.bind(listBerita[position])
    }

    override fun getItemCount(): Int {
        return listBerita.size
    }
}