package com.tinkoff.android_homework.data.repo.detail

import com.tinkoff.android_homework.data.network.datasource.DetailRemoteDataSource
import com.tinkoff.android_homework.data.storage.mappers.detail.DetailDbModelMapper
import com.tinkoff.android_homework.data.network.mappers.detail.DetailDtoMapper
import com.tinkoff.android_homework.data.repo.utils.InternetChecker
import com.tinkoff.android_homework.data.storage.dao.DetailDbModelDao
import com.tinkoff.android_homework.domain.main.entities.Detail
import com.tinkoff.android_homework.domain.main.repos.DetailRepository
import javax.inject.Inject


/**
 * Реализация возможных действий с дополнительной информацией о финансовой операции.
 */
class DetailRepositoryImpl @Inject constructor(
    private val detailRemoteDataSource: DetailRemoteDataSource,
    private val detailDbModelDao: DetailDbModelDao,
    private val detailDtoMapper: DetailDtoMapper,
    private val detailDbModelMapper: DetailDbModelMapper,
    private val internetChecker: InternetChecker,
) : DetailRepository {

    /**
     * Получение информации о финансовой операции.
     *
     * @param id Идентификатор финансовой операции.
     * @return Детальное описание финансовой операции domain-слоя
     */
    override suspend fun subscribeDetail(id: Int): Detail {

        // Проверка на подключение интернета
        if (internetChecker.isInternetAvailable()) {
            // Загружаем информацию из сети
            val detailDto = detailRemoteDataSource.getDetail(id)
            // Сохраняем информацию в БД
            detailDbModelDao.insertAll(detailDtoMapper(detailDto))
        }

        // TODO проверка на несоответствие id
        return detailDbModelMapper(detailDbModelDao.getDetailFlow(id.toLong()))
    }
}