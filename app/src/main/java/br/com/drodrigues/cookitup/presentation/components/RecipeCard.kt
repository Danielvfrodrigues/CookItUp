package br.com.drodrigues.cookitup.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import br.com.drodrigues.cookitup.domain.model.Recipe
import br.com.drodrigues.cookitup.util.DEFAULT_RECIPE_IMAGE
import br.com.drodrigues.cookitup.util.loadPicture

@Composable
fun RecipeCard(

    recipe: Recipe,
    onClick: () -> Unit,

) {

    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                vertical = 6.dp
            )
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )

    ) {
        Column {
            recipe.featuredImage?.let { url ->

                val image = loadPicture(
                    url = url, defaultImage = DEFAULT_RECIPE_IMAGE).value

                image?.let { img ->
                    Image(
                        bitmap = img.asImageBitmap(),
                        contentDescription = "Image of an empty plate",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(225.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            recipe.title?.let { title ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            vertical = 12.dp,
                            horizontal = 8.dp
                        )

                ) {
                    Text(
                        text = title,
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = recipe.rating.toString(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.End)
                            .align(Alignment.CenterVertically),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}