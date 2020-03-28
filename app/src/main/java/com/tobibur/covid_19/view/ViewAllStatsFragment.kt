package com.tobibur.covid_19.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tobibur.covid_19.R
import com.tobibur.covid_19.model.CountriesStat
import com.tobibur.covid_19.network.Outcome
import com.tobibur.covid_19.utils.ItemClickListener
import com.tobibur.covid_19.utils.gone
import com.tobibur.covid_19.utils.toast
import com.tobibur.covid_19.view.adapters.StatsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_view_all_stats.*
import org.koin.android.viewmodel.ext.android.viewModel


/**
 * A simple [Fragment] subclass.
 */
class ViewAllStatsFragment : Fragment(), ItemClickListener {

    private val homeViewModel: HomeViewModel by viewModel()

    lateinit var updatedAt: String

    companion object {
        private const val TAG = "ViewAllStatsFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_all_stats, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        activity!!.search_edittext.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                performSearch(v.text)
                return@OnEditorActionListener true
            }
            false
        })

        activity!!.search_edittext.addTextChangedListener {
            performSearch(it.toString())
        }

        homeViewModel.getCases().observe(viewLifecycleOwner, Observer { outcome ->
            progressViewAllStats.gone()
            when (outcome) {
                is Outcome.Success -> {
                    Log.d(TAG, "onActivityCreated: ${outcome.data}")

                    updatedAt = outcome.data.statisticTakenAt
                    fillListUI(outcome.data.countriesStat)
                }
                is Outcome.Failure -> {
                    Toast.makeText(activity!!, outcome.e.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun performSearch(text: CharSequence) {
//        TODO: Perform Search Here.

        activity!!.toast(text.toString())
    }

    private fun fillListUI(countriesStat: List<CountriesStat>) {
        val statsAdapter = StatsAdapter(countriesStat, this)
        val linearLayoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        recyclerViewAllStats.apply {
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

    override fun onItemClick(statsObject: CountriesStat) {
        findNavController().navigate(ViewAllStatsFragmentDirections.actionViewAllStatsFragmentToDetailFragment(statsObject, updatedAt))
    }

}
