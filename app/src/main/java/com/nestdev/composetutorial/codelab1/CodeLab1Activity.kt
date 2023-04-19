package com.nestdev.composetutorial.codelab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nestdev.composetutorial.Conversation
import com.nestdev.composetutorial.ui.theme.ComposeTutorialTheme

class CodeLab1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
               MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
    
    @Composable
    private fun Greeting(name: String) {
        //However you can't just assign mutableStateOf to a
        // variable inside a composable. As explained before,
        // recomposition can happen at any time which would
        // call the composable again, resetting the state
        // to a new mutable state with a value of false.
        //
        //To preserve state across recompositions,
        // remember the mutable state using remember.

        val isExpanded = remember { mutableStateOf(false) }
        //remember is used to guard against recomposition, so the state is not reset.
        val extraPadding = if (isExpanded.value) 48.dp else 0.dp

        Surface(color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {
            Row(modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()) {
                Column(modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)) {
                    Text(text = "Hello, ")
                    Text(text = name)
                }
                Button(
                    onClick = { isExpanded.value = !isExpanded.value },
                    shape = CircleShape,
                    elevation = ButtonDefaults.elevation(defaultElevation = 20.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.White,
                    contentColor = MaterialTheme.colors.primary)
                ) {
                        Text(text =  if (isExpanded.value) "Show less" else "Show more")
                }
            }

        }
    }

    @Composable
    private fun MyApp(
        modifier: Modifier,
        names: List<String> = listOf("World", "Compose")
    ) {
        Column(modifier.padding(vertical = 4.dp)) {
            for (name in names)
                Greeting(name = name)
        }
    }

    @Preview(showBackground = true, widthDp = 320)
    @Composable
    fun DefaultPreview() {
        ComposeTutorialTheme {
            MyApp(modifier = Modifier.fillMaxSize())
        }
    }

}
