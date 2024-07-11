package com.example.exam.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.exam.databinding.ContactFragmentBinding

class ContactFragment : Fragment() {

    val binding = ContactFragmentBinding.inflate(LayoutInflater.from(context))

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}