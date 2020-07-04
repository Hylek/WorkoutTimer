package com.danielcumbor.workouttimer

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class Workout {
    var workoutName: String = ""
    var setAmount: Int = 0
    var setDuration: Int = 0
    var restDuration: Int = 0

    companion object NewWorkout {
        fun create(): Workout = Workout()
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createworkout.setOnClickListener() {
            startActivity(Intent(this, CreateWorkoutActivity::class.java))
        }

        saveNewWorkout(intent)
    }

    fun saveNewWorkout(intent: Intent) {
        val workoutName = intent.getStringExtra("WorkoutName")
        val setAmount = intent.getStringExtra("SetAmount")
        val setDuration = intent.getStringExtra("SetDuration")
        val restDuration = intent.getStringExtra("RestDuration")

        val fileContent = workoutName + setAmount + setDuration + restDuration

        applicationContext.openFileOutput(workoutName, Context.MODE_PRIVATE).use {
            it.write(fileContent.toByteArray())
        }
    }

    fun loadWorkouts() {
        var files: Array<String> = applicationContext.fileList()

        for(fileName in files) {
            applicationContext.openFileInput(fileName)
        }
    }
}