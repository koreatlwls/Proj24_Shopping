package com.example.proj24_shopping.presentation.list

import com.example.proj24_shopping.data.entity.product.ProductEntity

internal sealed class ProductListState {

    object UnInitialized: ProductListState()

    object Loading: ProductListState()

    data class Success(
        val productList: List<ProductEntity>
    ): ProductListState()

    object Error: ProductListState()

}
