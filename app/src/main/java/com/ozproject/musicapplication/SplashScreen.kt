package com.ozproject.musicapplication

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AlertDialog

import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class SplashScreen : AppCompatActivity() {
     val RQ_STORAGE_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            Handler(Looper.getMainLooper()).postDelayed({
               storageRequestPermission()
            },3000)

        }

       fun storageRequestPermission(){
           if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
               ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),RQ_STORAGE_CODE)
           }
           else{
             nextActivity()
           }

       }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if( requestCode==RQ_STORAGE_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                nextActivity()
            }else{
                showDialog()

            }
        }

    }

    private fun nextActivity(){
        val intent = Intent(this@SplashScreen, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

      private  fun showDialog(){
        val alertStorageDialog = AlertDialog.Builder(this)
        alertStorageDialog.apply {
            setTitle("Grant Storage Permission")
            setMessage("Since you have not allow music player to access your storage," +
                    "mp3 files are unavailable now." +
                    "Please allow the storage access ")
            setPositiveButton("ok"){dialogInterface,i->
                ActivityCompat.requestPermissions(this@SplashScreen,arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),RQ_STORAGE_CODE)
        }
          }.create().show()
       }

    }
