package model;

import enums.Role;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Jacobo-bc
 */
public class User {

    private final String id;
    private final String fullName;
    private final Role role;
    private final ArrayList<Loan> loans;

    private String mobileNumber;
    private String username;
    private String password;

    public User(String id, String fullName, Role role, String mobileNumber, String username, String password) {
        this.id = id;
        this.fullName = fullName;
        this.role = role;
        this.mobileNumber = mobileNumber;
        this.username = username;
        this.password = password;
        loans = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public Role getRole() {
        return role;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        User user = (User) obj;

        return Objects.equals(id, user.id)
                && Objects.equals(fullName, user.fullName)
                && role == user.role
                && Objects.equals(mobileNumber, user.mobileNumber)
                && Objects.equals(username, user.username)
                && Objects.equals(password, user.password);
    }

}
