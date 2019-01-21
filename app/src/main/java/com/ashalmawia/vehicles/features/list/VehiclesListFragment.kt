package com.ashalmawia.vehicles.features.list

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ashalmawia.vehicles.R
import com.ashalmawia.vehicles.data.Repository
import java.lang.IllegalStateException

class VehiclesListFragment: Fragment() {

    private var view: VehiclesListView? = null
    private var presenter: VehiclesListPresenter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_vehicles_list, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize(view)
    }

    private fun initialize(root: View) {
        val view = VehiclesListViewImpl(root as ViewGroup)

        this.presenter = VehiclesListPresenterImpl(view, Repository.get())
        this.view = view
    }

    override fun onStart() {
        super.onStart()

        presenter?.start() ?: throw IllegalStateException("presenter not initialized")
    }

    override fun onStop() {
        super.onStop()

        presenter?.stop() ?: throw IllegalStateException("presenter not initialized")
    }

    override fun onDestroyView() {
        super.onDestroyView()

        view = null
        presenter = null
    }
}