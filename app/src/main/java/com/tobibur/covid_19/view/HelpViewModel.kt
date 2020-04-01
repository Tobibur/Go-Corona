package com.tobibur.covid_19.view

import androidx.lifecycle.ViewModel
import com.tobibur.covid_19.model.Help

class HelpViewModel : ViewModel() {

    val helpLineList = listOf<Help>(

        Help("Andhra Pradesh", "0866-2410978"),
        Help("Arunachal Pradesh", "9436055743"),
        Help("Assam", "6913347770"),
        Help("Bihar", "104"),
        Help("Chhattisgarh", "104"),
        Help("Goa", "104"),
        Help("Gujarat", "104"),
        Help("Haryana", "8558893911"),
        Help("Himachal Pradesh", "104"),
        Help("Jharkhand", "104"),
        Help("Karnataka", "104"),
        Help("Kerala", "0471-2552056"),
        Help("Madhya Pradesh", "0755-2527177"),
        Help("Maharashtra", "020-26127394"),
        Help("Manipur", "3852411668"),
        Help("Meghalaya", "108"),
        Help("Mizoram", "102"),
        Help("Nagaland", "7005539653"),
        Help("Odisha", "9439994859"),
        Help("Punjab", "104"),
        Help("Rajasthan", "0141-2225624"),
        Help("Sikkim", "104"),
        Help("Tamil Nadu", "044-29510500"),
        Help("Telangana", "104"),
        Help("Tripura", "0381-2315879"),
        Help("Uttarakhand", "104"),
        Help("Uttar Pradesh", "18001805145"),
        Help("West Bengal", "1800313444222"),
        Help("Andaman and Nicobar Islands", "03192-232102"),
        Help("Chandigarh", "9779558282"),
        Help("Dadra and Nagar Haveli and Daman & Diu", "104"),
        Help("Delhi", "011-22307145"),
        Help("Jammu & Kashmir", "01912520982"),
        Help("Ladakh", "01982256462"),
        Help("Lakshadweep", "104"),
        Help("Puducherry", "104")
    )
}
