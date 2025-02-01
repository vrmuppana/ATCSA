package ComparableDemo;
import java.io.*;
import java.util.*;
public class Movie2 {

    private double rating;
    private String name;
    private int year;
    public Movie2(String nm, double rt, int yr)
    {
        this.name = nm;
        this.rating = rt;
        this.year = yr;
    }

    public double getRating() {return rating;}
    public String getName() {return name;}
    public int getYear() {return year;}
}

class Main {
    public static void main(String[] args) {
        ArrayList<Movie2> list = new ArrayList<Movie2>();
        list.add(new Movie2("Force Awakens", 8.3, 2015));
        list.add(new Movie2("Star Wars", 8.7, 1977));
        list.add(new Movie2("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie2("Return of the Jedi", 8.4, 1983));

        System.out.println("Movies before sort");
        for (Movie2 movie : list) {
            System.out.println(movie.getName() + ", " + movie.getRating() + ", " + movie.getYear());
        }

        RatingsCompare rc = new RatingsCompare();
        Collections.sort(list, rc);

        System.out.println("\nMovies after sort");
        for (Movie2 movie : list) {
            System.out.println(movie.getName() + ", " + movie.getRating() + ", " + movie.getYear());
        }
    }
}
