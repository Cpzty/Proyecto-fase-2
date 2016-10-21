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
public class Conversiones {
/**
 * 
 * @param cant
 * @return
 */
  public static double lbsAkg(double cant){
    return cant * 0.45359237;
  }
/**
 * 
 * @param cant
 * @return
 */
  public static double kgAlbs(double cant){
    return cant / 0.45359237;
  }
/**
 * 
 * @param kilo
 * @return
 */
  public static double kilosAarboles(double kilo){
    return kilo/750.0;
  }
/**
 * 
 * @param arb
 * @return
 */
  public static double arbolesAlibros(double arb){
    return arb * 945.0;
  }
/**
 * 
 * @param kg
 * @return
 */
  public static double kilosAtoneladas(double kg){
    return kg/1000.0;
  }
/**
 * 
 * @param toneladas
 * @return
 */
  public static double toneladasAlouvre(double toneladas){
    return ((toneladas/180.0)*100.0);
  }
/**
 * 
 * @param toneladas
 * @return
 */
  public static double metalAEiffel(double toneladas){
    return (toneladas/1000.0) * 100.0;
  }

/**
 * 
 * @param kg
 * @return
 */
  public static double barby(double kg){
    return kg / 0.38;
  }
}
