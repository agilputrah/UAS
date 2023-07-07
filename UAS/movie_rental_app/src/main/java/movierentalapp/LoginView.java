package movierentalapp;
import java.util.Scanner;

public class LoginView {
    private LoginUseCase loginUseCase;

    public LoginView(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    public void showLoginScreen(String string) {
        System.out.println(string);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        boolean isValid = loginUseCase.validateUser(username, password);
        if (isValid) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}
