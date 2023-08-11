@file:OptIn(ExperimentalPermissionsApi::class, ExperimentalPermissionsApi::class)

package com.sample.composetutorial.requestpermission

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.accompanist.permissions.shouldShowRationale

@Composable
fun RequestMultiplePermissions(
    permissions: List<String>,
    deniedMessage: String = "Give this app a permission to proceed. If it doesn't work, then you'll have to do it manually from the settings.",
    rationalMessage: String = "To use this app's functionalities, you need to give us the permission."
) {
    val multiplePermissionsSate = rememberMultiplePermissionsState(permissions = permissions)

    HandleRequest(multiplePermissionsState = multiplePermissionsSate,
        deniedContent = { shouldShowRationale ->
            PermissionDeniedContent(
                deniedMessage = deniedMessage,
                rationaleMessage = rationalMessage,
                shouldShowRationale = shouldShowRationale,
                onRequestPermission = { multiplePermissionsSate.launchMultiplePermissionRequest() }
            )
        },
        content = {
            Content(
                text = "PERMISSION GRANTED!",
                showButton = false
            ) {}
        }
    )
}

@Composable
fun HandleRequest(
    multiplePermissionsState: MultiplePermissionsState,
    deniedContent: @Composable (Boolean) -> Unit,
    content: @Composable () -> Unit
) {
    var shouldShowRationale by remember {
        mutableStateOf(false)
    }
    val result = multiplePermissionsState.permissions.all {
        shouldShowRationale = it.status.shouldShowRationale
        it.status.isGranted
    }

    if (result) {
        content()
    } else {
        deniedContent(shouldShowRationale)
    }
}