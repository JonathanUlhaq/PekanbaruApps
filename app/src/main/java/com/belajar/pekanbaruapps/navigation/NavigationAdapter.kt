package com.belajar.pekanbaruapps.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.belajar.pekanbaruapps.model.KesehatanModel
import com.belajar.pekanbaruapps.screen.berita.screen.DetailBerita
import com.belajar.pekanbaruapps.screen.berita.viewmodel.BeritaViewModel
import com.belajar.pekanbaruapps.screen.detailhotel.DetailHotelScreen
import com.belajar.pekanbaruapps.screen.detailhotel.viewmodel.DetailHotelViewModel
import com.belajar.pekanbaruapps.screen.detailkesehatan.screen.DetailKesehatan
import com.belajar.pekanbaruapps.screen.detailkesehatan.viewmodel.DetailKesehatanViewModel
import com.belajar.pekanbaruapps.screen.detailperbelanjaan.screen.BelanjaDetailScreen
import com.belajar.pekanbaruapps.screen.detailperbelanjaan.viewmodel.DetailPerbelanjaanViewModel
import com.belajar.pekanbaruapps.screen.detailrestaurant.screen.RestDetailScreen
import com.belajar.pekanbaruapps.screen.detailrestaurant.viewmodel.DetailRestaurantViewModel
import com.belajar.pekanbaruapps.screen.fasilitaskesehatan.screen.KesehatanScreen
import com.belajar.pekanbaruapps.screen.fasilitaskesehatan.viewmodel.KesehatanViewModel
import com.belajar.pekanbaruapps.screen.galeri.screen.DetailGaleri
import com.belajar.pekanbaruapps.screen.galeri.screen.MainGaleri
import com.belajar.pekanbaruapps.screen.galeri.viewmodel.GaleriViewModel
import com.belajar.pekanbaruapps.screen.hoaks.viewmodel.HoaksViewModel
import com.belajar.pekanbaruapps.screen.hotel.HotelScreen
import com.belajar.pekanbaruapps.screen.hotel.viewmodel.HotelViewModel
import com.belajar.pekanbaruapps.screen.login.LoginScreen
import com.belajar.pekanbaruapps.screen.magazine.screen.MagazineScreen
import com.belajar.pekanbaruapps.screen.magazine.viewmodel.MagazineViewModel
import com.belajar.pekanbaruapps.screen.main.MainScreen
import com.belajar.pekanbaruapps.screen.mainberita.MainBerita
import com.belajar.pekanbaruapps.screen.onboarding.screen.OnBoarding
import com.belajar.pekanbaruapps.screen.pembelanjaan.screen.PembelanjanScreen
import com.belajar.pekanbaruapps.screen.pembelanjaan.viewmodel.PembelanjaanViewModel
import com.belajar.pekanbaruapps.screen.pendidikan.MainPendidikan
import com.belajar.pekanbaruapps.screen.pendidikan.sd.viewmodel.SDViewModel
import com.belajar.pekanbaruapps.screen.pendidikan.smp.viewmodel.SMPViewModel
import com.belajar.pekanbaruapps.screen.pendidikandetail.sd.screen.SDDetailScreen
import com.belajar.pekanbaruapps.screen.pendidikandetail.sd.viewmodel.SDDetailViewModel
import com.belajar.pekanbaruapps.screen.pendidikandetail.smp.screen.SMPDetailScreen
import com.belajar.pekanbaruapps.screen.pendidikandetail.smp.viewmodel.SMPDetailViewModel
import com.belajar.pekanbaruapps.screen.pengumuman.screen.PengumumanScreen
import com.belajar.pekanbaruapps.screen.pengumuman.viewmodel.PengumumanViewModel
import com.belajar.pekanbaruapps.screen.pengumumandetail.PengumumanDetail
import com.belajar.pekanbaruapps.screen.profile.EditProfile
import com.belajar.pekanbaruapps.screen.profile.ProfileScreen
import com.belajar.pekanbaruapps.screen.restaurant.screen.RestaurantScreen
import com.belajar.pekanbaruapps.screen.restaurant.viewmodel.RestaurantViewModel
import com.belajar.pekanbaruapps.screen.signup.SignUp
import com.belajar.pekanbaruapps.screen.wisata.screen.WisataScreen
import com.belajar.pekanbaruapps.screen.wisata.viewmodel.WisataViewModel
import com.belajar.pekanbaruapps.screen.wisatadetail.screen.WisataDetailScreen
import com.belajar.pekanbaruapps.screen.wisatadetail.viewmodel.WisataDetailViewModel
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavigationAdapter() {
    val navController = rememberAnimatedNavController()
    val systemUiController = rememberSystemUiController()

    val hotelVm = hiltViewModel<HotelViewModel>()
    val detailHotel = hiltViewModel<DetailHotelViewModel>()
    val restaurant = hiltViewModel<RestaurantViewModel>()
    val detailRestaurant = hiltViewModel<DetailRestaurantViewModel>()
    val wisataVm = hiltViewModel<WisataViewModel>()
    val wisataDetailVm = hiltViewModel<WisataDetailViewModel>()
    val pembelanjaanVm = hiltViewModel<PembelanjaanViewModel>()
    val belanjaDetailVm = hiltViewModel<DetailPerbelanjaanViewModel>()
    val SDVm = hiltViewModel<SDViewModel>()
    val SMPVm = hiltViewModel<SMPViewModel>()
    val SMPDetailVm = hiltViewModel<SMPDetailViewModel>()
    val SDDetailVm = hiltViewModel<SDDetailViewModel>()
    val kesehatanVm = hiltViewModel<KesehatanViewModel>()
    val detailKesehatanVm = hiltViewModel<DetailKesehatanViewModel>()
    val beritaVm = hiltViewModel<BeritaViewModel>()
    val hoaksVm = hiltViewModel<HoaksViewModel>()
    val magazineVm = hiltViewModel<MagazineViewModel>()
    val pengumumanVm = hiltViewModel<PengumumanViewModel>()
    val galeriVm = hiltViewModel<GaleriViewModel>()

    AnimatedNavHost(
        navController = navController,
        startDestination = AppRoute.Onboarding.route
    ) {

        composable(AppRoute.Onboarding.route) {
            systemUiController.setStatusBarColor(
                color = MaterialTheme.colors.onSurface
            )
            systemUiController.setNavigationBarColor(
                color = Color.Transparent
            )
            OnBoarding(navController)
        }

        composable(AppRoute.EditProfile.route) {
            systemUiController.setStatusBarColor(
                color = MaterialTheme.colors.onSurface
            )
            systemUiController.setNavigationBarColor(
                color = Color.Transparent
            )
            EditProfile(navController)
        }

        composable(AppRoute.Profile.route) {
            systemUiController.setStatusBarColor(
                color = MaterialTheme.colors.onSurface
            )
            systemUiController.setNavigationBarColor(
                color = Color.Transparent
            )
            ProfileScreen(navController)
        }


        composable(AppRoute.Signup.route) {
            systemUiController.setStatusBarColor(
                color = MaterialTheme.colors.onSurface
            )
            systemUiController.setNavigationBarColor(
                color = Color.Transparent
            )
            SignUp(navController)
        }

        composable(AppRoute.Login.route) {
            systemUiController.setStatusBarColor(
                color = MaterialTheme.colors.onSurface
            )
            systemUiController.setNavigationBarColor(
                color = Color.Transparent
            )
            LoginScreen(navController)
        }


        composable(AppRoute.Pengumuman.route) {
            systemUiController.setStatusBarColor(
                color = MaterialTheme.colors.onSurface
            )
            systemUiController.setNavigationBarColor(
                color = Color.Transparent
            )
            PengumumanScreen(navController = navController, vm = pengumumanVm  )
        }

        composable(AppRoute.Restaurant.route) {
            systemUiController.setStatusBarColor(
                color = MaterialTheme.colors.onSurface
            )
            systemUiController.setNavigationBarColor(
                color = Color.Transparent
            )
            RestaurantScreen(navController = navController,restaurant,detailRestaurant)
        }

        composable(AppRoute.Magazine.route) {
            systemUiController.setStatusBarColor(
                color = MaterialTheme.colors.onSurface
            )
            systemUiController.setNavigationBarColor(
                color = Color.Transparent
            )
            MagazineScreen(navController = navController, vm = magazineVm  )
        }

        composable(AppRoute.Berita.route) {
            systemUiController.setStatusBarColor(
                color = MaterialTheme.colors.onSurface
            )
            systemUiController.setNavigationBarColor(
                color = Color.Transparent
            )
            MainBerita(navController = navController, vm = beritaVm , hoaksVm = hoaksVm )
        }

        composable(AppRoute.Galeri.route) {
            systemUiController.setStatusBarColor(
                color = MaterialTheme.colors.onSurface
            )
            systemUiController.setNavigationBarColor(
                color = Color.Transparent
            )
            MainGaleri(navController = navController, vm = galeriVm )
        }

        composable(AppRoute.DetailGaleri.route+"/{name}",
            arguments = listOf(navArgument("name"){
                type = NavType.StringType
            })
        ) {
            systemUiController.setStatusBarColor(
                color = MaterialTheme.colors.onSurface
            )
            systemUiController.setNavigationBarColor(
                color = Color.Transparent
            )
            DetailGaleri(navController = navController,
                vm = galeriVm,
                berita = it.arguments!!.getString("name")!!
            )
        }

        composable(AppRoute.PengumumanDetail.route+"/{name}",
            arguments = listOf(navArgument("name"){
                type = NavType.StringType
            })
        ) {
            systemUiController.setStatusBarColor(
                color = MaterialTheme.colors.onSurface
            )
            systemUiController.setNavigationBarColor(
                color = Color.Transparent
            )
            PengumumanDetail(navController = navController,
                vm = pengumumanVm,
                pengumuman = it.arguments!!.getString("name")!!
            )
        }

        composable(AppRoute.KesehatanDetail.route+"/{name}",
            arguments = listOf(navArgument("name"){
                type = NavType.StringType
            })
        ) {
            systemUiController.setStatusBarColor(
                color = MaterialTheme.colors.onSurface
            )
            systemUiController.setNavigationBarColor(
                color = Color.Transparent
            )
            DetailKesehatan(navController = navController,
                vm = detailKesehatanVm,
                kesehatanName = it.arguments!!.getString("name")!!
            )
        }

        composable(AppRoute.DetailBerita.route+"/{name}",
            arguments = listOf(navArgument("name"){
                type = NavType.StringType
            })
        ) {
            systemUiController.setStatusBarColor(
                color = MaterialTheme.colors.onSurface
            )
            systemUiController.setNavigationBarColor(
                color = Color.Transparent
            )
            DetailBerita(navController = navController,
                vm = beritaVm,
                berita = it.arguments!!.getString("name")!!
            )
        }

        composable(AppRoute.Kesehatan.route) {
            systemUiController.setStatusBarColor(
                color = MaterialTheme.colors.onSurface
            )
            systemUiController.setNavigationBarColor(
                color = Color.Transparent
            )
            KesehatanScreen(navController = navController,kesehatanVm,detailKesehatanVm)
        }

        composable(AppRoute.Pembelanjaan.route) {
            systemUiController.setStatusBarColor(
                color = MaterialTheme.colors.onSurface
            )
            systemUiController.setNavigationBarColor(
                color = Color.Transparent
            )
            PembelanjanScreen(navController = navController,pembelanjaanVm,belanjaDetailVm)
        }

        composable(AppRoute.Pendidikan.route) {
            systemUiController.setStatusBarColor(
                color = MaterialTheme.colors.onSurface
            )
            systemUiController.setNavigationBarColor(
                color = Color.Transparent
            )
            MainPendidikan(navController = navController,SDVm,SMPVm,SDDetailVm,SMPDetailVm)
        }

        composable(AppRoute.Wisata.route) {
            systemUiController.setStatusBarColor(
                color = MaterialTheme.colors.onSurface
            )
            systemUiController.setNavigationBarColor(
                color = Color.Transparent
            )
            WisataScreen(navController = navController,wisataVm,wisataDetailVm)
        }

        composable(AppRoute.DetailRestaurant.route+"/{name}",
            arguments = listOf(navArgument("name"){
                type = NavType.StringType
            })
        ) {
            systemUiController.setStatusBarColor(
                color = MaterialTheme.colors.onSurface
            )
            systemUiController.setNavigationBarColor(
                color = Color.Transparent
            )
           RestDetailScreen(navController = navController,
               vm = detailRestaurant,
               restaurantName = it.arguments!!.getString("name")!!
           )
        }

        composable(AppRoute.SMPDetail.route+"/{name}",
            arguments = listOf(navArgument("name"){
                type = NavType.StringType
            })
        ) {
            systemUiController.setStatusBarColor(
                color = MaterialTheme.colors.onSurface
            )
            systemUiController.setNavigationBarColor(
                color = Color.Transparent
            )
            SMPDetailScreen(navController = navController,
                vm = SMPDetailVm,
                restaurantName = it.arguments!!.getString("name")!!
            )
        }

        composable(AppRoute.SDDetail.route+"/{name}",
            arguments = listOf(navArgument("name"){
                type = NavType.StringType
            })
        ) {
            systemUiController.setStatusBarColor(
                color = MaterialTheme.colors.onSurface
            )
            systemUiController.setNavigationBarColor(
                color = Color.Transparent
            )
            SDDetailScreen(navController = navController,
                vm = SDDetailVm,
                restaurantName = it.arguments!!.getString("name")!!
            )
        }

        composable(AppRoute.BelanjaDetail.route+"/{name}",
            arguments = listOf(navArgument("name"){
                type = NavType.StringType
            })
        ) {
            systemUiController.setStatusBarColor(
                color = MaterialTheme.colors.onSurface
            )
            systemUiController.setNavigationBarColor(
                color = Color.Transparent
            )
            BelanjaDetailScreen(navController = navController,
                vm = belanjaDetailVm,
                restaurantName = it.arguments!!.getString("name")!!
            )
        }

        composable(AppRoute.WisataDetail.route+"/{name}",
            arguments = listOf(navArgument("name"){
                type = NavType.StringType
            })
        ) {
            systemUiController.setStatusBarColor(
                color = MaterialTheme.colors.onSurface
            )
            systemUiController.setNavigationBarColor(
                color = Color.Transparent
            )
            WisataDetailScreen(navController = navController,
                vm = wisataDetailVm,
                restaurantName = it.arguments!!.getString("name")!!
            )
        }

        composable(AppRoute.Home.route) {
            systemUiController.setStatusBarColor(
                color = MaterialTheme.colors.primary
            )
            systemUiController.setNavigationBarColor(
                color = Color.Transparent
            )
            MainScreen(navController)
        }


        composable(AppRoute.HotelPekanbaru.route) {
            systemUiController.setStatusBarColor(
                color = MaterialTheme.colors.onSurface
            )
            systemUiController.setNavigationBarColor(
                color = Color.Transparent
            )
            HotelScreen(navController = navController, vm = hotelVm , detailVm = detailHotel )
        }

        composable(
            AppRoute.DetailHotel.route + "/{nama}",
            arguments = listOf(navArgument("nama") {
                type = NavType.StringType

            })
        ) {
            systemUiController.setStatusBarColor(
                color = MaterialTheme.colors.onSurface
            )
            systemUiController.setNavigationBarColor(
                color = Color.Transparent
            )
            DetailHotelScreen(
                navController = navController,
                detailHotel,
                it.arguments?.getString("nama")!!
            )
        }
    }
}