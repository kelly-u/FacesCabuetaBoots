package com.devlove.controllersgleice;

import com.devlove.model.daogleice.ManagerDao;
import com.devlove.model.entitiesgleice.Denuncia;
import com.devlove.model.entitiesgleice.Estudante;
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
public class DenunciaController {
    
    private Denuncia cadastro;
    private Denuncia selected;
    
    @PostConstruct
    public void init(){
        this.cadastro = new Denuncia();
    }
    
    public void resetarCamposCadastro(){
        this.setCadastro(new Denuncia());
    }
    
    public void inserir(Estudante e){
        
        this.cadastro.setDenunciante(e);
                
        ManagerDao.getCurrentInstance().insert(this.cadastro);
        
        e.getCriadas().add(cadastro);        
        ManagerDao.getCurrentInstance().update(e);
        
         FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Denuncia efetuada com sucesso!"));
         
         this.cadastro = new Denuncia();
         
         ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true))
                .removeAttribute("denuncia");
        
    }
    
    public List<Denuncia> allDenuncias(){
       
        List<Denuncia> denuncias = ManagerDao.getCurrentInstance().read(
                "select d from Denuncia d", Estudante.class);
        return denuncias;
    }
    
    public List<Denuncia> DenunciasProfLogado(Professor professor) {
        return ManagerDao.getCurrentInstance().read(
                "select d from Denuncia d where d.professor.codigo = " + professor.getCodigo() + " order by d.dataDenuncia desc", Denuncia.class);
    }
    
    public List<Denuncia> filterBy(String denuncianteEDenunciado){
        String query = "select d from Denuncia d where d.denunciante.nome LIKE '%"+denuncianteEDenunciado+"%' or "
                + "d.denunciado.nome LIKE '%"+denuncianteEDenunciado+"%'";
        
        return ManagerDao.getCurrentInstance().read(query, Denuncia.class);
    }
    
    
    public Denuncia getCadastro() {
        return cadastro;
    }

    public void setCadastro(Denuncia cadastro) {
        this.cadastro = cadastro;
    }

    public Denuncia getSelected() {
        return selected;
    }

    public void setSelected(Denuncia selected) {
        this.selected = selected;
    }
    
    
}
