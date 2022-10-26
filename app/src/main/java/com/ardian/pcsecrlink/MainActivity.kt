package com.ardian.pcsecrlink

import android.content.Intent
import android.net.wifi.WifiManager
import android.os.Bundle
import android.text.format.Formatter
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ardian.pcsecrlink.databinding.ActivityMainBinding
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var server : MyHTTPD
    private var port : Int = 8013

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var intent = getIntent()
        var result : String = intent.getStringExtra("message").toString()
        binding.txtMessage.text = ""

        try {
            server = MyHTTPD(ipAddress(), port, this)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        binding.btnTest.setOnClickListener {
            try {
                server.start()
                initIPAddress()
                Toast.makeText(this, "Server Start", Toast.LENGTH_LONG).show()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

//        if (MyHTTPD.responsePost != "") {
//            Intent(Intent.ACTION_SEND).apply {
//                putExtra(Intent.EXTRA_TEXT, MyHTTPD.responsePost)
//            }
//
            binding.btnStop.setOnClickListener {
                server.stop()
                binding.txtIp.text = ""
                Toast.makeText(this, "Server Stop", Toast.LENGTH_LONG).show()
            }
//        }
    }

    fun setTextView(text : String ){
        binding.txtMessage.text = text
    }

    fun initIPAddress() {
        var wm: WifiManager = applicationContext.getSystemService(WIFI_SERVICE) as WifiManager
        var ip: String = Formatter.formatIpAddress(wm.connectionInfo.ipAddress)
        binding.txtIp.text = "server running at: $ip: $port"
        Log.i("TAG", "onCreate: $ip")
    }

    fun ipAddress(): String {
        var wm: WifiManager = applicationContext.getSystemService(WIFI_SERVICE) as WifiManager
        var ip: String = Formatter.formatIpAddress(wm.connectionInfo.ipAddress)

        return ip
    }

}