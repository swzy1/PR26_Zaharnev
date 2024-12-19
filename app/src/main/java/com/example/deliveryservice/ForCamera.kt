package com.example.deliveryservice

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import androidx.core.content.FileProvider
import java.io.File

fun saveBitmapToCache(context: Context, bitmap: Bitmap): Uri? {
    val file = File(context.cacheDir, "avatar_${System.currentTimeMillis()}.png")
    file.outputStream().use {
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, it)
    }
    return FileProvider.getUriForFile(
        context,
        "${context.packageName}.provider",
        file
    )
}

fun getImageUri(context: Context): Uri? {
    val sharedPreferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    val uriString = sharedPreferences.getString("avatar_image_uri", null)
    return uriString?.let { Uri.parse(it) }
}

fun saveImageUri(context: Context, uri: Uri) {
    val sharedPreferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putString("avatar_image_uri", uri.toString())
    editor.apply()
}