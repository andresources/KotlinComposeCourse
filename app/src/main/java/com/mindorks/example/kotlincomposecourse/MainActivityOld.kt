package com.mindorks.example.kotlincomposecourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.mindorks.example.kotlincomposecourse.croping.ImagesViewModel
import com.mindorks.example.kotlincomposecourse.croping.ViewModelDemo
import com.mindorks.example.kotlincomposecourse.kotlinflows.sharedflow.OneShotOperationUsingSharedFlowComp
import com.mindorks.example.kotlincomposecourse.kotlinflows.sharedflow.SharedFlowFruitsComposable
import com.mindorks.example.kotlincomposecourse.kotlinflows.sharedflow.SharedFlowFruitsViewModel
import com.mindorks.example.kotlincomposecourse.kotlinflows.stateflow.OneShotOperationUsingStateFlowComp
import com.mindorks.example.kotlincomposecourse.kotlinflows.stateflow.StateFlowFruitsComposables
import com.mindorks.example.kotlincomposecourse.kotlinflows.stateflow.StateFlowFruitsViewModel
import com.mindorks.example.kotlincomposecourse.ui.theme.KotlinComposeCourseTheme

class MainActivity : ComponentActivity() {
    val viewModel: ImagesViewModel by viewModels()
    val fruitsViewModel: StateFlowFruitsViewModel by viewModels()
    val fruitViewModel: SharedFlowFruitsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinComposeCourseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //StateFlowFruitsComposables(fruitsViewModel)
                    //SharedFlowFruitsComposable(fruitViewModel)
                    //OneShotOperationUsingStateFlowComp()
                    OneShotOperationUsingSharedFlowComp()
                    //App(viewModel)
                    //TextFieldDemo()
                    //Demo_SwitchComponent()
                    //CheckBoxDemo()
                    //RadioButtonsDemo()
                    //CardsDemo()
                    //TextFieldDemo()
                    //ColumnDemo()
                    //BoxDemo()
                    //BottomNav()
                    //RippleLoadingAnimation()
                    //CardsDemo()
                    //LazyRowDemo()
                    //LazyRowRememberedState()
                    //ValidationsDemo()
                    //StateButton()
                     //TextFieldDemo()
                    //ColumnDemo()
                    //RowDemo()
                    //LazyColumnDemo()
                    //SimpleLazyRow()
                    //ScaffoldExample()
                    //ImageFromCameraContent()
                    /*var size: String by remember {mutableStateOf("Selected Values : ")}
                    Column() {
                        Text(text = "$size")
                        Filters{
                            size = it.toString()
                        }
                    }*/
                   // FlowRowDemo()

                }
            }
        }
    }
}

@Composable
private fun App(viewModel: ImagesViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Green
    ) {
        ViewModelDemo(viewModel = viewModel, modifier = Modifier.fillMaxSize())
//        SimpleDemo(modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinComposeCourseTheme {
        Greeting("Android")
    }
}