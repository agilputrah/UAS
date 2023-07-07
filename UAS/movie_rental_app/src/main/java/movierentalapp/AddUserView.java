package movierentalapp;

import java.util.Scanner;

public class AddUserView {
    private UserUseCase userUseCase;

    public AddUserView(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    public void showAddUserForm() {
        System.out.println("=== Add User ===");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        userUseCase.addUser(username, password);
    }
}
