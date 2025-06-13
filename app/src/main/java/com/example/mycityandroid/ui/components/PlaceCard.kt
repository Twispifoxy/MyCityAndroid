package com.example.mycityandroid.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mycityandroid.data.model.Place

@Composable
fun PlaceCard(
    place: Place,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .height(100.dp)
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = place.imageResId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
            )
            Spacer(Modifier.width(16.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = place.name,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = place.description,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 3,
                    overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                    textAlign = TextAlign.Justify
                )
            }
        }
    }
}