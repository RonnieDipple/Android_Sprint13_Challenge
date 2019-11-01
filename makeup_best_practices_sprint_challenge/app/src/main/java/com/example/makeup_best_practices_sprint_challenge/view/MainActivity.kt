package com.example.makeup_best_practices_sprint_challenge.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.makeup_best_practices_sprint_challenge.MakeUpAdapter
import com.example.makeup_best_practices_sprint_challenge.R
import com.example.makeup_best_practices_sprint_challenge.viewModel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ListViewModel
    private val makeUpAdapter = MakeUpAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.refresh()

        recyclerView_makeUpList.apply {

            layoutManager = LinearLayoutManager(context)
            adapter = makeUpAdapter
        }

        observViewModel()
    }

    fun observViewModel(){
        //receives mock data
        viewModel.makeup.observe(this, Observer { makeup ->

            makeup?.let { makeUpAdapter.updateMakeup(it) }
        })

        //Error handling

        viewModel.makeUpLoadError.observe(this, Observer { isError ->
            //Visibility switch depending on error
            isError?.let { text_view_error.visibility = if (it) View.VISIBLE else View.GONE}
        })

        //This will controll the spinner
        viewModel.loading.observe(this, Observer { isLoading ->

            isLoading?.let {
                loading_view.visibility = if (it) View.VISIBLE else View.GONE
                if (it){
                    text_view_error.visibility = View.GONE
                    recyclerView_makeUpList.visibility = View.GONE
                }
            }


        })
    }




}
