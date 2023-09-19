package model;

/**
 *
 * @author Jacobo-bc
 */
public class Genre {
    
    private int id;
    private final String name;

    public Genre(String name) {
        this.name = name;
    }

    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
}
