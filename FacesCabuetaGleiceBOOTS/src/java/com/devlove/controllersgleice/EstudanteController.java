package com.devlove.controllersgleice;

import com.devlove.model.daogleice.ManagerDao;
import com.devlove.model.entitiesgleice.Denuncia;
import com.devlove.model.entitiesgleice.Estudante;
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
public class EstudanteController {

    private Estudante cadastro;
    private Estudante logado;

    public EstudanteController() {
        this.cadastro = new Estudante();
    }

    public void resetarCamposCadastro() {
        this.setCadastro(new Estudante());
    }

    @PostConstruct
    public void init() {
        this.cadastro = new Estudante();
    }

    public void inserir(String confirma) {

        if (!this.cadastro.getSenha().equals(confirma)) {

            this.cadastro.setSenha("");

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    "A senha e a confirmação, não batem!"));

            return;

        }

        ManagerDao.getCurrentInstance().insert(this.cadastro);

        this.cadastro = new Estudante();

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(""
                + "Bem vindo ao Faces Cabueta!"
                + "Efetue seu login para fazer o que é certo:"
                + "Cabuetar seus amigos!"));

    }

    public String realizarLogin(String email, String senha) {

        try {
            Estudante l = (Estudante) ManagerDao.getCurrentInstance().read(
                    "select e from Estudante e where e.email = '" + email + "' and "
                    + "e.senha = '" + senha + "'", Estudante.class).get(0);

            this.logado = l;

            return "indexEstudante2";

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
                new FacesMessage("Seu pefil de estudante foi editado com sucesso!"));

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

    public List<Estudante> allEstudantes(){
        
        List<Estudante> estudantes = ManagerDao.getCurrentInstance()
                .read("select e from Estudante e", Estudante.class);
        
        return estudantes;
        
    }
    
    
    public void fazerDenuncia(Denuncia d) {
        /* 
        Compra c = new Compra();
        c.setDataCompra(new Date());
        c.setValor(r.getPreco());
        c.setReceita(r);
        
        this.logado.getCompradas().add(c);
        
        ManagerDao.getCurrentInstance().update(c);
        
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage("Parabéns, você acabou de comprar a receita: "+r.getNome()));
         */
    }

    /*
    public List<Estudante> listarEstudantes() {

        List<Estudante> estudantes = ManagerDao.getCurrentInstance().read("select e from Estudante e", Estudante.class);
        return estudantes;
    }
     */
    public Estudante getCadastro() {
        return cadastro;
    }

    public void setCadastro(Estudante cadastro) {
        this.cadastro = cadastro;
    }

    public Estudante getLogado() {
        return logado;
    }

    public void setLogado(Estudante logado) {
        this.logado = logado;
    }

}
