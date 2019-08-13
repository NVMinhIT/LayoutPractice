package com.daovuu97.layoutpractice.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daovuu97.layoutpractice.R
import com.daovuu97.layoutpractice.adapter.ListUserAdapter
import com.daovuu97.layoutpractice.adapter.TimelineAdapter
import com.daovuu97.layoutpractice.model.Status
import com.daovuu97.layoutpractice.model.User
import com.daovuu97.layoutpractice.service.DataServices

class TimeLineActivity : AppCompatActivity() {
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: TimelineAdapter
    private lateinit var listStatus: List<Status>
    private lateinit var listUser: List<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_line)
        listUser = DataServices.listUser
        listStatus = DataServices.listStatus
        mRecyclerView = findViewById(R.id.list_status)
        mAdapter = TimelineAdapter(this, listStatus)
        mRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@TimeLineActivity)
            adapter = mAdapter
        }

    }

}
