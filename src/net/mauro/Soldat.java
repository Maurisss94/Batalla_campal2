package net.mauro;

import acm.graphics.GImage;

public class Soldat {

    GImage imatge ;
    int velocitat;
    boolean haArribat;
    double desti;
    

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
	
	public boolean isHaArribat() {
		return haArribat;
	}
	public void setHaArribat(boolean haArribat) {
		this.haArribat = haArribat;
	}
	
	public double getDesti() {
		return desti;
	}
	public void setDesti(double desti) {
		this.desti = desti;
	}
	public void mouSoldat(){
		
		this.getImatge().move(velocitat, 0);
		this.getImatge().pause(10);
		
	}
	public boolean SoldatArriba(Camp pissarra){
		
		if(this.getImatge().getX()> pissarra.getWIDTH()-this.getImatge().getWidth()){
			this.haArribat = true;
			return true;
		}else{
			this.haArribat = false;
			return false;
		}
	}
	
	
	
		
	}
	





