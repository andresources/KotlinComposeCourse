package com.example.example1.cropimage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.dp
import com.mindorks.example.kotlincomposecourse.ui.theme.KotlinComposeCourseTheme

import com.mr0xf00.easycrop.CropState
import com.mr0xf00.easycrop.CropperLoading
import com.mr0xf00.easycrop.ui.ImageCropperDialog


@Composable
fun DemoContent(
    cropState: CropState?,
    loadingStatus: CropperLoading?,
    selectedImage: ImageBitmap?,
    onPick: () -> Unit,
    onPick1: () -> Unit,
    modifier: Modifier = Modifier,
) {
    if (cropState != null) {
        KotlinComposeCourseTheme(darkTheme = true) {
            ImageCropperDialog(state = cropState)
        }
    }
    if (cropState == null && loadingStatus != null) {
        LoadingDialog(status = loadingStatus)
    }
    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Please seletect Text")
        if (selectedImage != null) Image(
            bitmap = selectedImage, contentDescription = null,
            modifier = Modifier.weight(1f)
        ) /*else Box(contentAlignment = Alignment.Center, modifier = Modifier.weight(1f)) {
            Text("No image selected !")
        }*/
        Row {
            Button(onClick = onPick) { Text("Choose Image") }
            Button(onClick = onPick1) { Text("Choose Camera") }
        }

    }
}