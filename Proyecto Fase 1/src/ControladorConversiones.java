/**
 * 
 * @author Luis Diego Fernández
 * @author Rodrigo Urrutia
 * @author Helmuth Nisal
 * @author Gadhi Rodriguez
 * @author Cristian Perez
 * @author Mercedes Retolaza
 * @version 30.09.2016
 *
 */
import java.util.HashMap;
import java.util.Map;
class ControladorConversiones {

/**
 * Calcula la cantidad de papel utilizando las conversiones
 * @param cant
 * @param lb_kg
 * @return
 */
  public static double calcPaper(double cant, String lb_kg){
      if (lb_kg.equals("lb")){
        cant = Conversiones.lbsAkg(cant);
      }
      cant = Conversiones.kilosAarboles(cant);
      double books = Conversiones.arbolesAlibros(cant);
      return books;
    }
 /**
  * Calcula la cantidad de metal utilizando las conversiones
  * @param cant
  * @param lb_kg
  * @return
  */
    public static double calcMetal(double cant, String lb_kg){
      if (lb_kg.equals("lb")){
        cant = Conversiones.lbsAkg(cant);
      }
      cant = Conversiones.kilosAtoneladas(cant);
      double towers = Conversiones.metalAEiffel(cant);
      return towers;
    }
/**
 * Calcula la cantidad de plastico utilizando las conversiones
 * @param cant
 * @param lb_kg
 * @return
 */
    public static double calcPlastic(double cant, String lb_kg){
      if (lb_kg.equals("lb")){
        cant = Conversiones.lbsAkg(cant);
      }
      double barby = Conversiones.barby(cant);
      return barby;
    }
/**
 * Calcula la cantidad de vidrio utilizando las conversiones
 * @param cant
 * @param lb_kg
 * @return
 */
    public static double calcGlass(double cant, String lb_kg){
      if (lb_kg.equals("lb")){
        cant = Conversiones.lbsAkg(cant);
      }
      cant = Conversiones.kilosAtoneladas(cant);
      double glass = Conversiones.toneladasAlouvre(cant);
      return glass;
    }
/**
 * Obtiene la cantidad especifica de acuerdo al material
 * @param cant
 * @param lb_kg
 * @param material
 * @return
 */
    public double convertir(double cant , String lb_kg, String material){
      double resultado=0;
      material=material.toLowerCase();
      if (material.equals("papel")==true){
        resultado=calcPaper(cant, lb_kg);
      }else if(material.equals("metal")==true){
       resultado=calcMetal(cant, lb_kg);
      }else if(material.equals("plastico")==true){
       resultado=calcPlastic(cant, lb_kg);
      }else if(material.equals("vidrio")==true){
       resultado=calcGlass(cant, lb_kg);
      }
      return resultado;
    }  


}
