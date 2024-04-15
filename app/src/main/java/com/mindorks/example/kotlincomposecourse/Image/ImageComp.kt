package com.mindorks.example.kotlincomposecourse.Image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mindorks.example.kotlincomposecourse.R

@Composable
fun ImageComp() {
    Column{
        Image(modifier = Modifier.fillMaxWidth().height(120.dp), painter = painterResource(id = R.drawable.rrr) , contentDescription = "Image Desc", contentScale = ContentScale.Crop)
        Image(modifier = Modifier.padding(10.dp).clip(CircleShape).size(100.dp), painter = painterResource(id = R.drawable.rrr) , contentDescription = "Image Desc",contentScale = ContentScale.FillBounds)
        Image(modifier = Modifier.padding(10.dp).clip(RoundedCornerShape(16.dp)).size(200.dp), painter = painterResource(id = R.drawable.rrr) , contentDescription = "Image Desc",contentScale = ContentScale.FillBounds)
        Image(modifier = Modifier.padding(10.dp).clip(CutCornerShape(10.dp)).size(200.dp), painter = painterResource(id = R.drawable.rrr) , contentDescription = "Image Desc",contentScale = ContentScale.FillBounds)
    }
}

@Preview(showBackground = true)
@Composable
fun ImagePreview(){
    ImageComp()
}