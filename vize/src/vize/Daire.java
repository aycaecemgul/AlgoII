package vize;

/**
 *
 * @author aycae
 */
public class Daire extends GeometrikNesne {

    private double yaricap;
    
    //constructor without parameter
    public Daire() {
        yaricap=1.;
    }
    
    
    //constructor with radius
    public Daire(double yaricap) {
        if(yaricap<=0){yaricap=1.;}
        this.yaricap = yaricap;
    }

    //constructor with super parameters and radius
    public Daire(String label, Date tarih,double yaricap) {
        super(label, tarih);
        if(yaricap<=0){yaricap=1.;}
        this.yaricap = yaricap;
    }
    
    //getter setter metotları
    public double getYaricap() {
        return yaricap;
    }

    public void setYaricap(double yaricap) {
        this.yaricap = yaricap;
    }
    
    
    //copy constructor
    //no privacy leak with primitive types
    public  Daire(Daire orj) {
        
        if(orj==null){
            System.out.println("error while creating copy constructor of daire");
            System.exit(0);    
        }
        

        super.setLabel(orj.getLabel());
        super.setTarih(new Date(orj.getTarih()));
        this.yaricap=orj.getYaricap(); 

    }

    @Override
    public String toString() {
        return "Daire " +" label= "+super.getLabel()+" "+ "yaricap= " + yaricap + " label= " +super.getLabel() + " tarih= " + super.getTarih().toString();

    }
    
    //geometriknesne classındaki metotların daire classında implement edilmesi
    
    @Override
    public double alanHesapla() {
        return  Math.PI * Math.pow(yaricap, 2);
    }

    @Override
    public double cevreHesapla() {
        
        return 2* Math.PI *yaricap;
    }
    
    
    @Override
    public int compareTo(Object o) {

        Daire object = (Daire) o;
        double yaricap_object= object.getYaricap();
        
        if(yaricap>yaricap_object){
            return 1;
        }
        else if (yaricap<yaricap_object){
            return -1;
        }
        else if (yaricap==yaricap_object){
            return 0;
        }
        else return 404;
        
        
    }
    
    
    
}
