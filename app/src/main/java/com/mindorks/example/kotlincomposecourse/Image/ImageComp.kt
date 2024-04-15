package com.mindorks.example.kotlincomposecourse.Image

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

import com.mindorks.example.kotlincomposecourse.R

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ImageComp() {
    Column(Modifier.verticalScroll(rememberScrollState())){
        Image(modifier = Modifier
            .fillMaxWidth()
            .height(120.dp), painter = painterResource(id = R.drawable.rrr) , contentDescription = "Image Desc", contentScale = ContentScale.Crop)
        Image(modifier = Modifier
            .padding(10.dp).border(BorderStroke(5.dp, Color.Red), CircleShape)
            .clip(CircleShape)
            .size(100.dp), painter = painterResource(id = R.drawable.rrr) , contentDescription = "Image Desc",contentScale = ContentScale.FillBounds)
        Image(modifier = Modifier
            .padding(10.dp)
            .clip(RoundedCornerShape(16.dp))
            .size(200.dp), painter = painterResource(id = R.drawable.rrr) , contentDescription = "Image Desc",contentScale = ContentScale.FillBounds)
        Image(modifier = Modifier
            .padding(10.dp)
            .clip(CutCornerShape(10.dp))
            .size(200.dp), painter = painterResource(id = R.drawable.rrr) , contentDescription = "Image Desc",contentScale = ContentScale.FillBounds)
        /*AsyncImage(
            model = "https://www.sakshi.com/sites/default/files/styles/storypage_main/public/article_images/2024/04/15/BUSINESS-GOLD-123F-COPY.jpg",
            contentDescription = null,
        )*/
        GlideImage(
            model = "https://www.sakshi.com/sites/default/files/styles/storypage_main/public/article_images/2024/04/15/water.jpg?itok=rZK26CCG",
            contentDescription ="tEST",
            modifier = Modifier
                .padding(8.dp)
                .clickable(onClick = {})
                .size(100.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ImagePreview(){
    ImageComp()
}