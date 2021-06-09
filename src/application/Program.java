package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
	public static void main(String[]args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> prodi = new ArrayList<>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of products : ");
		int n = sc.nextInt();
		
		for(int x = 1; x <= n; x++) {
			System.out.println("Product #" + x + "data :");
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name : ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price : ");
			double price = sc.nextDouble();
			
			if(ch == 'i') {
				System.out.print("Customs fee: ");
				double cust = sc.nextDouble();
				Product prod = new ImportedProduct(name, price, cust);
				prodi.add(prod);
			}else if(ch == 'c') {
				Product prod = new Product(name, price);
				prodi.add(prod);
			}else if(ch == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY) : ");
				Date date = sdf.parse(sc.next());
				Product prod = new UsedProduct(name, price, date);
				prodi.add(prod);
			}else {
				System.out.println("Erro ao digitar");
				break;
			}
		}
		
		System.out.println("PRICE TAGS: ");
		for(Product prod : prodi) {
			System.out.println(prod.priceTag());
		}
	sc.close();	
	}
	

}