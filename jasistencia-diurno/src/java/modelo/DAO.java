package modelo;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import modelo.bd.Conexion;

public class DAO {
    private Conexion con;
    private String select;
    
    public static void main(String[] args) throws SQLException{
        DAO dao = new DAO();
//        dao.crearAlumno(new Alumno("11-1", "Damian", "Riquelme", "Distinto", 20, "m"));
//        dao.crearProfesion(new Profesion("Medicina"));
//        dao.crearProfesor(new Profesor("14564765-9", "Boris", "Gonzalez", "Engel", 90, "m", "123456"));
//        dao.asignarProfesion("14564765-9", "1");
//        dao.asignarProfesion("14564765-9", "4");
//        dao.crearCurso(new Curso("Servicios web y comercio electrónico"), "14564765-9");
//        dao.crearCurso(new Curso("Hardware y conectividad de equipos personales"), "14564765-9");
        /*id alumno , id del curso*/
//        dao.asignarCursoAlumno("1", "3");
//        dao.asignarCursoAlumno("2", "3");
//        dao.asignarCursoAlumno("3", "3");
//        dao.asignarCursoAlumno("4", "3");
//        
//        dao.asignarCursoAlumno("1", "4");
//        dao.asignarCursoAlumno("2", "4");
//        dao.asignarCursoAlumno("3", "4");
        /*id alumno , id del curso*/
//        dao.pasarAsistencia("1", "4", new Asistencia(true));
//        dao.pasarAsistencia("2", "4", new Asistencia(false));
//        for(Curso c : dao.getCurso("16828943-k")){
//            System.out.println(c);
//        }
//        for(Alumno a:dao.getAlumnos("4")){
//            System.out.println(a);
//        }
//        Date fec = new Date(Calendar.getInstance().getTimeInMillis());
//        List<AsistenciaAlumno> asistencias = dao.getAsistencias("4",fec);
////        
//        for(AsistenciaAlumno aa: asistencias){
//            System.out.println(aa);
//        }
//        for(Profesion pro : dao.getProfesiones("14564765-9")){
//            System.out.println(pro);
//        }
//        for(AsistenciaAlumno aa : dao.getAsistencias("17687328-0")){
//            System.out.println(aa);
//        }
        
//        for(AsistenciaAlumno aa : dao.getAsistencias("17687328-0", "4")){
//            System.out.println(aa);
//        }
//        Profesor p = dao.iniciarSesion("16828943-k", "1234587j6");
//        if(p != null){
//            System.out.println(p);
//        }else{
//            System.out.println("Error al iniciar sesion");
//        }
    }
    
    public DAO() throws SQLException{
        con = new Conexion("colegio", "28061995");
    }
    
    public void crearAlumno(Alumno nuevo) throws SQLException{
        con.insert("insert into alumno "
                + "values(null, '"+nuevo.getRut()+"', "
                + "'"+nuevo.getNombre()+"', "
                + "'"+nuevo.getApellidoPaterno()+"', "
                + "'"+nuevo.getApellidoMaterno()+"' ,"
                + "'"+nuevo.getEdad()+"' ,"
                + "'"+nuevo.getSexo()+"');");
    }
    
    public void crearProfesion(Profesion nueva) throws SQLException{
        con.insert("insert into profesion values(null, "
                + "'"+nueva.getNombre()+"');");
    }
    
    public void crearProfesor(Profesor nuevo) throws SQLException{
        con.insert("insert into profesor "
                + "values('"+nuevo.getRut()+"', "
                + "'"+nuevo.getNombre()+"', "
                + "'"+nuevo.getApellidoPaterno()+"', "
                + "'"+nuevo.getApellidoMaterno()+"' ,"
                + "'"+nuevo.getEdad()+"' ,"
                + "'"+nuevo.getSexo()+"', "
                + "AES_ENCRYPT('"+nuevo.getClave()+"','llave'));");
    }
    
