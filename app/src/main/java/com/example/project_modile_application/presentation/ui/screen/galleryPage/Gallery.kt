package com.example.project_modile_application.presentation.ui.screen.galleryPage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun GalleryPrev() {
    GalleryPage()
}

@Composable
fun GalleryPage() {
    Text("Gallery", modifier = Modifier.fillMaxSize())
    GalleryLayout()
}

@Composable
fun GalleryLayout(modifier: Modifier = Modifier) {
    val items = (1..10).toList()
//    CircularProgressIndicator()
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 84.dp, start = 26.dp, end = 26.dp)
    ) {
        items(items.size) { item ->
            when {
                item % 3 == 0 -> {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(173.dp)
                            .padding(8.dp)
                            .background(Color.Gray),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = item.toString(), color = Color.White)
                    }
                }

                item % 3 == 2 -> {}
                else -> {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(120.dp)
                                .padding(8.dp)
                                .background(Color.LightGray),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = item.toString(), color = Color.Black)
                        }
                        if (item + 1 < items.size) {
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .height(120.dp)
                                    .padding(8.dp)
                                    .background(Color.LightGray),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = (item + 1)/*[counter+1]*/.toString(),
                                    color = Color.Black
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}