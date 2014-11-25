package net.mauro;
import java.util.ArrayList;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;

/**
 * Classe principal que conté el run.
 * @author mauro
 *
 */
public final class Principal extends GraphicsProgram {

  /**
   * Numero maxim de soldats.
   */
  private static final int NUMERO_SOLDATS = 15;
  /**
   * Alçada del camp.
   */
  private static final int HEIGHT = 400;
  /**
   * Llargada del camp.
   */
  private static final int WIDTH = 1000;
  /**
   * Creem el camp amb una mida.
   */
     private Camp campBatalla = new Camp(WIDTH, HEIGHT);


     /**
      * metode que crea els soldats.
      * @param rutaImatge ruta de on es troba la imatge del soldat.
      * @return un Array de Soldats.
      */
    public ArrayList<Soldat> crearSoldats(final String rutaImatge) {

        ArrayList<Soldat> soldats = new ArrayList<Soldat>();

        for (int i = 0; i < NUMERO_SOLDATS; i++) {
            Soldat soldat1 = new Soldat(new GImage(rutaImatge));
            soldats.add(soldat1);

        }
        return soldats;
    }

    /**
     * Metode que ubica exercits.
     */
    public void ubicarExercits() {


        for (int i = 0; i < campBatalla.getExercits().size(); i++) {
            if (campBatalla.getExercits().get(i).getUbicacio() == 1) {

                campBatalla.getExercits().get(i).posiciona(0.0, 0.0);

            } else {
                campBatalla.getExercits().get(i)
                .posiciona(campBatalla.getWIDTH(), 0.0);


            }

        }
    }
    /**
     * Meotde que pinta els exercits.
     * @param exercits arraylist de exercits.
     */
    public void pintarExercits(final ArrayList<Exercit> exercits) {

        for (int i = 0; i < exercits.size(); i++) {


            ArrayList<Soldat> arraysoldats = exercits.get(i).soldatsExercit;
            for (int j = 0; j < arraysoldats.size(); j++) {

                this.add(arraysoldats.get(j).getImatge());
            }

        }

    }
    /**
     * Metode que forma als Exercits.
     */
    public void formarExercits() {


        for (int i = 0; i < campBatalla.getExercits().size(); i++) {
          campBatalla.getExercits().get(i).formar(campBatalla);
        }

    }
    /**
     * Metode que ordena a moure els exercits.
     */
    public void moureExercits() {



      while (!campBatalla.shaAcabat()) {


        for (int i = 0; i < campBatalla.getExercits().size(); i++) {
          campBatalla.getExercits().get(i).aplicarVelocitat();
          campBatalla.getExercits().get(i).moureExercit(campBatalla);

          campBatalla.getExercits().get(i).comprovarMorts(
          campBatalla.getExercits().get(oponent(i)).soldatsExercit);


        }




      }



    }
    /**
     * Metode que intercanvia les ubicacions dels exercits.
     * @param exercitOponent exercit oponent.
     * @return un 1 o un 0.
     */
    public int oponent(final int exercitOponent) {

      if (exercitOponent == 0) {
        return 1;
      } else {
        return 0;
      }
    }



    /**
     * Metode run, el principal.
     */
    public void run() {

        this.setSize((int) campBatalla.getWIDTH(),
           (int) campBatalla.getHEIGHT());
        Exercit exercit1 = new Exercit(crearSoldats("soldat.png"), 1);
        Exercit exercit2 = new Exercit(crearSoldats("soldat2.png"), 2);
        campBatalla.afegirExercits(exercit1);
        campBatalla.afegirExercits(exercit2);
        ubicarExercits();
        pintarExercits(campBatalla.getExercits());
        formarExercits();
        moureExercits();


    }

}
