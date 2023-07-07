package movierentalapp;

import java.util.List;

public class UserListView {
    private UserUseCase userUseCase;

    public UserListView(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    public void showUserList() {
        List<User> userList = userUseCase.getUserList();

        System.out.println("=== User List ===");
        for (User user : userList) {
            System.out.println("Username: " + user.getUsername());
            System.out.println("Password: " + user.getPassword());
            System.out.println();
        }
    }
}
