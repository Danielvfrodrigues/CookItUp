package br.com.drodrigues.cookitup.di

import br.com.drodrigues.cookitup.network.RecipeService
import br.com.drodrigues.cookitup.network.model.RecipeDtoMapper
import br.com.drodrigues.cookitup.repository.RecipeRepository
import br.com.drodrigues.cookitup.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providesRecipeRepository(

        recipeService: RecipeService,
        recipeDtoMapper: RecipeDtoMapper

    ): RecipeRepository {

        return RecipeRepositoryImpl(recipeService, recipeDtoMapper)
    }
}