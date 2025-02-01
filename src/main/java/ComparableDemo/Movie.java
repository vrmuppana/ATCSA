package ComparableDemo;
import java.io.*;
import java.util.*;
public class Movie implements Comparable<Movie> {

    private double rating;
    private String name;
    private int year;

    @Override
    public int compareTo(Movie m) {
        System.out.println(this.year + " - " + m.year);
        return this.year-m.year;
    }

    public Movie(String nm, double rt, int yr)
    {
        this.name = nm;
        this.rating = rt;
        this.year = yr;
    }

    public double getRating() {return rating;}
    public String getName() {return name;}
    public int getYear() {return year;}
}

//class Main {
//    public static void main(String[] args) {
//        ArrayList<Movie> list = new ArrayList<Movie>();
//        list.add(new Movie("Force Awakens", 8.3, 2015));
//        list.add(new Movie("Star Wars", 8.7, 1977));
//        list.add(new Movie("Empire Strikes Back", 8.8, 1990));
//        list.add(new Movie("Return of the Jedi", 8.4, 1983));
//
//        System.out.println("Movies before sort");
//        for (Movie movie : list) {
//            System.out.println(movie.getName() + ", " + movie.getRating() + ", " + movie.getYear());
//        }
//
//        Collections.sort(list);
//
//        System.out.println("\nMovies after sort");
//        for (Movie movie : list) {
//            System.out.println(movie.getName() + ", " + movie.getRating() + ", " + movie.getYear());
//        }
//    }
//}
