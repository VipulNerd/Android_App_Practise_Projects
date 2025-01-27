package com.example.courses.data

import com.example.courses.R
import com.example.courses.model.Topic

object DataSources {
    fun topics(): List<Topic> {
        return listOf(
            Topic(R.string.tech, 58, R.drawable.image1),
            Topic(R.string.architecture, 42, R.drawable.image2),
            Topic(R.string.design, 30, R.drawable.image3),
            Topic(R.string.architecture, 25, R.drawable.image4),
            Topic(R.string.tech, 58, R.drawable.image1),
            Topic(R.string.architecture, 42, R.drawable.image2),
            Topic(R.string.design, 30, R.drawable.image3),
            Topic(R.string.architecture, 25, R.drawable.image4),
            Topic(R.string.tech, 58, R.drawable.image1),
            Topic(R.string.architecture, 42, R.drawable.image2),
            Topic(R.string.design, 30, R.drawable.image3),
            Topic(R.string.architecture, 25, R.drawable.image4),
            Topic(R.string.tech, 58, R.drawable.image1),
            Topic(R.string.architecture, 42, R.drawable.image2),
            Topic(R.string.design, 30, R.drawable.image3),
            Topic(R.string.architecture, 25, R.drawable.image4),
            Topic(R.string.tech, 58, R.drawable.image1),
            Topic(R.string.architecture, 42, R.drawable.image2),
            Topic(R.string.design, 30, R.drawable.image3),
            Topic(R.string.architecture, 25, R.drawable.image4)

        )
    }
}