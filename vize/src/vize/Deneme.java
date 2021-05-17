package vize;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
/**
 *
 * @author aycae
 */
public class Deneme {

    public static void main(String[] args) throws FileNotFoundException {
        
        GeometrikNesne[] dizi = new GeometrikNesne[50];
        int index=0;
        try{
           File file = new File("input.txt"); 
           Scanner file_scanner = new Scanner(file);
           file_scanner.useLocale(Locale.US); //text dosyasındaki double ları okuyabilmesi için
           int month;
           int day;
           int year;
           GeometrikNesne yeni; 
           
           while (file_scanner.hasNextLine()) {       
                String sekil=file_scanner.next();
                if(sekil.equals("daire")){ //nextline daire nesnesi ise
                    
                    String label = file_scanner.next();
                    double yaricap= file_scanner.nextDouble();
                    String date = file_scanner.next();

                    month = file_scanner.nextInt();
                    day = file_scanner.nextInt();
                    year= file_scanner.nextInt();
                   
                    Date new_date= new Date(month,day,year);
                    yeni= new Daire(label,new_date,yaricap);
                    
                    dizi[index]=yeni;
                    index++;
                }
                else if(sekil.equals("dikdortgen")){ //nexline  dikdortgen nesnesi ise
                    String label = file_scanner.next();
                    double en= file_scanner.nextDouble();
                    double boy= file_scanner.nextDouble();
                    String date = file_scanner.next();
                        
                    month = file_scanner.nextInt();
                    day = file_scanner.nextInt();
                    year= file_scanner.nextInt();

                    Date new_date= new Date(month,day,year);
                    yeni= new Dikdortgen(label, new_date,en,boy);
                    dizi[index]=yeni;
                    index++;

                }
                else if(sekil.equals("silindir")){ //nextline silindir nesnesi ise
                    String label = file_scanner.next();
                    double yaricap= file_scanner.nextDouble();
                    double uzunluk = file_scanner.nextDouble();
                    String date = file_scanner.next();
                     
                    month = file_scanner.nextInt();
                    day = file_scanner.nextInt();
                    year= file_scanner.nextInt();

                    Date new_date= new Date(month,day,year);
                    yeni =new Silindir(yaricap,uzunluk,label,new_date);
                    dizi[index]=yeni;
                    index++;
                }
            }
        }
        catch(FileNotFoundException e){
             System.out.println("error while reading input text");
        }
                
        Daire dai3=(Daire) dizi[3];
        Daire dai4 = new Daire(dai3); //copy constructor
        dizi[index]=dai4;
        index++;
        
        Dikdortgen dik2 = (Dikdortgen) dizi[6];
        Dikdortgen dik3 = new Dikdortgen(dik2); //copy constructor
        dizi[index]=dik3;
        index++;
        
        Silindir sil2 = (Silindir) dizi[5];
        Silindir sil3 = new Silindir(sil2); //copy constructor
        dizi[index]=sil3;
        index++;
        
        Daire dai2 = (Daire) dizi[2];
        Dikdortgen dik1 = (Dikdortgen) dizi[1];
        Silindir sil1 = (Silindir) dizi[4];
        System.out.println("Polymorphicyazdir metot çıktıları: ");
        polymorphicYazdir(sil3);
        polymorphicYazdir(dik2);
        polymorphicYazdir(dai2);
        System.out.println("");
        
        System.out.println("karsılastır metot çıktıları: ");
        karsilastir(dai2,dai3);
        karsilastir(dai4,dai3); //sonuc esit cıkmalı
        karsilastir(dik1,dik2);
        karsilastir(dik2,dik3); //sonuc esit cıkmalı
        karsilastir(sil1,sil2);
        karsilastir(sil2,sil3); //sonuc esit cıkmalı
//        
//        ArrayList<Double> dizi2= new ArrayList<>();
//        
//        //cevre ortalaması,en küçük ve en büyük çevrenin bulunması:
//        
//        double cevre=0; 
//        double en_kucuk_cevre=10000.; //en kucuk cevrenin bulunması icin  büyük bir rakam atanmıştır.
//        double en_buyuk_cevre=0;
//        int count=0; //cevresi hesaplanan nesne sayısı
//        for (GeometrikNesne nesne : dizi) {
//            cevre+=nesne.cevreHesapla(); //yeni nesnenin cevresi toplam cevreye eklenir
//            count+=1; 
//            if(cevre>en_buyuk_cevre){en_buyuk_cevre=cevre;} //yeni hesaplanan cevre en büyük cevreden büyükse yeni en büyük cevre variable ı updatelenir
//            if(cevre<en_kucuk_cevre){en_kucuk_cevre=cevre;} //yeni hesaplanan cevre en kücük cevreden kücükse en kücük cevre variable ı updatelenir
//        }
//        cevre=cevre/count; //cevre aritmetik ortalaması hesaplanir
//        dizi2.add(cevre); //dizi2ye ortalamayı ekle
//        
//        
//        //alan ortalaması,en büyük ve en kucuk alanın bulunması:
//        
//        double alan=0;
//        double en_kucuk_alan=10000.; //en kucuk alanın bulunması icin  büyük bir rakam atanmıştır.
//        double en_buyuk_alan=0;
//        count=0; //alanı hesaplanan nesne sayısı
//        for (GeometrikNesne nesne : dizi) {
//            alan+=nesne.alanHesapla(); //yeni nesnenin alanı toplam alana eklenir
//            count+=1;
//            if(alan>en_buyuk_alan){en_buyuk_alan=alan;} //yeni hesaplanan alan en büyük alandan büyükse yeni en büyük alan variable ı updatelenir
//            if(alan<en_kucuk_alan){en_kucuk_alan=alan;} //yeni hesaplanan alan en kücük alandan kücükse en kücük alan variable ı updatelenir
//        }
//        alan=alan/count; //alan aritmetik ortalaması hesaplanir
//        dizi2.add(alan); //dizi2ye ortalamayı ekle
//        
//        //hacim ortalaması,en büyük ve en kücük hacimin bulunması:
//        double hacim=0;
//        double en_kucuk_hacim=1000000.; //en kucuk hacimin bulunması icin  büyük bir rakam atanmıştır.
//        double en_buyuk_hacim=0;
//        count=0; //hacmi hesaplanan silindir sayisi
//        for (GeometrikNesne nesne : dizi) {
//            if(nesne instanceof Silindir){ //eger silindir objesi ise hacim hesaplanır.
//                Silindir slndr = (Silindir) nesne; 
//                hacim+=slndr.hacimHesapla(); //nesnenin hacmi toplam hacim variable ına eklenir
//                count+=1; 
//                if(hacim>en_buyuk_hacim){en_buyuk_hacim=hacim;} //yeni hesaplanan hacim en büyük hacimden büyükse yeni en büyük hacim variable ı updatelenir
//                if(hacim<en_kucuk_hacim){en_kucuk_hacim=hacim;} //yeni hesaplanan hacim en kücük hacimden kücükse en kücük hacim variable ı updatelenir
//            }
//        }
//        hacim=hacim/count; //hacim aritmetik ortalaması hesaplanir
//        dizi2.add(hacim); //dizi2 ye ortalamayı ekle
//        
//        //bulunan min ve max değerleri dizi2 ye ekle.
//        dizi2.add(en_kucuk_cevre);
//        dizi2.add(en_buyuk_cevre);
//        
//        dizi2.add(en_kucuk_alan);
//        dizi2.add(en_buyuk_alan);
//        
//        dizi2.add(en_kucuk_hacim);
//        dizi2.add(en_buyuk_hacim);
//        
//        System.out.println("");
//        System.out.println("Ortalamalar:");
//        System.out.println("Cevre ortalaması= "+cevre);
//        System.out.println("Alan ortalaması= "+alan);
//        System.out.println("Hacim ortalaması= "+hacim);
        
        
    }
    
    public static void polymorphicYazdir(GeometrikNesne nesne){
        System.out.println(nesne.getLabel());
        System.out.println("Nesne çevresi= "+ nesne.cevreHesapla());
        System.out.println("Nesne alanı= " + nesne.alanHesapla());
        if(nesne instanceof Silindir){ //eger nesne silindir objesi ise true dondurur
            Silindir sil = (Silindir) nesne;
            System.out.println("Nesne hacim= " + sil.hacimHesapla());
        }       
    }
    
    public static void karsilastir(GeometrikNesne nesne1,GeometrikNesne nesne2){
        switch (nesne1.compareTo(nesne2)) {
            case 1:
                System.out.println(nesne1.getLabel()+
                        ", "+nesne2.getLabel()+"'den büyüktür.");
                break;
            case -1:
                System.out.println(nesne2.getLabel()+
                        ", "+nesne1.getLabel()+"'den büyüktür.");
                break;
            case 0:
                System.out.println(nesne1.getLabel()+
                        " ve "+nesne2.getLabel()+" eşittir.");
                break;
            default:
                System.out.println("hata.");
        }
    
    
    }

}