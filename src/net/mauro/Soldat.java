package net.mauro;

import acm.graphics.GImage;

public class Soldat {

    GImage imatge ;
    int velocitat;
    boolean haArribat;
    

    Soldat(){

    }
    public Soldat(GImage imatge){
        this.imatge = imatge;

    }
    public GImage getImatge() {
        return imatge;
    }
    public void setImatge(GImage imatge) {
        this.imatge = imatge;
    }

    public void vesA(double x, double y){

        imatge.setLocation(x, y);
    }
    
    public int getVelocitat() {
		return velocitat;
	}
	public void setVelocitat(int velocitat) {
		this.velocitat = velocitat;
	}
	
	
    
	
	public void mouSoldat(){
		
		this.getImatge().move(velocitat, 0);
		this.getImatge().pause(10);
		
	}
	public void arribaFinal(Camp camp, int ubicacio){
		
		if(ubicacio == 1){
			if(this.getImatge().getX() <= camp.getWIDTH()){
				
			}
		}
		
	}




}
