package controllers;

import dao.GenreDao;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Genre;
import singleton.dao.SingletonGenreDAO;

/**
 *
 * @author joanp
 */
public class GenreManagementController {
    
    private final GenreDao genreDao;

    public GenreManagementController() {
        this.genreDao = SingletonGenreDAO.getINSTANCE().getGenreDao();
    }
    
    public ArrayList<Genre> listGenres() {
        return genreDao.listGenres();
    }
    
    public Genre searchGenre(String name) {
        return genreDao.searchGenre(name);
    }
    
    public void addGenre(Genre genre) throws SQLException {
        genreDao.addGenre(genre);
    }
    
    public void updateGenre(int id, String name) throws SQLException {
        genreDao.updateGenre(id, name);
    }
    
    public void deleteGenre(int id) {
        genreDao.deleteGenre(id);
    }
    
}
