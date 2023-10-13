package controllers;

import dao.GenreDao;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Genre;

/**
 *
 * @author joanp
 */
public class GenreManagementController {
    
    private final GenreDao genreDao;

    public GenreManagementController() {
        genreDao = new GenreDao();
    }
    
    public ArrayList<Object> listAllGenres() {
        return genreDao.listEntity();
    }
    
    public Genre selectGenre(int id) {
        return (Genre) genreDao.selectEntity(id);
    }
    
    public void insertGenre(Genre genre) throws SQLException {
        genreDao.insertEntity(genre);
    }
    
    public void updateGenre(Genre genre) throws SQLException {
        genreDao.updateEntity(genre);
    }
    
    public void deleteGenre(int id) {
        genreDao.deleteEntity(id);
    }
    
}
