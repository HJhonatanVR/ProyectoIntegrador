package pe.edu.upeu.modelo;

public class Venta {
  public String numeroVenta;
  public String idProducto;    
  public String nombreProducto;
  public int cantidad;
  public double precioUnitario;
  public double precioTotal;


  public String getNumeroVenta() {
      return numeroVenta;
  }

  public void setNumeroVenta(String numeroVenta) {
      this.numeroVenta = numeroVenta;
  }

  public String getIdProducto() {
      return idProducto;
  }

  public void setIdProducto(String idProducto) {
      this.idProducto = idProducto;
  }

  public String getNombreProducto() {
      return nombreProducto;
  }

  public void setNombreProducto(String nombreProducto) {
      this.nombreProducto = nombreProducto;
  }

  public int getCantidad() {
      return cantidad;
  }

  public void setCantidad(int cantidad) {
      this.cantidad = cantidad;
  }

  public double getPrecioUnitario() {
      return precioUnitario;
  }

  public void setPrecioUnitario(double precioUnitario) {
      this.precioUnitario = precioUnitario;
  }

  public double getPrecioTotal() {
      return precioTotal;
  }

  public void setPrecioTotal(double precioTotal) {
      this.precioTotal = precioTotal;
  }

  
}