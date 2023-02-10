package br.com.drodrigues.cookitup.network.response

import br.com.drodrigues.cookitup.network.model.RecipeDto
import com.google.gson.annotations.SerializedName

data class RecipeSearchResponse(

    @SerializedName("count")
    var coun: Int,

    @SerializedName("results")
    var recipes: List<RecipeDto>

)