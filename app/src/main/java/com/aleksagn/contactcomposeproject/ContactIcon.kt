package com.aleksagn.contactcomposeproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ContactIcon(contact: Contact) {
    if (contact.imageRes != null) {
        Image(
            modifier = Modifier.fillMaxSize().padding(vertical = 16.dp),
            painter = painterResource(id = contact.imageRes),
            contentScale = ContentScale.Fit,
            contentDescription = null
        )
    } else {
        Box(
            modifier = Modifier.padding(vertical = 16.dp),
            contentAlignment = Alignment.Center) {
            Icon(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.circle),
                contentDescription = null,
                tint = Color.LightGray
            )
            Text(
                style = MaterialTheme.typography.h6,
                text = "${contact.name.take(1)}${contact.familyName.take(1)}")
        }
    }
}
