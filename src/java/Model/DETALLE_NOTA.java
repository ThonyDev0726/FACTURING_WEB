package Model;

/**
 *
 * @author perez
 */
public class DETALLE_NOTA {

    private Integer ID_DETALLE;
    private Integer FK_NOTA;
    private Integer FK_PRODUCTO;
    private Integer DET_CANTIDAD;
    private Double DET_TOTAL;

    public DETALLE_NOTA() {
    }

    public Integer getID_DETALLE() {
        return ID_DETALLE;
    }

    public void setID_DETALLE(Integer ID_DETALLE) {
        this.ID_DETALLE = ID_DETALLE;
    }

    public Integer getFK_NOTA() {
        return FK_NOTA;
    }

    public void setFK_NOTA(Integer FK_NOTA) {
        this.FK_NOTA = FK_NOTA;
    }

    public Integer getFK_PRODUCTO() {
        return FK_PRODUCTO;
    }

    public void setFK_PRODUCTO(Integer FK_PRODUCTO) {
        this.FK_PRODUCTO = FK_PRODUCTO;
    }

    public Integer getDET_CANTIDAD() {
        return DET_CANTIDAD;
    }

    public void setDET_CANTIDAD(Integer DET_CANTIDAD) {
        this.DET_CANTIDAD = DET_CANTIDAD;
    }

    public Double getDET_TOTAL() {
        return DET_TOTAL;
    }

    public void setDET_TOTAL(Double DET_TOTAL) {
        this.DET_TOTAL = DET_TOTAL;
    }

}
