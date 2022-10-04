package Model;

/**
 *
 * @author perez
 */
public class DETALLE_EMAIL {

    private Integer ID_DETALLE;
    private Integer FK_USUARIO;
    private String DET_RECEPTOR;
    private String DET_MENSAJE;
    private String DET_IP;
    private String DET_FECHA;

    public DETALLE_EMAIL() {
    }

    public Integer getID_DETALLE() {
        return ID_DETALLE;
    }

    public void setID_DETALLE(Integer ID_DETALLE) {
        this.ID_DETALLE = ID_DETALLE;
    }

    public Integer getFK_USUARIO() {
        return FK_USUARIO;
    }

    public void setFK_USUARIO(Integer FK_USUARIO) {
        this.FK_USUARIO = FK_USUARIO;
    }

    public String getDET_RECEPTOR() {
        return DET_RECEPTOR;
    }

    public void setDET_RECEPTOR(String DET_RECEPTOR) {
        this.DET_RECEPTOR = DET_RECEPTOR;
    }

    public String getDET_MENSAJE() {
        return DET_MENSAJE;
    }

    public void setDET_MENSAJE(String DET_MENSAJE) {
        this.DET_MENSAJE = DET_MENSAJE;
    }

    public String getDET_IP() {
        return DET_IP;
    }

    public void setDET_IP(String DET_IP) {
        this.DET_IP = DET_IP;
    }

    public String getDET_FECHA() {
        return DET_FECHA;
    }

    public void setDET_FECHA(String DET_FECHA) {
        this.DET_FECHA = DET_FECHA;
    }

}
