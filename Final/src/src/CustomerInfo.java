package src;

import java.util.ArrayList;

/**
 *
 * @author aycae
 */
public class CustomerInfo {
    
    private String adSoyad;
    private String adres;
    private ArrayList<String> telefonList;
    
    //constructors
    public CustomerInfo() {
    }

    public CustomerInfo(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public CustomerInfo(String adSoyad, String adres, ArrayList<String> telefonList) {
        this.adSoyad = adSoyad;
        this.adres = adres;
        this.telefonList = telefonList;
    }
    
    //getter and setters
    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public ArrayList<String> getTelefonList() {
        return telefonList;
    }

    public void setTelefonList(ArrayList<String> telefonList) {
        this.telefonList = telefonList;
    }

    @Override
    public String toString() {
        return "Musteri{" + "adSoyad=" + adSoyad + ", adres=" + adres + ", telefonList=" + telefonList + '}';
    }
    

    
    
    
}
