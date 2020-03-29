package com.tobibur.covid_19.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.tobibur.covid_19.R
import com.tobibur.covid_19.model.Tips
import com.tobibur.covid_19.view.adapters.TipsAdapter
import com.tobibur.covid_19.view.adapters.TipsClickListner
import kotlinx.android.synthetic.main.guide_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class GuideFragment : Fragment(), TipsClickListner {

    companion object {
        fun newInstance() = GuideFragment()
    }

//    private lateinit var viewModel: GuideViewModel

    private val guideViewModel: GuideViewModel by viewModel()
    lateinit var tipsAdapter: TipsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.guide_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initList()
        
        fillTipsList()

    }

    private fun fillTipsList() {
        tipsAdapter.submitList(guideViewModel.tipsMutableList)
    }

    private fun initList() {
        tipsAdapter = TipsAdapter(this)
        tips_list.adapter = tipsAdapter
    }

    override fun onTipsClick(tip: Tips) {
//        TODo: go to detailed writeup.



        findNavController().navigate(GuideFragmentDirections.actionGuideFragmentToTipDetailFragment(tip))

    }

}
