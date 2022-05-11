package aquarium;

import java.util.ArrayList;
import java.util.List;


public class Aquarium {
    private String name;
    private int capacity;
    private int size;
    private List<aquarium.Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public void add(aquarium.Fish fish) {
        boolean haveSameFish = false;
        for (aquarium.Fish f : fishInPool)
            if (f.getName().equals(fish)) {
                haveSameFish = true;
            }
        if (!haveSameFish && capacity > getFishInPool()) {
            this.fishInPool.add(fish);
        }
    }

    public boolean remove(String name) {
        aquarium.Fish removedFish = null;
        for (aquarium.Fish fish: fishInPool) {
            if (fish.getName().equals(name)) {
                removedFish = fish;
            }
        }
        if (removedFish==null) {
            return false;
        } else {
            fishInPool.remove(removedFish);
            return true;
        }
    }

    public aquarium.Fish findFish (String name) {
        for (aquarium.Fish fish: fishInPool) {
            if (fish.getName().equals(name)) {
                return fish;
            }
        }
        return null;
    }

    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Aquarium: %s ^ Size: %d", name, size)).append("\n");
        for (aquarium.Fish fish: fishInPool) {
            builder.append(fish.toString()).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
