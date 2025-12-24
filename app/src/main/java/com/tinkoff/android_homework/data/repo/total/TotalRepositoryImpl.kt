package com.tinkoff.android_homework.data.repo.total

import com.tinkoff.android_homework.data.network.mappers.total.TotalDtoMapper
import com.tinkoff.android_homework.data.repo.utils.InternetChecker
import com.tinkoff.android_homework.data.network.services.TotalDtoService
import com.tinkoff.android_homework.data.storage.dao.TotalDbModelDao
import com.tinkoff.android_homework.data.storage.mappers.total.TotalDbModelMapper
import com.tinkoff.android_homework.domain.main.entities.Total
import com.tinkoff.android_homework.domain.main.repos.TotalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class TotalRepositoryImpl @Inject constructor(
    private val totalDbModelDao: TotalDbModelDao,
    private val totalDtoService: TotalDtoService,
    private val totalDtoMapper: TotalDtoMapper,
    private val totalDbModelMapper: TotalDbModelMapper,
    private val internetChecker: InternetChecker,
) : TotalRepository {

    override suspend fun subscribeTotal(): Flow<Total> {
        if (internetChecker.isInternetAvailable()) {
            val totalApi = totalDtoService.getTotal()
            totalDbModelDao.insert(totalDtoMapper.invoke(totalApi))
        }
        return totalDbModelDao.getAll().map { totalDbModelMapper.invoke(it) }
    }
}