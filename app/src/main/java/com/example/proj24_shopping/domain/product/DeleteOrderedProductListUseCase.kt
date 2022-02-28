package com.example.proj24_shopping.domain.product

import com.example.proj24_shopping.domain.UseCase
import com.example.proj24_shopping.data.repository.ProductRepository

internal class DeleteOrderedProductListUseCase(
    private val productRepository: ProductRepository
): UseCase {

    suspend operator fun invoke() {
        return productRepository.deleteAll()
    }

}