    public void asignarProfesion(String rutProfesor, String idProfesion) throws SQLException{
        con.insert("insert into profesion_profesor "
                + "values(null, '"+rutProfesor+"','"+idProfesion+"');");
    }
    
    public void crearCurso(Curso nuevo, String rutProfesor) throws SQLException{
        con.insert("insert into curso values(null, "
                + "'"+nuevo.getNombre()+"','"+rutProfesor+"');");
    }
    
    public void asignarCursoAlumno(String idAlumno, String idCurso) throws SQLException{
        con.insert("insert into curso_alumno values(null, "
                + "'"+idAlumno+"','"+idCurso+"');");
    }
    
    public void pasarAsistencia(String idAlumno, String idCurso, Asistencia asi) throws SQLException{
        con.insert("insert into asistencia values(null, "
                + "'"+idAlumno+"', '"+idCurso+"', "
                + "NOW(), "+asi.isAsistio()+");");
    }
    
    public List<Curso> getCurso(String rutProfesor) throws SQLException{
        List<Curso> lista = new ArrayList<>();
        
        select = "select curso.id, curso.nombre " +
        "from curso, profesor " +
        "where curso.profesor = profesor.rut and " +
        "profesor.rut = '"+rutProfesor+"'";
        
        con.sen = con.con.createStatement();
        
        con.rs = con.sen.executeQuery(select);
        
        Curso c;
        String id, nombre;
        while(con.rs.next()){
            id = con.rs.getString("id");
            nombre = con.rs.getString("nombre");
            
            c = new Curso(id, nombre);
            lista.add(c);
        }
        
        con.sen.close();
        
        return lista;
    }
    
    public List<Alumno> getAlumnos(String idCurso) throws SQLException{
        List<Alumno> alumnos = new ArrayList<>();
        
        select = "select a.id, a.rut, a.nombre, a.ape_pat, " +
                "a.ape_mat, a.edad, a.sexo " +
                "from alumno a, curso c, curso_alumno ca " +
                "where c.id = ca.curso and ca.alumno = a.id " +
                "and c.id = "+idCurso+";";
        
        con.sen = con.con.createStatement();
        
        con.rs = con.sen.executeQuery(select);
        
        while(con.rs.next()){
            alumnos.add(new Alumno(
                    con.rs.getString("id"),
                    con.rs.getString("rut"),
                    con.rs.getString("nombre"),
                    con.rs.getString("ape_pat"),
                    con.rs.getString("ape_mat"),
                    con.rs.getInt("edad"),
                    con.rs.getString("sexo")
            ));
        }
        
        con.sen.close();
        
        return alumnos;
    }
    
    public List<AsistenciaAlumno> getAsistencias(String idCurso, Date fecha) throws SQLException{
        List<AsistenciaAlumno> lista = new ArrayList<>();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
        String fec = sdf.format(fecha);
        
        select = "select a.id, a.rut,  a.nombre, a.ape_pat, " +
                "a.ape_mat, a.edad, a.sexo, asis.fecha, asis.asistio " +
                "from curso c, asistencia asis, alumno a " +
                "where c.id = asis.curso and " +
                "asis.alumno = a.id and " +
                "c.id = '"+idCurso+"' and " +
                "asis.fecha between '"+fec+" 00:00:00' " +
                "and '"+fec+" 23:59:59';";
        System.out.println(select);
        con.sen = con.con.createStatement();
        con.rs = con.sen.executeQuery(select);
        
        Alumno al;
        Asistencia asis;
        AsistenciaAlumno asisAl;
        
        while(con.rs.next()){
            al = new Alumno(
                    con.rs.getString("id"),
                    con.rs.getString("rut"),
                    con.rs.getString("nombre"),
                    con.rs.getString("ape_pat"),
                    con.rs.getString("ape_mat"),
                    con.rs.getInt("edad"),
                    con.rs.getString("sexo")
            );
            
            asis = new Asistencia(
                    con.rs.getTimestamp("fecha"), 
                    con.rs.getBoolean("asistio")
            );
            
            asisAl = new AsistenciaAlumno(al, asis);
            
            lista.add(asisAl);
        }
        
        con.sen.close();
        
        return lista;
    }
    
