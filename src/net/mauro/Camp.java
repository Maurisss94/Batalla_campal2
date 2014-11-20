package net.mauro;

import java.util.ArrayList;

public class Camp {

    double HEIGHT;
    double WIDTH;
    ArrayList<Exercit> exercits = new ArrayList<>();

    Camp(){

    }
    public Camp(int width, int height){
        this.WIDTH = width;
        this.HEIGHT = height;

    }
    public double getWIDTH() {
        return WIDTH;
    }
    public void setWIDTH(int wIDTH) {
        WIDTH = wIDTH;
    }
    public double getHEIGHT() {
        return HEIGHT;
    }
    public void setHEIGHT(int hEIGHT) {
        HEIGHT = hEIGHT;
    }

    public ArrayList<Exercit> getExercits() {
        return exercits;
    }
    public void setExercits(ArrayList<Exercit> exercits) {
        this.exercits = exercits;
    }
    public void afegirExercits(Exercit exercitaAfegir){

        exercits.add(exercitaAfegir);

    }
    public boolean shaAcabat(){
    	
    	if(exercits.size() == 0){
    		return true;
    	}else{
    		return false;
    	}
    }





}
