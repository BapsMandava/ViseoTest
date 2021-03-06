package com.example.viseotest.ui.company

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.viseotest.R

class CompanyFragment : Fragment() {

    private lateinit var companyViewModel: CompanyViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        companyViewModel =
            ViewModelProviders.of(this).get(CompanyViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_company, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        companyViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}