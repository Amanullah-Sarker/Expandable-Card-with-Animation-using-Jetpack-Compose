package com.amanullah.expandablecardwithanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.amanullah.expandablecardwithanimation.ui.theme.ExpandableCardWithAnimationTheme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpandableCardWithAnimationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ExpandableCard(
                        titleText = "Expandable Card Title",
                        descriptionText = "Expandable Card Title\n" +
                                "Expandable Card Title\n" +
                                "Expandable Card Title\n" +
                                "Expandable Card Title\n" +
                                "Expandable Card Title\n" +
                                "Expandable Card Title\n" +
                                "Expandable Card Title\n" +
                                "Expandable Card Title\n" +
                                "Expandable Card Title\n" +
                                "Expandable Card Title"
                    )
                }
            }
        }
    }
}