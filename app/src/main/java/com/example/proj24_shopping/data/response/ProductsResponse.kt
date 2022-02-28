package com.example.proj24_shopping.data.response

import com.example.proj24_shopping.data.response.ProductResponse

data class ProductsResponse(
    val items: List<ProductResponse>,
    val count: Int
)
