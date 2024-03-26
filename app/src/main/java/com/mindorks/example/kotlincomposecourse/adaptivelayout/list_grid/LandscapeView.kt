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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
@Composable
fun LandscapeView(itemList:List<Foo> = Foo.foos,size: Dp =250.dp) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(size),
        userScrollEnabled = true,
        modifier = Modifier.padding(10.dp)
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        itemsIndexed(items = itemList,) { index, item ->
            Column(modifier=Modifier

                .background(Color.LightGray, RoundedCornerShape(10.dp))
                .padding(5.dp),horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    modifier=Modifier.fillMaxWidth(.5f),

                    painter = painterResource(id = item.icon),
                    contentDescription = item.title
                )

                Text(item.title,
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style= MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold,
                )
                Text(item.description,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(top = 10.dp).fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    style= MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Normal,
                )
            }

        }

    }
}