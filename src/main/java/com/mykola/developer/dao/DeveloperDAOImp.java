package main.java.com.mykola.developer.DAO;

import main.java.com.mykola.developer.exception.*;
import main.java.com.mykola.developer.model.Developer;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class DeveloperDAOImp implements DeveloperDAO {

    Scanner in = new Scanner(System.in);
    FileWriter writer;
    BufferedReader reader;
    File file;
    String path = "C:\\projectProselyte\\task\\developerMVCApp\\src\\resources\\test.txt";

    public DeveloperDAOImp() {
        file = new File(path);

        try {
            file.createNewFile();

        } catch (IOException e) {
            System.out.println();
        }
    }

    public void save(Developer dev) {
        try (FileWriter writer = new FileWriter(file, true)) {

            checkId(dev.getId());

            writer.write(dev.getId() + ", " + dev.getName() + ", " +
                    dev.getLastName() + ", " + dev.getPosition() + ", " +
                    dev.getSalary() + ", " + dev.getExperience() + System.lineSeparator());
            writer.flush();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (IdAlredyExistException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getById(int id) {
        String line = "";
        String readLine = "";

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            while ((line = reader.readLine()) != null) {
                if (Character.getNumericValue(line.charAt(0)) == id) {
                    readLine = line;
                } else throw new NotFoundIdException("Id does not exist in file");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NotFoundIdException e) {
            System.out.println(e.getMessage());
        }
        return readLine;
    }

    public void getAll() {
        try (Stream<String> lines =
                     Files.lines(Paths.get(path), Charset.defaultCharset())) {
            checkFile(file);
            lines.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (EmptyFileException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id) {
        String line;
        File tempFile = new File(file.getAbsolutePath() + ".tmp");

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file));
             FileWriter newFileWriter = new FileWriter(tempFile)) {

            checkFile(file);

            while ((line = reader.readLine()) != null) {
                if (!(Character.getNumericValue(line.charAt(0)) == id)) {
                    newFileWriter.write(line + System.lineSeparator());
                    newFileWriter.flush();
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (EmptyFileException e) {
            System.out.println(e.getMessage());
        }

        if (!file.delete()) System.out.println("Cannot delete file");
        if (!tempFile.renameTo(file)) System.out.println("Cannot rename file");

    }

    public void update(Developer dev) {
        try {
            checkFile(file);
            System.out.println("Developer for update: " + getById(dev.getId()));
            delete(dev.getId());
            Developer newDev = fillDev(dev);
            save(newDev);

        } catch (EmptyFileException e) {
            System.out.println(e.getMessage());
        }
    }

    public Developer fillDev(Developer dev) {
        System.out.println("Enter new Id:");
        dev.setId(in.nextInt());
        System.out.println("Enter new name:");
        dev.setName(in.next());
        System.out.println("Enter new lastName:");
        dev.setLastName(in.next());
        System.out.println("Enter new position:");
        dev.setPosition(in.next());
        System.out.println("Enter new salary:");
        dev.setSalary(in.nextInt());
        System.out.println("Enter new experience : ");
        dev.setExperience(in.nextInt());

        return dev;
    }

    public void checkId(int id) {
        String line;
        try (BufferedReader read =
                     new BufferedReader(new FileReader(file))) {

            while ((line = read.readLine()) != null) {
                if (((Character.getNumericValue(line.charAt(0)) == id)))
                    throw new IdAlredyExistException("Id should be unique");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void checkFile(File file) {
        if (file.length() == 0) throw new EmptyFileException("File is empty");
    }

}



