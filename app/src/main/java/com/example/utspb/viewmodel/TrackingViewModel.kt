package com.example.utspb.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.utspb.data.HabitRepositoryImpl
import com.example.utspb.model.Habit
import com.example.utspb.usecase.AddHabitUseCase
import com.example.utspb.usecase.GetHabitsUseCase
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class TrackingViewModel : ViewModel() {
    private val repository = HabitRepositoryImpl()
    private val addHabitUseCase = AddHabitUseCase(repository)
    private val getHabitsUseCase = GetHabitsUseCase(repository)

    private val _habits = mutableStateListOf<Habit>()
    val habits: List<Habit> get() = _habits

    init {
        loadHabits()
    }

    fun addHabit(name: String) {
        if (name.isNotBlank()) {
            addHabitUseCase(Habit(name))
            loadHabits()
        }
    }

    private fun loadHabits() {
        _habits.clear()
        _habits.addAll(getHabitsUseCase())
    }

    fun toggleHabitCheck(habit: Habit, date: String) {
        val idx = _habits.indexOf(habit)
        if (idx != -1) {
            val updated = _habits[idx].copy(
                dailyCheck = _habits[idx].dailyCheck.toMutableMap().apply {
                    this[date] = !(this[date] ?: false)
                }
            )
            _habits[idx] = updated
            repository.updateHabit(updated)
        }
    }
}
