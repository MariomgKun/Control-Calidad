package reales;

public class lista {
	static nodo nuevo;
	static int n;
	
	public lista() {
		nuevo= null;
		n=0;
	}
	
	public boolean isEmpty(){
	   return(nuevo==null)?true:false;
	}
	
	public static int tam() {
		return n;
	}
	
	public static void insertar(double num) {
		if(nuevo == null) {
			nuevo = new nodo(num);
		}else {
			nodo A3 = nuevo;
			nodo x = new nodo(num);
			x.sigui(A3);
			nuevo= x;
		}
		n++;
	}
	
	public static double obtener(int z) {
		int contar= 0;
		nodo siguiente = nuevo;
		while(contar<z) {
			siguiente= siguiente.getSigui();
			contar++;
		}
		return siguiente.getN();
	}
	
	
	
}
