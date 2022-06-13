package com.codennamdi.selfpromoapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_preview.*

class PreviewActivity : AppCompatActivity() {
    private lateinit var message: Message
    private lateinit var messagePreviewText: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        displayMessage()
        setUpButton()
    }

    private fun displayMessage() {
         message = intent.getSerializableExtra("Message") as Message
         messagePreviewText = """
                Hey ${message.contactName}
                
                My name is ${message.myDisplayName} and I am ${message.getJobDescription()}.
                
                I have a portfolio of apps i have created to showcase my skills in android development.
                
                I am willing and available to start the new role ${message.getAvailability()}.
                
                I will be waiting for your response.
                
                Thanks! Best regards.
            """.trimIndent()

        text_view_message.text = messagePreviewText
    }

    private fun setUpButton(){
        button_send_message.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto: ${message.contactNumber}")  // This ensures only SMS apps respond
                putExtra("sms_body", messagePreviewText)
            }
            startActivity(intent)
        }
    }
}