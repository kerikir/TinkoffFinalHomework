package com.tinkoff.android_homework.data.repo.detail

import com.tinkoff.android_homework.data.network.datasource.DetailRemoteDataSource
import com.tinkoff.android_homework.data.storage.mappers.detail.DetailDbModelMapper
import com.tinkoff.android_homework.data.network.mappers.detail.DetailDtoMapper
import com.tinkoff.android_homework.data.repo.utils.InternetChecker
import com.tinkoff.android_homework.data.storage.datasource.DetailLocalDataSource
import com.tinkoff.android_homework.domain.main.entities.Detail
import com.tinkoff.android_homework.domain.main.repos.DetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject



/**
 * Реализация возможных действий с дополнительной информацией о финансовой операции.
 */
class DetailRepositoryImpl @Inject constructor(
    private val detailRemoteDataSource: DetailRemoteDataSource,
    private val detailLocalDataSource: DetailLocalDataSource,
    private val detailDtoMapper: DetailDtoMapper,
    private val detailDbModelMapper: DetailDbModelMapper,
    private val internetChecker: InternetChecker,
) : DetailRepository {

    /**
     * Получение потока с информацией о финансовой операции.
     *
     * @param id Идентификатор финансовой операции.
     * @return Поток с детальным описанием финансовой операции domain-слоя
     */
    override fun subscribeDetail(id: Int): Flow<Detail> {

        return detailDbModelMapper(detailLocalDataSource.subscribeDetail(id))
            .onStart {
                // Выполняется перед началом эмита данных
                refreshFromNetwork(id)
            }
    }


    /**
     * Получение информации о финансовой операции из сети.
     *
     * @param id Идентификатор финансовой операции.
     */
    private suspend fun refreshFromNetwork(id: Int) {
        // Проверка на подключение интернета
        if (internetChecker.isInternetAvailable()) {
            // Загружаем информацию из сети
            val detailDto = detailRemoteDataSource.getDetail(id)
            // Сохраняем информацию в БД
            detailLocalDataSource.insertDetail(detailDtoMapper(detailDto))
        }
    }
}