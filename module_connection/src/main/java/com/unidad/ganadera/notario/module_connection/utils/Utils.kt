package com.unidad.ganadera.notario.module_connection.utils

import android.os.Build


enum class PermissionsType {
    LocationPermissionsType
}

fun checkIfPermissionsProvided(permissionsType: PermissionsType): Boolean {
    when (permissionsType) {
        PermissionsType.LocationPermissionsType -> {
            return true
        }
    }
}

fun verifyOSDeviceVersion(versionRequest: Int) =
    when {
        versionRequest >= 23 -> {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
        }

        else -> {
            false
        }
    }

