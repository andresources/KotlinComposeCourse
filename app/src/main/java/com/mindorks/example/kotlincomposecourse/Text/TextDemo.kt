package com.mindorks.example.kotlincomposecourse.Text

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mindorks.example.kotlincomposecourse.R
import com.mindorks.example.kotlincomposecourse.ui.theme.robots

@Composable
fun TextDemo(){
    //BasicMarqueeSample()
    TextFillMaxSize()
    //TextFillMaxWidth()
    //TextFillMaxWidth()

}

@Composable
fun TextFillMaxSize() {

    Column {
        Text(text = "Hello", modifier = Modifier
            .background(Color.Red)
            .fillMaxSize(), textAlign = TextAlign.Center)
    }
}

@Composable
fun TextFillMaxWidth() {
    Column {
        Text(
            text = "Hello", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
        )
    }
}

@Composable
fun TextFillMaxHeight() {
    Column {
        Text(
            text = "Hello", modifier = Modifier
                .background(Color.Red)
                .fillMaxHeight()
        )
    }
}

@Composable
fun basicText(){
   Text(text = "Simple Text")
}
@Composable
fun basicColorText(){
    Text(text = "Simple Text", color = MaterialTheme.colorScheme.primary)
}
@Composable
fun basicFontsSizesText(){
    Text(text = "Simple Text", fontSize = 18.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace)
}
@Composable
fun basicCustomFontsText(){
    Text(text = "Simple Text", fontSize = 18.sp, fontFamily = robots,fontWeight = FontWeight.Light)
}

@Composable
fun basicInlineCustomFontsText(){
    Text(text = "Simple Text", fontSize = 14.sp, fontFamily = FontFamily(Font(R.font.roboto_light)))
}
@Composable
fun shadowText(){
    val offset = Offset(5.0f, 10.0f)
    Text(text = "Simple Text", fontSize = 14.sp, style = TextStyle(fontSize = 24.sp,
        shadow = Shadow(
            color = Color.Blue, offset = offset, blurRadius = 3f
        )))
}
@Composable
fun MultipleStylesInText() {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Blue)) {
                append("H")
            }
            append("ello ")

            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
                append("W")
            }
            append("orld")
        }
    )
}

@Composable
fun GradientColorsText(){
    val gradientColors = listOf(Cyan, Color.Blue, Color.Magenta)
    Text(
        text = stringResource(id = R.string.app_name),
        style = TextStyle(
            brush = Brush.linearGradient(
                colors = gradientColors
            )
        )
    )
}
@Composable
fun SpanStyleText(){
    val gradientColors = listOf(Cyan, Color.Blue, Color.Magenta)
    Text(
        text = buildAnnotatedString {
            append("Do not allow people to dim your shine")
            withStyle(
                SpanStyle(
                    brush = Brush.linearGradient(
                        colors = gradientColors
                    )
                )
            ) {
                append("because they are blinded.")
            }
            append("\nTell them to put some sunglasses on.")
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BasicMarqueeSample() {
    // Marquee only animates when the content doesn't fit in the max width.
    Column(Modifier.width(400.dp)) {
        Text(
            "Learn about why it's great to use Jetpack Compose",
            modifier = Modifier.basicMarquee(delayMillis = 100),
            fontSize = 50.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TextPreview(){
    SpanStyleText()
}