package com.danielcumbor.workouttimer

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.create_workout.*

class CreateWorkoutActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_workout);

        submitNewWorkout.setOnClickListener() {
            startActivity(processNewWorkout())
        }
    }

    // Takes data in from the input fields and returns a new workout
    private fun processNewWorkout(): Intent {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("WorkoutName", convertDataToString(workoutName.text))
        intent.putExtra("SetAmount", convertDataToString(amountOfSets.text))
        intent.putExtra("SetDuration", convertDataToString(setDuration.text))
        intent.putExtra("RestDuration", convertDataToString(restDuration.text))

        return intent
    }

    private fun convertDataToString(data: Editable): String {
        return data.toString()
    }

//    private fun convertDataToInt(data: Editable): Int {
//        return if (data.toString().toIntOrNull() !== null) data.toString().toInt() else -1
//    }
}