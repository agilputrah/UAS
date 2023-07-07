package movierentalapp;

public class Main {
    public static void main(String[] args) {
        // Membuat objek dari setiap use case
        LoginUseCase loginUseCase = new LoginUseCase();
        UserUseCase userUseCase = new UserUseCase();
        MovieUseCase movieUseCase = new MovieUseCase();
        RentUseCase rentUseCase = new RentUseCase();

        // Membuat objek dari setiap view dengan menyediakan use case yang sesuai
        WelcomeView welcomeView = new WelcomeView();
        LoginView loginView = new LoginView(loginUseCase);
        UserListView userListView = new UserListView(userUseCase);
        AddUserView addUserView = new AddUserView(userUseCase);
        ChangePasswordView changePasswordView = new ChangePasswordView(userUseCase);
        MovieListView movieListView = new MovieListView(movieUseCase);
        AddMovieView addMovieView = new AddMovieView(movieUseCase);
        RentListView rentListView = new RentListView(rentUseCase);
        AddRentView addRentView = new AddRentView(rentUseCase);
        ReturnRentView returnRentView = new ReturnRentView(rentUseCase);

        // Menjalankan aplikasi
        welcomeView.showWelcomeMessage();

        while (true) {
            loginView.showLoginForm();

            if (loginUseCase.isAuthenticated()) {
                System.out.println("Login successful.");

                while (true) {
                    System.out.println();
                    System.out.println("=== Menu ===");
                    System.out.println("1. User Management");
                    System.out.println("2. Movie Management");
                    System.out.println("3. Rent Management");
                    System.out.println("0. Logout");

                    Scanner scanner = new Scanner(System.in);
                    int choice = scanner.nextInt();

                    if (choice == 1) {
                        while (true) {
                            System.out.println();
                            System.out.println("=== User Management ===");
                            System.out.println("1. User List");
                            System.out.println("2. Add User");
                            System.out.println("3. Change Password");
                            System.out.println("0. Back");

                            int userChoice = scanner.nextInt();
                            scanner.nextLine(); // Membaca karakter baru setelah angka

                            if (userChoice == 1) {
                                userListView.showUserList();
                            } else if (userChoice == 2) {
                                addUserView.showAddUserForm();
                            } else if (userChoice == 3) {
                                changePasswordView.showChangePasswordForm();
                            } else if (userChoice == 0) {
                                break;
                            }
                        }
                    } else if (choice == 2) {
                        while (true) {
                            System.out.println();
                            System.out.println("=== Movie Management ===");
                            System.out.println("1. Movie List");
                            System.out.println("2. Add Movie");
                            System.out.println("3. Delete Movie");
                            System.out.println("0. Back");

                            int movieChoice = scanner.nextInt();
                            scanner.nextLine(); // Membaca karakter baru setelah angka

                            if (movieChoice == 1) {
                                movieListView.showMovieList();
                            } else if (movieChoice == 2) {
                                addMovieView.showAddMovieForm();
                            } else if (movieChoice == 3) {
                                System.out.print("Movie ID: ");
                                int movieId = scanner.nextInt();
                                movieUseCase.deleteMovie(movieId);
                            } else if (movieChoice == 0) {
                                break;
                            }
                        }
                    } else if (choice == 3) {
                        while (true) {
                            System.out.println();
                            System.out.println("=== Rent Management ===");
                            System.out.println("1. Active Rent List");
                            System.out.println("2. Add Rent");
                            System.out.println("3. Return Rent");
                            System.out.println("0. Back");

                            int rentChoice = scanner.nextInt();
                            scanner.nextLine(); // Membaca karakter baru setelah angka

                            if (rentChoice == 1) {
                                rentListView.showRentList();
                            } else if (rentChoice == 2) {
                                addRentView.showAddRentForm();
                            } else if (rentChoice == 3) {
                                returnRentView.showReturnRentForm();
                            } else if (rentChoice == 0) {
                                break;
                            }
                        }
                    } else if (choice == 0) {
                        loginUseCase.logout();
                        break;
                    }
                }

            } else {
                System.out.println("Login failed. Please try again.");
            }
        }
    }
}
