package com.example.utspb.data

import com.example.utspb.model.Habit

interface HabitRepository {
    fun addHabit(habit: Habit)
    fun getHabits(): List<Habit>
    fun updateHabit(habit: Habit)
}

class HabitRepositoryImpl : HabitRepository {
    private val habits = mutableListOf<Habit>()
    override fun addHabit(habit: Habit) {
        habits.add(habit)
    }
    override fun getHabits(): List<Habit> = habits
    override fun updateHabit(habit: Habit) {
        val idx = habits.indexOfFirst { it.name == habit.name }
        if (idx != -1) {
            habits[idx] = habit
        }
    }
}
