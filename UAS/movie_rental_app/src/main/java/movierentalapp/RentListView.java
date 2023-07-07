package movierentalapp;

import java.util.List;

public class RentListView {
    private RentUseCase rentUseCase;

    public RentListView(RentUseCase rentUseCase) {
        this.rentUseCase = rentUseCase;
    }

    public void showRentList() {
        List<Rent> rentList = rentUseCase.getActiveRentList();

        System.out.println("=== Active Rent List ===");
        for (Rent rent : rentList) {
            System.out.println("ID: " + rent.getId());
            System.out.println("Rent Date: " + rent.getRentDate());
            System.out.println("Return Date: " + rent.getReturnDate());
            System.out.println("Movie ID: " + rent.getMovieId());
            System.out.println("Renter: " + rent.getRenter());
            System.out.println();
        }
    }
}
