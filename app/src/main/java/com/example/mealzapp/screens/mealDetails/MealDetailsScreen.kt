package com.example.mealzapp.screens.mealDetails

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.mealzapp.model.Category

@Composable
fun MealDetailScreen(navController: NavHostController, meal: Category?) {
    var isExpanded by remember { mutableStateOf(false)}
    var profilePicState by remember { mutableStateOf(MealPropsPicState.Normal)}
    val transition = updateTransition(targetState = profilePicState, label = null)
    val imageSizeDp by transition.animateDp(
        targetValueByState ={
                            it.size
        },label = ""
    )
    val color by transition.animateColor(
        targetValueByState = {
            it.color
        }, label = ""
    )

    val width by transition.animateDp(
        targetValueByState = {
            it.borderWidth
        }, label = ""
    )


    Column(modifier = Modifier.fillMaxSize()) {
        Row {
            if(meal != null){
                Card(colors = CardDefaults.cardColors(containerColor = Color.White),
                    modifier = Modifier.padding(16.dp),
                    shape = CircleShape,
                    border = BorderStroke(
                        width = width,
                        color = color
                    )
                ) {

                    AsyncImage(
                        model = meal.strCategoryThumb,

                        contentDescription = "image",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(imageSizeDp)
                            .padding(8.dp)
                            .clip(CircleShape)

                    )
                }
                Text(text = meal.strCategory, modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterVertically))
            }

        }
        Button(onClick = { profilePicState = if(profilePicState == MealPropsPicState.Normal) MealPropsPicState.Expanded else MealPropsPicState.Normal}, modifier = Modifier.padding(16.dp)) {
            Text(text = "Change state of the image")
        }
    }
}

enum class MealPropsPicState(val color: Color,val size: Dp, val borderWidth: Dp){
    Normal(Color.Magenta,120.dp,8.dp),
    Expanded(Color.Green,200.dp,24.dp)
}