package com.pashtet.topmovielist.daggerComponent

import com.pashtet.topmovielist.repository.MovieRepo
import dagger.Component


@Component(modules = [RepoModule::class])
interface RepoComponent {

    fun getRepository():MovieRepo
}