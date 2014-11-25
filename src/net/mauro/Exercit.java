package net.mauro;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe Exercit.
 * @author mauro
 *
 */
public class Exercit {


  /**
   * variable que conté la velocitat dels soldats.
   */
  private static final int VELOCITAT_SOLDAT = 10;
  /**
   * Numero per restar a la amplada del camp, per pintar els soldats.
   */
    private static final int NUMERO_RESTA = 100;
    /**
     * Array on es guardaran els soldats.
     */
    ArrayList<Soldat> soldatsExercit;
    /**
     *Variable on es guardara la ubicacio dels exercits.
     */
    private int ubicacio;

    /**
     * Constructor per defecte del exercit.
     */
    Exercit() {

    }
    /**
     * Constructor del Exercit.
     * @param soldats array de soldats.
     * @param ubicacioExercit ubicacio dels exercits
     */
    public Exercit(final ArrayList<Soldat> soldats, final int ubicacioExercit) {
        this.soldatsExercit = soldats;
        this.ubicacio = ubicacioExercit;
    }
    /**
     * Getter de la ubicacio del exercit.
     * @return la ubicacio del exercit.
     */
    public final int getUbicacio() {
        return ubicacio;
    }
    /**
     * Setter de la ubicacio.
     * @param ubicacioExercit ubicacio de l'exercit.
     */
    public final void setUbicacio(final int ubicacioExercit) {
        this.ubicacio = ubicacioExercit;
    }

    /**
     * Metode que posiciona els soldats.
     * @param x posicio x del soldat.
     * @param y posicio y del soldat.
     */
    public final void posiciona(final double x, final double y) {



        if (this.ubicacio == 1) {
            for (int i = 0; i < soldatsExercit.size(); i++) {
                soldatsExercit.get(i).vesA(x, y);
            }
        }
        if (this.ubicacio == 2) {
            for (int i = 0; i < soldatsExercit.size(); i++) {
              double posicioX = x
                  - soldatsExercit.get(i).getImatge().getWidth();
                soldatsExercit.get(i).vesA(posicioX, y);
            }
        }

    }

    /**
     * Metode que forma els soldats, col·loca al camp.
     * @param pissarra camp de batalla.
     */
    public final void formar(final Camp pissarra) {

      double y = 0.0;
      double x = 0.0;

        if (this.ubicacio == 1) {

          soldatsExercit.get(0).vesA(0, 0);
            for (int i = 0; i < soldatsExercit.size(); i++) {


                  if (y < pissarra.getHEIGHT() - soldatsExercit
                      .get(0).getImatge().getHeight() - NUMERO_RESTA) {
                    soldatsExercit.get(i).vesA(x, y);
                    y += soldatsExercit.get(0).getImatge().getHeight();



                  } else {
                    soldatsExercit.get(i).vesA(x, y);
                    x += soldatsExercit.get(0).getImatge().getWidth();
                    y = 0;


                  }


                }
            }

        if (this.ubicacio == 2) {


          double x2 = pissarra.getWIDTH() - soldatsExercit.get(0)
              .getImatge().getWidth();

      soldatsExercit.get(0).vesA(pissarra.getWIDTH(), 0);
      for (int i = 0; i < soldatsExercit.size(); i++) {

        if (y < pissarra.getHEIGHT() - soldatsExercit.get(0)
            .getImatge().getWidth() - NUMERO_RESTA) {

          soldatsExercit.get(i).vesA(x2, y);
          y += soldatsExercit.get(0).getImatge().getHeight();

        } else {
          soldatsExercit.get(i).vesA(x2, y);
          x2 -= soldatsExercit.get(0).getImatge().getWidth();
          y = 0;

        }

      }

        }


        }
    /**
     * Metode que reubica els exercits al camp quan arriben al final.
     * @param pissarra camp de batalla.
     */
    public final void reubicarExercits(final Camp pissarra) {

      if (this.soldatsArriben()) {
      if (this.ubicacio == 1) {
        this.setUbicacio(2);
      } else {
        this.setUbicacio(1);
      }
      this.formar(pissarra);
    }

    }



    /**
     * Metode que mou els soldats, per tant l'exercit tambe.
     * @param pissarra camp de batalla.
     */
    public final void moureExercit(final Camp pissarra) {

      Random rn = new Random();

            int mou = rn.nextInt(soldatsExercit.size());

            if (!soldatsExercit.get(mou)
                .soldatArriba(pissarra, this.ubicacio)) {
                  soldatsExercit.get(mou).mouSoldat();

                } else {

                  this.reubicarExercits(pissarra);

                }



      }

    /**
     * Metode que comprova si els soldats han arribat al final del camp.
     * @return true or false, depen de si han arribat.
     */
    public final boolean soldatsArriben() {
      int cont = 0;
      for (int i = 0; i < soldatsExercit.size(); i++) {
          if (soldatsExercit.get(i).isHaArribat()) {
              cont++;
          }
      }

      if (cont == soldatsExercit.size()) {

         return true;
     }
      return false;
 }
    /**
     * Metode que aplica velocitat als soldats.
     */
    public final void aplicarVelocitat() {

      for (int i = 0; i < soldatsExercit.size(); i++) {
        if (this.getUbicacio() == 1) {
          soldatsExercit.get(i).setVelocitat(VELOCITAT_SOLDAT);
        } else {
          soldatsExercit.get(i).setVelocitat(-VELOCITAT_SOLDAT);
        }
      }
    }
    /**
     * Metode que mata els soldats.
     * @param atacats array que conté els altres soldats.
     */
    public final void comprovarMorts(final ArrayList<Soldat> atacats) {

      for (int i = atacats.size() - 1; i >= 0; i--) {

        for (int j = this.soldatsExercit.size() - 1; j >= 0; j--) {

          if (atacats.get(i).morts(soldatsExercit.get(j))) {


              atacats.get(i).getImatge().getParent()
              .remove(atacats.get(i).getImatge());
              atacats.remove(i);
              break;


          }

        }
      }




    }







    }





