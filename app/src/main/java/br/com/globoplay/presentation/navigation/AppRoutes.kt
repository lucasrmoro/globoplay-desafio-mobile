package br.com.globoplay.presentation.navigation

import androidx.annotation.StringDef

@Retention(AnnotationRetention.SOURCE)
@StringDef(AppRoutes.ListStreams, AppRoutes.NewAndHot, AppRoutes.Profile)
annotation class AppRoute

object AppRoutes {

    const val ListStreams = "ListStreams"
    const val NewAndHot = "NewAndHot"
    const val Profile = "Profile"

}