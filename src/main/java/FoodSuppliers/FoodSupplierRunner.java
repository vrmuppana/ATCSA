package FoodSuppliers;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FoodSupplierRunner {

	public static void main(String[] args) throws ParseException, FileNotFoundException {
		Scanner sc = new Scanner(new File("src/FoodSuppliers/supplyOrders.dat"));
		int size = sc.nextInt();
		String iter = "";
		FoodSupplier fs = new FoodSupplier();
		
		for (int i = 0; i < size+1; i++) {
			iter=sc.nextLine();
			fs.add(iter);
		}
		Date date = new Date();
		SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");
		date = s.parse("1-9-2010");
		System.out.println(fs.minimumAmountProductInYear(400, "burgers", date));
//		fs.print();
	}

}
