package com.example.latihanframgent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    var maxProgress = 0
    var statusThread = false
    var progres: Int = 1
    var timeCalculation = 0
    val delayTime: Int = 200
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Main", "Running on thread ${Thread.currentThread().name}")
    }

    fun stopProgress(v: View?) {
        if (v == stop_button) {
            statusThread = false
        }
    }

    fun checkNumber(v: View?) {
        if (v == check_button) {
            statusThread = true
            maxProgress = input_text.text.toString().toInt()
            progress_bar.max = maxProgress
            runThread(v)
        }
    }

    fun startProgress(v: View?) {
        if (v == start_button) {
            statusThread = true
            maxProgress = input_text.text.toString().toInt()
            progress_bar.max = maxProgress
            runThread(v)
        }
    }

    fun resetProgress() {
        progres = 1
        start_button.isEnabled = true
        timeCalculation = 0
    }

    fun runProgress(number: Int, status: Boolean) {
        start_button.isEnabled = status
        progress_bar.progress = number
    }

    fun runThread(v: View?) {
        thread(statusThread) {
            for (i in progres..maxProgress) {
                Thread.sleep(delayTime.toLong())
                runOnUiThread {
                    progres = i
                    timeCalculation += delayTime
                    time_text.text = "Time : $timeCalculation"

                    stopProgress(v)

                    if (!statusThread) {
                        start_button.isEnabled = true
                        return@runOnUiThread
                    }
                    output_text.text = "$progres ${checkTypeNumber(progres)}"
                    runProgress(i, false)
                }

                if (!statusThread) {
                    return@thread
                }
            }
            runOnUiThread {
                resetProgress()
            }
        }
    }

    fun checkTypeNumber(num: Int): String {
        return if (num % 2 == 0) {
            "Ganjil"
        } else {
            "Genap"
        }
    }
}
