package com.example.tc.navigationtest

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_hello.*
import java.util.regex.Pattern

@RequiresApi(Build.VERSION_CODES.O)
class HelloActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)
        mEtColor.setText("#")
        mEtColor.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable) {
                if (s.isEmpty()) {
                    s.insert(0, "#")
                }

                if (s.isNotEmpty() && s[0] != '#') {
                    s.insert(0, "#")
                }
            }
        })

        mBtnDrawColor.setOnClickListener {
            println(mEtColor.text.toString())
            mCustomColor.setColor(isColor(mEtColor.text.toString()))
        }

        mBtnM.setOnClickListener {
            val lp = LinearLayout.LayoutParams(mCustomColor.layoutParams)
            lp.width = lp.width - 10
            lp.height = lp.height - 10
            mCustomColor.layoutParams = lp
        }

    }

    private fun isColor(color: String): String {
        return try {
            val reg = "#[a-f0-9A-F]{6,8}"
            if (!Pattern.matches(reg, color)) {
                "#000000"
            } else
                color
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "颜色输入错误", Toast.LENGTH_SHORT).show()
            ""
        }
    }

}