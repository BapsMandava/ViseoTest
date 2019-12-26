package com.example.viseotest.ui.member

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viseotest.R
import com.example.viseotest.models.Members
import com.example.viseotest.viewmodel.MemberViewModel
import kotlinx.android.synthetic.main.fragment_member.*

class MemberFragment : Fragment() {

    var memberViewModel: MemberViewModel? = null
    var memberAdapter: MemberAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        memberViewModel = ViewModelProviders.of(this).get(MemberViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_member, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getMembersData()
    }


    fun getMembersData() {
        //swiperefresh.setRefreshing(false)
        memberViewModel?.allMembers?.observe(this, Observer { blogList ->
            prepareRecyclerView(blogList)
        })

    }

    private fun prepareRecyclerView(blogList: List<Members>?) {

        memberAdapter = MemberAdapter(blogList)
        if (this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            blogRecyclerView.setLayoutManager(LinearLayoutManager(activity))
        } else {
            blogRecyclerView.setLayoutManager(GridLayoutManager(activity, 4))
        }
        blogRecyclerView.setItemAnimator(DefaultItemAnimator())
        blogRecyclerView.setAdapter(memberAdapter)

    }
}