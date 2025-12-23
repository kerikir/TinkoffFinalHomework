package com.tinkoff.android_homework.data.network.repo.detail

import com.tinkoff.android_homework.data.storage.mappers.detail.DetailDbModelMapper
import com.tinkoff.android_homework.data.network.mappers.detail.DetailDtoMapper
import com.tinkoff.android_homework.data.network.repo.utils.InternetChecker
import com.tinkoff.android_homework.data.network.services.DetailService
import com.tinkoff.android_homework.data.storage.dao.DetailDbModelDao
import com.tinkoff.android_homework.domain.main.entities.Detail
import javax.inject.Inject

/**
 * @author d.shtaynmets
 */
interface DetailRepository {

    suspend fun getDetail(id: Int): Detail

}

class SubscribeDetailRepositoryImpl @Inject constructor(
    private val detailService: DetailService,
    private val detailDbModelDao: DetailDbModelDao,
    private val detailDtoMapper: DetailDtoMapper,
    private val detailDbModelMapper: DetailDbModelMapper,
    private val internetChecker: InternetChecker,
) : DetailRepository {


    override suspend fun getDetail(id: Int): Detail {
        if (internetChecker.isInternetAvailable()) {
            val detailApi = detailService.getDetail(id)
            detailDbModelDao.insertAll(detailDtoMapper.invoke(detailApi))
        }

        return detailDbModelMapper.invoke(detailDbModelDao.getAll())
    }
}
