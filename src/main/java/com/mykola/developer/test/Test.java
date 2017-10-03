package main.java.com.mykola.developer.test;

import main.java.com.mykola.developer.dao.DeveloperDAOImp;
import main.java.com.mykola.developer.model.Developer;
import main.java.com.mykola.developer.view.DeveloperView;

public class Test {

    public static void main(String[] args) {
        //Developer dev = new Developer(1, "Mykola", "Petriv", "jun", 25, 2);
        //Developer dev2 = new Developer(1, "Myk", "Petr", "jun", 25, 2);

       // DeveloperDAOImp dao = new DeveloperDAOImp();
       //dao.saveDeveloper(dev);
      // dao.getById(2);
       // dao.delete(1);
       // System.out.println(dao.getAll().toString());
     // dao.updateDeveloper(dev2);
       // Developer dev2 = dao.createDevFromStr(dao.getById(1));
        //System.out.println(dev2.toString());

        DeveloperView view = new DeveloperView();
        view.menu();
    }
}
