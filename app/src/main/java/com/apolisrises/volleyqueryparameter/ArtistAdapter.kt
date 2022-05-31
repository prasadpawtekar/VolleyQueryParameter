package com.apolisrises.volleyqueryparameter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apolisrises.volleyqueryparameter.databinding.ViewHolderAlbumBinding

class ArtistAdapter(val artists: List<Artist>
): RecyclerView.Adapter<ArtistViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ViewHolderAlbumBinding.inflate(layoutInflater, parent, false)
        return ArtistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.setData(artists[position])
    }

    override fun getItemCount() = artists.size
}