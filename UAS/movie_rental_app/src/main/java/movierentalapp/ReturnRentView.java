package movierentalapp;

import java.util.Scanner;

public class ReturnRentView {
    private RentUseCase rentUseCase;

    public ReturnRentView(RentUseCase rentUseCase) {
        this.rentUseCase = rentUseCase;
    }

    public void showReturnRentForm() {
        System.out.println("=== Return Rent ===");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Rent ID: ");
        int rentId = scanner.nextInt();

        rentUseCase.returnRent(rentId);
        
    }
}
