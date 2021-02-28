package com.example.latihanframgent.utils.components

import androidx.appcompat.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import com.example.latihanframgent.R

class LoadingDialog {
    companion object {
        fun build(context: Context): AlertDialog {
            val inflate = LayoutInflater.from(context).inflate(R.layout.layout_dialog, null, true)
            val dialog = AlertDialog.Builder(context).setView(inflate).setCancelable(true).create()
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            return dialog
        }
    }
}