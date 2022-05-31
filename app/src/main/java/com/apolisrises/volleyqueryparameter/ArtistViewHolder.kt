package com.apolisrises.volleyqueryparameter

import androidx.recyclerview.widget.RecyclerView
import com.apolisrises.volleyqueryparameter.databinding.ViewHolderAlbumBinding

class ArtistViewHolder(val binding: ViewHolderAlbumBinding
): RecyclerView.ViewHolder(binding.root) {

    fun setData(album: Artist) {
        binding.apply {
            tvArtistName.text = "Artist: ${album.artistName}"
            tvReleaseDate.text = "Release Date: ${album.releaseDate}"
            tvTrackName.text = "Track: ${album.trackName}"
        }
    }
}