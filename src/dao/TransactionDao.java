/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import model.Transaction;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.mariadb.jdbc.Connection;
import singleton.Singleton;

/**
 *
 * @author jacobobc
 */
public class TransactionDao {

    private final Connection con;

    public TransactionDao() {
        con = Singleton.getINSTANCE().getConnection();
    }

    public ArrayList<Transaction> listTransactions(String userId) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        String query = "SELECT id, action_type, action_time FROM transactions WHERE user_id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, userId);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String actionType = rs.getString("action_type");
                LocalDateTime actionTime = rs.getTimestamp("action_time").toLocalDateTime();
                
                Transaction transaction = new Transaction(userId, actionType, actionTime, id);
                transactions.add(transaction);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return transactions;
    }
    
    public void insertTransaction(Transaction transaction) {
        String query = "INSERT INTO transactions(user_id, action_type, action_time) VALUES (?, ?, ?)";
        
        try (PreparedStatement ps = con.prepareStatement(query)) {
            
            ps.setString(1, transaction.getUserId());
            ps.setString(2, transaction.getActionType());
            ps.setTimestamp(3, Timestamp.valueOf(transaction.getTime()));
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

}
