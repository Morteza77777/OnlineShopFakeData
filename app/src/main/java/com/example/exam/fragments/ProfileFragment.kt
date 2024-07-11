package com.example.exam.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.exam.model.ModelProfileFragment
import com.example.exam.presenter.PresenterProfileFragment
import com.example.exam.view.ViewProfileFragment
import de.hdodenhof.circleimageview.CircleImageView

class ProfileFragment : Fragment() {

    lateinit var imageView : CircleImageView

    lateinit var view : ViewProfileFragment

    lateinit var context6 : Context

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = ViewProfileFragment(context6)
        val presenter = PresenterProfileFragment(view, ModelProfileFragment())
        presenter.onCreate()
        view.binding.imgEditProfile.setOnClickListener {
            uploadImage()
        }

        imageView = view.binding.imgProfile1
        return view.binding.root


    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context6 = context
    }

    private fun uploadImage() {
        val intent = Intent()
        intent.action = Intent.ACTION_GET_CONTENT
        intent.type = "image/*"
        startActivityForResult(intent,1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode==1){
            view.binding.imgProfile1.setImageURI(data?.data)

        }
    }

}