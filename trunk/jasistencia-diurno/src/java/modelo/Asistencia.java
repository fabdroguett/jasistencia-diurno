package modelo;

import java.sql.Timestamp;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Asistencia {
    private Timestamp fecha;
    private boolean asistio;

    public Asistencia(Timestamp fecha, boolean asistio) {
        this.fecha = fecha;
        this.asistio = asistio;
    }

    public Asistencia(boolean asistio) {
        this.asistio = asistio;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public boolean isAsistio() {
        return asistio;
    }

    public void setAsistio(boolean asistio) {
        this.asistio = asistio;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("H:mm");
        return "Asistencia{" + "fecha=" + fecha + " "+ "Hora: "+sdf.format(fecha) + ", asistio=" + asistio + '}';
    }
    
    
}
