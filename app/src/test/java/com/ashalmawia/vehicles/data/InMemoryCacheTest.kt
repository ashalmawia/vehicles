package com.ashalmawia.vehicles.data

import com.ashalmawia.vehicles.model.vehicle
import junit.framework.Assert.assertEquals
import org.junit.Test

class InMemoryCacheTest {

    @Test
    fun `test getting vehicles list`() {
        // given
        val vehicles = listOf(
            vehicle(name = "Test Vehicle 1"),
            vehicle(name = "Test Vehicle 2"),
            vehicle(name = "Test Vehicle 3")
        )
        val repository = MockRepository(vehicles)

        val cache = InMemoryCache(repository)

        // when
        cache.getVehicles().subscribe {
            // then
            assertEquals(vehicles, it)
        }
    }

    @Test
    fun `test result is cached`() {
        // given
        val vehicles = listOf(
            vehicle(name = "Test Vehicle 1"),
            vehicle(name = "Test Vehicle 2"),
            vehicle(name = "Test Vehicle 3")
        )
        val repository = MockRepository(vehicles)

        val cache = InMemoryCache(repository)
        cache.getVehicles().subscribe()     // fill the cache

        // when
        repository.changeVehicles(listOf())
        cache.getVehicles().subscribe {
            // then
            assertEquals(vehicles, it)
        }
    }

    @Test
    fun `test getting vehicle by id`() {
        // given
        val vehicles = listOf(
            vehicle(id = 1, name = "Test Vehicle 1"),
            vehicle(id = 2, name = "Test Vehicle 2"),
            vehicle(id = 3, name = "Test Vehicle 3")
        )
        val id = 2
        val repository = MockRepository(vehicles)

        val cache = InMemoryCache(repository)
        cache.getVehicles().subscribe()     // fill the cache

        // when
        val extracted = cache.vehicleById(id)

        // then
        assertEquals(vehicles.find { it.id == id }, extracted)

        // when
        repository.changeVehicles(listOf())
        val extractedAfterChange = cache.vehicleById(id)

        // then
        assertEquals(vehicles.find { it.id == id }, extractedAfterChange)
    }
}