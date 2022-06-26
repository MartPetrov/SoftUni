package workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private List<Exercise> exercises;
    private String type;
    private int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (this.exercises.size() < exerciseCount) {
            exercises.add(exercise);
        }
    }


    public boolean removeExercise(String name, String muscle) {
        for (Exercise exercise : exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                return exercises.remove(exercise);
            }
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle) {
        Exercise findEx = null;
        for (Exercise exercise : exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                findEx = exercise;
            }
        }
        return findEx;
    }

    public Exercise getMostBurnedCaloriesExercise() {
        int mostBurnCal = 0;
        Exercise mostBurnEx = null;
        for (Exercise exercise : exercises) {
            if (exercise.getBurnedCalories() > mostBurnCal) {
                mostBurnCal = exercise.getBurnedCalories();
                mostBurnEx = exercise;
            }
        }
        return mostBurnEx;
    }

    public int getExerciseCount() {
        return this.exercises.size();
    }

    public String getStatistics() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Workout type: %s%n",this.type));
        for (Exercise exercise : exercises) {
            sb.append((exercise.toString())).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
