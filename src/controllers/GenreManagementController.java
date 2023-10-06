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
    
    public ArrayList<Genre> listAllGenres() {
        return genreDao.listAllGenres();
    }
    
    public Genre selectGenre(int id) {
        return genreDao.selectGenre(id);
    }
    
    public void insertGenre(Genre genre) throws SQLException {
        genreDao.insertGenre(genre);
    }
    
    public void updateGenre(int id, String name) throws SQLException {
        genreDao.updateGenre(id, name);
    }
    
    public void deleteGenre(int id) {
        genreDao.deleteGenre(id);
    }
    
}
