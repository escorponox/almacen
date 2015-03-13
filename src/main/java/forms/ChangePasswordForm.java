package forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ChangePasswordForm {

    @NotNull(message = "User not Found")
    private Long userId;

    private String username;

    @NotNull(message = "Password is empty")
    @Size(min = 3, message = "Password must be at least 3 character long")
    private String newPassword;

    @NotNull(message = "Please repeat password")
    @Size(min = 3, message = "Password must be at least 3 character long")
    private String repeatPassword;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
