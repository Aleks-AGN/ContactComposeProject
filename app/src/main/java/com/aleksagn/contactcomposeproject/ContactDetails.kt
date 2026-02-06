package com.aleksagn.contactcomposeproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun ContactDetails(contact: Contact) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.25F),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.weight(0.5F)
            ) {
                ContactIcon(contact)
            }
            Column(
                modifier = Modifier.weight(0.5F),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    style = MaterialTheme.typography.h6,
                    text = listOf(contact.name, contact.surname).filterNotNull().joinToString(" ")
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        style = MaterialTheme.typography.h5,
                        text = contact.familyName
                    )
                    if (contact.isFavorite) Image(
                        modifier = Modifier.padding(start = 8.dp)
                            .align(Alignment.CenterVertically),
                        painter = painterResource(id = android.R.drawable.star_big_on),
                        contentDescription = null
                    )
                }
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(0.75F)
        ) {
            InfoRow(label = stringResource(id = R.string.phone), value = contact.phone)

            InfoRow(label = stringResource(id = R.string.address), value = contact.address)

            contact.email?.let {
                InfoRow(label = stringResource(id = R.string.email), value = it)
            }
        }
    }
}
