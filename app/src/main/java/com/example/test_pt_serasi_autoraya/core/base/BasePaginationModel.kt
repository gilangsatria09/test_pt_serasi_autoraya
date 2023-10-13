package com.example.test_pt_serasi_autoraya.core.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BasePaginationModel<T> (
    val page: Int,
    val results: List<T>,
    @SerialName("total_pages")
    val totalPages: Int,
    @SerialName("total_results")
    val totalResults: Int
)