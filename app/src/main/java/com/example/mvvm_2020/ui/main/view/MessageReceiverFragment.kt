package com.example.mvvm_2020.ui.main.view


import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.example.mvvm_2020.R
import com.example.mvvm_2020.ui.main.viewmodel.SharedViewModel
import kotlinx.android.synthetic.main.fragment_message_receiver.*


/**
 * A simple [Fragment] subclass.
 */
class MessageReceiverFragment : Fragment() {

    lateinit var model: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_message_receiver, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model = ViewModelProviders.of(activity!!).get(SharedViewModel::class.java);
        Handler().postDelayed({
//            model.message.observe(viewLifecycleOwner, Observer {
//                textViewReceiver.text = it
//            })
            textViewReceiver.text = model.message.value
        },5000)

    }
}