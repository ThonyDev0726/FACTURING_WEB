package Model;

/**
 *
 * @author perez
 */
public class PRODUCTO {

    private Integer ID_PRODUCTO;
    private Integer FK_SUCURSAL;
    private Integer FK_PROVEEDOR;
    private Integer FK_CATEGORIA;
    private String SUC_NOMBRE;
    private String PROV_NOMBRE;
    private String CAT_NOMBRE;
    private String PRO_NOMBRE;
    private String PRO_CODIGO;
    private Integer PRO_STOCK;
    private Double PRO_VALOR_FABRICA;
    private Double PRO_VALOR_UNITARIO;
    private Integer PRO_GANANCIA;
    private String PRO_IVA_TIPO;
    private String PRO_USO;
    private String PRO_IMG1;
    private String PRO_IMG2;
    private String PRO_IMG3;
    private String PRO_IMG4;
    private String PRO_CREACION;
    private String PRO_CREADOR;
    private String PRO_IP;
    private String PRO_ESTADO;

    public PRODUCTO() {
    }

    public Integer getID_PRODUCTO() {
        return ID_PRODUCTO;
    }

    public void setID_PRODUCTO(Integer ID_PRODUCTO) {
        this.ID_PRODUCTO = ID_PRODUCTO;
    }

    public Integer getFK_SUCURSAL() {
        return FK_SUCURSAL;
    }

    public void setFK_SUCURSAL(Integer FK_SUCURSAL) {
        this.FK_SUCURSAL = FK_SUCURSAL;
    }

    public Integer getFK_PROVEEDOR() {
        return FK_PROVEEDOR;
    }

    public void setFK_PROVEEDOR(Integer FK_PROVEEDOR) {
        this.FK_PROVEEDOR = FK_PROVEEDOR;
    }

    public Integer getFK_CATEGORIA() {
        return FK_CATEGORIA;
    }

    public void setFK_CATEGORIA(Integer FK_CATEGORIA) {
        this.FK_CATEGORIA = FK_CATEGORIA;
    }

    public String getSUC_NOMBRE() {
        return SUC_NOMBRE;
    }

    public void setSUC_NOMBRE(String SUC_NOMBRE) {
        this.SUC_NOMBRE = SUC_NOMBRE;
    }

    public String getPROV_NOMBRE() {
        return PROV_NOMBRE;
    }

    public void setPROV_NOMBRE(String PROV_NOMBRE) {
        this.PROV_NOMBRE = PROV_NOMBRE;
    }

    public String getCAT_NOMBRE() {
        return CAT_NOMBRE;
    }

    public void setCAT_NOMBRE(String CAT_NOMBRE) {
        this.CAT_NOMBRE = CAT_NOMBRE;
    }

    public String getPRO_NOMBRE() {
        return PRO_NOMBRE;
    }

    public void setPRO_NOMBRE(String PRO_NOMBRE) {
        this.PRO_NOMBRE = PRO_NOMBRE;
    }

    public String getPRO_CODIGO() {
        return PRO_CODIGO;
    }

    public void setPRO_CODIGO(String PRO_CODIGO) {
        this.PRO_CODIGO = PRO_CODIGO;
    }

    public Integer getPRO_STOCK() {
        return PRO_STOCK;
    }

    public void setPRO_STOCK(Integer PRO_STOCK) {
        this.PRO_STOCK = PRO_STOCK;
    }

    public Double getPRO_VALOR_UNITARIO() {
        return PRO_VALOR_UNITARIO;
    }

    public void setPRO_VALOR_UNITARIO(Double PRO_VALOR_UNITARIO) {
        this.PRO_VALOR_UNITARIO = PRO_VALOR_UNITARIO;
    }

    public Integer getPRO_GANANCIA() {
        return PRO_GANANCIA;
    }

    public void setPRO_GANANCIA(Integer PRO_IVA) {
        this.PRO_GANANCIA = PRO_IVA;
    }

    public String getPRO_IVA_TIPO() {
        return PRO_IVA_TIPO;
    }

    public void setPRO_IVA_TIPO(String PRO_IVA_TIPO) {
        this.PRO_IVA_TIPO = PRO_IVA_TIPO;
    }

    public String getPRO_USO() {
        return PRO_USO;
    }

    public void setPRO_USO(String PRO_USO) {
        this.PRO_USO = PRO_USO;
    }

    public String getPRO_IMG1() {
        return PRO_IMG1;
    }

    public void setPRO_IMG1(String PRO_IMG1) {
        this.PRO_IMG1 = PRO_IMG1;
    }

    public String getPRO_IMG2() {
        return PRO_IMG2;
    }

    public void setPRO_IMG2(String PRO_IMG2) {
        this.PRO_IMG2 = PRO_IMG2;
    }

    public String getPRO_IMG3() {
        return PRO_IMG3;
    }

    public void setPRO_IMG3(String PRO_IMG3) {
        this.PRO_IMG3 = PRO_IMG3;
    }

    public String getPRO_IMG4() {
        return PRO_IMG4;
    }

    public void setPRO_IMG4(String PRO_IMG4) {
        this.PRO_IMG4 = PRO_IMG4;
    }

    public String getPRO_CREACION() {
        return PRO_CREACION;
    }

    public void setPRO_CREACION(String PRO_CREACION) {
        this.PRO_CREACION = PRO_CREACION;
    }

    public String getPRO_CREADOR() {
        return PRO_CREADOR;
    }

    public void setPRO_CREADOR(String PRO_CREADOR) {
        this.PRO_CREADOR = PRO_CREADOR;
    }

    public String getPRO_IP() {
        return PRO_IP;
    }

    public void setPRO_IP(String PRO_IP) {
        this.PRO_IP = PRO_IP;
    }

    public String getPRO_ESTADO() {
        return PRO_ESTADO;
    }

    public void setPRO_ESTADO(String PRO_ESTADO) {
        this.PRO_ESTADO = PRO_ESTADO;
    }

    public Double getPRO_VALOR_FABRICA() {
        return PRO_VALOR_FABRICA;
    }

    public void setPRO_VALOR_FABRICA(Double PRO_VALOR_FABRICA) {
        this.PRO_VALOR_FABRICA = PRO_VALOR_FABRICA;
    }
}
