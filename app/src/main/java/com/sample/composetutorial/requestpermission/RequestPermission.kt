package com.sample.composetutorial.requestpermission

import android.Manifest
import androidx.compose.runtime.Composable

@Composable
fun RequestPermission() {
    RequestMultiplePermissions(
        permissions = listOf(
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.CAMERA
        )
    )
}