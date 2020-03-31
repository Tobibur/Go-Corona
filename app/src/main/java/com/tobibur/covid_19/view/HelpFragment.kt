package com.tobibur.covid_19.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tobibur.covid_19.R
import com.tobibur.covid_19.view.adapters.HelpLineAdapter
import kotlinx.android.synthetic.main.help_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class HelpFragment : Fragment() {

    companion object {
        fun newInstance() = HelpFragment()
    }

    private val helpViewModel: HelpViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.help_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val helpLineAdapter = HelpLineAdapter(helpViewModel.helpLineList)
        val linearLayoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        help_numbers_list.apply {
            layoutManager = linearLayoutManager
            adapter = helpLineAdapter
            addItemDecoration(
                DividerItemDecoration(
                    activity,
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }
}
