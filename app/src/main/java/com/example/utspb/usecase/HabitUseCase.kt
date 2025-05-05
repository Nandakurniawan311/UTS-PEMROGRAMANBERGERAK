package com.example.utspb.usecase

import com.example.utspb.data.HabitRepository
import com.example.utspb.model.Habit

class AddHabitUseCase(private val repository: HabitRepository) {
    operator fun invoke(habit: Habit) = repository.addHabit(habit)
}

class GetHabitsUseCase(private val repository: HabitRepository) {
    operator fun invoke(): List<Habit> = repository.getHabits()
}
