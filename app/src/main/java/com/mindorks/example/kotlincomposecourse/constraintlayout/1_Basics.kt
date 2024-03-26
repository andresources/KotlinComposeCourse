package com.example.example1.constraintlayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun ConstraintBasic() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val(btn1,btn2,btn3,btn4,tvCopy,tvMenu,tvFAB,tvCenter,tvFillLeft,container,ct1,ct2,ct3,ct4) = createRefs()

        Button(onClick = { }, modifier = Modifier.constrainAs(btn1) {
            top.linkTo(parent.top,10.dp)
            end.linkTo(parent.end,10.dp)
        }) {
            Text(text = "Button1")
        }
        Button(onClick = { }, modifier = Modifier.constrainAs(btn2) {
            top.linkTo(btn1.bottom,10.dp)
            end.linkTo(parent.end,10.dp)
        }) {
            Text(text = "Button2")
        }
        Button(onClick = { }, modifier = Modifier.constrainAs(btn3) {
            top.linkTo(btn1.bottom,10.dp)
            end.linkTo(btn2.start,10.dp)
        }) {
            Text(text = "Button3")
        }
        Button(onClick = { }, modifier = Modifier.constrainAs(btn4) {
            bottom.linkTo(btn3.bottom,0.dp)
            start.linkTo(parent.start,10.dp)
        }) {
            Text(text = "Button4")
        }
        Text(text = "Copy Rights", modifier = Modifier.constrainAs(tvCopy) {
            bottom.linkTo(parent.bottom,5.dp)
            centerHorizontallyTo(parent)
        })
        Text(text = "Menu", modifier = Modifier.constrainAs(tvMenu) {
            top.linkTo(parent.top,5.dp)
            start.linkTo(parent.start,5.dp)
        })
        Text(text = "FAB", modifier = Modifier.constrainAs(tvFAB) {
            bottom.linkTo(parent.bottom,5.dp)
            end.linkTo(parent.end,5.dp)
        })
        val rightguideLine= createGuidelineFromStart(0.4f)
        val leftguideLine= createGuidelineFromEnd(0.4f)
        Text(text = "Filled Text", modifier = Modifier
            .background(Color.Red)
            .constrainAs(tvCenter) {
                start.linkTo(parent.start)
                top.linkTo(btn4.bottom, 10.dp)
                end.linkTo(rightguideLine)
                width = Dimension.fillToConstraints
                height = Dimension.value(100.dp)
            })

        Text(text = "End Fill", modifier = Modifier
            .background(Color.Red)
            .constrainAs(tvFillLeft) {
                end.linkTo(parent.end)
                top.linkTo(btn2.bottom, 10.dp)
                start.linkTo(leftguideLine)
                width = Dimension.fillToConstraints
            })
        ConstraintLayout(modifier = Modifier.constrainAs(container){
            start.linkTo(tvCenter.end)
            end.linkTo(parent.end)
            bottom.linkTo(tvCenter.bottom)
            width = Dimension.fillToConstraints
        }) {
            Text(text = "T1", textAlign = TextAlign.Center, modifier = Modifier.padding(end = 5.dp, start = 5.dp).background(Color.Red).constrainAs(ct1){
                start.linkTo(parent.start,5.dp)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
            })
            Text(text = "T2",textAlign = TextAlign.Center,modifier = Modifier.padding(end = 5.dp).background(Color.Red).constrainAs(ct2){
                start.linkTo(ct1.end,5.dp)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
            })
            Text(text = "T3",textAlign = TextAlign.Center,modifier = Modifier.padding(end = 5.dp).background(Color.Red).constrainAs(ct3){
                start.linkTo(ct2.end,5.dp)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
            })
            Text(text = "T4",textAlign = TextAlign.Center,modifier = Modifier.padding(end = 5.dp).background(Color.Red).constrainAs(ct4){
                start.linkTo(ct3.end,5.dp)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
            })
            createHorizontalChain(ct1,ct2,ct3,ct4, chainStyle = ChainStyle.Packed)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview1() {
    ConstraintBasic()
}