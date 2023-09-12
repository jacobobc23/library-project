package model;

import enums.Role;
import exceptions.LoanPastDueException;
import java.time.LocalDate;
import java.util.ArrayList;

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

    public void applyLoan(Loan loan) {
        if (hasPastDueLoans()) {
            throw new LoanPastDueException();
        }
        loans.add(loan);
    }

    public boolean hasPastDueLoans() {
        for (Loan loan : loans) {
            if (!loan.isReturned()) {
                if (LocalDate.now().isAfter(loan.getDueDate())) {
                    return true;
                }
            }
        }
        return false;
    }
}
