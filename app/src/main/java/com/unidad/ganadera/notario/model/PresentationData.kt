package com.unidad.ganadera.notario.model

/**
 * Presentation Data
 * Intended to display the different data states in the UI.
 * 2 mayor scenarios: Offline an Online Mode.
 * Data will be coming either from <Online> full sync with Firebase.
 * Data will be coming from <Offline> from previous full sync with Local Room DB.
 * User should visualize either Online or Offline mode are activated.
 * Also to remind either to trigger a full sync after operations.
 */
sealed class PresentationData {
    object Loading : PresentationData()
    data class SuccessRemote<T: Any>(val data: T) : PresentationData()
    data class SuccessLocal<T: Any>(val data: T) : PresentationData()
    sealed class Synchronization : PresentationData() {
        data class OfflineMode(val isActive: Boolean) : Synchronization()
        data class FullSynchronize(val isCompleted: Boolean) : Synchronization()
    }
    data class Error(val errorMessage: String) : PresentationData()
}
