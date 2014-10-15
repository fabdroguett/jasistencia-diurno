package modelo;

public class AsistenciaAlumno {
    private Alumno alumno;
    private Asistencia asistencia;
    private Curso curso;

    /*Historial de un alumno (ASistencia)*/
    public AsistenciaAlumno(Alumno alumno, Asistencia asistencia, Curso curso) {
        this.alumno = alumno;
        this.asistencia = asistencia;
        this.curso = curso;
    }

    /* Asistencia de un curso determinado en una
    fecha determinada*/
    public AsistenciaAlumno(Alumno alumno, Asistencia asistencia) {
        this.alumno = alumno;
        this.asistencia = asistencia;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Asistencia getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Asistencia asistencia) {
        this.asistencia = asistencia;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "AsistenciaAlumno{" + "alumno=" + alumno + ", asistencia=" + asistencia + ", curso=" + curso + '}';
    }
    
    
    
}
