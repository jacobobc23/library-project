/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.ArrayList;

/**
 *
 * @author jacobobc
 */
public interface DaoInterface {
    
    ArrayList<Object> listEntity();
    Object selectEntity(Object obj);
    void insertEntity(Object obj);
    void updateEntity(Object obj);
    void deleteEntity(Object obj);
    
}
