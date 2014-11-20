package net.mauro;

import java.util.ArrayList;
import java.util.Random;

public class Exercit {

    ArrayList<Soldat> soldatsExercit;
    int ubicacio;

    Exercit(){

    }
    public Exercit(ArrayList<Soldat> soldats, int ubicacioExercit){
        this.soldatsExercit = soldats;
        this.ubicacio = ubicacioExercit;
    }
    public int getUbicacio() {
        return ubicacio;
    }
    public void setUbicacio(int ubicacio) {
        this.ubicacio = ubicacio;
    }

    public void posiciona(double x, double y){


        if(this.ubicacio == 1){
            for(int i=0;i<soldatsExercit.size();i++){
                soldatsExercit.get(i).vesA(x, y);
            }
        }
        if(this.ubicacio == 2){
            for(int i=0;i<soldatsExercit.size();i++){
                soldatsExercit.get(i).vesA(x-soldatsExercit.get(i).getImatge().getWidth(), y);
            }
        }

    }

    public void formar(Camp pissarra){

    	double y = 0.0;
    	double x = 0.0;
        if(this.ubicacio ==1){

        	soldatsExercit.get(0).vesA(0, 0);
            for(int i=0;i<soldatsExercit.size();i++){
                
                
                	if(y < pissarra.getHEIGHT()-soldatsExercit.get(0).getImatge().getHeight()-100 ){
                		soldatsExercit.get(i).vesA(x, y);
                		y +=soldatsExercit.get(0).getImatge().getHeight();
                		
                		
                    	
                	}else{
                		soldatsExercit.get(i).vesA(x, y);
                		x+=soldatsExercit.get(0).getImatge().getWidth();
                		y =0;
                		
                		
                	}
                	
                	
                }
            }
        
        if(this.ubicacio ==2){

        	
        	double x2 = pissarra.getWIDTH()-soldatsExercit.get(0).getImatge().getWidth();
        	
		    double y2 =0.0;
			soldatsExercit.get(0).vesA(pissarra.getWIDTH(), 0);
			for (int i = 0; i < soldatsExercit.size(); i++) {

				if (y2 < pissarra.getHEIGHT()- soldatsExercit.get(0).getImatge().getHeight() - 100){
						 
					soldatsExercit.get(i).vesA(x2, y2);
					y2 += soldatsExercit.get(0).getImatge().getHeight();

				} else {
					soldatsExercit.get(i).vesA(x2, y2);
					x2 -= soldatsExercit.get(0).getImatge().getWidth();
					y2 = 0;

				}

			}

        }


        }
    
    
    public void MoureExercit(Camp pissarra){
    	
    	Random rn = new Random();
    	
    				int mou = rn.nextInt(soldatsExercit.size());
    				
    				if(!soldatsExercit.get(mou).SoldatArriba(pissarra, this.ubicacio)){
            			soldatsExercit.get(mou).mouSoldat();
            		}else if(this.soldatsArriben()){
            			if(this.ubicacio == 1){
            				this.setUbicacio(2);
            			}else{
            				this.setUbicacio(1);
            			}
            			this.formar(pissarra);
            		}
    		
    		
    	
    	}
    
    public boolean soldatsArriben(){
      int cont=0;
      for(int i=0;i<soldatsExercit.size();i++){
          if(soldatsExercit.get(i).isHaArribat()){
              cont++;
          }
      }

      if(cont ==soldatsExercit.size()){

         return true;
     }
      return false;
 }
    
    public void aplicarVelocitat(){
    	
    	for(int i=0;i<soldatsExercit.size();i++){
    		if(this.getUbicacio() == 1){
    			soldatsExercit.get(i).setVelocitat(10);
    		}else{
    			soldatsExercit.get(i).setVelocitat(-10);
    		}
    	}
    }
    
     
    
    
    
    }





