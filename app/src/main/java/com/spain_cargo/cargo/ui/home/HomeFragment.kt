package com.spain_cargo.cargo.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.spain_cargo.cargo.R
import com.spain_cargo.cargo.data.model.brands.Brand
import com.spain_cargo.cargo.databinding.FragmentHomeBinding
import com.spain_cargo.cargo.ui.base.BaseFragment
import com.spain_cargo.cargo.ui.base.BaseNavigator
import com.spain_cargo.cargo.util.Constants.country_id
import com.spain_cargo.cargo.util.copyToClipBoard
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, IHomeInteractionListener, HomeViewModel>(),
    IHomeInteractionListener, IHomeItemActionListener {

    private val homeViewModel: HomeViewModel by viewModels()


    override fun getLayoutId() = R.layout.fragment_home

    override fun getViewModel() = homeViewModel

    override fun getNavigator() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getViewModel().getBrands(country_id)
        getViewModel().getUser()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val brandsAdapter = HomeAdapter(requireContext(), mutableListOf())
        brandsAdapter.setOnItemClickListener(this)

        getViewDataBinding().apply {
            rvBrands.adapter = brandsAdapter
            cvBalances.setOnClickListener {
                onBalanceClickListener()
            }
        }
    }

    override fun onItemClick(item: Brand) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(item.link))
        startActivity(browserIntent)
    }

    private fun onBalanceClickListener() {
        getViewModel().usersResponse.observe(viewLifecycleOwner) {
            copyToClipBoard(it.data?.data?.user?.balance.toString())
        }
    }
}

interface IHomeInteractionListener : BaseNavigator