package com.aleksagn.contactcomposeproject

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp

@Composable
fun InfoRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier.weight(0.5F).padding(5.dp),
            horizontalAlignment = Alignment.End,
        ) {
            Text(
                text = "$label:",
                style = TextStyle(fontStyle = FontStyle.Italic)
            )
        }
        Column(
            modifier = Modifier.weight(0.5F).padding(5.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(value)
        }
    }
}