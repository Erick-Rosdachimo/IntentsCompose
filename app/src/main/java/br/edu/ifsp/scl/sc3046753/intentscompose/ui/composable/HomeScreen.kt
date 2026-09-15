package br.edu.ifsp.scl.sc3046753.intentscompose.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
            OutlinedTextField(
            value = "",
            onValueChange = {},
            readOnly = true,
            label = {
                Text("String")
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}