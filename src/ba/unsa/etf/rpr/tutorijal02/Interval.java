package ba.unsa.etf.rpr.tutorijal02;

import java.util.Scanner;

public class Interval {
    private double PocetnaTacka, KrajnjaTacka;
    private boolean DaLiPrvaPripada, DaLiDrugaPripada;

    public Interval(double pocetnatacka, double krajnjatacka, boolean daLiPrvaPripada, boolean daLiDrugaPripada) {
        if(pocetnatacka>krajnjatacka) throw new IllegalArgumentException("Pocetna tacka je veca od kranje.");
        this.PocetnaTacka= pocetnatacka;
        this.KrajnjaTacka = krajnjatacka;
        this.DaLiPrvaPripada = daLiPrvaPripada;
        this.DaLiDrugaPripada = daLiDrugaPripada;
    }
    public Interval(){
        PocetnaTacka=0;
        KrajnjaTacka=0;
        DaLiDrugaPripada=false;
        DaLiPrvaPripada=false;
    }
    public double getPocetnaTacka() {
        return PocetnaTacka;
    }

    public double getKrajnjaTacka() {
        return KrajnjaTacka;
    }

    public boolean isDaLiPrvaPripada() {
        return DaLiPrvaPripada;
    }
    public boolean isDaLiDrugaPripada(){
        return DaLiDrugaPripada;
    }
    public boolean isNull(){
        if(this.PocetnaTacka==this.KrajnjaTacka) return true;
        else return false;
    }
    public boolean isIn(double tacka){
        if(tacka>this.PocetnaTacka && tacka<this.KrajnjaTacka) return true;
        else if(tacka==this.PocetnaTacka) return this.DaLiPrvaPripada;
        else if(tacka==this.KrajnjaTacka) return this.DaLiDrugaPripada;
        else return false;
    }
    public boolean podudaranjetacke(boolean b1, boolean b2){
        if(b1==b2) return true;
        else return false;
    }
    public Interval intersect(Interval i1) {
        Interval i2 = new Interval();
        if(i1.isNull()) return i2;
        if (isIn(i1.getPocetnaTacka()) && isIn(i1.getKrajnjaTacka())) {
            if (i1.getPocetnaTacka() == this.getPocetnaTacka()) {
                if (i1.getKrajnjaTacka() == this.getKrajnjaTacka())
                    i2 = new Interval(i1.getPocetnaTacka(), i1.getKrajnjaTacka(), podudaranjetacke(i1.isDaLiPrvaPripada(), this.isDaLiPrvaPripada()), podudaranjetacke(i1.isDaLiDrugaPripada(), this.isDaLiDrugaPripada()));
                else
                    i2 = new Interval(i1.getPocetnaTacka(), i1.getKrajnjaTacka(), podudaranjetacke(i1.isDaLiPrvaPripada(), this.isDaLiPrvaPripada()), i1.isDaLiDrugaPripada());
            } else if (i1.getKrajnjaTacka() == this.getKrajnjaTacka())
                    i2 = new Interval(i1.getPocetnaTacka(), i1.getKrajnjaTacka(), i1.isDaLiPrvaPripada(), podudaranjetacke(i1.isDaLiDrugaPripada(), this.isDaLiDrugaPripada()));
              else
                    i2 = new Interval(i1.getPocetnaTacka(), i1.getKrajnjaTacka(), i1.isDaLiPrvaPripada(), i1.isDaLiDrugaPripada());
            }
        else if(isIn(i1.getPocetnaTacka()) && (!isIn(i1.getKrajnjaTacka()))) {
            if (i1.getPocetnaTacka() == this.getPocetnaTacka())
                i2 = new Interval(i1.getPocetnaTacka(), this.getKrajnjaTacka(), podudaranjetacke(i1.isDaLiPrvaPripada(), this.isDaLiPrvaPripada()), this.isDaLiDrugaPripada());
            else
                i2 = new Interval(i1.getPocetnaTacka(), this.getKrajnjaTacka(), i1.isDaLiPrvaPripada(), this.isDaLiDrugaPripada());
        }
        else if((!isIn(i1.getPocetnaTacka())) && isIn(i1.getKrajnjaTacka())) {
            if (i1.getKrajnjaTacka() == this.getKrajnjaTacka())
                i2 = new Interval(this.getPocetnaTacka(), i1.getKrajnjaTacka(), this.isDaLiPrvaPripada(), podudaranjetacke(i1.isDaLiDrugaPripada(), this.isDaLiDrugaPripada()));
            else
                i2 = new Interval(this.getPocetnaTacka(), i1.getKrajnjaTacka(), this.isDaLiPrvaPripada(), i1.isDaLiDrugaPripada());
        }
        else
            i2 = new Interval(this.getPocetnaTacka(),this.getKrajnjaTacka(),this.isDaLiPrvaPripada(),this.isDaLiDrugaPripada());
        return i2;
    }
    public static Interval intersect(Interval i1, Interval i2){
        Interval i3 = i1.intersect(i2);
        return i3;
    }
    @Override
    public String toString(){
        String s = "";
        if(this.isNull()) return "()";
        if(this.isDaLiPrvaPripada()) s = "[";
        else s = "(";
        s=s+this.getPocetnaTacka() + "," + this.getKrajnjaTacka();
        if(this.isDaLiDrugaPripada()) s=s+"]";
        else s=s+")";
        return s;
    }
    public boolean equals(Interval i1){
        if(i1.getPocetnaTacka()==this.getPocetnaTacka() && i1.getKrajnjaTacka()==this.getKrajnjaTacka()
        && i1.isDaLiPrvaPripada()==this.isDaLiPrvaPripada() && i1.isDaLiDrugaPripada()==this.isDaLiDrugaPripada()) return true;
        else return false;
    }
}
