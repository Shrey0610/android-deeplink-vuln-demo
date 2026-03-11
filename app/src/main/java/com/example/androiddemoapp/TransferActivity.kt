package com.example.androiddemoapp

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.widget.TextView

class TransferActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val data: Uri? = intent?.data
        val raw = intent?.dataString ?: "(no data)"
        val to = data?.getQueryParameter("to") ?: "(missing)"
        val amount = data?.getQueryParameter("amount") ?: "(missing)"

        val status = TextView(this).apply {
            text = "TransferActivity\n" +
                "raw=$raw\n" +
                "Received deep link:\n" +
                "to=$to\namount=$amount\n\n" +
                "Forwarding intent without validation..."
            setTextColor(Color.BLACK)
            textSize = 18f
            setPadding(32, 32, 32, 32)
        }
        setContentView(status)

        // Vulnerability: forwards the incoming intent without validation.
        val forward = Intent(intent)
        forward.setClass(this, ConfirmTransferActivity::class.java)
        startActivity(forward)
        finish()
    }
}
