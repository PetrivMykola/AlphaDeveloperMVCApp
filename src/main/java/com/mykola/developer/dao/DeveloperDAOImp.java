package main.java.com.mykola.developer.dao;

import main.java.com.mykola.developer.exception.*;
import main.java.com.mykola.developer.model.Developer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DeveloperDAOImp implements DeveloperDAO {

    File file;
    String path = ".\\src\\resources\\test.txt";
    List<Developer> listDev;

    public DeveloperDAOImp() {
        file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void save(Developer dev) {
        try (FileWriter writer = new FileWriter(file, true)) {
            checkId(dev.getId());

            writer.write(dev.getId() + ", " + dev.getName() + ", " +
                    dev.getLastName() + ", " + dev.getPosition() + ", " +
                    dev.getSalary() + ", " + dev.getExperience() + System.lineSeparator());
            writer.flush();
        } catch (IOException | IdAlredyExistException e) {
            System.out.println(e.getMessage());
        }
    }

    public Developer getById(int id) {
        String line = "";
        String readLine = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            while ((line = reader.readLine()) != null) {
                if (Character.getNumericValue(line.charAt(0)) == id) {
                    readLine = line;
                } else throw new NotFoundIdException("Id does not exist in file");
            }
        } catch (IOException | NullPointerException | NotFoundIdException e) {
            System.out.println(e.getMessage());
        }
        return createDevFromStr(readLine);
    }

    public List<Developer> getAll() {
        String line;
        listDev = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            checkFile(file);

            while ((line = reader.readLine()) != null) {
                listDev.add(createDevFromStr(line));
            }
        } catch (IOException | EmptyFileException e) {
            System.out.println(e.getMessage());
        }
        return listDev;
    }

    public void delete(int id) {
        String line;
        File tempFile = new File(file.getAbsolutePath() + ".tmp");

        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             FileWriter newFileWriter = new FileWriter(tempFile)) {
                checkFile(file);

            while ((line = reader.readLine()) != null) {
                if (!(Character.getNumericValue(line.charAt(0)) == id)) {
                    newFileWriter.write(line + System.lineSeparator());
                    newFileWriter.flush();
                }
            }
        } catch (IOException | EmptyFileException e) {
            System.out.println(e.getMessage());
        }
        if (!file.delete()) System.out.println("Cannot delete file");
        if (!tempFile.renameTo(file)) System.out.println("Cannot rename file");

    }

    public void update(Developer dev) {
        try {
            if(isExistDevInFileById(dev)) {
                delete(dev.getId());
                Developer newDev = dev;
                save(newDev);
            } else throw new NotFoundIdException("Cannot find developer in file");
        } catch (EmptyFileException | NotFoundIdException e) {
            System.out.println(e.getMessage());
        }
    }

    public void checkId(int id) {
        String line;
        try (BufferedReader read = new BufferedReader(new FileReader(file))) {
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

    public Developer createDevFromStr(String str) {
        String[] arrayWords = str.split(", ");
        Developer dev = new Developer(Integer.valueOf(arrayWords[0]), arrayWords[1], arrayWords[2],
                arrayWords[3], Integer.valueOf(arrayWords[4]), Integer.valueOf(arrayWords[5]));
        return dev;
    }

    public boolean isExistDevInFileById(Developer dev) {
        boolean result = false;
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            checkFile(file);

            while ((line = reader.readLine()) != null) {
                if (Character.getNumericValue(line.charAt(0)) == dev.getId()) {
                    result = true;
                } else result = false;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
            return result;
    }

}



