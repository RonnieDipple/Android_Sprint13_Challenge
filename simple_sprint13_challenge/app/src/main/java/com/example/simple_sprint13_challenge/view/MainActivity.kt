package com.example.simple_sprint13_challenge.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simple_sprint13_challenge.Model.MakeUpData
import com.example.simple_sprint13_challenge.Model.MakeUpService
import com.example.simple_sprint13_challenge.R
import com.example.simple_sprint13_challenge.App
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_makeup_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var makeUpService: MakeUpService

    private val makeUpList = mutableListOf<MakeUpData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_makeup_main)

        (application as App).appComponent.inject(this)

        recyclerView_makeUpList.apply {
            setHasFixedSize(false)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = MakeUpAdapter(mockdata)
        }

        search_icon.setOnQueryTextListener(object: SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(search: String?): Boolean {
                makeUpService.getList("${search}").subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe (
                        { query ->
                            val bundle = Bundle()
                            bundle.putString("success", "API ${query.size}")

                            recyclerView_makeUpList.adapter = MakeUpAdapter(query) },
                        { query ->
                            val bundle = Bundle()
                            bundle.putString("failure", query.message)
                        })

                return true
            }

            override fun onQueryTextChange(search: String?): Boolean {
                return true
            }
        })
    }

//The mockdata has helped with this bug, the recycler is now working
    val mockdata = mutableListOf<MakeUpData>(
        MakeUpData("Test","TestName", "PriceTest", 4, "Imageplaceholder"),
        MakeUpData("Test2", "TestName2", "PriceTest", 4, "Imageplaceholder2"))
}
