import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.tanitama.R
import com.example.tanitama.WeatherState
import com.example.tanitama.WeatherViewModel
import com.example.tanitama.ui.components.BlackWeatherData
import com.example.tanitama.ui.components.CardList
import kotlin.math.roundToInt

@Composable
fun Home(state: WeatherState, homeViewModel: WeatherViewModel = viewModel(), navController: NavController) {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    state.weatherInfo?.currentWeatherData?.let { data ->

        Column(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.padding(0.dp)) {
                Image(
                    painter = painterResource(R.drawable.home),
                    contentDescription = null,
//                contentScale = ContentScale.FillWidth,
//                modifier = Modifier
//                    .height(screenHeight / 3)
//                    .fillMaxWidth()
//                    .clip(
//                        shape = RoundedCornerShape(
//                            bottomStart = 35.dp,
//                            bottomEnd = 35.dp,
//                            topStart = 0.dp,
//                            topEnd = 0.dp
//                        )
//                    )
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Column(modifier = Modifier.padding(top = 20.dp)) {
                    SectionWhiteText(title = "Selamat Pagi", modifier = Modifier.fillMaxWidth())
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 30.dp, end = 30.dp, top = 15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Top
                    ) {
                        Column() {
                            Text(
                                text = "${data.temperatureCelcius}°C",
                                style = TextStyle(
                                    fontSize = 85.sp,
                                    fontWeight = FontWeight.ExtraLight,
                                    color = Color.White
                                )
                            )
                            Text(
                                text = "Tegal",
                                style = TextStyle(
                                    fontSize = 25.sp,
                                    color = Color.White
                                )
                            )
                        }
                        Image(
                            painter = painterResource(id = data.weatherType.iconRes),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .size(95.dp)

                        )
                    }
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Black.copy(alpha = 0.8f),
                        ),
                        shape = RoundedCornerShape(19.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp, start = 30.dp, end = 30.dp),
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            BlackWeatherData(
                                value = data.rainSum.roundToInt(),
                                unit = "mm",
                                icon = ImageVector.vectorResource(id = R.drawable.ic_drop),
                                iconTint = Color.White,
                                textStyle = TextStyle(
                                    color = Color.White,
                                    fontSize = 21.sp
                                )
                            )
                            BlackWeatherData(
                                value = data.windDirection.roundToInt(),
                                unit = "°",
                                icon = ImageVector.vectorResource(id = R.drawable.ic_winddir),
                                iconTint = Color.White,
                                textStyle = TextStyle(
                                    color = Color.White,
                                    fontSize = 21.sp
                                )
                            )
                            BlackWeatherData(
                                value = data.windSpeed.roundToInt(),
                                unit = "km/h",
                                icon = ImageVector.vectorResource(id = R.drawable.ic_wind),
                                iconTint = Color.White,
                                textStyle = TextStyle(
                                    color = Color.White,
                                    fontSize = 21.sp
                                )
                            )
                        }
                        Spacer(modifier = Modifier.height(35.dp))
                        SectionBlackText(title = "FOR YOU")
                        CardList()
                    }
                }
            }
        }
    }
}