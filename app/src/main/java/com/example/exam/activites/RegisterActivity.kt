package com.example.exam.activites

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.example.exam.R
import com.example.exam.databinding.ActivityRegisterBinding
import com.example.exam.remote.RetrofitService
import com.example.exam.remote.dataModel.LoginModel
import com.example.exam.remote.others.AndroidId
import com.example.exam.remote.others.ErrorHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    @SuppressLint("ResourceType", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val deviceId = AndroidId.deviceInfo(this)
        startCountDown(binding.textView)
        val color = ResourcesCompat.getColor(resources, R.color.orange, null)
        binding.buttonConfirm.setBackgroundColor(color)

        val email = intent.getStringExtra("email").toString()

        binding.txtEmail.text = "کد 6 رقمی ارسال شده به $email خود را وارد کتید "

        binding.viewBack.setOnClickListener {

                sendCodeInEmail(email)

        }
        binding.txtEdit.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.buttonConfirm.setOnClickListener {
           verifyCode(deviceId, binding.getEmailEdt.text.toString(), email)

        }



        binding.getEmailEdt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                if (p0.toString() == "")
                    binding.edtEmail.error = null
            }
        })

    }

    private fun startCountDown(textView: TextView) {
        val scope = CoroutineScope(Dispatchers.Main)
        scope.launch {
            var seconds = 120
            while (seconds > 0) {
                textView.text = seconds.toString()
                delay(1000)
                seconds--
            }
            textView.text = "0"
        }
    }

    private fun sendCodeInEmail(email: String) {

        val service = RetrofitService.apiService

        CoroutineScope(Dispatchers.IO).launch {
            val result = service.sendRequest(email)

            if (result.isSuccessful) {
                launch(Dispatchers.Main) {
                    val data = result.body() as LoginModel

                    Toast.makeText(this@RegisterActivity, data.message, Toast.LENGTH_SHORT).show()

                }
            } else {
                launch(Dispatchers.Main) {
                    Toast.makeText(
                        this@RegisterActivity,
                        ErrorHandler.getError(result),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }
    }

    @SuppressLint("ResourceType")
    private fun verifyCode(deviceId: String, code1: String, email: String) {

        val service = RetrofitService.apiService
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val result = service.verifyCode(deviceId, code1, email)

                if (result.isSuccessful) {
                    launch(Dispatchers.Main) {
                        binding.edtEmail.error = ""
                        val alert = Dialog(this@RegisterActivity)
                        alert.setContentView(R.layout.custom_dialog)
                        alert.setCancelable(false)
                        alert.show()
                        alert.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                        delay(4000)
                        val intent = Intent(this@RegisterActivity,
                            InformationActivity::class.java)
                        startActivity(intent)
                    }
                } else {
                    launch(Dispatchers.Main) {

                        binding.edtEmail.error = "کد وارد شده اشتباه است !"
                        binding.edtEmail.errorIconDrawable = null
                        Toast.makeText(this@RegisterActivity, ErrorHandler.getError(result),
                            Toast.LENGTH_SHORT).show()

                    }

                }
            }catch (e:Exception){
                Log.i("error",e.message.toString())
            }

        }

    }
}
