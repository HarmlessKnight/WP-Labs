package mk.finki.ukim.mk.lab.Repository;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Movie;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class MovieRepository {
    public static List<Movie> TempDatabase = new ArrayList<>();

    @PostConstruct
    public void init ()
    {
        TempDatabase.add(new Movie("Inception", "Dream theft with mind-bending twists.", 8.8));
        TempDatabase.add(new Movie("Shawshank Redemption", "Friendship and hope in prison.", 9.3));
        TempDatabase.add(new Movie("The Dark Knight", "Gotham's chaos with the Joker.", 9.0));
        TempDatabase.add(new Movie("Pulp Fiction", "Interwoven crime stories.", 8.9));
        TempDatabase.add(new Movie("Forrest Gump", "Life journey of an extraordinary man.", 8.8));
        TempDatabase.add(new Movie("The Matrix", "Revealing reality's truth.", 8.7));
        TempDatabase.add(new Movie("Interstellar", "Space travel for humanity's survival.", 8.6));
        TempDatabase.add(new Movie("Fight Club", "An underground fight club.", 8.8));
        TempDatabase.add(new Movie("LOTR: Return of the King", "Epic battle for Middle Earth.", 8.9));
        TempDatabase.add(new Movie("The Godfather", "Mafia's legacy and power struggle.", 9.2));
    }

    public List<Movie> findAll()
    {
        return TempDatabase;
    }

    public List<Movie> searchMovies(String text)
    {
       return TempDatabase.stream().filter(movie -> movie.getTitle().contains(text.toLowerCase())|| movie.getSummary().contains(text.toLowerCase())).toList();
    }
}
