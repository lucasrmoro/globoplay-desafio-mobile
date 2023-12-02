package br.com.globoplay.presentation.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import br.com.globoplay.R

enum class BottomNavItem(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    @AppRoute val route: String
) {
    HOME(title = R.string.home, R.drawable.ic_home, AppRoutes.ListStreams),
    NEW_AND_HOT(title = R.string.new_and_hot, R.drawable.ic_video_library, AppRoutes.NewAndHot),
    PROFILE(title = R.string.my_profile, R.drawable.ic_person, AppRoutes.Profile)
}