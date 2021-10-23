package sample.GestionOffre.models;


import java.time.LocalDate;

public class Favoris {
    int idoffre;
    int idCli;
    int VL;
    //int Vc;
    LocalDate datelike;
  //  LocalDate datecomment;


    public Favoris(int idoffre, int idCli, int VL, LocalDate datelike) {
        this.idoffre = idoffre;
        this.idCli = idCli;
        this.VL = VL;
        this.datelike = datelike;
    }

    public int getVL() {
        return VL;
    }

    public void setVL(int VL) {
        this.VL = VL;
    }



    public int getIdoffre() {
        return idoffre;
    }

    public void setIdoffre(int idoffre) {
        this.idoffre = idoffre;
    }

    public int getIdCli() {
        return idCli;
    }

    public void setIdCli(int idCli) {
        this.idCli = idCli;
    }

    public LocalDate getDatelike() {
        return datelike;
    }

    public void setDatelike(LocalDate datelike) {
        this.datelike = datelike;
    }
}
