package Model;

/**
 *
 * @author perez
 */
public class EMPLEADO extends SUCURSAL{

    private Integer ID_EMPLEADO;
    private Integer FK_SUCURSAL;
    private String EMP_NOMBRES;
    private String EMP_APELLIDOS;
    private String EMP_CEDULA;
    private String EMP_EMAIL;
    private String EMP_TELEFONO;
    private String EMP_DIRECCION;
    private String EMP_CUMPLEANOS;
    private String EMP_CREACIOM;
    private String EMP_CREADOR;
    private String EMP_IP;
    private String EMP_ESTADO;
    private String EMP_IMG;

    public EMPLEADO() {
    }

    public Integer getID_EMPLEADO() {
        return ID_EMPLEADO;
    }

    public void setID_EMPLEADO(Integer ID_EMPLEADO) {
        this.ID_EMPLEADO = ID_EMPLEADO;
    }

    public Integer getFK_SUCURSAL() {
        return FK_SUCURSAL;
    }

    public void setFK_SUCURSAL(Integer FK_SUCURSAL) {
        this.FK_SUCURSAL = FK_SUCURSAL;
    }

    public String getEMP_NOMBRES() {
        return EMP_NOMBRES;
    }

    public void setEMP_NOMBRES(String EMP_NOMBRES) {
        this.EMP_NOMBRES = EMP_NOMBRES;
    }

    public String getEMP_APELLIDOS() {
        return EMP_APELLIDOS;
    }

    public void setEMP_APELLIDOS(String EMP_APELLIDOS) {
        this.EMP_APELLIDOS = EMP_APELLIDOS;
    }

    public String getEMP_CEDULA() {
        return EMP_CEDULA;
    }

    public void setEMP_CEDULA(String EMP_CEDULA) {
        this.EMP_CEDULA = EMP_CEDULA;
    }

    public String getEMP_EMAIL() {
        return EMP_EMAIL;
    }

    public void setEMP_EMAIL(String EMP_EMAIL) {
        this.EMP_EMAIL = EMP_EMAIL;
    }

    public String getEMP_TELEFONO() {
        return EMP_TELEFONO;
    }

    public void setEMP_TELEFONO(String EMP_TELEFONO) {
        this.EMP_TELEFONO = EMP_TELEFONO;
    }

    public String getEMP_DIRECCION() {
        return EMP_DIRECCION;
    }

    public void setEMP_DIRECCION(String EMP_DIRECCION) {
        this.EMP_DIRECCION = EMP_DIRECCION;
    }

    public String getEMP_CUMPLEANOS() {
        return EMP_CUMPLEANOS;
    }

    public void setEMP_CUMPLEANOS(String EMP_CUMPLEANOS) {
        this.EMP_CUMPLEANOS = EMP_CUMPLEANOS;
    }

    public String getEMP_CREACIOM() {
        return EMP_CREACIOM;
    }

    public void setEMP_CREACIOM(String EMP_CREACIOM) {
        this.EMP_CREACIOM = EMP_CREACIOM;
    }

    public String getEMP_CREADOR() {
        return EMP_CREADOR;
    }

    public void setEMP_CREADOR(String EMP_CREADOR) {
        this.EMP_CREADOR = EMP_CREADOR;
    }

    public String getEMP_IP() {
        return EMP_IP;
    }

    public void setEMP_IP(String EMP_IP) {
        this.EMP_IP = EMP_IP;
    }

    public String getEMP_ESTADO() {
        return EMP_ESTADO;
    }

    public void setEMP_ESTADO(String EMP_ESTADO) {
        this.EMP_ESTADO = EMP_ESTADO;
    }

    public String getEMP_IMG() {
        return EMP_IMG;
    }

    public void setEMP_IMG(String EMP_IMG) {
        this.EMP_IMG = EMP_IMG;
    }

    @Override
    public String toString() {
        return "EMPLEADO{" +"\n" + "ID_EMPLEADO=" + ID_EMPLEADO +"\n"
                + ", FK_SUCURSAL=" + FK_SUCURSAL +"\n" +
                ", EMP_NOMBRES=" + EMP_NOMBRES +"\n" +
                ", EMP_APELLIDOS=" + EMP_APELLIDOS +"\n" +
                ", EMP_CEDULA=" + EMP_CEDULA +"\n" +
                ", EMP_EMAIL=" + EMP_EMAIL +"\n" +
                ", EMP_TELEFONO=" + EMP_TELEFONO +"\n" +
                ", EMP_DIRECCION=" + EMP_DIRECCION +"\n" +
                ", EMP_CUMPLEANOS=" + EMP_CUMPLEANOS +"\n" +
                ", EMP_CREACIOM=" + EMP_CREACIOM +"\n" +
                ", EMP_CREADOR=" + EMP_CREADOR +"\n" +
                ", EMP_IP=" + EMP_IP +"\n" +
                ", EMP_ESTADO=" + EMP_ESTADO +"\n" +
                ", EMP_IMG=" + EMP_IMG + '}';
    }

}
