package movierentalapp;

import java.util.Scanner;

public class AddMovieView {
    private MovieUseCase movieUseCase;

    public AddMovieView(MovieUseCase movieUseCase) {
        this.movieUseCase = movieUseCase;
    }

    public void showAddMovieForm() {
        System.out.println("=== Add Movie ===");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Genre: ");
        String genre = scanner.nextLine();

        movieUseCase.addMovie(title, genre);
    }
}
