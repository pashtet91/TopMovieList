package com.pashtet.topmovielist.model

class MoviewResponse (
    val page: Int,
    val total_results: Int,
    val total_pages: Int,
    var results: List<Movie>
    )
