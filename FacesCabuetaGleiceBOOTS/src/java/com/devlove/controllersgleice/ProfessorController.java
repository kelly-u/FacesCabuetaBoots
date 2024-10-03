package com.devlove.controllersgleice;

import com.devlove.model.daogleice.ManagerDao;
import com.devlove.model.entitiesgleice.Professor;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * @author Gleice
 */
@ManagedBean
@SessionScoped
public class ProfessorController {

    private Professor cadastro;
    private Professor logado;

    @PostConstruct
    public void init() {
        this.cadastro = new Professor();
    }

    public void inserir(String confirma) {

        if (!this.cadastro.getSenha().equals(confirma)) {

            this.cadastro.setSenha("");

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    "A senha e a confirmação, não batem!"));

            return;

        }
    
    ManagerDao.getCurrentInstance().insert(this.cadastro);

        this.cadastro = new Professor();

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(""
                + "Bem vindo ao Faces Cabueta!"
                + "Efetue seu login para fazer o que é certo:"
                + "Descobrir e punir os alunos pilantras!"));
    }
    
    public String realizarLogin(String email, String senha) {

        try {
            Professor l = (Professor) ManagerDao.getCurrentInstance().read(
                    "select p from Professor p where p.email = '" + email + "' and "
                    + "p.senha = '" + senha + "'", Professor.class).get(0);

            this.logado = l;

            return "indexProfessor2";

        } catch (IndexOutOfBoundsException index) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao logar",
                            "O e-mail e/ou senha estão incorretos"));

            return null;
        }

    }

    public void editarPerfil() {

        ManagerDao.getCurrentInstance().update(this.logado);

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Seu pefil de professor(a) foi editado com sucesso!"));

    }
    
    
    public void editarSenha(String atual, String nova, String confirma) {

        if (!this.logado.getSenha().equals(atual)) {

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Erro ao digitar a senha atual", ""));

            return;

        }
        if (nova.length() < 3) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "A nova senha possui menos de 3 caracteres!", ""));

            return;
        }
        if (!nova.equals(confirma)) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "A nova senha não bate com a confirmação!", ""));

            return;

        }

        this.logado.setSenha(nova);

        ManagerDao.getCurrentInstance().update(this.logado);

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Sua senha foi alterada!", ""));

    }

    public void logout() {

        ((HttpSession) FacesContext.getCurrentInstance().getExternalContext()
                .getSession(true)).invalidate();

    }

    public List<Professor> allProfessores(){
        
        List<Professor> professores = ManagerDao.getCurrentInstance()
                .read("select p from Professor p", Professor.class);
        
        return professores;
        
    }

    public Professor getCadastro() {
        return cadastro;
    }

    public void setCadastro(Professor cadastro) {
        this.cadastro = cadastro;
    }

    public Professor getLogado() {
        return logado;
    }

    public void setLogado(Professor logado) {
        this.logado = logado;
    }

}
