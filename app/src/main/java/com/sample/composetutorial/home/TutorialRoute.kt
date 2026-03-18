package com.sample.composetutorial.home

sealed class TutorialRoute(val route: String, val title: String) {
    object Home : TutorialRoute("home", "Compose Tutorial")

    // Basic UI Elements
    object Text : TutorialRoute("text", "Text")
    object TextField : TutorialRoute("textfield", "TextField")
    object Button : TutorialRoute("button", "Button")
    object Image : TutorialRoute("image", "Image")
    object Card : TutorialRoute("card", "Card")
    object Row : TutorialRoute("row", "Row")
    object Box : TutorialRoute("box", "Box")
    object Checkbox : TutorialRoute("checkbox", "Checkbox")
    object RadioButton : TutorialRoute("radiobutton", "RadioButton")
    object Switch : TutorialRoute("switch", "Switch")
    object Slider : TutorialRoute("slider", "Slider")
    object FloatingActionButton : TutorialRoute("fab", "FloatingActionButton")
    object Chip : TutorialRoute("chip", "Chip")
    object Badge : TutorialRoute("badge", "Badge")
    object PasswordField : TutorialRoute("passwordfield", "Password Field")
    object GoogleButton : TutorialRoute("googlebutton", "Google Button")
    object GradientButton : TutorialRoute("gradientbutton", "Gradient Button")
    object ExpandableCard : TutorialRoute("expandablecard", "Expandable Card")
    object CoilImage : TutorialRoute("coilimage", "Coil Image")
    object HorizontalPager : TutorialRoute("horizontalpager", "Horizontal Pager")
    object VerticalPager : TutorialRoute("verticalpager", "Vertical Pager")

    // Lists
    object LazyColumn : TutorialRoute("lazycolumn", "LazyColumn")
    object StickyHeader : TutorialRoute("stickyheader", "Sticky Header")
    object LazyRow : TutorialRoute("lazyrow", "LazyRow")
    object LazyGrid : TutorialRoute("lazygrid", "LazyGrid")

    // Navigation
    object BottomNavigation : TutorialRoute("bottomnavigation", "Bottom Navigation")
    object NestedNavGraph : TutorialRoute("nestednavgraph", "Nested Nav Graph")

    // Components
    object AlertDialog : TutorialRoute("alertdialog", "AlertDialog")
    object DropdownMenu : TutorialRoute("dropdownmenu", "Dropdown Menu")
    object Scaffold : TutorialRoute("scaffold", "Scaffold")
    object Snackbar : TutorialRoute("snackbar", "Snackbar")
    object BottomSheet : TutorialRoute("bottomsheet", "Bottom Sheet")
    object TabRow : TutorialRoute("tabrow", "TabRow")
    object TopAppBar : TutorialRoute("topappbar", "TopAppBar")
    object Material3TopAppBar : TutorialRoute("material3topappbar", "Material3 TopAppBar")
    object CollapsingToolbar : TutorialRoute("collapsingtoolbar", "Collapsing Toolbar")

    // Pickers
    object DatePicker : TutorialRoute("datepicker", "Date Picker")
    object TimePicker : TutorialRoute("timepicker", "Time Picker")

    // Effects & Animations
    object BlurScreen : TutorialRoute("blurscreen", "Blur Effect")
    object LoadingAnimation : TutorialRoute("loadinganimation", "Loading Animation")
    object ShimmerEffect : TutorialRoute("shimmereffect", "Shimmer Effect")
    object ThemeSwitcher : TutorialRoute("themeswitcher", "Theme Switcher")

    // Advanced
    object BrowseImage : TutorialRoute("browseimage", "Browse Image")
    object CircularShapeImage : TutorialRoute("circularshapeimage", "Circular Shape Image")
    object CustomCanvas : TutorialRoute("customcanvas", "Custom Canvas")
    object CircularProgressBar : TutorialRoute("circularprogressbar", "Circular Progress Bar")
    object HyperLinkText : TutorialRoute("hyperlinktext", "HyperLink Text")
    object SelectableItem : TutorialRoute("selectableitem", "Selectable Item")
    object MultiPreview : TutorialRoute("multipreview", "Multi Preview")
    object WebView : TutorialRoute("webview", "WebView")
    object StopWatch : TutorialRoute("stopwatch", "StopWatch")
    object RequestPermission : TutorialRoute("requestpermission", "Request Permission")
    object SplashScreen : TutorialRoute("splashscreen", "Splash Screen")
}
