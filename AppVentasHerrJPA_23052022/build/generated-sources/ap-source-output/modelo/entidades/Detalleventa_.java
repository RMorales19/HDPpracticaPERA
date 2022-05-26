package modelo.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.entidades.Encabezadoventa;
import modelo.entidades.Producto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-25T14:53:46")
@StaticMetamodel(Detalleventa.class)
public class Detalleventa_ { 

    public static volatile SingularAttribute<Detalleventa, Integer> iddetalleventa;
    public static volatile SingularAttribute<Detalleventa, Integer> cantidadventa;
    public static volatile SingularAttribute<Detalleventa, Producto> idproducto;
    public static volatile SingularAttribute<Detalleventa, Encabezadoventa> idencabezadoventa;

}