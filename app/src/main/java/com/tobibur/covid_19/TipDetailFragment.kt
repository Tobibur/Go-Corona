package com.tobibur.covid_19

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.tobibur.covid_19.utils.load
import kotlinx.android.synthetic.main.fragment_tip_detail.*

/**
 * A simple [Fragment] subclass.
 */
class TipDetailFragment : Fragment() {

    private val args: TipDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tip_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tip = args.tipsObject

        tip_detail_img.load(tip.tipsImage, activity!!)
        tip_detail_title.text = tip.tipTitle
        tip_details_writeup.text = tip.tipContent



    }

}
