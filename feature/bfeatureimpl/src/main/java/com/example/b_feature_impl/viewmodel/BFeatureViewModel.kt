package com.example.b_feature_impl.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common_api.lce.LceViewState
import com.example.common_api.lce.lce
import com.example.common_api.lce.reduce
import givemesomecoffee.ru.test_interactor_api.api.TestInteractorApi
import givemesomecoffee.ru.test_interactor_api.model.TestInteractorDto
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class BFeatureViewModel() : ViewModel() {
    @Inject
    protected lateinit var testInteractor: TestInteractorApi

    private val _state: MutableLiveData<LceViewState<TestInteractorDto>> = MutableLiveData()
    val state: LiveData<LceViewState<TestInteractorDto>> get() = _state

    fun getData(id: Int){
        viewModelScope.launch {
            lce {
                testInteractor.getSomething(id)
            }.collectLatest {
                _state.postValue(it.reduce(_state.value))
            }
        }
    }

}
