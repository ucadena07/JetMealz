package com.example.mealzapp.screens.mealDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.mealzapp.model.Category

@Composable
fun MealDetailScreen(navController: NavHostController, meal: Category?) {
    Column {
        Row {
            if(meal != null){
                Card {
                    AsyncImage(
                        model = meal.strCategoryThumb,
                        contentDescription = "image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(200.dp)
                            .padding(4.dp)
                    )
                }
                Text(text = meal.strCategory)
            }

        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Change state of the image")
        }
    }
}