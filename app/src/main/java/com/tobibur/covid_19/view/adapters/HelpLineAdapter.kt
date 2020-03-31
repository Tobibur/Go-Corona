package com.tobibur.covid_19.view.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tobibur.covid_19.R
import com.tobibur.covid_19.model.Help
import com.tobibur.covid_19.utils.inflate
import kotlinx.android.synthetic.main.stats_view_item.view.*

class HelpLineAdapter(private val helplines: List<Help>) :
    RecyclerView.Adapter<HelpLineAdapter.HelpViewHolder>() {

    inner class HelpViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HelpViewHolder {
        return HelpViewHolder(parent.inflate(R.layout.stats_view_item))
    }

    override fun getItemCount(): Int {
        return helplines.size
    }

    override fun onBindViewHolder(holder: HelpViewHolder, position: Int) {
        val helpline = helplines[position]
        holder.itemView.apply {
            txtCountryName.text = helpline.place
            txtCases.text = helpline.helpline
        }
    }
}