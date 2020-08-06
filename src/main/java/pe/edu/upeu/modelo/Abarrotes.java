package pe.edu.upeu.modelo;

public class Abarrotes {
   
  public String CodigoProducto;  
  public String NProducto; 
  public int Cantidad; 
  public String UnitMed;
  public double Precio; 
  
  public String getCodigoProducto(){
      return CodigoProducto;
  }
  public void setCodigoProducto(String CodigoProducto){
      this.CodigoProducto = CodigoProducto;
  }
  public String getNProducto(){
      return NProducto;
  }
  public void setNProducto(String NProducto){
      this.NProducto = NProducto;
  }
  public int getCantidad(){
      return Cantidad;
  }
  public void setCantidad(int Cantidad){
      this.Cantidad = Cantidad;
  }
  public double getPrecio(){
      return Precio;
  }
  public void setPrecio(double Precio){
      this.Precio = Precio;
  }

  public String getUnitMed() {
      return UnitMed;
  }

  public void setUnitMed(String unitMed) {
      UnitMed = unitMed;
  }

  

}