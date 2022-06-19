package PrepareForExam.P03.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }


    public void add(Person person) {
        if (this.roster.size() < this.capacity) {
            roster.add(person);
        }
    }

    public boolean remove(String name) {
        for (Person person : roster) {
            if (person.getName().equals(name)) {
                roster.remove(person);
                return true;
            }
        }
        return false;
    }

    public Person getPerson(String name, String hometown) {
        Person current = null;
        for (Person person : roster) {
            if (person.getName().equals(name) && person.getHometown().equals(hometown)) {
                current = person;
            }
        }
        return current;
    }

    public int getCount() {
        return roster.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The people in the hotel %s are:%n", this.name));
        for (Person person : roster) {
            sb.append(person.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
