package com.devlove.model.entitiesgleice;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Gleice
 */

@Entity
public class Professor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codigo;
    @Column(length = 50)
    private String nome;
    @Column(length = 50)
    private String email;
    private String senha;
    
    //portifólio
    @OneToMany
    private List<Denuncia> feitas;
    
    public Professor(){
        this.feitas = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public List<Denuncia> getFeitas() {
        return feitas;
    }

    public void setCriadas(List<Denuncia> feitas) {
        this.feitas = feitas;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}

