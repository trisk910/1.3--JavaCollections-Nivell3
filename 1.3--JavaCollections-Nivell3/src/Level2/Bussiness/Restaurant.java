package Level2.Bussiness;

import java.util.Objects;

public class Restaurant implements Comparable<Restaurant> {
    private String name;
    private int score;


    public Restaurant(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Restaurant)) return false;
        Restaurant that = (Restaurant) obj;
        return score == that.score && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }

    @Override
    public String toString() {
        return name + " " + score;
    }

    @Override
    public int compareTo(Restaurant o) {
        return this.name.compareTo(o.name) != 0 ? this.name.compareTo(o.name) : Integer.compare(o.score, this.score);
    }
}
