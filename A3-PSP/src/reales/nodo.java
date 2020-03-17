package reales;

public class nodo {
	double numero;
	nodo siguiente;
	
	 public nodo(double num){
	    numero=num;
	 }
	 public double getN(){
	    return numero;
	 }
	 
	 public void sigui(nodo sig){
	    siguiente = sig;
	 }
	 public nodo getSigui(){
	    return siguiente;
	 }
}
