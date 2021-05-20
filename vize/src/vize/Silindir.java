package vize;

/**
 *
 * @author aycae
 */
public class Silindir extends GeometrikNesne {

    private double yaricap;
    private double uzunluk;

    public Silindir() {
        yaricap=1.;
        uzunluk=1.;
    }

    public Silindir(double yaricap, double uzunluk) {
        this.yaricap = yaricap;
        this.uzunluk = uzunluk;
    }
    //constructor with super parameters
    public Silindir(double yaricap, double uzunluk, String label, Date tarih) {
        super(label, tarih);
        this.yaricap = yaricap;
        this.uzunluk = uzunluk;
    }
    
        //copy constructor
    public Silindir(Silindir orj) {
        
        if(orj==null){
            System.out.println("error while creating copy constructor of silindir");
            System.exit(0);    
        }

        super.setLabel(orj.getLabel()+"-copy");
        super.setTarih(new Date(orj.getTarih()));
        yaricap=orj.getYaricap(); //no privacy leak with primitive types
        uzunluk=orj.getUzunluk();
        
    }

    
    public double getYaricap() {
        return yaricap;
    }

    public void setYaricap(double yaricap) {
        this.yaricap = yaricap;
    }

    public double getUzunluk() {
        return uzunluk;
    }

    public void setUzunluk(double uzunluk) {
        this.uzunluk = uzunluk;
    }

    @Override
    public String toString() {
        return "Silindir " +"label= "+super.getLabel()+" "+ "yaricap= " + yaricap + " uzunluk= " + uzunluk +" tarih= "+ super.getTarih().toString();
    }
    
    
    public double hacimHesapla(){
        
        double hacim= Math.PI*yaricap*yaricap*uzunluk;
        return hacim;
    }
    
    @Override
    public double alanHesapla() {
        
        double alan= 2*yaricap*Math.PI*(yaricap+uzunluk);
        return alan;
    }

    @Override
    public double cevreHesapla() {
        double cevre= (2*2*yaricap*Math.PI)+(2*uzunluk);
        return cevre;
    }

    @Override
    public int compareTo(Object o) {
        
        Silindir obj = (Silindir) o;
        double obj_hacim= obj.hacimHesapla();
        
        if(hacimHesapla()>obj_hacim){
            return 1;
        }
        else if(hacimHesapla()<obj_hacim){
            return -1;
        }
        else if(hacimHesapla()==obj_hacim){
            return 0;
        }
        else return 404;
            
            

    }
    
    
    
    
    
    
    
    
}
