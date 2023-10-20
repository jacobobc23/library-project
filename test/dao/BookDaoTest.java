/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import model.Book;
import model.Genre;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jacobobc
 */
public class BookDaoTest {

    public BookDaoTest() {
    }

    /**
     * Test of selectEntity method, of class BookDao.
     */
//    @Test
//    public void testSelectEntity() {
//        Object isbn = "621-9-87-654321-0";
//        BookDao instance = new BookDao();
//        Genre genre = new Genre(2, "Fantasía");
//        Object expResult = new Book((String) isbn, "El secreto de las Estrellas", "Diego Sanchez", genre, 2021, 22);
//        Object result = instance.selectEntity(isbn);
//        assertEquals(expResult, result);
//    }

    @Test
    public void testSelectNullEntity() {
        Object isbn = "invalid_isbn";
        BookDao instance = new BookDao();
        Object expResult = null;
        Object result = instance.selectEntity(isbn);
        assertEquals(expResult, result);
    }
}
