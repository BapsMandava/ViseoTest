package com.example.viseotest.ui.member

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.viseotest.R
import com.example.viseotest.viewmodel.MemberViewModel

class MemberFragment : Fragment() {

    private lateinit var membersViewModel: MemberViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        membersViewModel =
            ViewModelProviders.of(this).get(MemberViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_member, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        membersViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}