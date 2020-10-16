package com.example.basicguiprog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TextView displays information
        //EditText enter data
        //Button triggers action
         var vObj: View = UIManager(this).createFullScreen()
        //root view object
        setContentView(vObj)
//        setContentView(R.layout.activity_main)
    }
}