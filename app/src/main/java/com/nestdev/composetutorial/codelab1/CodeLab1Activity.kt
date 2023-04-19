package com.nestdev.composetutorial.codelab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
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
        Surface(color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {
            Row(modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = "Hello, ")
                    Text(text = name)
                }
                Button(
                    onClick = { /*TODO*/ },
                    shape = CircleShape,
                    elevation = ButtonDefaults.elevation(defaultElevation = 20.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.White,
                    contentColor = MaterialTheme.colors.primary),

                    modifier = Modifier
                        .weight(1f)
                ) {
                        Text(text = "Show more")
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
