/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import model.User;

/**
 *
 * @author jacobobc
 */
public interface LogInDaoInterface {
    
    User selectUser(String username, String password);
    
}
