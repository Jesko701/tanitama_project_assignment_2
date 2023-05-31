@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


//@Composable
//fun TransparentColor(percent: Float): Color {
//    val clampedPercent = percent.coerceIn(0f, 100f) / 100f
//    return Color.Transparent.copy(alpha = clampedPercent)
//}

@Composable
fun CornerTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 19.dp,
    backgroundColor: Color = Color.Transparent,
    borderColor: Color = Color.Gray,
    textColor: Color = Color.Gray
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = placeholder,
                color = Color.Gray,
            )},
        modifier = modifier
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(cornerRadius)
            )
            .background(
                backgroundColor,
                shape = RoundedCornerShape(19.dp)),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = textColor,
            textColor = textColor
        )
    )
}

@Composable
fun CornerTextFieldPassword(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 19.dp,
    backgroundColor: Color = Color.Transparent,
    borderColor: Color = Color.Gray,
    textColor: Color = Color.Gray,
    visualTransformation: PasswordVisualTransformation
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = placeholder,
                color = Color.Gray,
            )},
        visualTransformation = visualTransformation,
        modifier = modifier
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(cornerRadius)
            )
            .background(
                backgroundColor,
                shape = RoundedCornerShape(19.dp)),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = textColor,
            textColor = textColor
        )
    )
}
