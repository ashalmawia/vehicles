package com.ashalmawia.vehicles.features.list

import com.ashalmawia.vehicles.data.MockRepository
import com.ashalmawia.vehicles.model.Vehicle
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class VehicleListPresenterTest {

    @Test
    fun `vehicles are loaded and shown in view`() {
        // given
        val list = listOf(
            Vehicle("Test Vehicle 1"),
            Vehicle("Test Vehicle 2")
        )

        val mockRepository = MockRepository(list)
        val mockView = VehicleListViewMock()
        val presenter = VehiclesListPresenterImpl(mockView, mockRepository)

        // when
        presenter.start()

        // then
        assertEquals(list, mockView.shownVehicles)
    }
}