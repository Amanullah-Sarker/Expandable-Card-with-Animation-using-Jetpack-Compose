package com.amanullah.expandablecardwithanimation

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.amanullah.expandablecardwithanimation.ui.theme.Shapes

@ExperimentalMaterialApi
@Composable
fun ExpandableCard(
    titleText: String = "Demo Title",
    titleTextFontSize: TextUnit = MaterialTheme.typography.h4.fontSize,
    titleTextFontWeight: FontWeight = FontWeight.Bold,
    titleTextFontColor: Color = MaterialTheme.colors.primary,
    titleTextMaxLine: Int = 1,
    titleTextOverflow: TextOverflow = TextOverflow.Ellipsis,

    descriptionText: String = "Demo Description",
    descriptionTextFontSize: TextUnit = MaterialTheme.typography.subtitle1.fontSize,
    descriptionTextFontWeight: FontWeight = FontWeight.Thin,
    descriptionTextFontColor: Color = MaterialTheme.colors.secondary,
    descriptionTextMaxLine: Int = 5,
    descriptionTextOverflow: TextOverflow = TextOverflow.Ellipsis,
    descriptionTextBackgroundColor: Color = MaterialTheme.colors.primaryVariant
)
{
    var expandedState by remember { mutableStateOf(false) }
    val rotateState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = Shapes.medium,
//        onClick = {
//            expandedState =! expandedState
//        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .weight(6f),
                    text = titleText,
                    fontSize = titleTextFontSize,
                    fontWeight = titleTextFontWeight,
                    color = titleTextFontColor,
                    maxLines = titleTextMaxLine,
                    overflow = titleTextOverflow
                )

                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium)
                        .weight(1f)
                        .rotate(rotateState),
                    onClick = {
                        expandedState =! expandedState
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop Down Icon")
                }
            }
            if (expandedState)
            {
                Text(
                    modifier = Modifier
                        .background(descriptionTextBackgroundColor)
                        .padding(5.dp)
                        .fillMaxWidth(),
                    text = descriptionText,
                    fontSize = descriptionTextFontSize,
                    fontWeight = descriptionTextFontWeight,
                    color = descriptionTextFontColor,
                    maxLines = descriptionTextMaxLine,
                    overflow = descriptionTextOverflow
                )
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
@Preview
private fun ExpandableCardPreview()
{
    ExpandableCard()
}