    public List<Profesion> getProfesiones(String rutProfesor) throws SQLException{
        List<Profesion> lista = new ArrayList<>();
        select = "select profesion.id, profesion.nombre " +
                "from profesor, profesion, profesion_profesor " +
                "where profesor.rut = profesion_profesor.profesor and " +
                "profesion.id = profesion_profesor.profesion and " +
                "profesor.rut = '"+rutProfesor+"';";
        
        con.sen = con.con.createStatement();
        con.rs = con.sen.executeQuery(select);
        
        while(con.rs.next()){
            lista.add(new Profesion(
                con.rs.getString("id"),
                con.rs.getString("nombre")
            ));
            
        }
        
        con.sen.close();
        
        return lista;
    }
    
    public List<AsistenciaAlumno> getAsistencias(String rutAlumno) throws SQLException{
        select = "select a.id, a.rut, a.nombre, a.ape_pat, " +
                "a.ape_mat, a.edad, a.sexo, asis.fecha, asis.asistio," +
                "c.nombre as 'curso' " +
                "from curso c, asistencia asis, alumno a " +
                "where c.id = asis.curso and " +
                "asis.alumno = a.id and " +
                "a.rut = '"+rutAlumno+"';";
        return ejecutar(select);
    }
    
    public List<AsistenciaAlumno> getAsistencias(String rutAlumno, String idCurso) throws SQLException{
        select = "select a.id, a.rut, a.nombre, a.ape_pat, " +
                    "a.ape_mat, a.edad, a.sexo, asis.fecha, asis.asistio, " +
                    "c.nombre as 'curso' " +
                    "from curso c, asistencia asis, alumno a " +
                    "where c.id = asis.curso and " +
                    "asis.alumno = a.id and " +
                    "a.rut = '"+rutAlumno+"' and " +
                    "c.id = '"+idCurso+"';";
        return ejecutar(select);
    }

    private List<AsistenciaAlumno> ejecutar(String select) throws SQLException {
        List<AsistenciaAlumno> lista = new ArrayList<>();
        
        
        con.sen = con.con.createStatement();
        con.rs = con.sen.executeQuery(select);
        
        Alumno al;
        Asistencia asis;
        Curso curso;
        AsistenciaAlumno asisAl;
        
        while(con.rs.next()){
            al = new Alumno(
                    con.rs.getString("id"),
                    con.rs.getString("rut"),
                    con.rs.getString("nombre"),
                    con.rs.getString("ape_pat"),
                    con.rs.getString("ape_mat"),
                    con.rs.getInt("edad"),
                    con.rs.getString("sexo")
            );
            
            asis = new Asistencia(
                    con.rs.getTimestamp("fecha"), 
                    con.rs.getBoolean("asistio")
            );
            
            curso = new Curso(con.rs.getString("curso"));
            
            asisAl = new AsistenciaAlumno(al, asis, curso);
            
            lista.add(asisAl);
        }
        
        con.sen.close();
        return lista;
    }

    public Profesor iniciarSesion(String rut, String pass) throws SQLException{
        Profesor pro = null;
        select = "select * from profesor " +
                "where clave = AES_ENCRYPT('"+pass+"','llave') and " +
                "rut = '"+rut+"';";
        
        con.sen = con.con.createStatement();
        
        con.rs = con.sen.executeQuery(select);
        
        if(con.rs.next()){
            pro = new Profesor(
                    con.rs.getString("rut"), 
                    con.rs.getString("nombre"), 
                    con.rs.getString("ape_pat"),
                    con.rs.getString("ape_mat"), 
                    con.rs.getInt("edad"), 
                    con.rs.getString("sexo")
            );
        }
        
        con.sen.close();
        return pro;
    }
}
