package vize;

/**
 *
 * @author aycae
 */
//geometriknesne comparable arayüzünü implement eder
public abstract class GeometrikNesne implements Comparable {
    
    private String label;     //etiket ve tarih değişkeni
    private Date tarih; 

    //empty constructor
    public GeometrikNesne() {
        tarih= new Date();
    }

    //constructor with all parameters of the class
    public GeometrikNesne(String label, Date tarih) {
        this.label = label;
        this.tarih = tarih;
    }
    
    //getters and setters
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Date getTarih() {
        return new Date(tarih); //new date object to avoid privacy leaking
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }
    
    //copy constructor
    public GeometrikNesne(GeometrikNesne orj){
        if(orj==null){
            System.out.println("error while creating copy constructor of geometriknesne");
            System.exit(0);    
        }
        Date copy_tarih= new Date(orj.getTarih()); //creating new date object to avoid privacy leak

        label=orj.getLabel();
        tarih= copy_tarih;
    }

    @Override
    public String toString() {
        return "GeometrikNesne" + "label= " + label + ", tarih= " + tarih.toString() ;
    }
    
    //geometriknesne classını inherit edecek classlarda bulunacak metotların imzaları
    
    public abstract double alanHesapla();
    
    public abstract double cevreHesapla();
    
    @Override
    public abstract int compareTo(Object o);
}
