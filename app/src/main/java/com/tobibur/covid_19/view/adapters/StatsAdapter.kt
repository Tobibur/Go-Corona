package com.tobibur.covid_19.view.adapters

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tobibur.covid_19.R
import com.tobibur.covid_19.model.CountriesStat
import com.tobibur.covid_19.utils.inflate
import com.tobibur.covid_19.utils.ItemClickListener
import kotlinx.android.synthetic.main.stats_view_item.view.*

class StatsAdapter(
    private val statsList: List<CountriesStat>,
    private val itemClickListener: ItemClickListener
) :
    RecyclerView.Adapter<StatsAdapter.StatsViewHolder>() {

    inner class StatsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatsViewHolder {
        return StatsViewHolder(parent.inflate(R.layout.stats_view_item))
    }

    override fun getItemCount(): Int {
        return statsList.size
    }

    override fun onBindViewHolder(holder: StatsViewHolder, position: Int) {
        val stats = statsList[position]
        holder.itemView.apply {
            txtCountryName.text = "${stats.countryName}"
            txtCases.text = "${stats.cases}"

            setOnClickListener {
                Log.d("statsadapter", "Adapter to Click to hua hai")
                itemClickListener.onItemClick(stats)

            }
        }
    }
}