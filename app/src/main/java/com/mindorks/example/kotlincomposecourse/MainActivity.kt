package com.example.example1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.example1.camera.CameraDemo
import com.example.example1.dropdown.Demo_DropDownMenu
import com.example.example1.dropdown.Demo_DropDownMenuStatic
import com.example.example1.dropdown.Demo_ExposedDropdownMenuBox
import com.example.example1.dropdown.listsgrids.EmpList
import com.example.example1.dropdown.listsgrids.EmpListRow
import com.example.example1.dropdown.listsgrids.LazyColumnList
import com.example.example1.dropdown.listsgrids.LazyHorizontalGridDemo
import com.example.example1.dropdown.listsgrids.LazyRowEmpList
import com.example.example1.dropdown.listsgrids.LazyVerticalGridDemo
import com.example.example1.dropdown.listsgrids.NestedDemo
import com.example.example1.dropdown.listsgrids.NestedScrollScreen

import com.example.example1.dropdown.myAlertDialogBox
import com.example.example1.dropdown.showMyDialog
import com.example.example1.switchbutton.Demo_SwitchComponent
import com.example.example1.ui.theme.Example1Theme

class MainActivity : ComponentActivity() {

    private val _showProgress: MutableState<Emp> = mutableStateOf(Emp())
    val showProgress: State<Emp> = _showProgress
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Example1Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    //Greeting("Android")
                    //Demo_ExposedDropdownMenuBox()
                    //Demo_ExposedDropdownMenuBox()
                    //NestedDemo()
                    CameraDemo()
                    /*Column(){
                        val context = LocalContext.current
                        Text(text = "Name : ${showProgress.value.name}")
                        Text(text = "Sal : ${showProgress.value.sal}")
                        Button(onClick = {
                            _showProgress.value = _showProgress.value.copy(name ="KSR", sal = 10000)
                        }) {
                            Text(text = "Submit")
                        }
                    }*/
                }
            }
        }
    }
}
data class Emp(val name: String = "",val sal:Int = 0)

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
    Example1Theme {
        //Greeting("Android")
        //Demo_ExposedDropdownMenuBox()
    }
}