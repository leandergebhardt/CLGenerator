package com.leandergebhardt.clgenerator

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_preview.*

class PreviewActivity : AppCompatActivity() {

    private lateinit var message: Message
    private lateinit var previewText: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        displayMessage()
        setupButton()
    }

    private fun displayMessage() {
        message = intent.getSerializableExtra("Message") as Message
        previewText = """
                Hi ${message.contactName},
                
                My name is ${message.contactName} and I am ${message.getFullJobDescription()}
                I have a portfolio of apps to demonstrate my technical skills that I can show on request.
                
                I am able to start a new position ${message.getAvailability()}.
                
                Please get in touch if you have any suitable roles for me.
                
                Thanks and best regards.
            """.trimIndent()

        text_view_message.text = previewText
    }
    private fun setupButton() {
        button_send_message.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto: ${message.contactNumber}")
                putExtra("sms_body",previewText)
            }
            startActivity(intent)
        }
    }
}