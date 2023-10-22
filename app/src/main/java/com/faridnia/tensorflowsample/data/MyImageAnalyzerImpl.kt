package com.faridnia.tensorflowsample.data

import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.faridnia.tensorflowsample.domain.Classification
import com.faridnia.tensorflowsample.domain.MyImageClassifier
import com.faridnia.tensorflowsample.presentaion.centerCrop

class MyImageAnalyzerImpl(
    private val classifier: MyImageClassifier,
    private val onResults: (List<Classification>) -> Unit
): ImageAnalysis.Analyzer {

    private var frameSkipCounter = 0

    override fun analyze(image: ImageProxy) {
        if(frameSkipCounter % 60 == 0) {
            val rotationDegrees = image.imageInfo.rotationDegrees
            val bitmap = image
                .toBitmap()
                .centerCrop(224, 224)

            val results = classifier.classify(bitmap, rotationDegrees)
            onResults(results)
        }
        frameSkipCounter++

        image.close()
    }
}