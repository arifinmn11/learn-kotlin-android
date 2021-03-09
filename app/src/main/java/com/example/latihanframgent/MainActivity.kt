package com.example.latihanframgent

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.example.latihanframgent.databinding.ActivityMainBinding
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    val CAMERA_CODE = 100
    val READ_STORAGE_CODE = 101
    val WRITE_STORAGE_CODE = 102

    private lateinit var binding: ActivityMainBinding
    lateinit var photoPath: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkForPermission(android.Manifest.permission.CAMERA, "camera", CAMERA_CODE)
        checkForPermission(
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            "write_storage",
            WRITE_STORAGE_CODE
        )
        checkForPermission(
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            "read_storage",
            READ_STORAGE_CODE
        )

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            takePictureButton.setOnClickListener {
                takePictureIntent()
            }
        }
    }

    private fun takePictureIntent() {
        val takePicture = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        takePicture.resolveActivity(packageManager)?.also {
            val photoFile: File? = try {
                createImageFile()
            } catch (e: IOException) {
                null
            }
            photoFile?.also {
                val photoURI: Uri = FileProvider.getUriForFile(
                    this, "${BuildConfig.APPLICATION_ID}.fileprovider", it
                )
                takePicture.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                startActivityForResult(takePicture, CAMERA_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        var imageBitmap: Bitmap?
        if (requestCode == CAMERA_CODE && resultCode == RESULT_OK) {
            imageBitmap = BitmapFactory.decodeFile(photoPath)
            binding.photoImageView.setImageBitmap(imageBitmap)
        }
    }

    private fun createImageFile(): File {
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageDir = filesDir
        val storageDir = File(imageDir, "photo-$timeStamp.jpg")
        return storageDir.apply {
            photoPath = absolutePath
        }
    }

    private fun checkForPermission(permission: String, name: String, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            when {
                ContextCompat.checkSelfPermission(
                    applicationContext,
                    permission
                ) == PackageManager.PERMISSION_GRANTED -> {
                    Toast.makeText(
                        applicationContext,
                        "$name permission granted",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                shouldShowRequestPermissionRationale(permission) -> showDialog(
                    permission,
                    name,
                    requestCode
                )

                else -> ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)
            }

        }
    }

    private fun showDialog(permission: String, name: String, requestCode: Int) {
        val builder = AlertDialog.Builder(this)
        builder.apply {
            setMessage("Permission to your $name is required to use this app")
            setMessage("Permission requires")
            setPositiveButton("OK") { dialog, which ->
                ActivityCompat.requestPermissions(
                    this@MainActivity,
                    arrayOf(permission),
                    requestCode
                )
            }
            val dialog = builder.create()
            dialog.show()
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        fun innerCheck(name: String) {
            if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(
                    applicationContext, "$name permission refused",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } else {
                Toast.makeText(
                    applicationContext, "$name permission granted",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }

        when (requestCode) {
            CAMERA_CODE -> innerCheck("camera")
            READ_STORAGE_CODE -> innerCheck("read_storage")
            WRITE_STORAGE_CODE -> innerCheck("write_storage")
        }
    }
}
