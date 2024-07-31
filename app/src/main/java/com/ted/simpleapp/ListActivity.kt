package com.ted.simpleapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ted.simpleapp.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {
    private lateinit var activityListBinding: ActivityListBinding
    private lateinit var listViewAdapter: ListViewAdapter
    private lateinit var listItems: ArrayList<ListModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        activityListBinding = ActivityListBinding.inflate(layoutInflater)
        setContentView(activityListBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        listViewAdapter = ListViewAdapter()

        activityListBinding.rvList.apply {
           setLayoutManager(layoutManager)
           adapter = listViewAdapter
           setHasFixedSize(true)
        }

        getListItems()
    }

    private fun getListItems() {
        listItems = ArrayList()

        listItems.add(ListModel("", "text1"))
        listItems.add(ListModel("", "text2"))
        listItems.add(ListModel("", "text3"))
        listItems.add(ListModel("", "text4"))
        listItems.add(ListModel("", "text5"))

        listViewAdapter.setItemList(listItems)
    }
}