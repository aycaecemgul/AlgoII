package quiz2;

import java.util.Objects;
/**
 *
 * @author aycae
 */
public class Address {
    private String sokak_cadde;
    private int bina_no;
    private int daire_no;
    private String sehir;

    public Address() {
    }

    public Address(String sokak_cadde, int bina_no, int daire_no, String sehir) {
        this.sokak_cadde = sokak_cadde;
        this.bina_no = bina_no;
        this.daire_no = daire_no;
        this.sehir = sehir;
    }

    public String getSokak_cadde() {
        return sokak_cadde;
    }

    public void setSokak_cadde(String sokak_cadde) {
        this.sokak_cadde = sokak_cadde;
    }

    public int getBina_no() {
        return bina_no;
    }

    public void setBina_no(int bina_no) {
        this.bina_no = bina_no;
    }

    public int getDaire_no() {
        return daire_no;
    }

    public void setDaire_no(int daire_no) {
        this.daire_no = daire_no;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    @Override
    public String toString() {
        return "sokak_cadde= " + sokak_cadde + ", bina_no= " + bina_no + ", daire_no= " + daire_no + ", sehir= " + sehir ;
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
        final Address other = (Address) obj;
        if (this.bina_no != other.bina_no) {
            return false;
        }
        if (this.daire_no != other.daire_no) {
            return false;
        }
        if (!Objects.equals(this.sokak_cadde, other.sokak_cadde)) {
            return false;
        }
        if (!Objects.equals(this.sehir, other.sehir)) {
            return false;
        }
        return true;
    }
    
    

}



