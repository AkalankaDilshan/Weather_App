package com.akalanka.weatherapp.presentation

import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.activity.viewModels

import com.google.android.gms.location.LocationServices
import java.util.*
import android.Manifest

import android.location.Address



import androidx.activity.ComponentActivity
import android.location.Location
import android.nfc.Tag
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

class GetLocationName : AppCompatActivity() {
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>
    lateinit var mFusedLocationProviderClient: FusedLocationProviderClient
    //public var cityname = "dfgdfggghgdh"
    private val TAG = "GetLocationName"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //updateLocation()
    }
   /* fun updateLocation() {
        var locationRequest = LocationRequest()
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

        var geocoder: Geocoder
        var addressList = ArrayList<Address>()

        geocoder = Geocoder(applicationContext, Locale.getDefault())

        addressList = geocoder.getFromLocation(
            location.latitude,
            location.longitude,
            1
        ) as ArrayList<Address>



        //var  city_name2 = "akalanka"//addressList.get(0).subAdminArea.toString()
        //MainActivity().cityName = "dfsrtgfdgsty"//city_name2

        Log.d(TAG,""+addressList.get(0).subAdminArea)


    }

*/


    }
