package Model;

/**
 *
 * @author perez
 */
public class FACTURA {

    private Integer ID_FACTURA;
    private Integer FK_USUARIO;
    private Integer FK_CLIENTE;
    private Integer FAC_FECHA;
    private Integer FAC_CODIGO;
    private Integer FAC_SUBTOTAL;
    private Integer FAC_TOTAL;
    private Integer FAC_ESTADO;

    public FACTURA() {
    }

    public Integer getID_FACTURA() {
        return ID_FACTURA;
    }

    public void setID_FACTURA(Integer ID_FACTURA) {
        this.ID_FACTURA = ID_FACTURA;
    }

    public Integer getFK_USUARIO() {
        return FK_USUARIO;
    }

    public void setFK_USUARIO(Integer FK_USAURIO) {
        this.FK_USUARIO = FK_USAURIO;
    }

    public Integer getFK_CLIENTE() {
        return FK_CLIENTE;
    }

    public void setFK_CLIENTE(Integer FK_CLIENTE) {
        this.FK_CLIENTE = FK_CLIENTE;
    }

    public Integer getFAC_FECHA() {
        return FAC_FECHA;
    }

    public void setFAC_FECHA(Integer FAC_FECHA) {
        this.FAC_FECHA = FAC_FECHA;
    }

    public Integer getFAC_CODIGO() {
        return FAC_CODIGO;
    }

    public void setFAC_CODIGO(Integer FAC_CODIGO) {
        this.FAC_CODIGO = FAC_CODIGO;
    }

    public Integer getFAC_SUBTOTAL() {
        return FAC_SUBTOTAL;
    }

    public void setFAC_SUBTOTAL(Integer FAC_SUBTOTAL) {
        this.FAC_SUBTOTAL = FAC_SUBTOTAL;
    }

    public Integer getFAC_TOTAL() {
        return FAC_TOTAL;
    }

    public void setFAC_TOTAL(Integer FAC_TOTAL) {
        this.FAC_TOTAL = FAC_TOTAL;
    }

    public Integer getFAC_ESTADO() {
        return FAC_ESTADO;
    }

    public void setFAC_ESTADO(Integer FAC_ESTADO) {
        this.FAC_ESTADO = FAC_ESTADO;
    }

}
