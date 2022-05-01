package com.pashtet.topmovielist.daggerComponent

import android.app.Activity
import com.pashtet.topmovielist.adapter.MovieListAdapter
import com.pashtet.topmovielist.repository.MovieRepo
import com.pashtet.topmovielist.ui.MainActivity
import dagger.Component


@Component(modules = [RepoModule::class])
interface RepoComponent {

    fun getRepository():MovieRepo

}