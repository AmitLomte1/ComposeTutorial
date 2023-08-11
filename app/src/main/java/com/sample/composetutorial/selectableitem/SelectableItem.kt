package com.sample.composetutorial.selectableitem

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun SelectableItem(
    modifier: Modifier = Modifier,
    selected: Boolean,
    title: String,
    titleColor: Color = if (selected) MaterialTheme.colorScheme.primary
    else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f),
    titleSize: TextUnit = MaterialTheme.typography.bodyMedium.fontSize,
    titleWeight: FontWeight = FontWeight.Medium,
    subTitle: String? = null,
    subTitleColor: Color = if (selected) MaterialTheme.colorScheme.primary
    else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f),
    borderWidth: Dp = 1.dp,
    borderColor: Color = if (selected) MaterialTheme.colorScheme.primary
    else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f),
    borderShape: Shape = RoundedCornerShape(size = 10.dp),
    icon: ImageVector = Icons.Default.CheckCircle,
    iconColor: Color = if (selected) MaterialTheme.colorScheme.primary
    else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f),
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .border(
                width = borderWidth,
                color = borderColor,
                shape = borderShape
            )
            .clickable {
                onClick()
            }
    ) {
        Row(
            modifier = Modifier.padding(start = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(8f),
                text = title,
                style = TextStyle(
                    color = titleColor,
                    fontSize = titleSize,
                    fontWeight = titleWeight
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            IconButton(
                modifier = Modifier.weight(2f),
                onClick = onClick
            ) {
                Icon(imageVector = icon, contentDescription = "", tint = iconColor)
            }
        }
        if (subTitle != null) {
            Text(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 12.dp),
                text = subTitle,
                style = TextStyle(
                    color = subTitleColor
                ),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun PreviewSelectableItem() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(80.dp)
    ) {
        var selected by remember {
            mutableStateOf(false)
        }
        var selected2 by remember {
            mutableStateOf(false)
        }
        SelectableItem(
            selected = selected,
            title = "This is example",
            onClick = { selected = !selected })
        SelectableItem(
            selected = selected2,
            title = "This is example",
            subTitle = "This is example This is example This is example This is exampleThis is exampleThis is example",
            onClick = { selected2 = !selected2 })
    }
}