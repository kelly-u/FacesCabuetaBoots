package com.devlove.controllersgleice;

import com.devlove.model.daogleice.ManagerDao;
import com.devlove.model.entitiesgleice.MetodoFila;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * @author Gleice
 */

@ManagedBean
@SessionScoped
public class MetodoFilaController {
    
    private MetodoFila cadastro;
    private MetodoFila selection;
    
    public MetodoFilaController(){
        this.cadastro = new MetodoFila();
    }
    
    public void resetarCamposCadastro(){
        this.setCadastro(new MetodoFila());
    }
    
    public List<MetodoFila> getMetodosFila(){
        
        List<MetodoFila> metodosFila = ManagerDao.getCurrentInstance()
                .read("select mf from MetodoFila mf", MetodoFila.class);
        
        return metodosFila;
        
    }
    
    public String cadastrar(){
        
        ManagerDao.getCurrentInstance().insert(this.getCadastro());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Método de fila cadastrado com sucesso!"));
        
        return "MetodoFila";
    }
    
    
    public String editar(){
        
        ManagerDao.getCurrentInstance().update(this.getSelection());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Método de fila editado com sucesso!"));
        
        return "MetodoFila";
    }
    
    
    public List<MetodoFila> listarMetodoFila(){
        
        List<MetodoFila> metodoFila = ManagerDao.getCurrentInstance().read("select mf from MetodoFila mf", MetodoFila.class);
        return metodoFila;
    }
    
    
    public void deletar(){
        
        ManagerDao.getCurrentInstance().delete(this.selection);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Método de fila deletado com sucesso!"));
        //return "MetodoFila";
    }

    public List<MetodoFila> allMetodos(){
        
        List<MetodoFila> metodosFila = ManagerDao.getCurrentInstance()
                .read("select mf from MetodoFila mf", MetodoFila.class);
        
        return metodosFila;
        
    }
    
    
    public MetodoFila getCadastro() {
        return cadastro;
    }

    public void setCadastro(MetodoFila cadastro) {
        this.cadastro = cadastro;
    }

    public MetodoFila getSelection() {
        return selection;
    }

    public void setSelection(MetodoFila selection) {
        this.selection = selection;
    }

}
