package com.example.blackcoffer.Fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.TextView
import com.example.blackcoffer.R
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup


class RefineFragment : Fragment() {

    private lateinit var statusGroup: ChipGroup
    private lateinit var statusInput: EditText
    private lateinit var statusTextCount: TextView
    private lateinit var availability: AutoCompleteTextView
    private var availabilityStatusList =
        listOf<String>("Available | Hey Let Us Connect",
            "Away | Stay Discreet And Watch",
            "Busy | Do Not Disturb | Will catch Up Later",
            "Sos | Emergency Need Assistance"
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_refine, container, false)
        initialiseViews(view)
        Log.e("TAG", "onCreateView: statusegroup child count ${statusGroup.childCount}")
        statusInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                s?.length?.let { statusTextCount.text = it.toString() }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
        val availabilityAdapter = ArrayAdapter(this@RefineFragment.requireContext(), android.R.layout.simple_dropdown_item_1line, availabilityStatusList)
        availability.setAdapter(availabilityAdapter)
        return view
    }

    private fun initialiseViews(view: View) {
        statusGroup = view.findViewById(R.id.status_group)
        statusInput = view.findViewById(R.id.status_container)
        statusTextCount = view.findViewById(R.id.status_count)
        availability = view.findViewById(R.id.availability)
    }


}