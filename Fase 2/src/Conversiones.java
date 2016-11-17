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
/**Se realizan conversiones 
 * 
 * @param cant
 * @return
 */
  public static double lbsAkg(double cant){
    return cant * 0.45359237;
  }
/**Se realizan conversiones 
 * 
 * @param cant
 * @return
 */
  public static double kgAlbs(double cant){
    return cant / 0.45359237;
  }
/**Se realizan conversiones 
 * 
 * @param kilo
 * @return
 */
  public static double kilosAarboles(double kilo){
    return kilo/750;
  }
/**Se realizan conversiones 
 * 
 * @param arb
 * @return
 */
  public static double arbolesAlibros(double arb){
    return arb * 945.0;
  }
/**Se realizan conversiones 
 * 
 * @param kg
 * @return
 */
  public static double kilosAtoneladas(double kg){
    return kg/1000.0;
  }
/**Se realizan conversiones 
 * 
 * @param toneladas
 * @return
 */
  public static double toneladasAlouvre(double toneladas){
    return ((toneladas/180.0)*100.0);
  }
/**Se realizan conversiones 
 * 
 * @param toneladas
 * @return
 */
  public static double metalAEiffel(double toneladas){
    return (toneladas/1000.0) * 100.0;
  }

/**Se realizan conversiones 
 * 
 * @param kg
 * @return
 */
  public static double barby(double kg){
    return kg / 0.38;
  }
  /**Se realizan conversiones 
   * 
   * @param kg
   * @return
   */
  public static double NuevoPapel(double kg){
	    return kg*3.75;
	  }
  /**Se realizan conversiones 
   * 
   * @param kg
   * @return
   */
  public static double NuevoMetal(double kg){
	    return kg*13.875;
	  }
  /**
   * Se realizan conversiones 
   * @param kg
   * @return
   */
  public static double NuevoPlastico(double kg){
	    return kg*9;
	  }
  /**
   * Se realizan conversiones 
   * @param kg
   * @return
   */
  public static double NuevoVidrio(double kg){
	    return kg*0.186;
	  }
  /**
   * Se realizan conversiones 
   * @param kg
   * @return
   */
  public static double RecicladoPapel(double kg){
	    return kg*0.2;
	  }
  /**
   * Se realizan conversiones 
   * @param kg
   * @return
   */
  public static double RecicladoMetal(double kg){
	    return kg*2.25;
	  }
  /**
   * Se realizan conversiones 
   * @param kg
   * @return
   */
  public static double RecicladoPlastico(double kg){
	    return kg*0.55;
	  }
  /**
   * Se realizan conversiones 
   * @param kg
   * @return
   */
  public static double RecicladoVidrio(double kg){
	    return kg*0.09;
	  }
}
