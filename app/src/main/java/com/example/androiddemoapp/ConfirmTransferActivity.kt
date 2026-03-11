package com.example.androiddemoapp

import android.app.Activity
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.widget.TextView

class ConfirmTransferActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val data: Uri? = intent?.data
        val raw = intent?.dataString ?: "(no data)"
        val to = data?.getQueryParameter("to") ?: "(missing)"
        val amount = data?.getQueryParameter("amount") ?: "(missing)"

        val details = TextView(this).apply {
            text = "ConfirmTransferActivity\n" +
                "raw=$raw\n" +
                "Executing transfer:\n" +
                "to=$to\namount=$amount"
            setTextColor(Color.BLACK)
            textSize = 18f
            setPadding(32, 32, 32, 32)
        }
        setContentView(details)
    }
}
