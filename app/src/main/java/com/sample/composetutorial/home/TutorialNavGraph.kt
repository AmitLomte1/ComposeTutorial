package com.sample.composetutorial.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sample.composetutorial.alertdialog.BasicAlertDialog
import com.sample.composetutorial.blurscreen.BlurScreen
import com.sample.composetutorial.bottomnavigation.MainScreen
import com.sample.composetutorial.bottomsheet.BasicBottomSheet
import com.sample.composetutorial.browseimage.BrowseImageScreen
import com.sample.composetutorial.circularshapeimage.CircularShapeImage
import com.sample.composetutorial.collapsingtollbar.CollapsingToolbarScreen
import com.sample.composetutorial.datepicker.DatePickerScreen
import com.sample.composetutorial.datepicker.TimePickerScreen
import com.sample.composetutorial.dropdownmenu.ExposedDropdownMenuScreen
import com.sample.composetutorial.hyperlinktext.HyperTextLinkPreview
import com.sample.composetutorial.loadinganimation.LoadingAnimation
import com.sample.composetutorial.multipreview.MultiPreviewScreen
import com.sample.composetutorial.nestednavigationgraph.navgraph.RootNavGraph
import com.sample.composetutorial.requestpermission.RequestPermission
import com.sample.composetutorial.scaffold.BasicScaffold
import com.sample.composetutorial.selectableitem.PreviewSelectableItem
import com.sample.composetutorial.shimmereffect.AnimatedShimmer
import com.sample.composetutorial.snackbar.BasicSnackbar
import com.sample.composetutorial.splashscreen.navgraph.SetUpNavGraph
import com.sample.composetutorial.stopwatch.screen.StopWatchScreen
import com.sample.composetutorial.stopwatch.viewmodel.StopWatchViewModel
import com.sample.composetutorial.tabrow.BasicTabRow
import com.sample.composetutorial.themeswitcher.ThemeSwitcherScreenPreview
import com.sample.composetutorial.topappbar.Material3TopAppBar
import com.sample.composetutorial.ui.basicuielements.AllButtonTypes
import com.sample.composetutorial.ui.basicuielements.AllChipTypes
import com.sample.composetutorial.ui.basicuielements.AllFabTypes
import com.sample.composetutorial.ui.basicuielements.BadgeWithIcon
import com.sample.composetutorial.ui.basicuielements.BasicCard
import com.sample.composetutorial.ui.basicuielements.BasicCheckbox
import com.sample.composetutorial.ui.basicuielements.BasicSlider
import com.sample.composetutorial.ui.basicuielements.BasicSwitch
import com.sample.composetutorial.ui.basicuielements.CoilImage
import com.sample.composetutorial.ui.basicuielements.CustomText
import com.sample.composetutorial.ui.basicuielements.ExpandableCardPreview
import com.sample.composetutorial.ui.basicuielements.GoogleButton
import com.sample.composetutorial.ui.basicuielements.GradientButton
import com.sample.composetutorial.ui.basicuielements.Greetings
import com.sample.composetutorial.ui.basicuielements.HorizontalPagerScreen
import com.sample.composetutorial.ui.basicuielements.ImageContentScales
import com.sample.composetutorial.ui.basicuielements.PasswordText
import com.sample.composetutorial.ui.basicuielements.RadioButtonGroup
import com.sample.composetutorial.ui.basicuielements.SimpleText
import com.sample.composetutorial.ui.basicuielements.VerticalPagerScreen
import com.sample.composetutorial.ui.basicuielements.WeightedRow
import com.sample.composetutorial.ui.canvas.ShowCustomCanvasComponent
import com.sample.composetutorial.ui.lazycolumn.LazyColumnScreen
import com.sample.composetutorial.ui.lazycolumn.StickyHeader
import com.sample.composetutorial.ui.lazygrid.FixedColumnsGrid
import com.sample.composetutorial.ui.lazyrow.BasicLazyRow
import com.sample.composetutorial.ui.progressbar.CustomCircularProgressBar
import com.sample.composetutorial.ui.toolbar.CentralizedToolBar
import com.sample.composetutorial.webview.WebScreen

