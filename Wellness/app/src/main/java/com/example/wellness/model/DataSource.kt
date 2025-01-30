package com.example.wellness.model

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.wellness.R

object DataSource {
    fun WellnessQuote() : List<Wellness> {
       return listOf(
            Wellness(
                titleRes = (R.string.title1),
                quote = (R.string.quote1),
                imageRes = (R.drawable.culinary)
            ),
           Wellness(
               titleRes = (R.string.title1),
               quote = (R.string.quote1),
               imageRes = (R.drawable.culinary)
           ),
           Wellness(
               titleRes = (R.string.title1),
               quote = (R.string.quote1),
               imageRes = (R.drawable.culinary)
           ),
           Wellness(
               titleRes = (R.string.title1),
               quote = (R.string.quote1),
               imageRes = (R.drawable.culinary)
           ),
           Wellness(
               titleRes = (R.string.title1),
               quote = (R.string.quote1),
               imageRes = (R.drawable.culinary)
           ),
           Wellness(
               titleRes = (R.string.title1),
               quote = (R.string.quote1),
               imageRes = (R.drawable.culinary)
           )
        )
    }
}