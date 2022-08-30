package com.example.data.mapper

import com.example.data.model.MovieResponse
import com.example.domain.model.MovieItem


fun MovieResponse.toDomain(): MovieItem {
    return MovieItem(
        type = this.type,
        description = this.attributes.descr,
        rate = this.attributes.imdb_rate,
        titleEnglish = this.attributes.movie_title,
        titlePersian = this.attributes.movie_title_en,
        imageUrl = this.attributes.pic.movie_img_s
    )
}