@Composable
fun TutorialNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = TutorialRoute.Home.route
    ) {
        composable(TutorialRoute.Home.route) {
            TutorialHomeScreen(onItemClick = { route ->
                navController.navigate(route.route)
            })
        }

        // Basic UI Elements
        composable(TutorialRoute.Text.route) {
            TutorialScreen(title = TutorialRoute.Text.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Column(
                    modifier = modifier.fillMaxSize().padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CustomText()
                }
            }
        }

        composable(TutorialRoute.TextField.route) {
            TutorialScreen(title = TutorialRoute.TextField.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    SimpleText()
                }
            }
        }

        composable(TutorialRoute.Button.route) {
            TutorialScreen(title = TutorialRoute.Button.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    AllButtonTypes()
                }
            }
        }

        composable(TutorialRoute.Image.route) {
            TutorialScreen(title = TutorialRoute.Image.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    ImageContentScales()
                }
            }
        }

        composable(TutorialRoute.Card.route) {
            TutorialScreen(title = TutorialRoute.Card.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    BasicCard()
                }
            }
        }

        composable(TutorialRoute.Row.route) {
            TutorialScreen(title = TutorialRoute.Row.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Column(
                    modifier = modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {
                    WeightedRow()
                }
            }
        }

        composable(TutorialRoute.Box.route) {
            TutorialScreen(title = TutorialRoute.Box.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    Greetings()
                }
            }
        }

        composable(TutorialRoute.Checkbox.route) {
            TutorialScreen(title = TutorialRoute.Checkbox.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    BasicCheckbox()
                }
            }
        }

        composable(TutorialRoute.RadioButton.route) {
            TutorialScreen(title = TutorialRoute.RadioButton.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    RadioButtonGroup()
                }
            }
        }

        composable(TutorialRoute.Switch.route) {
            TutorialScreen(title = TutorialRoute.Switch.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    BasicSwitch()
                }
            }
        }

        composable(TutorialRoute.Slider.route) {
            TutorialScreen(title = TutorialRoute.Slider.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    BasicSlider()
                }
            }
        }

        composable(TutorialRoute.FloatingActionButton.route) {
            TutorialScreen(title = TutorialRoute.FloatingActionButton.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    AllFabTypes()
                }
            }
        }

        composable(TutorialRoute.Chip.route) {
            TutorialScreen(title = TutorialRoute.Chip.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    AllChipTypes()
                }
            }
        }

        composable(TutorialRoute.Badge.route) {
            TutorialScreen(title = TutorialRoute.Badge.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    BadgeWithIcon()
                }
            }
        }

        composable(TutorialRoute.PasswordField.route) {
            TutorialScreen(title = TutorialRoute.PasswordField.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    PasswordText()
                }
            }
        }

        composable(TutorialRoute.GoogleButton.route) {
            TutorialScreen(title = TutorialRoute.GoogleButton.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Column(
                    modifier = modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    GoogleButton()
                }
            }
        }

        composable(TutorialRoute.GradientButton.route) {
            TutorialScreen(title = TutorialRoute.GradientButton.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Column(
                    modifier = modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    GradientButton()
                }
            }
        }

        composable(TutorialRoute.ExpandableCard.route) {
            TutorialScreen(title = TutorialRoute.ExpandableCard.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Column(
                    modifier = modifier.fillMaxSize().padding(16.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    ExpandableCardPreview()
                }
            }
        }

        composable(TutorialRoute.CoilImage.route) {
            TutorialScreen(title = TutorialRoute.CoilImage.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Column(
                    modifier = modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CoilImage()
                }
            }
        }

        composable(TutorialRoute.HorizontalPager.route) {
            TutorialScreen(title = TutorialRoute.HorizontalPager.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    HorizontalPagerScreen()
                }
            }
        }

        composable(TutorialRoute.VerticalPager.route) {
            TutorialScreen(title = TutorialRoute.VerticalPager.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    VerticalPagerScreen()
                }
            }
        }

        // Lists
        composable(TutorialRoute.LazyColumn.route) {
            TutorialScreen(title = TutorialRoute.LazyColumn.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    LazyColumnScreen()
                }
            }
        }

        composable(TutorialRoute.StickyHeader.route) {
            TutorialScreen(title = TutorialRoute.StickyHeader.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    StickyHeader()
                }
            }
        }

        composable(TutorialRoute.LazyRow.route) {
            TutorialScreen(title = TutorialRoute.LazyRow.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Column(
                    modifier = modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {
                    BasicLazyRow()
                }
            }
        }

        composable(TutorialRoute.LazyGrid.route) {
            TutorialScreen(title = TutorialRoute.LazyGrid.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    FixedColumnsGrid()
                }
            }
        }

        // Navigation
        composable(TutorialRoute.BottomNavigation.route) {
            TutorialScreen(title = TutorialRoute.BottomNavigation.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    MainScreen()
                }
            }
        }

        composable(TutorialRoute.NestedNavGraph.route) {
            TutorialScreen(title = TutorialRoute.NestedNavGraph.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    RootNavGraph(navHostController = androidx.navigation.compose.rememberNavController())
                }
            }
        }

        // Components
        composable(TutorialRoute.AlertDialog.route) {
            TutorialScreen(title = TutorialRoute.AlertDialog.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    BasicAlertDialog()
                }
            }
        }

        composable(TutorialRoute.DropdownMenu.route) {
            TutorialScreen(title = TutorialRoute.DropdownMenu.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    ExposedDropdownMenuScreen()
                }
            }
        }

        composable(TutorialRoute.Scaffold.route) {
            TutorialScreen(title = TutorialRoute.Scaffold.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    BasicScaffold()
                }
            }
        }

        composable(TutorialRoute.Snackbar.route) {
            TutorialScreen(title = TutorialRoute.Snackbar.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    BasicSnackbar()
                }
            }
        }

        composable(TutorialRoute.BottomSheet.route) {
            TutorialScreen(title = TutorialRoute.BottomSheet.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    BasicBottomSheet()
                }
            }
        }

        composable(TutorialRoute.TabRow.route) {
            TutorialScreen(title = TutorialRoute.TabRow.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    BasicTabRow()
                }
            }
        }

        composable(TutorialRoute.TopAppBar.route) {
            TutorialScreen(title = TutorialRoute.TopAppBar.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Column(modifier = modifier.fillMaxSize()) {
                    CentralizedToolBar()
                }
            }
        }

        composable(TutorialRoute.Material3TopAppBar.route) {
            TutorialScreen(title = TutorialRoute.Material3TopAppBar.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    Material3TopAppBar()
                }
            }
        }

        composable(TutorialRoute.CollapsingToolbar.route) {
            TutorialScreen(title = TutorialRoute.CollapsingToolbar.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    CollapsingToolbarScreen()
                }
            }
        }

        // Pickers
        composable(TutorialRoute.DatePicker.route) {
            TutorialScreen(title = TutorialRoute.DatePicker.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    DatePickerScreen()
                }
            }
        }

        composable(TutorialRoute.TimePicker.route) {
            TutorialScreen(title = TutorialRoute.TimePicker.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    TimePickerScreen()
                }
            }
        }

        // Effects & Animations
        composable(TutorialRoute.BlurScreen.route) {
            TutorialScreen(title = TutorialRoute.BlurScreen.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    BlurScreen()
                }
            }
        }

        composable(TutorialRoute.LoadingAnimation.route) {
            TutorialScreen(title = TutorialRoute.LoadingAnimation.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Column(
                    modifier = modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    LoadingAnimation()
                }
            }
        }

        composable(TutorialRoute.ShimmerEffect.route) {
            TutorialScreen(title = TutorialRoute.ShimmerEffect.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Column(modifier = modifier.fillMaxSize()) {
                    repeat(7) {
                        AnimatedShimmer()
                    }
                }
            }
        }

        composable(TutorialRoute.ThemeSwitcher.route) {
            TutorialScreen(title = TutorialRoute.ThemeSwitcher.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    ThemeSwitcherScreenPreview()
                }
            }
        }

        // Advanced
        composable(TutorialRoute.BrowseImage.route) {
            TutorialScreen(title = TutorialRoute.BrowseImage.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    BrowseImageScreen()
                }
            }
        }

        composable(TutorialRoute.CircularShapeImage.route) {
            TutorialScreen(title = TutorialRoute.CircularShapeImage.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Column(
                    modifier = modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CircularShapeImage()
                }
            }
        }

        composable(TutorialRoute.CustomCanvas.route) {
            TutorialScreen(title = TutorialRoute.CustomCanvas.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    ShowCustomCanvasComponent()
                }
            }
        }

        composable(TutorialRoute.CircularProgressBar.route) {
            TutorialScreen(title = TutorialRoute.CircularProgressBar.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Column(
                    modifier = modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CustomCircularProgressBar()
                }
            }
        }

        composable(TutorialRoute.HyperLinkText.route) {
            TutorialScreen(title = TutorialRoute.HyperLinkText.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    HyperTextLinkPreview()
                }
            }
        }

        composable(TutorialRoute.SelectableItem.route) {
            TutorialScreen(title = TutorialRoute.SelectableItem.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    PreviewSelectableItem()
                }
            }
        }

        composable(TutorialRoute.MultiPreview.route) {
            TutorialScreen(title = TutorialRoute.MultiPreview.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    MultiPreviewScreen()
                }
            }
        }

        composable(TutorialRoute.WebView.route) {
            TutorialScreen(title = TutorialRoute.WebView.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    WebScreen()
                }
            }
        }

        composable(TutorialRoute.StopWatch.route) {
            TutorialScreen(title = TutorialRoute.StopWatch.title, onBackClick = { navController.popBackStack() }) { modifier ->
                val stopWatchViewModel: StopWatchViewModel = viewModel()
                Box(modifier = modifier.fillMaxSize()) {
                    StopWatchScreen(stopWatchViewModel)
                }
            }
        }

        composable(TutorialRoute.RequestPermission.route) {
            TutorialScreen(title = TutorialRoute.RequestPermission.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    RequestPermission()
                }
            }
        }

        composable(TutorialRoute.SplashScreen.route) {
            TutorialScreen(title = TutorialRoute.SplashScreen.title, onBackClick = { navController.popBackStack() }) { modifier ->
                Box(modifier = modifier.fillMaxSize()) {
                    val splashNavController = androidx.navigation.compose.rememberNavController()
                    SetUpNavGraph(navController = splashNavController)
                }
            }
        }
    }
}
