package com.tobibur.covid_19.view.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tobibur.covid_19.R
import com.tobibur.covid_19.model.CountriesStat
import com.tobibur.covid_19.utils.inflate
import kotlinx.android.synthetic.main.stats_view_item.view.*

class StatsAdapter(private val statsList: List<CountriesStat>):
    RecyclerView.Adapter<StatsAdapter.StatsViewHolder>() {

    inner class StatsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatsViewHolder {
        return StatsViewHolder(parent.inflate(R.layout.stats_view_item))
    }

    override fun getItemCount(): Int {
        return statsList.size
    }

    override fun onBindViewHolder(holder: StatsViewHolder, position: Int) {
        val stats = statsList[position]
        holder.itemView.apply {
            txtCountryName.text = "Country: ${stats.countryName}"
            txtCases.text = "Total cases: ${stats.cases}"
            txtDeaths.text = "Total deaths: ${stats.deaths}"
            txtRecovered.text = "Total Recovered: ${stats.totalRecovered}"
        }
    }
}