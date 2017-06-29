package productos;

/**
 *
 * @author Lic. Alexis Ayala Solorio
 */
public class ProductsDetails {
    private String idProducto;
    private String Nombre;
    private String Descripcion;
    private String UnidadMedida;
    private String PrecioUnitario;
    private String UnidadesExistentes;
     
     
     
    public ProductsDetails(){
        super();
    }
    public ProductsDetails(String idProducto, String Nombre,String Descripcion,String UnidadMedida,String PrecioUnitario,
            String UnidadesExistentes) {
        super();
        this.idProducto=idProducto;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.UnidadMedida = UnidadMedida;
        this.PrecioUnitario = PrecioUnitario;
        this.UnidadesExistentes = UnidadesExistentes;
    }
    public String getId(){
        return idProducto;
    }
    public void setId(String idProducto){
        this.idProducto=idProducto;
    }
    public String getName() {
        return Nombre;
    }
    public void setName(String Nombre) {
        this.Nombre=Nombre;
    }
    public String getDescription() {
        return Descripcion;
    }
    public void setDescription(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    public String getUnit() {
        return UnidadMedida;
    }
    public void setUnit(String UnidadMedida) {
        this.UnidadMedida = UnidadMedida;
    }
    public String getPrice() {
        return PrecioUnitario;
    }
    public void setPrice(String PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }
    public String getStock() {
        return UnidadesExistentes;
    }
    public void setStock(String UnidadesExistentes) {
        this.UnidadesExistentes=UnidadesExistentes;
    }
}