package com.example.proj24_shopping.di

import com.example.proj24_shopping.data.db.provideDB
import com.example.proj24_shopping.data.db.provideToDoDao
import com.example.proj24_shopping.data.network.provideProductRetrofit
import com.example.proj24_shopping.data.preference.PreferenceManager
import com.example.proj24_shopping.data.repository.DefaultProductRepository
import com.example.proj24_shopping.data.repository.ProductRepository
import com.example.proj24_shopping.domain.product.DeleteOrderedProductListUseCase
import com.example.proj24_shopping.domain.product.GetOrderedProductListUseCase
import com.example.proj24_shopping.domain.product.GetProductItemUseCase
import com.example.proj24_shopping.domain.product.GetProductListUseCase
import com.example.proj24_shopping.domain.product.OrderProductItemUseCase
import com.example.proj24_shopping.presentation.detail.ProductDetailViewModel
import com.example.proj24_shopping.presentation.list.ProductListViewModel
import com.example.proj24_shopping.presentation.main.MainViewModel
import com.example.proj24_shopping.presentation.profile.ProfileViewModel
import com.example.proj24_shopping.data.network.buildOkHttpClient
import com.example.proj24_shopping.data.network.provideGsonConverterFactory
import com.example.proj24_shopping.data.network.provideProductApiService
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val appModule = module {

    single { Dispatchers.Main }
    single { Dispatchers.IO }

    // ViewModel
    viewModel { MainViewModel() }
    viewModel { ProductListViewModel(get()) }
    viewModel { ProfileViewModel(get(), get(), get()) }
    viewModel { (productId: Long) -> ProductDetailViewModel(productId, get(), get()) }

    // UseCase
    factory { GetProductListUseCase(get()) }
    factory { GetOrderedProductListUseCase(get()) }
    factory { GetProductItemUseCase(get()) }
    factory { OrderProductItemUseCase(get()) }
    factory { DeleteOrderedProductListUseCase(get()) }

    // Repository
    single<ProductRepository> { DefaultProductRepository(get(), get(), get()) }

    single { provideGsonConverterFactory() }

    single { buildOkHttpClient() }

    single { provideProductRetrofit(get(), get()) }

    single { provideProductApiService(get()) }

    single { PreferenceManager(androidContext()) }

    // Database
    single { provideDB(androidApplication()) }
    single { provideToDoDao(get()) }

}

