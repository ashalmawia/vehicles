package com.ashalmawia.vehicles.dependency

import com.ashalmawia.vehicles.data.InMemoryCache
import com.ashalmawia.vehicles.data.Repository
import com.ashalmawia.vehicles.data.network.NetworkRepository

/**
 * As application grows, it should be better replaced with a dependency injection solution (Dagger)
 * or a third-party service locator with more features supported (e.g. Koin or Kodein)
 */
interface ServiceLocator {

    val repository: Repository

}

object ServiceLocatorImpl : ServiceLocator {

    override val repository: Repository by lazy { InMemoryCache(NetworkRepository()) }

}