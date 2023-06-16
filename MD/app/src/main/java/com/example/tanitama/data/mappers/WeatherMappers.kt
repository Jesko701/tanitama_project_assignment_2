package com.example.tanitama.data.mappers

import com.example.tanitama.model.UserResponse
import com.example.tanitama.model.auth.LoginResponse
import com.example.tanitama.model.weather.WeatherData
import com.example.tanitama.model.weather.WeatherDataDto
import com.example.tanitama.model.weather.WeatherDto
import com.example.tanitama.model.weather.WeatherInfo
import com.example.tanitama.model.weather.WeatherType
import retrofit2.Response
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private data class IndexedWeatherData(
    val index: Int,
    val data: WeatherData
)

fun WeatherDataDto.toWeatherDataMap(): Map<Int, List<WeatherData>> {
    return time.mapIndexed {index, time ->
        val temperature = temperatures[index]
        val weatherCode = weatherCodes[index]
        val rainSum = rainSums[index]
        val windDirection = windDirections[index]
        val windSpeed = windSpeeds[index]
        IndexedWeatherData(
            index = index,
            data = WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelcius = temperature,
                rainSum = rainSum,
                windDirection = windDirection,
                windSpeed = windSpeed,
                weatherType = WeatherType.fromWMO(weatherCode)
            )
        )
    }.groupBy {
        it.index
    }.mapValues {
        it.value.map { it.data}
    }
}

fun WeatherDto.toWeatherInfo(): WeatherInfo {
    val weatherDataMap = weatherData.toWeatherDataMap()
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.firstOrNull()
    return WeatherInfo(
        weatherDataPerDay = weatherDataMap,
        currentWeatherData = currentWeatherData
    )
}

//fun Response<LoginResponse>.toLoginResponse(): LoginResponse {
//    return body() ?: LoginResponse("")
//}
//
//fun Response<UserResponse>.toUserResponse(): UserResponse {
//    return body() ?: UserResponse("")
//}