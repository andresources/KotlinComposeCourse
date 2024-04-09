package com.example.example1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.example1.NavigationRail.NavigationRailSample
import com.example.example1.adaptivelayout.Adaptive1
import com.example.example1.adaptivelayout.AdaptiveLazyGrid
import com.example.example1.adaptivelayout.FlowRowSample
import com.example.example1.adaptivelayout.list_grid.LGMainView
import com.example.example1.animations.MyExpandedList
import com.example.example1.bottomsheet.ModalBottomSheetDemo
import com.example.example1.button.ButtonsEx
import com.example.example1.button.FabClickedScreen
import com.example.example1.button.SharedViewModel
import com.example.example1.camera.CameraDemo
import com.example.example1.carddemo.CardExample
import com.example.example1.carddemo.ExpCard
import com.example.example1.cropimage.SimpleDemo
import com.example.example1.databinding.DataBindingUsingFlowDemo
import com.example.example1.databinding.DataBindingUsingLiveDataDemo
import com.example.example1.databinding.DataBindingUsingState
import com.example.example1.dropdown.Demo_ExposedDropdownMenuBox

import com.example.example1.dropdown.listsgrids.NestedDemo
import com.example.example1.launched_effect.CoroutineScopeDemo
import com.example.example1.launched_effect.DisposableEffectDemo
import com.example.example1.launched_effect.DropDownMenuLaunchedEffectDemo
import com.example.example1.launched_effect.LaunchedEffectDemo
import com.example.example1.layouts.BoxModel1
import com.example.example1.layouts.BoxModel2
import com.example.example1.showhide.ShowHideText
import com.example.example1.state.CounterViewModel
import com.example.example1.state.CreateCustomCard
import com.example.example1.state.CustomCardState
import com.example.example1.state.CustomCardStateViewModel
import com.example.example1.state.CustomComposableDemo
import com.example.example1.state.DerivedStateOfDemo
import com.example.example1.state.MyCoroutineScopeComposable
import com.example.example1.state.SideEffectDemo
import com.example.example1.state.SideEffectDemo8
import com.example.example1.state.StateHoistingComposable
import com.example.example1.state.StateHoistingViewModel
import com.example.example1.state.ViewModelStateManagement
import com.example.example1.switchbutton.Demo_SwitchComponent
import com.example.example1.tabs.TabScreen
import com.mindorks.example.kotlincomposecourse.state.StateButton
import com.mindorks.example.kotlincomposecourse.ui.theme.KotlinComposeCourseTheme

class MainActivity2 : ComponentActivity() {
    private lateinit var itemViewModel: StateHoistingViewModel
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
            val windowSizeClass = calculateWindowSizeClass(this)
            val configuration = LocalConfiguration.current
            val screenW = configuration.screenWidthDp
            KotlinComposeCourseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Adaptive1(windowSizeClass)
                    //CardExample()
                    // NavigationRailSample()
                    //ModalBottomSheetDemo()
                    //DataBindingUsingLiveDataDemo()
                    //DataBindingUsingState()
                    //CoroutineScopeDemo()
                    //DropDownMenuLaunchedEffectDemo()
                    //StateHoistingComposable()
                    //CreateCustomCard("My Card",false,{})
                    /*itemViewModel = StateHoistingViewModel()
                    CustomCardStateViewModel(itemViewModel)*/
                    //ViewModelStateManagement(CounterViewModel())
                    //DerivedStateOfDemo()
                    //SideEffectDemo()
                    //MyCoroutineScopeComposable()
                   // ButtonsEx()
                    StateButton()
                    /*Column(modifier = Modifier.size(200.dp,200.dp)){
                        ExpCard()
                    }*/
                    //MyExpandedList()

                    //FabClickedScreen(SharedViewModel())
                    //CustomComposableDemo()
                    //DataBindingUsingFlowDemo()
                    //SimpleDemo()
                    //SimpleDemo(modifier = Modifier.fillMaxSize())
                    //TabScreen()

                   /*var fg by remember { mutableStateOf(false) }
                   if(fg) {
                       Anim1()
                    }
                    Button(modifier = Modifier.wrapContentHeight().wrapContentWidth(), onClick = {
                        fg = !fg
                    }) {
                        Text(text = "Click")
                    }*/

                }
            }
        }
    }
}
@Composable
fun Anim1() {
    var visible by remember { mutableStateOf(true) }
    val density = LocalDensity.current
    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically {
            // Slide in from 40 dp from the top.
            with(density) { -400.dp.roundToPx() }
        } + expandVertically(
            // Expand from the top.
            expandFrom = Alignment.Top
        ) + fadeIn(
            // Fade in with the initial alpha of 0.3f.
            initialAlpha = 0.3f
        ),
        exit = slideOutVertically() + shrinkVertically() + fadeOut()
    ) {
        Text("Hello",
            Modifier
                .fillMaxWidth()
                .height(200.dp))
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    KotlinComposeCourseTheme() {
        ButtonsEx()
    }
}