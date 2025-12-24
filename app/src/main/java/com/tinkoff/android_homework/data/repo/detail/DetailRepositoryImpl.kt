package com.tinkoff.android_homework.data.repo.detail

import com.tinkoff.android_homework.data.network.datasource.DetailRemoteDataSource
import com.tinkoff.android_homework.data.storage.mappers.detail.DetailDbModelMapper
import com.tinkoff.android_homework.data.network.mappers.detail.DetailDtoMapper
import com.tinkoff.android_homework.data.repo.utils.InternetChecker
import com.tinkoff.android_homework.data.storage.dao.DetailDbModelDao
import com.tinkoff.android_homework.domain.main.entities.Detail
import com.tinkoff.android_homework.domain.main.repos.DetailRepository
import javax.inject.Inject


class DetailRepositoryImpl @Inject constructor(
    private val detailRemoteDataSource: DetailRemoteDataSource,
    private val detailDbModelDao: DetailDbModelDao,
    private val detailDtoMapper: DetailDtoMapper,
    private val detailDbModelMapper: DetailDbModelMapper,
    private val internetChecker: InternetChecker,
) : DetailRepository {


    override suspend fun getDetail(id: Int): Detail {
        if (internetChecker.isInternetAvailable()) {
            val detailDto = detailRemoteDataSource.getDetail(id)
            detailDbModelDao.insertAll(detailDtoMapper(detailDto))
        }

        return detailDbModelMapper.invoke(detailDbModelDao.getAll())
    }
}