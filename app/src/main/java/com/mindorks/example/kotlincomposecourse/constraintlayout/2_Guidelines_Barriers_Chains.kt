package com.example.example1.constraintlayout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.mindorks.example.kotlincomposecourse.R


@Composable
fun MovieBookingScreen() {
    //https://proandroiddev.com/getting-started-with-constraint-layout-in-jetpack-compose-48d4e02b76fd
    Surface(color = Color.White) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (
                menuButton, coverImage, titleText, genreText, ratingText,
                castText, castContainer, castImage1, castImage2, castImage3, castImage4,
                descText, bottomSurface, bookButton, cinemaNameContainer,
            ) = createRefs()

            val rightGuideline = createGuidelineFromStart(0.4f)

            //Top menu - ICON
            Icon(
                painter = painterResource(id = R.drawable.ic_menu),
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
                    .constrainAs(menuButton) {
                        start.linkTo(parent.start, 16.dp)
                        top.linkTo(parent.top, 16.dp)
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.rrr), contentDescription = null,
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                modifier = Modifier
                    .constrainAs(coverImage) {
                        start.linkTo(parent.start, 24.dp)
                        top.linkTo(menuButton.bottom, 16.dp)
                        end.linkTo(rightGuideline, 16.dp)
                        width = Dimension.fillToConstraints
                    }
                    .aspectRatio(2f / 3f),
            )

            Text(
                text = "Deadpool",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.constrainAs(titleText) {
                    top.linkTo(menuButton.bottom, 8.dp)
                    start.linkTo(coverImage.end, 16.dp)
                }
            )
            Text(
                text = "Action | 1h 48m",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.constrainAs(genreText) {
                    top.linkTo(titleText.bottom)
                    start.linkTo(coverImage.end, 16.dp)
                }
            )

            Text(
                text = "IMDb 8.0/10",
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.constrainAs(ratingText) {
                    top.linkTo(genreText.bottom, 16.dp)
                    start.linkTo(coverImage.end, 16.dp)
                }
            )

            Text(
                text = "CAST",
                fontSize = 14.sp,
                color = Color.Gray,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.constrainAs(castText) {
                    bottom.linkTo(castContainer.top)
                    start.linkTo(coverImage.end, 16.dp)
                }
            )
            ConstraintLayout(modifier = Modifier.constrainAs(castContainer) {
                bottom.linkTo(coverImage.bottom)
                start.linkTo(coverImage.end, 16.dp)
                end.linkTo(parent.end, 16.dp)
                width = Dimension.fillToConstraints
            }) {
                Image(
                    painter = painterResource(id = R.drawable.i1),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(50.dp)
                        .constrainAs(castImage1) {
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            start.linkTo(coverImage.end, 16.dp)
                        }
                        .aspectRatio(1f)
                )

                Image(
                    painter = painterResource(id = R.drawable.i1),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(50.dp)
                        .constrainAs(castImage2) {
                            top.linkTo(castImage1.top)
                            bottom.linkTo(castImage1.bottom)
                            start.linkTo(castImage1.end)
                        }
                        .aspectRatio(1f)
                )

                Image(
                    painter = painterResource(id = R.drawable.i1),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(50.dp)
                        .constrainAs(castImage3) {
                            top.linkTo(castImage1.top)
                            bottom.linkTo(castImage1.bottom)
                            start.linkTo(castImage2.end)
                        }
                        .aspectRatio(1f)
                )

                Box(modifier = Modifier
                    .height(50.dp)
                    .background(color = colorResource(id = R.color.black))
                    .constrainAs(castImage4) {
                        top.linkTo(castImage1.top)
                        bottom.linkTo(castImage1.bottom)
                        start.linkTo(castImage3.end)
                        end.linkTo(parent.end, 16.dp)
                    }
                    .aspectRatio(1f))
                {
                    Text(
                        text = "+9",
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp,
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .align(Alignment.Center),
                        color = Color.Black
                    )
                }

                createHorizontalChain(
                    castImage1, castImage2, castImage3, castImage4,
                    chainStyle = ChainStyle.SpreadInside
                )
            }
            val barrier = createBottomBarrier(coverImage, castContainer)

            Text(
                text = "This is movie information...",
                color = Color(0x8A000000),
                fontSize = 16.sp,
                modifier = Modifier.constrainAs(descText) {
                    top.linkTo(barrier, 18.dp)
                    start.linkTo(parent.start, 24.dp)
                    end.linkTo(parent.end, 24.dp)
                    width = Dimension.preferredWrapContent
                }
            )
            Surface(color = colorResource(id = R.color.gray),
                modifier = Modifier.constrainAs(bottomSurface) {
                    top.linkTo(descText.bottom, 36.dp)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
            ) {}
            val (date1, date2, date3, date4, date5, date6, date7,
                day1, day2, day3, day4, day5, day6, day7, dateSelector, dateMarker) = createRefs()

            val selectedDateStartState = remember { mutableStateOf(day1.start) }
            val selectedDateEndState = remember { mutableStateOf(day1.end) }

            Surface(
                color = Color.White,
                modifier = Modifier
                    .constrainAs(dateSelector) {
                        top.linkTo(descText.bottom, 36.dp)
                        start.linkTo(selectedDateStartState.value)
                        end.linkTo(selectedDateEndState.value)
                        bottom.linkTo(day1.bottom)
                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints
                    }
            ) {}

            Surface(
                color = Color.Black,
                modifier = Modifier
                    .height(4.dp)
                    .constrainAs(dateMarker) {
                        top.linkTo(dateSelector.top)
                        start.linkTo(dateSelector.start)
                        end.linkTo(dateSelector.end)
                        width = Dimension.fillToConstraints
                    }
            ) {}
            Text(
                text = "20",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 14.sp,
                modifier = Modifier
                    .constrainAs(date1) {
                        top.linkTo(descText.bottom, 52.dp)
                        start.linkTo(day1.start)
                        end.linkTo(day1.end)
                    }
                    .clickable {
                        selectedDateStartState.value = day1.start
                        selectedDateEndState.value = day1.end
                    }
            )
            Text(
                text = "SUN",
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.gray),
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, bottom = 16.dp)
                    .constrainAs(day1) {
                        top.linkTo(date1.bottom, 16.dp)
                    }
                    .clickable {
                        selectedDateStartState.value = day1.start
                        selectedDateEndState.value = day1.end
                    }
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    //MovieBookingScreen()
}