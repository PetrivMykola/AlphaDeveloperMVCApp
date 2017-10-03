package main.java.com.mykola.developer.test;

import main.java.com.mykola.developer.dao.DeveloperDAOImp;
import main.java.com.mykola.developer.model.Developer;

public class Test {

    public static void main(String[] args) {
        Developer dev = new Developer(1, "Mykola", "Petriv", "jun", 25, 2);
        Developer dev2 = new Developer(1, "Myk", "Petr", "jun", 25, 2);

        DeveloperDAOImp dao = new DeveloperDAOImp();
       //dao.save(dev);
      // dao.getById(2);
       // dao.delete(1);
       // System.out.println(dao.getAll().toString());
      dao.update(dev2);
       // Developer dev2 = dao.createDevFromStr(dao.getById(1));
        //System.out.println(dev2.toString());
    }
}
