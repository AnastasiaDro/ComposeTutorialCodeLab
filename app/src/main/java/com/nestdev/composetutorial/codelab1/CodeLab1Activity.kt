package com.nestdev.composetutorial.codelab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.nestdev.composetutorial.Conversation
import com.nestdev.composetutorial.ui.theme.ComposeTutorialTheme

class CodeLab1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                 //   Conversation(messages = SampleData.conversationSample)
                }
            }
        }
    }
}