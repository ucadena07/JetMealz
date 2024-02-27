package com.example.mealzapp.screens.MealCategories

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.mealzapp.model.Category
import com.example.mealzapp.screens.MealCategoriesViewModel


@Composable
fun MealsCategoryScreen(vm: MealCategoriesViewModel) {

    Surface(modifier = Modifier
        .fillMaxSize()
        .padding(12.dp)) {
        LazyColumn{
            items(vm.meals.value){
                MealCategory(meal = it)
            }
        }
    }

}


@Composable
fun MealCategory(meal: Category){
    var isExpanded by remember{ mutableStateOf(false)}
    Card(shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)) {
        Row {
            AsyncImage(
                model = meal.strCategoryThumb,
                contentDescription = "image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(88.dp)
                    .padding(4.dp)
                    .align(Alignment.CenterVertically),
            )
            Column(modifier = Modifier
                .align(Alignment.CenterVertically)
                .fillMaxWidth(.8f)
                .padding(16.dp)) {
                Text(text = meal.strCategory, style = MaterialTheme.typography.headlineSmall)
                Text(text = meal.strCategoryDescription, style = MaterialTheme.typography.bodyMedium,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = if (isExpanded) 10 else 3,
                    textAlign = TextAlign.Start)
            }
            Icon(imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown , contentDescription = "arrow",
                modifier = Modifier.padding(16.dp).align(Alignment.CenterVertically).clickable { isExpanded = !isExpanded })
        }
    }

}

@Composable
@Preview(showBackground = true)
fun MealsCategoryScreenPreview(){

        MealCategory(meal = Category(idCategory = "1","Lamb","Lamb, hogget, and mutton are the meat of domestic sheep (species Ovis aries) at different ages",""))

}