package com.unidad.ganadera.notario.module_connection.connectiviy

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build
import com.unidad.ganadera.notario.module_connection.utils.verifyOSDeviceVersion
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class NetworkConnectionManagerImpl @Inject constructor(
    private val context: Context
) : ConnectionManager {

    private val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    override fun isOnline(): Boolean {
        if (verifyOSDeviceVersion(Build.VERSION_CODES.M)) {
            val network = connectivityManager.activeNetwork ?: return false
            val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
            return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                    capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
        } else {
            @Suppress("DEPRECATION")
            val networkInfo = connectivityManager.activeNetworkInfo ?: return false
            @Suppress("DEPRECATION")
            return networkInfo.isConnected && networkInfo.isAvailable
        }
    }

    override fun isMetered(): Boolean {
        return connectivityManager.isActiveNetworkMetered
    }

    override fun observeConnection(): Flow<ConnectionState> = callbackFlow {
        val callback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                trySend(ConnectionState.Available)
            }

            override fun onLosing(network: Network, maxMsToLive: Int) {
                trySend(ConnectionState.Losing)
            }

            override fun onLost(network: Network) {
                trySend(ConnectionState.Lost)
            }

            override fun onUnavailable() {
                trySend(ConnectionState.Unavailable)
            }
        }

        val request = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()

        connectivityManager.registerNetworkCallback(request, callback)

        awaitClose {
            connectivityManager.unregisterNetworkCallback(callback)
        }
    }
        .onStart { emit(if (isOnline()) ConnectionState.Available else ConnectionState.Unavailable) }
        .distinctUntilChanged()
}
