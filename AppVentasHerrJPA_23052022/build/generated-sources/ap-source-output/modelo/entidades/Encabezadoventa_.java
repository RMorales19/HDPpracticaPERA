package modelo.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.entidades.Cliente;
import modelo.entidades.Detalleventa;
import modelo.entidades.Vendedor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-25T14:53:46")
@StaticMetamodel(Encabezadoventa.class)
public class Encabezadoventa_ { 

    public static volatile ListAttribute<Encabezadoventa, Detalleventa> detalleventaList;
    public static volatile SingularAttribute<Encabezadoventa, Long> montototalventa;
    public static volatile SingularAttribute<Encabezadoventa, Vendedor> idvendedor;
    public static volatile SingularAttribute<Encabezadoventa, String> tipoventa;
    public static volatile SingularAttribute<Encabezadoventa, Date> fechaventa;
    public static volatile SingularAttribute<Encabezadoventa, Cliente> idcliente;
    public static volatile SingularAttribute<Encabezadoventa, String> idencabezadoventa;

}