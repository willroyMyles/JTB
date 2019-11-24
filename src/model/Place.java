package model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

enum  MainAttraction{
    JerkChicken,
     RiverTours,
     WaterSlides

}

public class Place implements Serializable {

    private String guid;
    private String name;
    private String description;
    private String address;
    private String photoLink;
    private String contactNumber;
    private MainAttraction mainAttraction;
    private int parishCode;
    private int costForEntry;
    private Date openingHours;

    public Place() {
        this.guid = UUID.randomUUID().toString();
    }

    public Place(String name, String description, String address, String photoLink, String contactNumber, MainAttraction mainAttraction, int parishCode, int costForEntry, Date openingHours) {
        this.guid = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.address = address;
        this.photoLink = photoLink;
        this.contactNumber = contactNumber;
        this.mainAttraction = mainAttraction;
        this.parishCode = parishCode;
        this.costForEntry = costForEntry;
        this.openingHours = openingHours;
    }

    public String getGuid() {
        return guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public MainAttraction getMainAttraction() {
        return mainAttraction;
    }

    public void setMainAttraction(MainAttraction mainAttraction) {
        this.mainAttraction = mainAttraction;
    }

    public int getParishCode() {
        return parishCode;
    }

    public void setParishCode(int parishCode) {
        this.parishCode = parishCode;
    }

    public int getCostForEntry() {
        return costForEntry;
    }

    public void setCostForEntry(int costForEntry) {
        this.costForEntry = costForEntry;
    }

    public Date getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(Date openingHours) {
        this.openingHours = openingHours;
    }


}
