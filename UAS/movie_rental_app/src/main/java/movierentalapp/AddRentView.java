package movierentalapp;

import java.util.Scanner;

public class AddRentView {
    private RentUseCase rentUseCase;

    public AddRentView(RentUseCase rentUseCase) {
        this.rentUseCase = rentUseCase;
    }

    public void showAddRentForm() {
        System.out.println("=== Add Rent ===");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Movie ID: ");
        int movieId = scanner.nextInt();
        scanner.nextLine(); // Membaca karakter baru setelah angka

        System.out.print("Renter: ");
        String renter = scanner.nextLine();

        rentUseCase.addNewRent(movieId, renter);
    }
}
