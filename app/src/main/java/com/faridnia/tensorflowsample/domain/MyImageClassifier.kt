package com.faridnia.tensorflowsample.domain

import android.graphics.Bitmap

interface MyImageClassifier {
    fun classify(bitmap: Bitmap, rotation: Int): List<Classification>
}