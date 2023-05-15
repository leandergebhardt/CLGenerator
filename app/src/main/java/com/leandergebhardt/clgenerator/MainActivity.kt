package com.leandergebhardt.clgenerator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_preview.setOnClickListener {
            onPreviewClicked()
        }

        val jobEntries: Array<String> = arrayOf(getString(R.string.text_jobs_1),
            getString(R.string.text_jobs_2),
            getString(R.string.text_jobs_3),
            getString(R.string.text_jobs_4)
        )

        val spinnerAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            jobEntries
        )
        spinner_job_title.adapter = spinnerAdapter

    }

    private fun onPreviewClicked() {

        val message = Message(
            input_text_name.text.toString(),
            input_text_contact_number.text.toString(),
            input_text_display_name.text.toString(),
            check_box_junior.isChecked,
            spinner_job_title.selectedItem?.toString(),
            check_box_immidiate_start.isChecked,
            input_text_start_date.text.toString()
        )

        val previewActivityIntent = Intent(this, PreviewActivity::class.java)
        previewActivityIntent.putExtra("Message",message)
        startActivity(previewActivityIntent)
    }
}