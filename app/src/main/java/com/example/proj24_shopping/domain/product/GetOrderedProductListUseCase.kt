package com.example.proj24_shopping.domain.product

import com.example.proj24_shopping.domain.UseCase
import com.example.proj24_shopping.data.entity.product.ProductEntity
import com.example.proj24_shopping.data.repository.ProductRepository

internal class GetOrderedProductListUseCase(
    private val productRepository: ProductRepository
): UseCase {

    suspend operator fun invoke(): List<ProductEntity> {
        return productRepository.getLocalProductList()
    }

}
