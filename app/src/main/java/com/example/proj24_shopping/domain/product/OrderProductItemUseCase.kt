package com.example.proj24_shopping.domain.product

import com.example.proj24_shopping.domain.UseCase
import com.example.proj24_shopping.data.entity.product.ProductEntity
import com.example.proj24_shopping.data.repository.ProductRepository

internal class OrderProductItemUseCase(
    private val productRepository: ProductRepository
): UseCase {

    suspend operator fun invoke(productEntity: ProductEntity): Long {
        return productRepository.insertProductItem(productEntity)
    }

}
