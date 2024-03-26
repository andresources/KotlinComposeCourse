package com.example.example1.adaptivelayout.list_grid

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun PortraitView(itemList:List<Foo> = Foo.foos) {
    val listState = rememberLazyListState()
    LazyColumn(
        state = listState,
        userScrollEnabled = true,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White,RoundedCornerShape(10.dp))
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(itemList) {item ->

            Row(modifier=Modifier.fillMaxWidth()
                .background(Color.LightGray,RoundedCornerShape(10.dp))
                .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically)
            {

                Image(
                    modifier=Modifier.fillMaxWidth(.2f),
                    painter = painterResource(id = item.icon),
                    contentDescription = item.title
                )

                Column(modifier=Modifier
                    .background(Color.Gray,RoundedCornerShape(10.dp))
                    .padding(10.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {


                    Text(item.title,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Start,
                        style= MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.ExtraBold,
                    )
                    Text(item.description,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(top = 0.dp).fillMaxWidth(),
                        textAlign = TextAlign.Start,
                        style= MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Normal,
                    )
                }

            }
        }

    }
}