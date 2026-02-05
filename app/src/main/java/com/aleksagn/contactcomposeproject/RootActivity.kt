package com.aleksagn.contactcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class RootActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactDetails(Contact1())
        }
    }

    @Composable
    fun Contact1() : Contact {
        return Contact(
            name = "Евгений",
            surname = "Андреевич",
            familyName = "Лукашин",
            isFavorite = true,
            phone = "+7 495 495 95 95",
            address = "г. Москва, 3-я улица Строителей, д. 25, кв. 12",
            email = "ELukashin@practicum.ru"
        )
    }

    @Composable
    fun Contact2() : Contact {
        return Contact(
            name = "Василий",
            familyName = "Кузякин",
            imageRes = R.drawable.johnson,
            phone = "---",
            address = "Ивановская область, дер. Крутово, д. 4"
        )
    }

    @Preview(name = "portrait", showSystemUi = true)
    @Composable
    fun ContactDetailsPreview() {
        ContactDetails(Contact1())
    }

    @Preview(name = "portrait", showSystemUi = true)
    @Composable
    fun ContactDetailsPreview2() {
        ContactDetails(Contact2())
    }
}
