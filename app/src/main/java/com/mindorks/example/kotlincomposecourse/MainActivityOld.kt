package com.mindorks.example.kotlincomposecourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.example1.dropdown.listsgrids.LazyColumnList
import com.example.example1.launched_effect.CoroutineScopeDemo
import com.mindorks.example.kotlincomposecourse.animations.AnimatedContentDemo
import com.mindorks.example.kotlincomposecourse.animations.AnimatedContentSizeDemo
import com.mindorks.example.kotlincomposecourse.animations.AnimatedVisibilityDemo
import com.mindorks.example.kotlincomposecourse.croping.ImagesViewModel
import com.mindorks.example.kotlincomposecourse.croping.ViewModelDemo
import com.mindorks.example.kotlincomposecourse.kotlinflows.sharedflow.SharedFlowFruitsViewModel
import com.mindorks.example.kotlincomposecourse.kotlinflows.stateflow.StateFlowFruitsViewModel
import com.mindorks.example.kotlincomposecourse.animations.ShowHideComposable
import com.mindorks.example.kotlincomposecourse.animations.ValueBasedAnimDemo
import com.mindorks.example.kotlincomposecourse.dialogs.MyDialogComp
import com.mindorks.example.kotlincomposecourse.dialogs.ShowHideTextDemo
import com.mindorks.example.kotlincomposecourse.gradients.GradientsDemo
import com.mindorks.example.kotlincomposecourse.launched_effect.LaunchedEffectOneTime
import com.mindorks.example.kotlincomposecourse.mvvm.ex1.CreditCardScreen
import com.mindorks.example.kotlincomposecourse.mvvm.ex1.viewmodel.CreditCardViewModel
import com.mindorks.example.kotlincomposecourse.mvvm.ex2.PostListComposable
import com.mindorks.example.kotlincomposecourse.mvvm.ex2.PostViewModel
import com.mindorks.example.kotlincomposecourse.mvvm.ex3.Ex3PostListComposable
import com.mindorks.example.kotlincomposecourse.mvvm.ex3.GenericPostsViewModel
import com.mindorks.example.kotlincomposecourse.navigationdrawer.DefaultNavDrawerComposable
import com.mindorks.example.kotlincomposecourse.navigationdrawer.DrawerAppComponent
import com.mindorks.example.kotlincomposecourse.responsive.ResponsiveHomeScreen
import com.mindorks.example.kotlincomposecourse.responsive.ResponsiveViewModel
import com.mindorks.example.kotlincomposecourse.reusablebutton.DemoComposable
import com.mindorks.example.kotlincomposecourse.snackbarhost.SnackBarHostComposable
import com.mindorks.example.kotlincomposecourse.testing.viewmodel.TestingComposable
import com.mindorks.example.kotlincomposecourse.ui.theme.KotlinComposeCourseTheme

class MainActivity : ComponentActivity() {
    val viewModel: ImagesViewModel by viewModels()
    val fruitsViewModel: StateFlowFruitsViewModel by viewModels()
    val fruitViewModel: SharedFlowFruitsViewModel by viewModels()
    private val creditCardViewModel: CreditCardViewModel by viewModels()
    private val postViewModel: PostViewModel by viewModels()
    private val reVm: ResponsiveViewModel by viewModels()
    //private val genericPostsViewModel: GenericPostsViewModel by viewModels()

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinComposeCourseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    /*val windowSize = calculateWindowSizeClass(this)
                    ResponsiveHomeScreen(windowSize = windowSize.widthSizeClass,reVm)*/
                    DefaultNavDrawerComposable()
                    //AnimatedVisibilityDemo()
                    //AnimatedContentDemo()
                    //AnimatedContentSizeDemo()
                    //ValueBasedAnimDemo()
                    //GradientsDemo()
                    //CreditCardScreen(creditCardViewModel)
                    //PostListComposable(postViewModel)
                    /*val genericPostsViewModel = hiltViewModel<GenericPostsViewModel>()
                    Ex3PostListComposable(genericPostsViewModel)*/
                    //DemoComposable()
                    //ShowHideTextDemo()
                    //CoroutineScopeDemo()
                    //LaunchedEffectOneTime()
                    //TestingComposable()
                    //CreditCardScreen()
                    //LazyColumnList()
                    //SnackBarHostComposable()
                    //MyDialogComp()
                    //StateFlowFruitsComposables(fruitsViewModel)
                    //SharedFlowFruitsComposable(fruitViewModel)
                    //OneShotOperationUsingStateFlowComp()
                    //OneShotOperationUsingSharedFlowComp()
                    //SnapshotflowComp()
                    //ImageComp()
                    //AlertDialogComp()
                    //MyDialogComp()
                    //ShapesComposable()
                   // LazyVerticalGridDemo()
                    //LazyHorizontalGridDemo()
                    //ReusableComposable()
                    //ShowHideComposable()
                    //BackbuttonHandler()

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