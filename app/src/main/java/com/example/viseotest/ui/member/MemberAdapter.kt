package com.example.viseotest.ui.member

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.viseotest.R
import com.example.viseotest.models.Members

class MemberAdapter(val blogList: List<Members>?) : RecyclerView.Adapter<MemberAdapter.ViewHolder>() {


    override fun getItemCount()=blogList!!.size

    private var mContext: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        this.mContext=parent.context;

        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val mMember = blogList?.get(position);

        if (mMember?.name != null) {
            holder.tvTitle.setText(mMember.name.first + " " + mMember.name.last)
        }
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle);

    }
}

