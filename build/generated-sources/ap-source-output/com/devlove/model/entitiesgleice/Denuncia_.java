package com.devlove.model.entitiesgleice;

import com.devlove.model.entitiesgleice.Cadeira;
import com.devlove.model.entitiesgleice.Estudante;
import com.devlove.model.entitiesgleice.MetodoFila;
import com.devlove.model.entitiesgleice.Professor;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-10-03T14:18:51")
@StaticMetamodel(Denuncia.class)
public class Denuncia_ { 

    public static volatile SingularAttribute<Denuncia, Integer> codigo;
    public static volatile SingularAttribute<Denuncia, String> descricaoDoOcorrido;
    public static volatile SingularAttribute<Denuncia, Professor> professor;
    public static volatile SingularAttribute<Denuncia, Estudante> denunciado;
    public static volatile SingularAttribute<Denuncia, Cadeira> cadeira;
    public static volatile SingularAttribute<Denuncia, Estudante> denunciante;
    public static volatile SingularAttribute<Denuncia, String> turno;
    public static volatile SingularAttribute<Denuncia, MetodoFila> metodo;
    public static volatile SingularAttribute<Denuncia, Date> dataDenuncia;

}