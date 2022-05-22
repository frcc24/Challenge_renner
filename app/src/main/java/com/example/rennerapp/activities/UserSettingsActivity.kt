package com.example.rennerapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rennerapp.R
import kotlinx.android.synthetic.main.activity_user_settings.*
import kotlinx.android.synthetic.main.main_content.*

class UserSettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_settings)

        //todo transformar em fragments
        bot_nav_bar_settings.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.bot_nav_user -> gotoUserSetting()
                else -> {
                    gotoUserHome()
                }
            }
        }
    }

    private fun gotoUserHome(): Boolean {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        return true
    }

    private fun gotoUserSetting(): Boolean {
        return true
    }
}