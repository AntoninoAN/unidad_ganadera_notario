package com.unidad.ganadera.notario.model

import com.unidad.ganadera.notario.module_app.domain.UseCase
import kotlinx.coroutines.flow.flow

class RepositoryImpl constructor(private val useCase: UseCase): Repository {

    /**
     * Define @param unidadGanadera, possibly used for different unidades
     */
    override fun getAllCows(unidadGanadera: String) =
        flow<PresentationData>{
            useCase.getAllCows()
            emit(
                PresentationData.SuccessRemote(
                    useCase.state.value
                )
            )
        }
}