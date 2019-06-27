package excelExercise3;

import java.io.IOException;
import java.util.ArrayList;

public class TestSample2 {

	public static void main(String[] args) throws IOException {
		
		Exercise3 e = new Exercise3();
		ArrayList data = e.getData("AddProfile");
		
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
		
		
	}
}
