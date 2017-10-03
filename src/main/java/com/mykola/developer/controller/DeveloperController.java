package main.java.com.mykola.developer.controller;
import main.java.com.mykola.developer.dao.DeveloperDAO;
import main.java.com.mykola.developer.dao.DeveloperDAOImp;
import main.java.com.mykola.developer.model.Developer;
import java.util.Scanner;

public class DeveloperController {

    Scanner in = new Scanner(System.in);
    Developer dev;
    DeveloperDAO dao;

    public DeveloperController() {
         dao = new DeveloperDAOImp();
    }

    public Developer createNewDeveloper() {
        dev = new Developer();
        System.out.println("Enter id:");
        dev.setId(in.nextInt());
        System.out.println("Enter name:");
        dev.setName(in.next());
        System.out.println("Enter lastName:");
        dev.setLastName(in.next());
        System.out.println("Enter position");
        dev.setPosition(in.next());
        System.out.println("Enter Salary:");
        dev.setSalary(in.nextInt());
        System.out.println("Enter Experience:");
        dev.setExperience(in.nextInt());

        return dev = new Developer(dev.getId(), dev.getName(), dev.getLastName(), dev.getPosition(), dev.getSalary(), dev.getExperience());
    }

    public Developer enterFieldsForDeveloper(Developer dev) {
        System.out.println("Enter name:");
        dev.setName(in.next());
        System.out.println("Enter lastName:");
        dev.setLastName(in.next());
        System.out.println("Enter position");
        dev.setPosition(in.next());
        System.out.println("Enter Salary:");
        dev.setSalary(in.nextInt());
        System.out.println("Enter Experience:");
        dev.setExperience(in.nextInt());
        return dev  = new Developer(dev.getId(), dev.getName(), dev.getLastName(), dev.getPosition(), dev.getSalary(), dev.getExperience());
    }

    public void saveDeveloper() {
        dao.save(createNewDeveloper());
        System.out.println("Create and save Developer was successful");
        System.out.println("##############################");
    }
    public void showListDevelopers() {
        System.out.println(dao.getAll());
        System.out.println("##############################");
    }

    public void updateDeveloper() {
        System.out.println("Enter id developer for update: ");
        int id = in.nextInt();
        System.out.println("Developer for udate: " + dao.getById(id));
        Developer newDev = enterFieldsForDeveloper(dao.getById(id));
        dao.update(newDev);
        System.out.println("###################################");

    }

    public void deleteDeveloper() {
        System.out.println("Enter id developer for delete: ");
        int id = in.nextInt();
        dao.delete(id);
        System.out.println("##############################");

    }

}
