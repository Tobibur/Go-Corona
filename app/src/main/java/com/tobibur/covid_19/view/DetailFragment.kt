package com.tobibur.covid_19.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs

import com.tobibur.covid_19.R
import kotlinx.android.synthetic.main.fragment_detail.*

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {

    val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val statsObject = args.statsObject

        (activity as AppCompatActivity).supportActionBar?.title = statsObject.countryName

        detail_total_cases.text = statsObject.cases
        detail_deaths.text = statsObject.deaths
        detail_recovered.text = statsObject.totalRecovered
        detail_active_cases.text = statsObject.activeCases
        detail_serious_cases.text = statsObject.seriousCritical
        timeUpdatedTv.text = ("${args.updatedAt} GMT")

    }

}
