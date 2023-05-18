package com.akalanka.weatherapp.presentation

import android.Manifest

import android.location.Address
import android.location.Geocoder
import android.os.Bundle

import androidx.activity.ComponentActivity
import android.location.Location
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import android.os.Looper
import android.util.Log
import kotlin.collections.ArrayList
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign


import androidx.compose.ui.unit.dp
import com.akalanka.weatherapp.presentation.ui.theme.DarkBlue
import com.akalanka.weatherapp.presentation.ui.theme.DeepBlue

import com.akalanka.weatherapp.presentation.ui.theme.WeatherAppTheme
import com.google.android.gms.location.FusedLocationProviderClient

import dagger.hilt.android.AndroidEntryPoint
import java.util.*


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: WeatherViewModel by viewModels()
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>
    lateinit var mFusedLocationProviderClient: FusedLocationProviderClient
    private val TAG="MainActivity "


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateLocation()

        //methana idn thiyenne anith code

        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            viewModel.loadWeatherInfo()
        }
        permissionLauncher.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
        ))
        setContent {
            WeatherAppTheme {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(DarkBlue)
                    ) {
                        WeatherCard(
                            state = viewModel.state,
                            backgroundColor = DeepBlue
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        WeatherForecast(state = viewModel.state)
                    }
                    if(viewModel.state.isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                    viewModel.state.error?.let { error ->
                        Text(
                            text = error,
                            color = Color.Red,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }



    fun updateLocation() {
        val locationRequest = LocationRequest()
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest.interval = 10000
        locationRequest.fastestInterval = 5000

        mFusedLocationProviderClient = FusedLocationProviderClient(this)
        mFusedLocationProviderClient.requestLocationUpdates(
            locationRequest, mLocationCallback,
            Looper.myLooper()
        )
    }


    var mLocationCallback = object : LocationCallback() {
        override fun onLocationResult(p0: LocationResult) {

            val location: Location? = p0.lastLocation
            if (location != null) {
                updateAddressUI(location)

            }

        }
    }

    fun updateAddressUI(location: Location) {

        val geocoder: Geocoder
        var addressList = ArrayList<Address>()

        geocoder = Geocoder(applicationContext, Locale.getDefault())

        addressList = geocoder.getFromLocation(
            location.latitude,
            location.longitude,
            1
        ) as ArrayList<Address>

        //get massage for if we get correct city name
        Log.d(TAG,""+addressList.get(0))


       //vall CityName Object
        val myVar = addressList.get(0).subAdminArea
        CityName.Current_city = myVar.toString()
        CityName.myFunction()



    }
}