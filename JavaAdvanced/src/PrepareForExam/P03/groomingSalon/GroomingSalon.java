package PrepareForExam.P03.groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (data.size() < capacity) {
            data.add(pet);
        }
    }


    public boolean remove(String name) {
        for (Pet pet : data) {
            if (pet.getName().equals(name)) {
                return data.remove(pet);
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        Pet isFound = null;
        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                isFound = pet;
            }
        }
        return isFound;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The grooming salon has the following clients:").append(System.lineSeparator());
        for (Pet pet : data) {
            sb.append(String.format("%s %s", pet.getName(), pet.getOwner())).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
