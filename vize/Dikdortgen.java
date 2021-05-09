/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vize;

/**
 *
 * @author aycae
 */
public class Dikdortgen extends GeometrikNesne {
    
    private double en;
    private double boy;
    
    public Dikdortgen(){
        en=1.0;
        boy=1.0;
        
    }
    
    public Dikdortgen(double en, double boy){
        if (en<=0.0) en=1.0;
        if (boy<=0.0) boy=1.0;
        
        this.en=en;
        this.boy=boy;
    }
    
    public Dikdortgen(String label, Date tarih,double en, double boy) {
        
        super(label, tarih);
        if (en<=0.0) en=1.0;
        if (boy<=0.0) boy=1.0;
        
        this.en=en;
        this.boy=boy;
    }
    
    
    public double getEn() {
        return en;
    }

    public void setEn(double en) {
        this.en = en;
    }

    public double getBoy() {
        return boy;
    }

    public void setBoy(double boy) {
        this.boy = boy;
    }
    
    //copy constructor
    //no privacy leak with primitive types
    public  Dikdortgen(Dikdortgen orj){
        
        if(orj==null){
            System.out.println("error while creating copy constructor of dikdortgen");
            System.exit(0);    
        }
        String copy_label= orj.getLabel()+"_copy";
        super.setLabel(copy_label);
        super.setTarih(orj.getTarih());
        en=orj.getEn(); 
        boy=orj.getBoy();
        
    }
    

    @Override
    public String toString() {
        return "Dikdortgen " + "label= "+super.getLabel()+ " en= "+ en +
                " boy= "+  boy + " tarih= "+super.getTarih().toString();
    }
    
    
    @Override
    public double cevreHesapla(){
        return 2*getEn()+2*getBoy();
    }
    
    @Override
    public double alanHesapla(){
        return getEn()*getBoy();
    }
    

    @Override
    public int compareTo(Object o) {

        Dikdortgen obj= (Dikdortgen) o;
        double obj_alan= obj.alanHesapla();
        if(alanHesapla()>obj_alan){
            return 1;
        } 
        else if(alanHesapla()<obj_alan){
            return -1;
        } 
        else if(alanHesapla()==obj_alan){
            return 0;
        }
        else return 404;
    }
    
}
