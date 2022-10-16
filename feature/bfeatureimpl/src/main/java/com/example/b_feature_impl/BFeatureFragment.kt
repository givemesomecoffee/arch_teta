package com.example.b_feature_impl

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.b_feature_impl.di.BFeatureComponent
import com.example.b_feature_impl.di.BFeatureComponentHolder
import com.example.b_feature_impl.viewmodel.BFeatureViewModel
import com.example.common_api.lce.LceViewState
import givemesomecoffee.ru.test_interactor_api.model.TestInteractorDto

class BFeatureFragment : Fragment() {

    private val viewModel: BFeatureViewModel by viewModels()

    private var loader: ProgressBar? = null
    private var textField: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (BFeatureComponentHolder.get() as BFeatureComponent).inject(viewModel)
        viewModel.getData(2)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.state.observe(viewLifecycleOwner, ::render)
        return inflater.inflate(R.layout.b_feature_fragment, container, false).apply {
            loader = findViewById(R.id.loading)
            textField = findViewById(R.id.test_field)
        }
    }

    private fun render(state: LceViewState<TestInteractorDto>) {
        loader?.isVisible = state.loading
        state.data?.let {
            textField?.text = it.master
        }
        if (state.animateError) textField?.text = state.error
    }

    companion object {
        fun newInstance() = BFeatureFragment()
    }
}
