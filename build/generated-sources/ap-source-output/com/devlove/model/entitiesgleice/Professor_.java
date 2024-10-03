package com.devlove.model.entitiesgleice;

import com.devlove.model.entitiesgleice.Denuncia;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-10-03T14:18:51")
@StaticMetamodel(Professor.class)
public class Professor_ { 

    public static volatile SingularAttribute<Professor, String> senha;
    public static volatile SingularAttribute<Professor, Integer> codigo;
    public static volatile ListAttribute<Professor, Denuncia> feitas;
    public static volatile SingularAttribute<Professor, String> nome;
    public static volatile SingularAttribute<Professor, String> email;

}