package com.aliahmed.techtasktemplate.di

import com.aliahmed.techtasktemplate.data.repositories.AccountsRepositoryImpl
import com.aliahmed.techtasktemplate.domain.repository.AccountRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    @Binds
    fun provideRepository(accountRepository: AccountsRepositoryImpl): AccountRepository

}