package parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (this.data.size() < this.capacity) {
            data.add(parrot);
        }
    }

    public boolean remove(String parrot_name) {
        for (Parrot parrot : data) {
            if (parrot.getName().equals(parrot_name)) {
                return data.remove(parrot);
            }
        }
        return false;
    }

    public Parrot sellParrot(String parrotName) {
        Parrot currentParrot = null;
        for (Parrot parrot : data) {
            if (parrot.getName().equals(parrotName)) {
                parrot.setAvailable(false);
                currentParrot = parrot;
            }
        }
        return currentParrot;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> soldSpecies = new ArrayList<>();
            int sizeOfList = data.size();
        for (Parrot parrot : data) {
            String currentSpecies = parrot.getSpecies();
            if (currentSpecies.equals(species)) {
                soldSpecies.add(parrot);
            }
        }
        data.removeAll(soldSpecies);
        return soldSpecies;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Parrots available at %s:%n",name));
        for (Parrot parrot : data) {
            sb.append(parrot.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
