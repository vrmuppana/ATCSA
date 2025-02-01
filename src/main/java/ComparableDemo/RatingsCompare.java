package ComparableDemo;
import java.util.Comparator;

public class RatingsCompare implements Comparator<Movie2>{

    @Override
    public int compare(Movie2 o1, Movie2 o2) {
        if (o1.getRating() < o2.getRating())
            return -1;
        if (o1.getRating() > o2.getRating())
            return 1;
        else
            return 0;
    }
}
