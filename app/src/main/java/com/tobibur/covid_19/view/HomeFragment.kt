package com.tobibur.covid_19.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tobibur.covid_19.R
import com.tobibur.covid_19.model.CountriesStat
import com.tobibur.covid_19.network.Outcome
import com.tobibur.covid_19.utils.gone
import com.tobibur.covid_19.view.adapters.StatsAdapter
import kotlinx.android.synthetic.main.home_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()

        private const val TAG = "HomeFragment"
    }

    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getStatsFromApi()
    }

    private fun getStatsFromApi() {
        homeViewModel.getCases().observe(this, Observer { outcome ->
            homeProgress.gone()
            when (outcome) {
                is Outcome.Success -> {
                    Log.d(TAG, "onActivityCreated: ${outcome.data}")
                    fillListUI(outcome.data.countriesStat)
                }
                is Outcome.Failure -> {
                    Toast.makeText(activity!!, outcome.e.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun fillListUI(countriesStat: List<CountriesStat>) {
        val statsAdapter = StatsAdapter(countriesStat)
        val linearLayoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        statsRecycler.apply {
            layoutManager = linearLayoutManager
            adapter = statsAdapter
            setHasFixedSize(true)
            addItemDecoration(
                DividerItemDecoration(
                    activity,
                    DividerItemDecoration.VERTICAL
                )
            )

        }
    }

}
