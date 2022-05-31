package com.apolisrises.volleyqueryparameter

data class ArtistSearchResponse(
    val resultCount: Int,
    val results: List<Artist>
)