package com.example.example1.cropimage
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.FileProvider
import com.example.example1.camera.createImageFile
import com.mindorks.example.kotlincomposecourse.ui.theme.KotlinComposeCourseTheme

import com.mr0xf00.easycrop.*
import com.mr0xf00.easycrop.ui.ImageCropperDialog
import kotlinx.coroutines.launch
import java.util.Objects

@Composable
fun SimpleDemo(modifier: Modifier = Modifier) {
    val imageCropper = rememberImageCropper()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    var selectedImage by remember { mutableStateOf<ImageBitmap?>(null) }
    var error by remember { mutableStateOf<CropError?>(null) }
    /*val imagePicker = rememberImagePicker(onImage = { uri ->
        scope.launch {
            when (val result = imageCropper.crop(uri, context)) {
                CropResult.Cancelled -> {}
                is CropError -> error = result
                is CropResult.Success -> {
                    selectedImage = result.bitmap
                }
            }
        }
    })*/

    val file = context.createImageFile()
    val uri = FileProvider.getUriForFile(
        Objects.requireNonNull(context),
        "com.exa.provider", file
    )
    val cameraLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) {
            scope.launch {
                when (val result = imageCropper.crop(uri, context)) {
                    CropResult.Cancelled -> {}
                    is CropError -> error = result
                    is CropResult.Success -> {
                        selectedImage = result.bitmap
                    }
                }
            }
        }

    if (imageCropper.cropState != null) {
        KotlinComposeCourseTheme(darkTheme = true) {
            ImageCropperDialog(state = imageCropper.cropState!!)
        }
    }
    if (imageCropper.cropState == null && imageCropper.loadingStatus != null) {
        LoadingDialog(status = imageCropper.loadingStatus!!)
    }
    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Please seletect Text")
        if (selectedImage != null) Image(
            bitmap = selectedImage!!, contentDescription = null,
            modifier = Modifier.weight(1f)
        ) /*else Box(contentAlignment = Alignment.Center, modifier = Modifier.weight(1f)) {
            Text("No image selected !")
        }*/
        Row {
            Button(onClick = { /*imagePicker.pick()*/ }) { Text("Choose Image") }
            Button(onClick = { cameraLauncher.launch(uri) }) { Text("Choose Camera") }
        }

    }
    error?.let { CropErrorDialog(it, onDismiss = { error = null }) }

    /*DemoContent(
       cropState = imageCropper.cropState,
       loadingStatus = imageCropper.loadingStatus,
       selectedImage = selectedImage,
       onPick = { imagePicker.pick() },
       onPick1 = { cameraLauncher.launch(uri) },
       modifier = modifier
   )*/
}