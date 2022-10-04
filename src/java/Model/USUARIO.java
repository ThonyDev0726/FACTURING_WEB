package Model;

/**
 *
 * @author perez
 */
public class USUARIO extends EMPLEADO {

    private Integer ID_USUARIO;
    private Integer FK_SUCURSAL;
    private Integer FK_EMPLEADO;
    private String USU_USUARIO;
    private String USU_CLAVE;
    private String USU_PARAMETRO;
    private String USU_CODIGO;
    private String USU_CREACION;
    private String USU_CREADOR;
    private String USU_IP;
    private String USU_ACTIVIDAD;
    private String USU_ESTADO;

    public USUARIO() {
    }

    public USUARIO(String USU_USUARIO, String USU_CLAVE) {
        this.USU_USUARIO = USU_USUARIO;
        this.USU_CLAVE = USU_CLAVE;
    }

    public USUARIO(Integer ID_USUARIO) {
        this.ID_USUARIO = ID_USUARIO;
    }

    public Integer getID_USUARIO() {
        return ID_USUARIO;
    }

    public void setID_USUARIO(Integer ID_USUARIO) {
        this.ID_USUARIO = ID_USUARIO;
    }

    public Integer getFK_SUCURSAL() {
        return FK_SUCURSAL;
    }

    public void setFK_SUCURSAL(Integer FK_SUCURSAL) {
        this.FK_SUCURSAL = FK_SUCURSAL;
    }

    public Integer getFK_EMPLEADO() {
        return FK_EMPLEADO;
    }

    public void setFK_EMPLEADO(Integer FK_EMPLEADO) {
        this.FK_EMPLEADO = FK_EMPLEADO;
    }

    public String getUSU_USUARIO() {
        return USU_USUARIO;
    }

    public void setUSU_USUARIO(String USU_USUARIO) {
        this.USU_USUARIO = USU_USUARIO;
    }

    public String getUSU_CLAVE() {
        return USU_CLAVE;
    }

    public void setUSU_CLAVE(String USU_CLAVE) {
        this.USU_CLAVE = USU_CLAVE;
    }

    public String getUSU_PARAMETRO() {
        return USU_PARAMETRO;
    }

    public void setUSU_PARAMETRO(String USU_PARAMETRO) {
        this.USU_PARAMETRO = USU_PARAMETRO;
    }

    public String getUSU_CODIGO() {
        return USU_CODIGO;
    }

    public void setUSU_CODIGO(String USU_CODIGO) {
        this.USU_CODIGO = USU_CODIGO;
    }

    public String getUSU_CREACION() {
        return USU_CREACION;
    }

    public void setUSU_CREACION(String USU_CREACION) {
        this.USU_CREACION = USU_CREACION;
    }

    public String getUSU_CREADOR() {
        return USU_CREADOR;
    }

    public void setUSU_CREADOR(String USU_CREADOR) {
        this.USU_CREADOR = USU_CREADOR;
    }

    public String getUSU_IP() {
        return USU_IP;
    }

    public void setUSU_IP(String USU_IP) {
        this.USU_IP = USU_IP;
    }

    public String getUSU_ACTIVIDAD() {
        return USU_ACTIVIDAD;
    }

    public void setUSU_ACTIVIDAD(String USU_ACTIVIDAD) {
        this.USU_ACTIVIDAD = USU_ACTIVIDAD;
    }

    public String getUSU_ESTADO() {
        return USU_ESTADO;
    }

    public void setUSU_ESTADO(String USU_ESTADO) {
        this.USU_ESTADO = USU_ESTADO;
    }

}
