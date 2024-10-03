package com.devlove.model.entitiesgleice;

import com.devlove.model.entitiesgleice.Denuncia;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-10-03T14:18:51")
@StaticMetamodel(Estudante.class)
public class Estudante_ { 

    public static volatile SingularAttribute<Estudante, String> senha;
    public static volatile SingularAttribute<Estudante, Integer> codigo;
    public static volatile ListAttribute<Estudante, Denuncia> criadas;
    public static volatile SingularAttribute<Estudante, String> nome;
    public static volatile SingularAttribute<Estudante, Integer> anoEntrada;
    public static volatile SingularAttribute<Estudante, String> email;

}