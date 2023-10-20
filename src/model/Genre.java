package model;

import java.util.Objects;

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
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        Genre genre = (Genre) obj;
        
        return Objects.equals(name, genre.getName())
                && Objects.equals(id, genre.getId());
    }
    
}
