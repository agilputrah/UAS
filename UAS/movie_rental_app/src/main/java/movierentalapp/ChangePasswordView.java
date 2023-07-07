package movierentalapp;

import java.util.Scanner;

public class ChangePasswordView {
    private UserUseCase userUseCase;

    public ChangePasswordView(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    public void showChangePasswordForm() {
        System.out.println("=== Change Password ===");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("New Password: ");
        String newPassword = scanner.nextLine();

        userUseCase.changePassword(username, newPassword);
    }
}
