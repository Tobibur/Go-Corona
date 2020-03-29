package com.tobibur.covid_19.view

import androidx.lifecycle.ViewModel
import com.tobibur.covid_19.R
import com.tobibur.covid_19.model.Tips

class GuideViewModel : ViewModel() {

    val tipsMutableList = mutableListOf(
        Tips(
            R.drawable.covid19,
            "Coronavirus Overview",
            "Coronavirus disease (COVID-19) is an infectious disease caused by a newly discovered coronavirus.\n" +
                    "\n" +
                    "Most people infected with the COVID-19 virus will experience mild to moderate respiratory illness and recover without requiring special treatment.  Older people, and those with underlying medical problems like cardiovascular disease, diabetes, chronic respiratory disease, and cancer are more likely to develop serious illness.\n" +
                    "\n" +
                    "The best way to prevent and slow down transmission is be well informed about the COVID-19 virus, the disease it causes and how it spreads. Protect yourself and others from infection by washing your hands or using an alcohol based rub frequently and not touching your face. \n" +
                    "\n" +
                    "The COVID-19 virus spreads primarily through droplets of saliva or discharge from the nose when an infected person coughs or sneezes, so it’s important that you also practice respiratory etiquette (for example, by coughing into a flexed elbow).\n" +
                    "\n" +
                    "At this time, there are no specific vaccines or treatments for COVID-19. However, there are many ongoing clinical trials evaluating potential treatments. WHO will continue to provide updated information as soon as clinical findings become available."
        ),
        Tips(
            R.drawable.handwash,
            "Coronavirus Prevention tips",
            "To prevent infection and to slow transmission of COVID-19, do the following:\n" +
                    "\n" +
                    "\u2022 Wash your hands regularly with soap and water, or clean them with alcohol-based hand rub.\n" +
                    "\u2022 Maintain at least 1 metre distance between you and people coughing or sneezing.\n" +
                    "\u2022 Avoid touching your face.\n" +
                    "\u2022 Cover your mouth and nose when coughing or sneezing.\n" +
                    "\u2022 Stay home if you feel unwell.\n" +
                    "\u2022 Refrain from smoking and other activities that weaken the lungs.\n" +
                    "\u2022 Practice physical distancing by avoiding unnecessary travel and staying away from large groups of people."
        ),
        Tips(
            R.drawable.symptoms,
            "Coronavirus Symptoms",
            "The COVID-19 virus affects different people in different ways.  COVID-19 is a respiratory disease and most infected people will develop mild to moderate symptoms and recover without requiring special treatment.  People who have underlying medical conditions and those over 60 years old have a higher risk of developing severe disease and death.\n" +
                    "\n" +
                    "Common symptoms include:\n" +
                    "\n" +
                    "• fever\n" +
                    "• tiredness\n" +
                    "• dry cough.\n" +
                    "Other symptoms include:\n" +
                    "\n" +
                    "• shortness of breath\n" +
                    "• aches and pains\n" +
                    "• sore throat\n" +
                    "• and very few people will report diarrhoea, nausea or a runny nose.\n" +
                    "\nPeople with mild symptoms who are otherwise healthy should self-isolate and contact their medical provider or a COVID-19 information line for advice on testing and referral.\n" +
                    "\n" +
                    "People with fever, cough or difficulty breathing should call their doctor and seek medical attention."
        )

    )

}
