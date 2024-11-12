package accountLogin;

public class CustomerLogin {
    private String username;
    private String password;

    // Constructor
    public CustomerLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Phương thức đăng nhập
    public boolean login() {
        // Kiểm tra tên người dùng và mật khẩu (có thể thay bằng phương thức kiểm tra thực tế)
        if (username.equals("customer123") && password.equals("******")) {
            return true;
        } else {
            return false;
        }
    }
}
