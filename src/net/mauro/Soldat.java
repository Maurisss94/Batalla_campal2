package net.mauro;

import acm.graphics.GImage;
import acm.graphics.GRectangle;

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
	
	public boolean isHaArribat() {
		return haArribat;
	}
	public void setHaArribat(boolean haArribat) {
		this.haArribat = haArribat;
	}
	
	
	public void mouSoldat(){
		
		this.getImatge().move(velocitat, 0);
		this.getImatge().pause(10);
		
	}
	public boolean SoldatArriba(Camp pissarra, int ubicacio){
		
		
		if(ubicacio == 1){
			if(this.getImatge().getX()> pissarra.getWIDTH()-this.getImatge().getWidth()){
				this.haArribat = true;
				return true;
			}else{
				this.haArribat = false;
				return false;
			}
		}else{
			if(this.getImatge().getX() <= 0){
				this.haArribat = true;
				return true;
			}else{
				this.haArribat = false;
				return false;
			}
		}
		
	}
	public boolean Morts(Soldat soldatEnemic){

        if(this.Rectangle().intersects(soldatEnemic.Rectangle())){
            return true;
        }else{
            return false;
        }


    }
    public GRectangle Rectangle(){
        return getImatge().getBounds();

    }
	
	
	
		
	}
	





