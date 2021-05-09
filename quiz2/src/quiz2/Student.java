package quiz2;

import java.util.Objects;

/**
 *
 * @author aycae
 */
public class Student {
    private int ogrenci_no;
    private String ogrenci_isim;
    private double not_ort;
    private static int ogrenci_sayisi;
    private Address ogrenci_adresi;

    public Student() {
    }

    public Student(int ogrenci_no, String ogrenci_isim, double not_ort, Address ogrenci_adresi) {
        this.ogrenci_no = ogrenci_no;
        this.ogrenci_isim = ogrenci_isim;
        this.not_ort = not_ort;
        this.ogrenci_adresi = ogrenci_adresi;
        ogrenci_sayisi+=1;
    }

    public String getOgrenci_isim() {
        return ogrenci_isim;
    }

    public void setOgrenci_isim(String ogrenci_isim) {
        this.ogrenci_isim = ogrenci_isim;
    }


    public int getOgrenci_no() {
        return ogrenci_no;
    }

    public void setOgrenci_no(int ogrenci_no) {
        this.ogrenci_no = ogrenci_no;
    }

    public double getNot_ort() {
        return not_ort;
    }

    public void setNot_ort(double not_ort) {
        this.not_ort = not_ort;
    }

    public static int getOgrenci_sayisi() {
        return ogrenci_sayisi;
    }

    public static void setOgrenci_sayisi(int ogrenci_sayisi) {
        Student.ogrenci_sayisi = ogrenci_sayisi;
    }

    public Address getOgrenci_adresi() {
        return ogrenci_adresi;
    }

    public void setOgrenci_adresi(Address ogrenci_adresi) {
        this.ogrenci_adresi = ogrenci_adresi;
    }

    @Override
    public String toString() {
        return "Student{" + "ogrenci_no= " + ogrenci_no + ", not_ort= " + not_ort + ", ogrenci_adresi= " + ogrenci_adresi.toString() + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.ogrenci_no != other.ogrenci_no) {
            return false;
        }
        if (Double.doubleToLongBits(this.not_ort) != Double.doubleToLongBits(other.not_ort)) {
            return false;
        }
        if (!Objects.equals(this.ogrenci_adresi, other.ogrenci_adresi)) {
            return false;
        }
        return true;
        
    
    }
    
    
    
    
}
