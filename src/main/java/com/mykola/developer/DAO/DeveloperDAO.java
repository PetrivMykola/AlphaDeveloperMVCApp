package main.java.com.mykola.developer.DAO;

import main.java.com.mykola.developer.model.Developer;

public interface DeveloperDAO {

    void save(Developer dev);

    String getById(int id);

    void getAll();

    void delete(int id);

    void update (Developer dev);

}
