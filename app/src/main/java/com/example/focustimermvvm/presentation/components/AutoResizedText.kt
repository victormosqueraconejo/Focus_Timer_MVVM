package com.example.focustimermvvm.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.focustimermvvm.presentation.theme.FocusTimerMVVMTheme

@Composable
fun AutoResizedText (
    modifier: Modifier = Modifier,
    text : String,
    textStyle : TextStyle = MaterialTheme.typography.displayLarge
) {

    var timeTextStyle by remember { mutableStateOf(textStyle) }
    var fontSizeFactor = 0.95

    Text(
        text,
        modifier = modifier.fillMaxWidth(),
        softWrap = false,
        style = timeTextStyle,
        onTextLayout = {
            if (it.didOverflowWidth) {
               timeTextStyle = timeTextStyle.copy(
                   fontSize = timeTextStyle.fontSize * fontSizeFactor
               )
            }
        }
    )


}


@Preview()
@Composable
fun AutoResizedTextPreview () {

    FocusTimerMVVMTheme(
        content ={
            AutoResizedText(text = "Prueba")
        }
    )
}

