package com.example.mvvm_2020.ui.main.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import com.example.mvvm_2020.R
import com.example.mvvm_2020.ui.main.viewmodel.SharedViewModel
import kotlinx.android.synthetic.main.fragment_message_sender.*

/**
 * A simple [Fragment] subclass.
 */
class MessageSenderFragment : Fragment() {

    lateinit var model: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_message_sender, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model = ViewModelProviders.of(activity!!).get(SharedViewModel::class.java);
        model.sendMessage("MindOrks")
    }
}