package net.mauro;
import java.util.ArrayList;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class Principal extends GraphicsProgram {

    Camp campBatalla = new Camp(1000, 400);


    public ArrayList<Soldat> crearSoldats(String rutaImatge){

        ArrayList<Soldat> Soldats = new ArrayList<Soldat>();

        for(int i=0;i<15;i++){
            Soldat soldat1 = new Soldat(new GImage(rutaImatge));
            Soldats.add(soldat1);

        }
        return Soldats;
    }

    public void ubicarExercits(){


        for(int i=0;i<campBatalla.getExercits().size();i++){
            if(campBatalla.getExercits().get(i).getUbicacio() == 1){

                campBatalla.getExercits().get(i).posiciona(0.0, 0.0);

            }else{
                campBatalla.getExercits().get(i).posiciona(campBatalla.getWIDTH(), 0.0);


            }

        }
    }
    public void pintarExercits(ArrayList<Exercit> exercits){

        for(int i=0;i<exercits.size();i++){


            ArrayList<Soldat> arraysoldats = exercits.get(i).soldatsExercit;
            for(int j=0;j<arraysoldats.size();j++){

                this.add(arraysoldats.get(j).getImatge());
            }

        }

    }
    public void formarExercits(){
    	
    	
        for(int i=0;i<campBatalla.getExercits().size();i++){
        	campBatalla.getExercits().get(i).formar(campBatalla);
        }
    	
    }
    public void moureExercits(){
    
    	
    	for(int i=0;i<campBatalla.getExercits().size();i++){
    		campBatalla.getExercits().get(i).MoureExercit(campBatalla);        
            
    	}
    }


    public void run(){



        this.setSize((int)campBatalla.getWIDTH(), (int)campBatalla.getHEIGHT());


        Exercit exercit1 = new Exercit(crearSoldats("soldat.png"), 1);
        Exercit exercit2 = new Exercit(crearSoldats("soldat2.png"),2);

        campBatalla.afegirExercits(exercit1);
        campBatalla.afegirExercits(exercit2);
        ubicarExercits();
        pintarExercits(campBatalla.getExercits());
        formarExercits();
        moureExercits();
        
        
        










    }

}
