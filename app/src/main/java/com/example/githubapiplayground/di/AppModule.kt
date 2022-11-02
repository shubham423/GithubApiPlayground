package com.example.githubapiplayground.di

import com.example.githubapiplayground.data.network.GithubApi
import com.example.githubapiplayground.data.repository.GithubRepository
import com.example.githubapiplayground.data.repository.GithubRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideGithubRepository(
        api: GithubApi
    ): GithubRepository {
        return GithubRepositoryImpl(api)
    }

}