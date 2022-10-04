package Model;

/**
 *
 * @author perez
 */
public class NOTA_VENTA {

    private Integer ID_NOTA;
    private Integer FK_USUARIO;
    private Integer FK_CLIENTE;
    private Integer NOT_FECHA;
    private Integer NOT_CODIGO;
    private Integer NOT_SUBTOTAL;
    private Integer NOT_TOTAL;
    private Integer NOT_ESTADO;

    public NOTA_VENTA() {
    }

    public Integer getID_NOTA() {
        return ID_NOTA;
    }

    public void setID_NOTA(Integer ID_NOTA) {
        this.ID_NOTA = ID_NOTA;
    }

    public Integer getFK_USUARIO() {
        return FK_USUARIO;
    }

    public void setFK_USUARIO(Integer FK_USUARIO) {
        this.FK_USUARIO = FK_USUARIO;
    }

    public Integer getFK_CLIENTE() {
        return FK_CLIENTE;
    }

    public void setFK_CLIENTE(Integer FK_CLIENTE) {
        this.FK_CLIENTE = FK_CLIENTE;
    }

    public Integer getNOT_FECHA() {
        return NOT_FECHA;
    }

    public void setNOT_FECHA(Integer NOT_FECHA) {
        this.NOT_FECHA = NOT_FECHA;
    }

    public Integer getNOT_CODIGO() {
        return NOT_CODIGO;
    }

    public void setNOT_CODIGO(Integer NOT_CODIGO) {
        this.NOT_CODIGO = NOT_CODIGO;
    }

    public Integer getNOT_SUBTOTAL() {
        return NOT_SUBTOTAL;
    }

    public void setNOT_SUBTOTAL(Integer NOT_SUBTOTAL) {
        this.NOT_SUBTOTAL = NOT_SUBTOTAL;
    }

    public Integer getNOT_TOTAL() {
        return NOT_TOTAL;
    }

    public void setNOT_TOTAL(Integer NOT_TOTAL) {
        this.NOT_TOTAL = NOT_TOTAL;
    }

    public Integer getNOT_ESTADO() {
        return NOT_ESTADO;
    }

    public void setNOT_ESTADO(Integer NOT_ESTADO) {
        this.NOT_ESTADO = NOT_ESTADO;
    }

}
