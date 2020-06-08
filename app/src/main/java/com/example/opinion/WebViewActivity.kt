package com.example.opinion

import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson


class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val bundle: Bundle? = intent.extras
        val src = bundle!!.getString("html_link")
        var link: String? = src
        if (src!!.take(20) == "http://blogs.timesof" ) {
            link = "https://timesofindia.indiatimes.com/blogs/" + src!!.drop(41)}
//        } else if( src!!.take(13) == "https://times") {
//           // link = "https://m.timesofindia.com/" + src!!.drop(36)
//        }

        Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show()
        val webView: WebView? = findViewById(R.id.webView)
        webView!!.webViewClient = WebViewClient()


        val setting = webView?.settings
        setting?.javaScriptEnabled = true
        setting?.domStorageEnabled = true
        setting?.loadWithOverviewMode=true
        setting?.useWideViewPort = true
        setting?.builtInZoomControls = true
        setting?.displayZoomControls = true
        setting?.defaultTextEncodingName = "utf-8"


        webView?.loadUrl(link)

    }

}
//https://timesofindia.indiatimes.com/india/air-india-likely-to-get-custom-made-b777-planes-for-vvip-travel-by-september/articleshow/76261153.cms
//https://timesofindia.indiatimes.com/india/bsvl-to-conduct-trials-on-severe-sepsis-drug-in-covid-19-patients-with-ards/articleshow/76260418.cms
//https://timesofindia.indiatimes.com/india/bsvl-to-conduct-trials-on-severe-sepsis-drug-in-covid-19-patients-with-ards/articleshow/76260418.cms