package br.com.drodrigues.cookitup.presentation.ui.recipe_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.drodrigues.cookitup.domain.model.Recipe
import br.com.drodrigues.cookitup.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class RecipeListViewModel
@Inject
constructor(

    private val repository: RecipeRepository,
    @Named("auth_token") private val token: String

) : ViewModel() {

    val recipes: MutableState<List<Recipe>> = mutableStateOf(listOf())
    val query = mutableStateOf("Chicken")

    init {
        newSearch()
    }

    private fun newSearch() {
        viewModelScope.launch {
            val result = repository.search(
                token = token,
                page = 1,
                query = "Chicken"
            )
            recipes.value = result
        }
    }

    fun onQueryChanged(query: String) {
        this.query.value = query
    }

}