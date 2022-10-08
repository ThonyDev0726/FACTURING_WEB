package Model;

/**
 *
 * @author perez
 */
public class CATEGORIA_PRODUCTO {

    private Integer ID_CATEGORIA;
    private String CAT_DESCRIPCION;
    private String CAT_ESTADO;
    private String CAT_IP;

    public CATEGORIA_PRODUCTO() {
    }

    public Integer getID_CATEGORIA() {
        return ID_CATEGORIA;
    }

    public void setID_CATEGORIA(Integer ID_CATEGORIA) {
        this.ID_CATEGORIA = ID_CATEGORIA;
    }

    public String getCAT_DESCRIPCION() {
        return CAT_DESCRIPCION;
    }

    public void setCAT_DESCRIPCION(String CAT_DESCRIPCION) {
        this.CAT_DESCRIPCION = CAT_DESCRIPCION;
    }

    public String getCAT_ESTADO() {
        return CAT_ESTADO;
    }

    public void setCAT_ESTADO(String CAT_ESTADO) {
        this.CAT_ESTADO = CAT_ESTADO;
    }

    public String getCAT_IP() {
        return CAT_IP;
    }

    public void setCAT_IP(String CAT_IP) {
        this.CAT_IP = CAT_IP;
    }

}
