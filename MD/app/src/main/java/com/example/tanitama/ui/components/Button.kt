@file:OptIn(ExperimentalMaterial3Api::class)

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ButtonGreen(
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    text: String,
    colors: ButtonColors,
) {
    Button(
        onClick = { onClick },
        modifier = modifier,
        colors = ButtonDefaults.textButtonColors(
            containerColor = Color(0xFF00CF6C).copy(alpha = 0.6f),
            contentColor = Color.White
        )
    ) {
        Text(text)
    }
}