package com.spain_cargo.cargo.ui.home

import android.view.View
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.spain_cargo.cargo.data.AppDataManager
import com.spain_cargo.cargo.data.model.BaseResource
import com.spain_cargo.cargo.data.model.brands.BrandsResponse
import com.spain_cargo.cargo.data.model.countries.CountriesResponse
import com.spain_cargo.cargo.ui.base.BaseViewModel
import com.spain_cargo.cargo.util.print

class HomeViewModel @ViewModelInject constructor(
    dataManager: AppDataManager
) : BaseViewModel<IHomeInteractionListener>(
    dataManager
) {


    var brandsResponse: MutableLiveData<BaseResource<BrandsResponse>> = MutableLiveData()


    fun getBrands(country_id:Int) {
        brandsResponse.value = BaseResource.loading(brandsResponse.value?.data)

        dispose(
            dataManager.getBrands(country_id),
            ::onCountriesSuccess,
            { e ->
                //error handling
                e.message?.let {
                    brandsResponse.postValue(BaseResource.error(it, null)) }
            })

        refreshListener.postValue(View.OnClickListener { getBrands(country_id) })

    }

    private fun onCountriesSuccess(result: BaseResource<BrandsResponse>) {

        result.data?.let {
            brandsResponse.postValue(result)
            it.print()
        }

    }

}