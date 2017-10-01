package main.java.com.mykola.developer.Test;

import main.java.com.mykola.developer.DAO.DeveloperDAO;
import main.java.com.mykola.developer.DAO.DeveloperDAOImp;
import main.java.com.mykola.developer.model.Developer;

public class Test {

    public static void main(String[] args) {
        Developer dev = new Developer(1, "Mykola", "Petriv", "jun", 25, 2);
        DeveloperDAO dao = new DeveloperDAOImp();
      // dao.save(dev);
      // dao.getById(2);
       // dao.delete(3);
        //dao.getAll();
       dao.update(dev);
    }
}
