package modelo.entidades;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.entidades.Detalleventa;
import modelo.entidades.Lineadeproductos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-25T14:53:46")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile ListAttribute<Producto, Detalleventa> detalleventaList;
    public static volatile SingularAttribute<Producto, Integer> existencia;
    public static volatile SingularAttribute<Producto, String> descripcionproducto;
    public static volatile SingularAttribute<Producto, BigDecimal> preciounitario;
    public static volatile SingularAttribute<Producto, Integer> idproducto;
    public static volatile SingularAttribute<Producto, Lineadeproductos> idlineaproducto;

}