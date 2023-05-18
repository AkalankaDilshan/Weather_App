package com.akalanka.weatherapp.presentation


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
//object MyFile {
//    var myVar: String = ""
//
//    fun myFunction() {
//        // Use the value of myVar for further processing or storage
//        // For example:
//        val processedValue = myVar.toUpperCase()
//        // ... do something with the processed value
//    }
//}


fun locationDataDisplay(
    location_name: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(),
    iconTint: Color = Color.White
)
{

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconTint,
            modifier = Modifier.size(30.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "$location_name",
            style = textStyle,
            fontSize = 15.sp,
           // fontFamily ="sans-serif-condensed",
            color = Color.White
        )
    }

}