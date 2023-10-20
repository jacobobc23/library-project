/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import model.Genre;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jacobobc
 */
public class GenreDaoTest {

    public GenreDaoTest() {
    }

    /**
     * Test of selectEntity method, of class GenreDao.
     */
    @Test
    public void testSelectEntity() {
        Object id = 1;
        GenreDao instance = new GenreDao();
        Object expResult = new Genre((int) id, "Misterio");
        Object result = instance.selectEntity(id);
        assertEquals(expResult, result);
    }

    @Test
    public void testSelectNullEntity() {
        Object id = 100;
        GenreDao instance = new GenreDao();
        Object expResult = null;
        Object result = instance.selectEntity(id);
        assertEquals(expResult, result);
    }

}
