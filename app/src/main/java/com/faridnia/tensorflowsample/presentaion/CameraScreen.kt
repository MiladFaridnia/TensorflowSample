package com.faridnia.tensorflowsample.presentaion

import androidx.camera.view.LifecycleCameraController
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.faridnia.tensorflowsample.domain.Classification


@Composable
fun CameraScreen(controller: LifecycleCameraController, classifications: List<Classification>) {

/*    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {*/

    Box(
            modifier = Modifier
                .fillMaxSize()
        ) {

        CameraPreview(controller,
            Modifier
//                .height(900.dp)
                .fillMaxHeight()
                .fillMaxWidth() //.fillMaxSize()
        )


        Text(
                text = "Agha Bardia",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .padding(8.dp),
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.primary
            )


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
            ) {
                classifications.forEach {
                    Text(
                        text = it.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.primaryContainer)
                            .padding(8.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }


        }
//    }

}