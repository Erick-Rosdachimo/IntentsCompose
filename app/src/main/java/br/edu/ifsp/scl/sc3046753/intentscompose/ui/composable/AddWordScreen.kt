package br.edu.ifsp.scl.sc3046753.intentscompose.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun AddWordScreen(
    currentString: String,
    modifier: Modifier = Modifier,
    onConcatenateClick: (String) -> Unit
) {
    var newWord by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = currentString,
            onValueChange = {},
            readOnly = true,
            label = {
                Text("String atual")
            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = newWord,
            onValueChange = { newWord = it },
            label = {
                Text("Nova palavra")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                onConcatenateClick(newWord)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Concatenar")
        }
    }
}