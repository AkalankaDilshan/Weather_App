package com.akalanka.weatherapp.domain.repository

import com.akalanka.weatherapp.domain.util.Resource
import com.akalanka.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}