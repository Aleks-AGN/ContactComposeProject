package com.aleksagn.contactcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class RootActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

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
                        text = "${contact.name} ${contact.surname.orEmpty()}"
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

    @Preview(name = "portrait", showSystemUi = true)
    @Composable
    fun ContactDetailsPreview() {
        ContactDetails(
            contact = Contact(
                name = "Евгений",
                surname = "Андреевич",
                familyName = "Лукашин",
                isFavorite = true,
                phone = "+7 495 495 95 95",
                address = "г. Москва, 3-я улица Строителей, д. 25, кв. 12",
                email = "ELukashin@practicum.ru"
            )
        )
    }

    @Preview(name = "portrait", showSystemUi = true)
    @Composable
    fun ContactDetailsPreview2() {
        ContactDetails(
            contact = Contact(
                name = "Василий",
                familyName = "Кузякин",
                imageRes = R.drawable.johnson,
                phone = "---",
                address = "Ивановская область, дер. Крутово, д. 4",
            )
        )
    }
}
