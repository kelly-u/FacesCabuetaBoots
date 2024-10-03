package com.devlove.model.entitiesgleice;

import java.util.Date;
//import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Gleice
 */
@Entity
public class Denuncia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codigo;
    @Temporal(TemporalType.DATE)
    private Date dataDenuncia;
    private String turno;
    @Lob
    private String descricaoDoOcorrido;

    @ManyToOne
    private Professor professor;
    @ManyToOne
    private Cadeira cadeira;
    @ManyToOne
    private MetodoFila metodo;
    @ManyToOne
    private Estudante denunciante;
    @ManyToOne
    private Estudante denunciado;
    /*
    @OneToMany
    @JoinColumn(name="DENUNCIADO_CODIGO")
    private List<Estudante> denunciados;
    */
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getDataDenuncia() {
        return dataDenuncia;
    }

    public void setDataDenuncia(Date dataDenuncia) {
        this.dataDenuncia = dataDenuncia;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getDescricaoDoOcorrido() {
        return descricaoDoOcorrido;
    }

    public void setDescricaoDoOcorrido(String descricaoDoOcorrido) {
        this.descricaoDoOcorrido = descricaoDoOcorrido;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Cadeira getCadeira() {
        return cadeira;
    }

    public void setCadeira(Cadeira cadeira) {
        this.cadeira = cadeira;
    }

    public MetodoFila getMetodo() {
        return metodo;
    }

    public void setMetodo(MetodoFila metodo) {
        this.metodo = metodo;
    }

    public Estudante getDenunciante() {
        return denunciante;
    }

    public void setDenunciante(Estudante denunciante) {
        this.denunciante = denunciante;
    }

    public Estudante getDenunciados() {
        return denunciado;
    }

    public void setDenunciados(Estudante denunciados) {
        this.denunciado = denunciados;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    
    
}
