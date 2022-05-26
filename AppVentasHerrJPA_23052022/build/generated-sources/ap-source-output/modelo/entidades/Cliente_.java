package modelo.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.entidades.Encabezadoventa;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-25T14:53:46")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, Character> categoriacliente;
    public static volatile SingularAttribute<Cliente, Integer> otro;
    public static volatile ListAttribute<Cliente, Encabezadoventa> encabezadoventaList;
    public static volatile SingularAttribute<Cliente, Integer> idcliente;
    public static volatile SingularAttribute<Cliente, String> nombrecliente;

}