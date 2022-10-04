package Model;

/**
 *
 * @author perez
 */
public class DETALLE_PRODUCTO {

    private Integer ID_DETALLE;
    private Integer FK_PRODUCTO;
    private Double DET_VALOR_COMPRA;
    private Integer DET_FECHA_COMPRA;
    private Integer DET_FECHA_ENTREGA;
    private Integer DET_FECHA_CADUCIDAD;

    public DETALLE_PRODUCTO() {
    }

    public Integer getID_DETALLE() {
        return ID_DETALLE;
    }

    public void setID_DETALLE(Integer ID_DETALLE) {
        this.ID_DETALLE = ID_DETALLE;
    }

    public Integer getFK_PRODUCTO() {
        return FK_PRODUCTO;
    }

    public void setFK_PRODUCTO(Integer FK_PRODUCTO) {
        this.FK_PRODUCTO = FK_PRODUCTO;
    }

    public Double getDET_VALOR_COMPRA() {
        return DET_VALOR_COMPRA;
    }

    public void setDET_VALOR_COMPRA(Double DET_VALOR_COMPRA) {
        this.DET_VALOR_COMPRA = DET_VALOR_COMPRA;
    }

    public Integer getDET_FECHA_COMPRA() {
        return DET_FECHA_COMPRA;
    }

    public void setDET_FECHA_COMPRA(Integer DET_FECHA_COMPRA) {
        this.DET_FECHA_COMPRA = DET_FECHA_COMPRA;
    }

    public Integer getDET_FECHA_ENTREGA() {
        return DET_FECHA_ENTREGA;
    }

    public void setDET_FECHA_ENTREGA(Integer DET_FECHA_ENTREGA) {
        this.DET_FECHA_ENTREGA = DET_FECHA_ENTREGA;
    }

    public Integer getDET_FECHA_CADUCIDAD() {
        return DET_FECHA_CADUCIDAD;
    }

    public void setDET_FECHA_CADUCIDAD(Integer DET_FECHA_CADUCIDAD) {
        this.DET_FECHA_CADUCIDAD = DET_FECHA_CADUCIDAD;
    }

}
