/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author jacobobc
 */
public class Transaction {
    
    private final String userId;
    private final String actionType;
    private final LocalDateTime time;
    
    private int id;
    
    public Transaction(String userId, String actionType) {
        this.userId = userId;
        this.actionType = actionType;
        time = LocalDateTime.now();
    }

    public Transaction(String userId, String actionType, LocalDateTime time, int id) {
        this.userId = userId;
        this.actionType = actionType;
        this.time = time;
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public String getActionType() {
        return actionType;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public int getId() {
        return id;
    }
        
}
