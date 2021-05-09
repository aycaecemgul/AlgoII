package quiz2;

/**
 *
 * @author aycae
 */
import java.io.File;  
import java.util.Scanner;

public class Deneme {
    public static void main(String[] args){
        String DIR = "C:\\Users\\aycae\\OneDrive\\Belgeler\\NetBeansProjects\\quiz2\\src\\quiz2\\girdiQuiz2.txt";
        double en_yuksek_not=0;
        double temp=0;
        try{
            File file = new File(DIR);
            Scanner file_scanner = new Scanner(file);

            while (file_scanner.hasNextLine()) {
                int ogrenci_no =file_scanner.nextInt();

                String isim =file_scanner.next();
                String soyisim =file_scanner.next();            
                String ogrenci_isim=isim+" "+soyisim;

                double ort=file_scanner.nextDouble();
                temp=ort;
                if(temp>en_yuksek_not){en_yuksek_not=temp; }
                String sokak1=file_scanner.next();
                String sokak2=file_scanner.next();
                String sokak = sokak1+" "+sokak2;

                int bina_no=file_scanner.nextInt();
                int daire_no=file_scanner.nextInt();
                String sehir=file_scanner.next();
                
                Address adres = new Address(sokak,bina_no,daire_no,sehir);
                Student student = new Student(ogrenci_no,ogrenci_isim,ort,adres);
                System.out.println(student.toString());
            }
        }
        catch(Exception e){
             System.out.println("error");
        }
        System.out.println("En yüksek not= "+en_yuksek_not);
        System.out.println("Ogrenci sayisi= "+Student.getOgrenci_sayisi());
    }
}
