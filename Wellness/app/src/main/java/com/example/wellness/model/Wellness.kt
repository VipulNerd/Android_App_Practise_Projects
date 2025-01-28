package com.example.wellness.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Wellness(
    @StringRes val titleRes: Int,
    @StringRes val quote: Int,
    @DrawableRes val imageRes: Int
)