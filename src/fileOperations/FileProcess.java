package fileOperations;

import javafx.collections.FXCollections;
import javafx.scene.image.ImageView;
import model.MainAttraction;
import model.ParishCode;
import model.Place;
import model.Request;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileProcess {

    public static ArrayList<Place> list = new ArrayList<>();
    public static ArrayList<Request> requestList = new ArrayList<>();
    public static BinaryTree treeList = new BinaryTree();

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

        ObjectInputStream reader = null;
        try {
                 reader = new ObjectInputStream(new FileInputStream("places"));
            while(true) {
                Place p = (Place) reader.readObject();
                p.setUpImage();
                list.add(p);
            }
        }catch(NullPointerException e) {
            //file not found
            return;
        }
        catch (Exception exc){
            //end of file eception
            try {
                if(reader != null)
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeRequestsToFile(){
        try {
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("requests"));


                writer.writeObject(treeList);

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readRequestsFromFile(){

        ObjectInputStream reader = null;
        try {
            reader = new ObjectInputStream(new FileInputStream("requests"));
            while(true) {
                treeList = (BinaryTree) reader.readObject();
            }
        }catch(NullPointerException e) {
            //file not found
            return;
        }
        catch (Exception exc){
            //end of file exception
            treeList.updateButtons(treeList.root);
            try {
                if(reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static MainAttraction lastRequestAttraction = null;

    public static ArrayList<Place> getListbyParish(int code){
        ArrayList<Place> al = new ArrayList<>();
        for(Place p : list){
            if (p.getParishCode() == code){
                p.setupButton(false);
                al.add(p);
            }
        }
        return al;
    }

    public static ArrayList<Place> getListbyLowestCost(){
        ArrayList<Place> al = list;
        al.sort((place, t1) -> {
            if(place.getCostForEntry() < t1.getCostForEntry()) return -1;
            else return 1;
        });

        for(Place p : al){
            p.setupButton(false);
        }

        return al;
    }

    public static ArrayList<Place> getListByAttraction(MainAttraction code) {

        ArrayList<Place> al = new ArrayList<>();
        for(Place p : list){
            if (p.getMainAttraction() == code){
                p.setupButton(false);
                al.add(p);
            }
        }
        return al;
    }
}
