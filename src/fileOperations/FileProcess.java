package fileOperations;

import model.Place;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileProcess {

    public static ArrayList<Place> list = new ArrayList<>();

    public static void writePlacesToFile(){
        try {
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("places"));
            for (Place p: list
            ) {
                writer.writeObject(p);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readPlacesFromFile(){
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream("places"))) {
            while(true){
                Place p = (Place) reader.readObject();
                list.add(p);
            }
        } catch(NullPointerException y){
            return; // file finished reading
             }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
