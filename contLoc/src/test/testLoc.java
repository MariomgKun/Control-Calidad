package test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.junit.jupiter.api.Test;
import program.loc;

class testLoc {

	@Test
	public void A2() {
		loc locn = new loc();
		int programa = locn.ContadorLineasLOC("C:/Users/finix/Documents/BUAP/PRIMAVERA 20/CONTROL/A2-PSP/src/reales/");
	}

	@Test
	public void A3() {
		loc locn = new loc();
		int programa = locn.ContadorLineasLOC("C:/Users/finix/Documents/BUAP/PRIMAVERA 20/CONTROL/A3-PSP/src/reales/");
	}
	
	@Test
	public void testLoc() {
		loc locn = new loc();
		int programa = locn.ContadorLineasLOC("C:/Users/finix/Documents/BUAP/PRIMAVERA 20/CONTROL/contLoc/src/program/");
	}
}
