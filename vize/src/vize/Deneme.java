package vize;

import java.io.File;
import java.io.FileNotFoundException;
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
        //son yaratılan nesneleri tutmak ici variable lar
        GeometrikNesne son_daire=null;
        GeometrikNesne son_dik=null;
        GeometrikNesne son_sil = null;
        
        //ilk nesnelerin tutulması icin variablelar ve indexler oluşturuldu
        GeometrikNesne ilk_daire=null;
        GeometrikNesne ilk_dik=null;
        GeometrikNesne ilk_sil = null;
        int daire_index=0;
        int dik_index=0;
        int sil_index=0;
        
        try{
           File file = new File("input.txt"); 
           Scanner file_scanner = new Scanner(file);
           file_scanner.useLocale(Locale.US); //text dosyasındaki double ları okuyabilmesi için
           int month;
           int day;
           int year;
           GeometrikNesne yeni; 
           //
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
                    son_daire= new Daire( (Daire) yeni); //so daireyi tutan var. her loopta gücellenir.
                    dizi[index]=yeni;
                    index++;
                    if(daire_index==0){ilk_daire=yeni; daire_index++;}
                    
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
                    son_dik= new Dikdortgen( (Dikdortgen) yeni); //so dikdörtgeni tutan var. her loopta gücellenir.
                    dizi[index]=yeni;
                    index++;
                    if(dik_index==0){ilk_dik=yeni; dik_index++;}
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
                    son_sil = new Silindir ((Silindir) yeni);
                    dizi[index]=yeni;
                    index++;
                    if(sil_index==0){ilk_sil=yeni; sil_index++;}
                }
            }
        }
        catch(FileNotFoundException e){
             System.out.println("error while reading input text");
        }
        

        
        //son daire,dikdortgen ve silindir copyleri oluşturulur listeye eklenir
        
        GeometrikNesne son_daire_copy = new Daire((Daire)son_daire); //copy constructor
        dizi[index]=son_daire_copy;
        index++;
        
        GeometrikNesne son_dik_copy = new Dikdortgen((Dikdortgen) son_dik); //copy constructor
        dizi[index]=son_dik_copy;
        index++;

        GeometrikNesne son_sil_copy = new Silindir((Silindir) son_sil); //copy constructor
        dizi[index]=son_sil_copy;
        index++;
        
        
        System.out.println("Polymorphicyazdir metot çıktıları: ");
        System.out.println("");
        for(int j=0;j<index;j++){
            polymorphicYazdir(dizi[j]);}
        System.out.println("");
        
        System.out.println("karsılastır metot çıktıları: ");
        karsilastir(ilk_daire,son_daire_copy);
        karsilastir(son_daire_copy,son_daire); // ==
        karsilastir(ilk_dik,son_dik_copy);
        karsilastir(son_dik_copy,son_dik); //==
        karsilastir(ilk_sil,son_sil_copy);
        karsilastir(son_sil_copy,son_sil); //==
        
        double[] dizi2 = new double[50];
        int index2=0;
        
        System.out.println("");
        
        //cevre ortalaması,en küçük ve en büyük çevrenin bulunması:
        
        
        double toplam_cevre=0;
        double en_kucuk_cevre=10000.; //en kucuk cevrenin bulunması icin  büyük bir rakam atanmıştır.
        double en_buyuk_cevre=0;
        int count=0; //cevresi hesaplanan nesne sayısı

        for (int i=0;i<index;i++) {
            double cevre=0; 
            cevre = dizi[i].cevreHesapla(); //yeni nesnenin cevresi toplam cevreye eklenir
            toplam_cevre+=cevre;
            count+=1; 
            if(cevre>en_buyuk_cevre){en_buyuk_cevre=cevre;} //yeni hesaplanan cevre en büyük cevreden büyükse yeni en büyük cevre variable ı updatelenir
            if(cevre<en_kucuk_cevre){en_kucuk_cevre=cevre;} //yeni hesaplanan cevre en kücük cevreden kücükse en kücük cevre variable ı updatelenir
        }
        
        dizi2[index2]= toplam_cevre/count;  //cevre aritmetik ortalaması hesapla dizi2ye ekle
        index2++;
        
        
        //alan ortalaması,en büyük ve en kucuk alanın bulunması:
        
        double toplam_alan=0;
        double en_kucuk_alan=10000.; //en kucuk alanın bulunması icin  büyük bir rakam atanmıştır.
        double en_buyuk_alan=0;
        count=0; //alanı hesaplanan nesne sayısı
        for (int i=0;i<index;i++) {
            double alan=0;
            alan=dizi[i].alanHesapla(); //yeni nesnenin alanı toplam alana eklenir
            toplam_alan+=alan;
            count+=1;
            if(alan>en_buyuk_alan){en_buyuk_alan=alan;} //yeni hesaplanan alan en büyük alandan büyükse yeni en büyük alan variable ı updatelenir
            if(alan<en_kucuk_alan){en_kucuk_alan=alan;} //yeni hesaplanan alan en kücük alandan kücükse en kücük alan variable ı updatelenir
        }
        
        dizi2[index2]=toplam_alan/count; //alan aritmetik ortalaması hesapla ve dizi2ye ekle
        index2++;
        
        //hacim ortalaması,en büyük ve en kücük hacimin bulunması:
        double toplam_hacim=0;
        double en_kucuk_hacim=10000000.; //en kucuk hacimin bulunması icin  büyük bir rakam atanmıştır.
        double en_buyuk_hacim=0;
        count=0; //hacmi hesaplanan silindir sayisi
        for (int i=0;i<index;i++) {
            double hacim=0;
            if(dizi[i] instanceof Silindir){ //eger silindir objesi ise hacim hesaplanır.
                Silindir slndr = (Silindir) dizi[i]; 
                hacim=slndr.hacimHesapla(); //nesnenin hacmi toplam hacim variable ına eklenir
                toplam_hacim+=hacim;
                count+=1; 
                if(hacim>en_buyuk_hacim){en_buyuk_hacim=hacim;} //yeni hesaplanan hacim en büyük hacimden büyükse yeni en büyük hacim variable ı updatelenir
                if(hacim<en_kucuk_hacim){en_kucuk_hacim=hacim;} //yeni hesaplanan hacim en kücük hacimden kücükse en kücük hacim variable ı updatelenir
            }
        }
        dizi2[index2]=toplam_hacim/count;; //hacim aritmetik ortalaması hesapla ve dizi2 ye ekle
        index2++;
        
        //bulunan min ve max değerleri dizi2 ye ekle.
        dizi2[index2]=en_kucuk_cevre;
        index2++;
        dizi2[index2]=en_buyuk_cevre;
        index2++;
        
        dizi2[index2]=en_kucuk_alan;
        index2++;
        dizi2[index2]=en_buyuk_alan;
        index2++;
        
        dizi2[index2]=en_kucuk_hacim;
        index2++;
        dizi2[index2]=en_buyuk_hacim;
        index2++;
        
        
        System.out.println("");
        System.out.println("Ortalamalar ve Enler:");
        System.out.println("Cevre ortalaması= "+dizi2[0]);
        System.out.println("Alan ortalaması= "+dizi2[1]);
        System.out.println("Hacim ortalaması= "+dizi2[2]);
        System.out.println("En küçük çevre= "+dizi2[3]);
        System.out.println("En büyük çevre= "+dizi2[4]);
        System.out.println("En küçük alan= "+dizi2[5]);
        System.out.println("En büyük alan= "+dizi2[6]);
        System.out.println("En küçük hacim= "+dizi2[7]);
        System.out.println("En büyük hacim= "+dizi2[8]);

        
    }
    
    public static void polymorphicYazdir(GeometrikNesne nesne){
        System.out.println(nesne.toString());
        
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