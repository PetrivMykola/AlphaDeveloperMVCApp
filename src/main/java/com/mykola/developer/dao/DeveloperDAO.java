package main.java.com.mykola.developer.dao;

import main.java.com.mykola.developer.model.Developer;

import java.util.List;

public interface DeveloperDAO {

    void save(Developer dev);

    Developer getById(int id);

    List<Developer> getAll();

    void delete(int id);

    void update (Developer dev);

}
