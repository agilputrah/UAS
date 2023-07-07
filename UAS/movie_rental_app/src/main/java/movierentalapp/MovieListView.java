package movierentalapp;

import java.util.List;

public class MovieListView {
    private MovieUseCase movieUseCase;

    public MovieListView(MovieUseCase movieUseCase) {
        this.movieUseCase = movieUseCase;
    }

    public void showMovieList() {
        List<Movie> movieList = movieUseCase.getMovieList();

        System.out.println("=== Movie List ===");
        for (Movie movie : movieList) {
            System.out.println("ID: " + movie.getId());
            System.out.println("Title: " + movie.getTitle());
            System.out.println("Genre: " + movie.getGenre());
            System.out.println();
        }
    }
}
