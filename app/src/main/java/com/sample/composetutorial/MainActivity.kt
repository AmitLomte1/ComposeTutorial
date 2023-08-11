package com.sample.composetutorial

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sample.composetutorial.ui.basicuielements.VerticalPagerScreen
import com.sample.composetutorial.ui.theme.ComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
            ComposeTutorialTheme {
                VerticalPagerScreen()
//                HorizontalPagerScreen()
//                TimePickerScreen()
//                DatePickerScreen()
//                BlurScreen()
                // A surface container using the 'background' color from the theme
//                CentralizedToolBar()
//                Material3TopAppBar()
//                CollapsingToolbarScreen()
//                Column(
//                    modifier = Modifier.fillMaxSize(),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center
//                ) {
//                    BrowseImageScreen()
//                    val mainViewModel: StopWatchViewModel by viewModels()
//                    StopWatchScreen(mainViewModel)
//                    WebScreen()
//                    RootNavGraph(navHostController = rememberNavController())
//                    HyperTextLinkPreview()
//                    PreviewSelectableItem()
//                    val navController = rememberNavController()
//                    CentralizedToolBar()
//                    HyperTextLinkPreview()
//                    RequestPermission()
//                    SetUpNavGraph(navHostController = navController)
//                    LoadingAnimation()
//                    val navController = rememberNavController()
//                    SetUpNavGraph(navController = navController)
//                    CircularShapeImage()
//                    val mainViewModel: SearchViewModel by viewModels()
//                    SearchScreen(mainViewModel)
//                    val context = LocalContext.current
//                    context.startActivity(Intent(context, NavigationActivity::class.java))
//                }
            }
        }
    }
}
