package ClasesPOJO;

import ClasesPOJO.Empleados;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-07-06T16:26:07", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Incidencias.class)
public class Incidencias_ { 

    public static volatile SingularAttribute<Incidencias, Empleados> empleadoOrigen;
    public static volatile SingularAttribute<Incidencias, Empleados> empleadoDestino;
    public static volatile SingularAttribute<Incidencias, String> tipo;
    public static volatile SingularAttribute<Incidencias, LocalDateTime> fechaHora;
    public static volatile SingularAttribute<Incidencias, Integer> id;
    public static volatile SingularAttribute<Incidencias, String> detalle;

}