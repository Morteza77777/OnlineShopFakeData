package com.example.exam.activites

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.exam.R
import com.example.exam.ext.ActivityUtils
import com.example.exam.fragments.AboutUsFragment
import com.example.exam.fragments.BackUpFragment
import com.example.exam.fragments.ContactFragment
import com.example.exam.fragments.ProfileFragment
import com.example.exam.fragments.RulesFragment
import com.example.exam.model.ModelMainActivity
import com.example.exam.presenter.PresenterMainActivity
import com.example.exam.view.ViewMainActivity
import dagger.hilt.android.AndroidEntryPoint
import de.hdodenhof.circleimageview.CircleImageView

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ActivityUtils {
    lateinit var view: ViewMainActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        view = ViewMainActivity(this, this)

        setContentView(view.binding.root)

        val presenter = PresenterMainActivity(view, ModelMainActivity())
        presenter.onCreate()
        onBackHandler()
    }

    override fun setImage(circleImageView: CircleImageView) {

        val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) {
            circleImageView.setImageURI(it)
        }

        circleImageView.setOnClickListener {
            getContent.launch("image/*")
        }
    }

    override fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }

    override fun setActionBar(toolbar: androidx.appcompat.widget.Toolbar) {
        setSupportActionBar(toolbar)
    }

    override fun starActivity(intent: Intent, requestCode: Int) {
        startActivityForResult(intent, requestCode)
    }

    private fun onBackHandler() {
        var exit = false
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (exit) {
                    finish()
                } else {
                    exit = true
                    Toast.makeText(
                        this@MainActivity, "برای خروج دوباره کلیک کنید",
                        Toast.LENGTH_SHORT
                    ).show()
                    Handler(Looper.getMainLooper()).postDelayed({ exit = false }, 3000)

                }
            }

        })
    }

}