package com.helloworldstudios.bottomsheetdialoglearning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.helloworldstudios.bottomsheetdialoglearning.databinding.FragmentExpandableBottomSheetDialogBinding

class ExpandableBottomSheetDialogFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentExpandableBottomSheetDialogBinding
    private lateinit var behavior: BottomSheetBehavior<*>
    private var isExpanded = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentExpandableBottomSheetDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        behavior = BottomSheetBehavior.from(requireView().parent as View)
        binding.tvToggle.setOnClickListener {
            if (isExpanded) {
                behavior.state = BottomSheetBehavior.STATE_COLLAPSED
                behavior.peekHeight = (view.height / 5)
                binding.tvToggle.text = "Expand"
            } else {
                behavior.state = BottomSheetBehavior.STATE_EXPANDED
                behavior.peekHeight = view.height
                binding.tvToggle.text = "Collapse"
            }
            isExpanded = !isExpanded
        }
    }

    override fun onStart() {
        super.onStart()
        behavior.state = BottomSheetBehavior.STATE_COLLAPSED
        //behavior.peekHeight = (binding.root.height / 2)
    }
}