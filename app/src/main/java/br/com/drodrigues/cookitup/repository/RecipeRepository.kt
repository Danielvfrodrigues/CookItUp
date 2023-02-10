package br.com.drodrigues.cookitup.repository

import br.com.drodrigues.cookitup.domain.model.Recipe

interface RecipeRepository {

    suspend fun search(token: String, page: Int, query: String): List<Recipe>

    suspend fun get(token: String, id: Int): Recipe
}