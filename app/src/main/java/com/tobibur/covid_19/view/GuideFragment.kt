package com.tobibur.covid_19.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.tobibur.covid_19.R

class GuideFragment : Fragment() {

    companion object {
        fun newInstance() = GuideFragment()
    }

    private lateinit var viewModel: GuideViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.guide_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GuideViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
