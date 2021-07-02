package com.netlify.joblink.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.netlify.joblink.R
import com.netlify.joblink.adapter.ProfessionAdapter
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment() {

    private lateinit var rvCategory: RecyclerView
    private lateinit var adapterProfission: ProfessionAdapter
    private lateinit var profileFragment: ProfileFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        startRecycleView()

    }

    private fun startRecycleView() {
        rvCategory = recycle_view_search
        adapterProfission = ProfessionAdapter(activity)
        rvCategory.layoutManager =
            GridLayoutManager(activity, 2, LinearLayoutManager.VERTICAL, false)
        rvCategory.adapter = adapterProfission
    }
}