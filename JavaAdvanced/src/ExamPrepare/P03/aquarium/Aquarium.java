package ExamPrepare.P03.aquarium;


import java.util.ArrayList;
import java.util.Collection;


public class Aquarium {
    private String name;
    private int capacity;
    private int size;
    private Collection<Fish> fishInPool;

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

    public void add(Fish fish) {
        boolean isHaveSameFish = false;
        for (Fish fishInList : fishInPool) {
            if (fishInList.equals(fish.getName())) {
                isHaveSameFish = true;
            }
        }
        if (this.fishInPool.size() < getCapacity() && !isHaveSameFish) {
            fishInPool.add(fish);
        }
    }


    public boolean remove(String name) {
        Fish removedFish = null;
        for (Fish fish : fishInPool) {
            if (fish.getName().equals(name)) {
                removedFish = fish;
            }
        }
        if (removedFish == null) {
            return false;
        } else {
            fishInPool.remove(removedFish);
            return true;
        }
    }

    public Fish findFish(String name) {
        for (Fish fish : fishInPool) {
            if (fish.getName().equals(name)) {
                return fish;
            }
        }
        return null;
    }

    public String report() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Aquarium: %s ^ Size: %d", this.name, this.size)).append("\n");
        for (Fish fish : fishInPool) {
            sb.append(fish.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
