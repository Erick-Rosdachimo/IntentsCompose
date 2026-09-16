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
fun HomeScreen(
    modifier: Modifier = Modifier,
    onAddWordClick: (String) -> Unit
) {
    var currentString by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
            OutlinedTextField(
            value = currentString,
            onValueChange = {},
            readOnly = true,
            label = {
                Text("String")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                onAddWordClick(currentString)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Adicionar palavra")
        }
    }
}