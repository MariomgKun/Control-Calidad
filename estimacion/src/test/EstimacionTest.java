package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import estimacion.insertar;
import estimacion.operaciones;

class EstimacionTest {
	
	//Test de insertar numero de programas con numero 0
	@Test
	void insertar0() throws IOException {
		insertar in = new insertar(); 
		System.out.println("Aqui empieza el test 0");
		in.Insertar(0);
		System.out.println("\nAqui termina el test 0\n");
	}
	
	//Test de insertar numero de programas con numero negativo
		@Test
		void insertarN() throws IOException {
			insertar in = new insertar(); 
			System.out.println("Aqui empieza el test N\n");
			in.Insertar(-1);
			System.out.println("\nAqui termina el test N\n");
		}
		
		//Test de insertar numero de programas con numero negativo
		//Aqui marca el test error por que no se puede insertar letras solo enteros 
		/*@Test
		void insertarABC() throws IOException {
			insertar in = new insertar(); 
			System.out.println("Aqui empieza el test ABC\n");
			in.Insertar(a);
			System.out.println("\nAqui termina el test ABC\n");
		}*/
		
		
		//Test de insertar numero de progrmas mayor a 0
		//Debe insertar el valor de xi y yi con un numero entero mayores a 0
		//De lo contrario el progrma le mandara mensaje de correccion
		@Test
		void insertar1() throws IOException {
			insertar in = new insertar(); 
			System.out.println("Aqui empieza el test 1\n");
			in.Insertar(1);
			System.out.println("\nAqui termina el test 1\n");
		}
	
		
		//Test de insertar datos double a las operaciones
		//xk mayor a 0
		// t1 y t2 cual quier numero diferente a 0
		@Test
		void op1() throws IOException {
			operaciones op = new operaciones(); 
			System.out.println("Aqui empieza el test op1\n");
			op.Operacion(386, 1.108, 1.86);
			System.out.println("\nAqui termina el test op1\n");
		}
		
		//Test de insertar datos double a las operaciones
		//xk igual a 0
		// t1 y t2 cual quier numero diferente a 0
		@Test
		void op2() throws IOException {
			operaciones op = new operaciones(); 
			System.out.println("Aqui empieza el test op2\n");
			op.Operacion(0, 1.108, 1.86);
			System.out.println("\nAqui termina el test op2\n");
		}
		
		//Test de insertar datos double a las operaciones
		//xk mayor a 0
		// t1 cual quier numero diferente a 0 y t2 igual 0
		@Test
		void op3() throws IOException {
			operaciones op = new operaciones(); 
			System.out.println("Aqui empieza el test op3\n");
			op.Operacion(386, 1.108, 0);
			System.out.println("\nAqui termina el test op3\n");
		}
		
		//Test de insertar datos double a las operaciones
		//xk mayor a 0
		// t1 igual a 0 y t2 cual quier numero diferente a 0
		@Test
		void op4() throws IOException {
			operaciones op = new operaciones(); 
			System.out.println("Aqui empieza el test op4\n");
			op.Operacion(386, 0, 1.86);
			System.out.println("\nAqui termina el test op4\n");
		}
	

}
