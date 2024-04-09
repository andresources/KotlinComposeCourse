package com.mindorks.example.kotlincomposecourse.TextField

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/*
@Composable
fun TextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape =
        MaterialTheme.shapes.small.copy(bottomEnd = ZeroCornerSize, bottomStart = ZeroCornerSize),
    colors: TextFieldColors = TextFieldDefaults.textFieldColors()
)*/

@Composable
fun TextFieldDemo() {
    Column(modifier = Modifier.padding(10.dp)) {
        //SimpleTextField()
         //LabelAndPlaceHolder()
        //TextFieldWithInputType()
        //OutLineTextFieldSample()
        //TextFieldWithIcons()
        //TextFieldWithClearText()
        //TextFieldPasswordShowHide()
        //TextFieldWithErrorState()
        SupportingTextEx()
       /* TextFieldReadOnly()
        TextFieldSingleLine()
        TextFieldMultilines()




        HelperTextDemo()*/
    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTextField() {
    val context = LocalContext.current
    var data = remember { mutableStateOf("") }
    Column{
        Text(text = data.value)
        TextField(value = data.value, onValueChange = {
            data.value = it
        })
    }
    
    /*var text by remember { mutableStateOf("") }
    TextField(
        modifier = Modifier.padding(5.dp),
        value = text,
        onValueChange = { newText ->
            text = newText
        }
    )*/
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LabelAndPlaceHolder() {
    var text by remember { mutableStateOf("") }
    TextField(
        modifier = Modifier.padding(5.dp),
        value = text,
        onValueChange = { newText ->
            text = newText
        },
        label = { Text(text = "Your Name") },
        placeholder = { Text(text = "Please enter Your name") },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldWithInputType() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        modifier = Modifier.padding(5.dp),
        value = text,
        label = { Text(text = "Number Input Type") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        onValueChange = { it ->
            text = it
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutLineTextFieldSample() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        modifier = Modifier.padding(5.dp),
        value = text,
        label = { Text(text = "Enter Your Name") },
        onValueChange = {
            text = it
        }
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldWithIcons() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
     OutlinedTextField(
        value = text,
        leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") },
        trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
        onValueChange = {
            text = it
        },
        label = { Text(text = "Email address") },
        placeholder = { Text(text = "Enter your e-mail") },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldReadOnly() {
    var text by remember { mutableStateOf(TextFieldValue("harry@gmail.com")) }
    OutlinedTextField(
        value = text, readOnly = true,
        onValueChange = {
            text = it
        },
        label = { Text(text = "Email address") }
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldSingleLine() {
    var text by remember { mutableStateOf(TextFieldValue("harry@gmail.com")) }
    OutlinedTextField(
        value = text,
        onValueChange = {
            text = it
        },
        singleLine = true,
        label = { Text(text = "Email address") }
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldMultilines() {
    var text by remember { mutableStateOf(TextFieldValue("harry@gmail.com")) }
    OutlinedTextField(
        value = text,
        onValueChange = {
            text = it
        },
        singleLine = false,
        maxLines = 5,
        label = { Text(text = "Email address") }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldWithClearText() {
    var text by rememberSaveable { mutableStateOf("") }

    TextField(
        value = text,
        modifier = Modifier.padding(5.dp),
        onValueChange = { text = it },
        trailingIcon = {
            Icon(Icons.Default.Clear,
                contentDescription = "clear text",
                modifier = Modifier
                    .clickable {
                        text = ""
                    }
            )
        }

    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldPasswordShowHide() {
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    TextField(
        value = password,
        modifier = Modifier.padding(5.dp),
        onValueChange = { password = it },
        label = { Text("Password") },
        singleLine = true,
        placeholder = { Text("Password") },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (passwordVisible)
                Icons.Filled.Visibility
            else Icons.Filled.VisibilityOff

            // Please provide localized description for accessibility services
            val description = if (passwordVisible) "Hide password" else "Show password"

            IconButton(onClick = {passwordVisible = !passwordVisible}){
                Icon(imageVector  = image, description)
            }
        }
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldWithErrorState() {
    var textInput by remember { mutableStateOf("") }
    var isValid by remember { mutableStateOf(true) }

    TextField(
        value = textInput,
        onValueChange = { input ->
            textInput = input
            isValid = input.isNotEmpty() && input.length>4 // Add your custom validation rules here
        },
        label = { Text("Enter Text") },
        isError = !isValid
    )

    if (!isValid) { //!false -> true
        Text(text = "PLease enter 4 chars.", color = Color.Red)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SupportingTextEx() {
    var text by remember { mutableStateOf("") }
    val maxChar = 8
    TextField(
        value = text,
        onValueChange = {newText ->
            if (newText.length <= maxChar)
                text = newText
        },
        modifier = Modifier.fillMaxWidth(),
        supportingText = {
            Text(
                text = "${text.length} / $maxChar",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End,
            )
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelperTextDemo() {
    val errorMessage = "Text input too long"
    var text by rememberSaveable { mutableStateOf("") }
    var isError by rememberSaveable { mutableStateOf(false) }
    val charLimit = 10

    fun validate(text: String) {
        isError = text.length > charLimit
    }

    TextField(
        value = text,
        onValueChange = {
            text = it
            validate(text)
        },
        singleLine = true,
        isError = isError,
        supportingText = {
            if (isError) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Limit: ${text.length}/$charLimit",
                    color = MaterialTheme.colorScheme.error
                )
            }
        },
        trailingIcon = {
            if (isError)
                Icon(Icons.Filled.Error,"error", tint = MaterialTheme.colorScheme.error)
        }
    )
}


