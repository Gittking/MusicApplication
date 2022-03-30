package com.ozproject.musicapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)

         supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container,MusicList())
            addToBackStack(null)
            commit()
        }

        btnplay.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                replace(R.id.fragment_container,MusicInPlayFragment())
                addToBackStack(null)
                commit()
            }
        }
    }



}























































































//    //                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.fromParts("package",BuildConfig.APPLICATION_ID,null))
////                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
////                startActivity(intent)
//
//}


