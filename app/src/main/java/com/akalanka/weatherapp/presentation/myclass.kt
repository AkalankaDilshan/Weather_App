package com.akalanka.weatherapp.presentation

import androidx.activity.result.ActivityResultLauncher
import com.google.android.gms.location.FusedLocationProviderClient

class myclass() {
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>
    lateinit var mFusedLocationProviderClient: FusedLocationProviderClient
    public var cityName:String?=null

//    constructor() : this() {
//        //this is primary activity
//
//    }
//
//    constructor(cname:String){
//        cityName=cname
//    }
}