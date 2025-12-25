package com.tinkoff.android_homework.data.repo.total

import com.tinkoff.android_homework.data.network.datasource.TotalRemoteDataSource
import com.tinkoff.android_homework.data.network.mappers.total.TotalDtoMapper
import com.tinkoff.android_homework.data.repo.utils.InternetChecker
import com.tinkoff.android_homework.data.storage.dao.TotalDbModelDao
import com.tinkoff.android_homework.data.storage.mappers.total.TotalDbModelMapper
import com.tinkoff.android_homework.domain.main.entities.Total
import com.tinkoff.android_homework.domain.main.repos.TotalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


/**
 * Реализация возможных действий с общей суммой финансовых операций.
 */
class TotalRepositoryImpl @Inject constructor(
    private val totalDbModelDao: TotalDbModelDao,
    private val totalRemoteDataSource: TotalRemoteDataSource,
    private val totalDtoMapper: TotalDtoMapper,
    private val totalDbModelMapper: TotalDbModelMapper,
    private val internetChecker: InternetChecker,
) : TotalRepository {

    /**
     * Подписка на общую сумму финансовых операций.
     *
     * @return Поток общей суммы финансовых операций
     */
    override suspend fun subscribeTotal(): Flow<Total> {

        // Проверка на подключение интернета
        if (internetChecker.isInternetAvailable()) {
            // Загружаем информацию из сети
            val totalDto = totalRemoteDataSource.getTotal()
            // Сохраняем информацию в БД
            totalDbModelDao.insert(totalDtoMapper(totalDto))
        }

        // Получаем общую сумму финансовых операции из БД
        return totalDbModelDao.getTotal().map { totalDbModelMapper(it) }
    }
}