package com.example.last_month.presentation.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.last_month.presentation.ui.utils.UIState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

open class BaseFragment : Fragment() {

    open fun loadView() {}
    open fun initClickers() {}

    protected fun <T> StateFlow<UIState<T>>.collectState(
        state: (UIState<T>) -> Unit,
        onSuccess: (data: T ) -> Unit
    ){
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                collect { result ->
                    state.invoke(result)
                    when (result) {
                        is UIState.Empty -> {}
                        is UIState.Error -> {
                            Toast.makeText(requireContext(), result.message, Toast.LENGTH_SHORT)
                                .show()
                        }

                        is UIState.Loading -> {
                            //show progress bar
                        }

                        is UIState.Success -> {
                            onSuccess(result.data)
                        }
                    }
                }
            }
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadView()
        initClickers()
    }
}

