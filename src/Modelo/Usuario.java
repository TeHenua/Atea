package Modelo;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Usuario {
    private int id;
    private String nombre;
    private String dni;
    private String apellido1;
    private String apellido2;
    private Integer numSocio;
    private Date fechaNac;
    private String lugarNac;
    private String direccion;
    private String localidad;
    private int codigoPos;
    private String provincia;
    private String colegio;
    private String ocupacion;
    private String diagnostico;
    private String gradoDiscapacidad;
    private String gradoDependencia;
    private String puntosMovilidad;
    private String demanda;
    private String numSs;
    private int tis;
    private Date primeraEntrevista;
    private boolean alertaCustodia;
    private boolean alertaMedica;
    private boolean estado;

    //relaciones
    private ArrayList<Socio> socios;
    private Grupo grupo;
    private ArrayList<Consulta> consultas;
    private ArrayList<Contacto> contactos;

    public boolean guardarUsuario(int socioId){//aqui se guarda el usuario en la base de datos IMPORTANTE QUITAR ID AUTOINCREMENTAL
        ControladorBaseDatos.conectar();
        try {//TODO FALTA VER QUE HACEMOS CON EL ESTADO DE MOMENTO LE ENVIAMOS UN 1 A MACHETE A LA BBDD
            PreparedStatement ps = ControladorBaseDatos.getConexion().prepareStatement("INSERT INTO USUARIOS(" +
                    "ID,NOMBRE,APELLIDO1,APELLIDO2,NUM_SOCIO,FECHA_NAC,LUGAR_NAC,DIRECCION,LOCALIDAD,PROVINCIA,CODIGO_POS," +
                    "COLEGIO,OCUPACION,DIAGNOSTICO,GRADO_DISCAPACIDAD,GRADO_DEPENDENCIA,PUNTOS_MOVILIDAD,NUM_SS,TIS," +
                    "PRIMERA_ENTREVISTA,ALERTA_CUSTODIA,ALERTA_MEDICA,ESTADO)" +
                    " VALUES((SELECT (NVL(MAX(ID),0)+1) FROM USUARIOS),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1)");
            ps.setString(1,nombre);
            ps.setString(2,apellido1);
            ps.setString(3,apellido2);
            ps.setInt(4,numSocio);
            ps.setDate(5,fechaNac);
            ps.setString(6,lugarNac);
            ps.setString(7,direccion);
            ps.setString(8,localidad);
            ps.setString(9,provincia);
            ps.setInt(10,codigoPos);
            ps.setString(11,colegio);
            ps.setString(12,ocupacion);
            ps.setString(13, diagnostico);
            ps.setString(14,gradoDiscapacidad);
            ps.setString(15,gradoDependencia);
            ps.setString(16,puntosMovilidad);
            ps.setString(17,numSs);
            ps.setInt(18,tis);
            ps.setDate(19,primeraEntrevista);
            ps.setString(20,convertirAlertas(alertaCustodia));
            ps.setString(21,convertirAlertas(alertaMedica));
            //ejecutamos la sentencia
            ps.execute();
            //cerramos la conexion
            ControladorBaseDatos.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modificarUsuario(){
        ControladorBaseDatos.conectar();
        try{
            PreparedStatement ps = ControladorBaseDatos.getConexion().prepareStatement(
                "UPDATE USUARIOS SET NOMBRE=? ,APELLIDO1=? ,APELLIDO2=? ,NUM_SOCIO=? ,FECHA_NAC=? ,LUGAR_NAC=? ,DIRECCION=?"+
                    "LOCALIDAD=? ,PROVINCIA=? ,CODIGO_POS=? ,COLEGIO=? ,OCUPACION=? ,DIAGNOSTICO=? ,GRADO_DISCAPACIDAD=?"+
                    "GRADO_DEPENDENCIA=? ,PUNTOS_MOVILIDAD=? ,NUM_SS=? ,TIS=? ,PRIMERA_ENTREVISTA=? ,ALERTA_CUSTODIA=? ,ALERTA_MEDICA=?");
            ps.setString(1,nombre);
            ps.setString(2,apellido1);
            ps.setString(3,apellido2);
            ps.setInt(4,numSocio);
            ps.setDate(5,fechaNac);
            ps.setString(6,lugarNac);
            ps.setString(7,direccion);
            ps.setString(8,localidad);
            ps.setString(9,provincia);
            ps.setInt(10,codigoPos);
            ps.setString(11,colegio);
            ps.setString(12,ocupacion);
            ps.setString(13, diagnostico);
            ps.setString(14,gradoDiscapacidad);
            ps.setString(15,gradoDependencia);
            ps.setString(16,puntosMovilidad);
            ps.setString(17,numSs);
            ps.setInt(18,tis);
            ps.setDate(19,primeraEntrevista);
            ps.setString(20,convertirAlertas(alertaCustodia));
            ps.setString(21,convertirAlertas(alertaMedica));
            //ejecutamos la sentencia
            ps.execute();
            //cerramos la conexion
            ControladorBaseDatos.desconectar();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean borrarUsuario(){
        try{
            ControladorBaseDatos.conectar();
            PreparedStatement ps = null;
            ps = ControladorBaseDatos.getConexion().prepareStatement("DELETE FROM USUARIOS WHERE ID=?");
            ps.setInt(1,id);
            //ejecutamos la sentencia
            ps.execute();
            //cerramos la conexion
            ControladorBaseDatos.desconectar();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    //para listar todos los usuarios
    public static ArrayList<Usuario> todosLosUsuarios(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            ControladorBaseDatos.conectar();
            PreparedStatement ps = ControladorBaseDatos.getConexion().prepareStatement("SELECT ID,NOMBRE,APELLIDO1," +
                    "APELLIDO2 FROM USUARIOS");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Usuario usuario = new Usuario(rs.getInt("ID"),rs.getString("NOMBRE"),
                        rs.getString("APELLIDO1"),rs.getString("APELLIDO2"));
                usuarios.add(usuario);
            }
            ControladorBaseDatos.desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    private String convertirAlertas(boolean alerta){
        if (alerta){
            return "s";
        }else {
            return "n";
        }
    }

    //***************************************//
    //              CONSTRUCTORES           //
    //*************************************//

    //aqui el constructor vacio
    public Usuario() {
    }

    //aqui el constructor con todos los campos obligatorios
    public Usuario(String nombre, String dni, String apellido1, String apellido2, Integer numSocio, Date fechaNac,
                   String lugarNac, String direccion, String localidad, int codigoPos, String provincia, String colegio,
                   String ocupacion, String diagnostico, String gradoDiscapacidad, String gradoDependencia,
                   String puntosMovilidad, String demanda, String numSs, int tis, Date primeraEntrevista,
                   boolean alertaCustodia, boolean alertaMedica) {
        this.nombre = nombre;
        this.dni = dni;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.numSocio = numSocio;
        this.fechaNac = fechaNac;
        this.lugarNac = lugarNac;
        this.direccion = direccion;
        this.localidad = localidad;
        this.codigoPos = codigoPos;
        this.provincia = provincia;
        this.colegio = colegio;
        this.ocupacion = ocupacion;
        this.diagnostico = diagnostico;
        this.gradoDiscapacidad = gradoDiscapacidad;
        this.gradoDependencia = gradoDependencia;
        this.puntosMovilidad = puntosMovilidad;
        this.demanda = demanda;
        this.numSs = numSs;
        this.tis = tis;
        this.primeraEntrevista = primeraEntrevista;
        this.alertaCustodia = alertaCustodia;
        this.alertaMedica = alertaMedica;
    }

    public Usuario(int id, String nombre, String apellido1, String apellido2) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    //***************************************//
    //        FIN DE CONSTRUCTORES           //
    //***************************************//

    //Añadir objetos al array para la relacion
    public void añadirSocio(Socio socio){
        socios.add(socio);
        socio.añadirUsuario(this);
    }

    //Añadir objetos al array para la relacion
    public void añadirConsulta(Consulta consulta){
        consultas.add(consulta);
    }

    //Añadir objetos al array para la relacion
    public void añadirContacto(Contacto contacto){
        contactos.add(contacto);
    }

    //********************************************************//
    //AQUI LAS PUERTAS DE ENTRADA Y SALIDA CON GETTER Y SETTER//
    //********************************************************//

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Integer getNumSocio() {
        return numSocio;
    }

    public void setNumSocio(Integer numSocio) {
        this.numSocio = numSocio;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getCodigoPos() {
        return codigoPos;
    }

    public void setCodigoPos(int codigoPos) {
        this.codigoPos = codigoPos;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getColegio() {
        return colegio;
    }

    public void setColegio(String colegio) {
        this.colegio = colegio;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getGradoDiscapacidad() {
        return gradoDiscapacidad;
    }

    public void setGradoDiscapacidad(String gradoDiscapacidad) {
        this.gradoDiscapacidad = gradoDiscapacidad;
    }

    public String getGradoDependencia() {
        return gradoDependencia;
    }

    public void setGradoDependencia(String gradoDependencia) {
        this.gradoDependencia = gradoDependencia;
    }

    public String getPuntosMovilidad() {
        return puntosMovilidad;
    }

    public void setPuntosMovilidad(String puntosMovilidad) {
        this.puntosMovilidad = puntosMovilidad;
    }

    public String getDemanda() {
        return demanda;
    }

    public void setDemanda(String demanda) {
        this.demanda = demanda;
    }

    public String getNumSs() {
        return numSs;
    }

    public void setNumSs(String numSs) {
        this.numSs = numSs;
    }

    public int getTis() {
        return tis;
    }

    public void setTis(int tis) {
        this.tis = tis;
    }

    public Date getPrimeraEntrevista() {
        return primeraEntrevista;
    }

    public void setPrimeraEntrevista(Date primeraEntrevista) {
        this.primeraEntrevista = primeraEntrevista;
    }

    public boolean isAlertaCustodia() {
        return alertaCustodia;
    }

    public void setAlertaCustodia(boolean alertaCustodia) {
        this.alertaCustodia = alertaCustodia;
    }

    public boolean isAlertaMedica() {
        return alertaMedica;
    }

    public void setAlertaMedica(boolean alertaMedica) {
        this.alertaMedica = alertaMedica;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getLugarNac() {
        return lugarNac;
    }

    public void setLugarNac(String lugarNac) {
        this.lugarNac = lugarNac;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public ArrayList<Socio> getSocios() { return socios; }

    public ArrayList<Consulta> getConsultas() { return consultas; }

    public ArrayList<Contacto> getContactos() { return contactos; }
}
