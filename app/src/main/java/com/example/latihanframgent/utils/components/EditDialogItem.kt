package com.example.latihanframgent.utils.components

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.example.latihanframgent.R

class EditDialogItem {
    companion object {
        fun build(context: Context): AlertDialog {
            val inflate = LayoutInflater.from(context).inflate(R.layout.layout_dialog_edit_item, null, true)
            val dialog = AlertDialog.Builder(context).setView(inflate).setCancelable(false).create()
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            return dialog
        }
    }
}

