package quiz4;

/**
 *
 * @author aycae
 */
public class Customer {
    String ID;
    String adSoyad;

    public Customer(String ID, String adSoyad) {
        this.ID = ID;
        this.adSoyad = adSoyad;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    @Override
    public String toString() {
        return "Customer " + "ID=" + ID + ", ad soyad=" + adSoyad + '}';
    }
    
    
    
}
