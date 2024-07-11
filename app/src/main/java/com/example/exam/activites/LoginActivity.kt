package com.example.exam.activites

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.example.exam.databinding.ActivityLoginBinding
import com.example.exam.remote.RetrofitService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonSend.setOnClickListener {
            val email = binding.edtEmail.text.toString().trim()
            if (email.isEmpty()) {
                binding.edtEmail.error = "ایمیل را وارد کنید"
            } else {
                binding.edtEmail.error = null
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    binding.edtEmail.error = "ایمیل وارد شده معتبر نیست"
                } else{
                    binding.edtEmail.error = null
                    sendCodeInEmail(email)
                    val intent = Intent(this,RegisterActivity::class.java)
                    intent.putExtra("email",email)
                    startActivity(intent)
                }



            }
        }


    }
    private fun sendCodeInEmail(email: String) {
        CoroutineScope(Dispatchers.IO).launch{
            try {
                RetrofitService.apiService.sendRequest(email)
            }catch (e:Exception){
                Log.i("error",e.message.toString())
            }
        }

    }
}
