package com.dunzo.project.ui.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AbsListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dunzo.project.R
import com.dunzo.project.data.local.model.Photo
import com.dunzo.project.di.component.ActivityComponent
import com.dunzo.project.ui.base.BaseActivity
import com.dunzo.project.utils.network.Status
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity :BaseActivity<MainViewModel>(){

    var pageNo : Int = 0
    var isScrolling = false
    var currentItem : Int = 0
    var totalItem : Int = 0
    var scrollOutItems :Int = 0
    var queryToSearch : String = ""
    var photosAdapter : PhotosPagedAdapter = PhotosPagedAdapter()

    override fun provideLayoutId(): Int = R.layout.activity_main

    override fun injectDependencies(activityComponent: ActivityComponent)  = activityComponent.inject(this)

    override fun setupView(savedInstanceState: Bundle?) {
        setupRecyclerView()
        setupTextListener()
        scrollListener()
    }

    private fun setupRecyclerView() {
        rvPhotos.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = photosAdapter
        }
    }

    private fun scrollListener() {
        rvPhotos.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL)
                {
                    isScrolling = true
                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                currentItem = rvPhotos.layoutManager?.childCount!!
                totalItem = rvPhotos.layoutManager?.itemCount!!
                scrollOutItems = (rvPhotos.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                if(isScrolling && (currentItem + scrollOutItems == totalItem))
                {
                    isScrolling = false
                    pageNo++
                    createRequest(queryToSearch)
                }

            }
        })
    }

    private fun setupTextListener() {
        editText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s?.isNotEmpty() == true){
                    queryToSearch = s.toString()
                    createRequest(s)
                }
                else{
                    pageNo = 0
                    photosAdapter.submitList(emptyList())
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
    }


    private fun createRequest(s: CharSequence) {
        viewModel.getPhotos(pageNo,s.toString()).observe(this, {
            when(it.status){
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                }
                Status.SUCCESS -> {
                    photosAdapter.submitList(it.data?.photos?.photo)
                    progressBar.visibility = View.GONE
                }
                Status.ERROR -> {
                    progressBar.visibility = View.GONE
                }
            }
        })
    }



}