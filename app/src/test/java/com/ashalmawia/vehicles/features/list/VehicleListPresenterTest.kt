package com.ashalmawia.vehicles.features.list

import com.ashalmawia.vehicles.data.ErrorRepository
import com.ashalmawia.vehicles.data.MockRepository
import com.ashalmawia.vehicles.model.Vehicle
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import junit.framework.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class VehicleListPresenterTest {

    @Before
    fun before() {
        val thread = Schedulers.newThread()
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { thread }
        RxJavaPlugins.setIoSchedulerHandler { thread }
    }

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
        Thread.sleep(200)       // have to wait because operation is asynchronous

        // then
        assertEquals(list, mockView.shownVehicles)
        assertFalse(mockView.isShowErrorCalled)
    }

    @Test
    fun `error loading vehicles`() {
        // given
        val error = Exception("mock exception")
        val mockRepository = ErrorRepository(error)
        val mockView = VehicleListViewMock()
        val presenter = VehiclesListPresenterImpl(mockView, mockRepository)

        // when
        presenter.start()
        Thread.sleep(200)       // have to wait because operation is asynchronous

        // then
        assertTrue(mockView.isShowErrorCalled)
        assertTrue(mockView.shownVehicles.isEmpty())
    }
}