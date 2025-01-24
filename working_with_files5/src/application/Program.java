package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Product;
 
public class Program {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
 
		List<Product> list = new ArrayList<>(); //criando a lista de produtos
	
		System.out.println("Enter file path: ");
		String sourceFileStr = sc.nextLine(); //inserindo o caminho do arquivo source
	
		File sourceFile = new File(sourceFileStr); 
		String sourceFolderStr = sourceFile.getParent(); 
		
		boolean success = new File(sourceFolderStr + "\\out").mkdir(); //criando a subpasta out 
	 	System.out.println("Directory created successfully: "+ success);
	 	
	 	String targetFileStr = sourceFolderStr + "\\out\\summary.csv"; //criando o arquivo de saída na subpasta
	 	
	 	try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) { //leitura do arquivo source
	 		
	 		String itemCsv = br.readLine();
	 		
 			while (itemCsv != null) { //leitura das linhas do arquivo
 				
 				String[] fields = itemCsv.split(","); //lendo os item separando por vírgula
 				String name = fields[0]; //campo 1 
 				double price = Double.parseDouble(fields[1]); //campo 2
 				int quantity = Integer.parseInt(fields[2]); //campo 3
 				
 				list.add(new Product(name, price, quantity)); //adicionando lista de produtos
 				
 				itemCsv = br.readLine(); //leitura da próxima linha
 			}
 			
 			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr, true))) { //criando o arquivo de saída 
 				
 				for (Product item : list) { //percorrendo a lista
 					bw.write(item.getName() + ", " + String.format("%.2f", item.totalPrice())); //reescrevendo o arquivo de saída com os dados (nome, preço total)
 					bw.newLine(); //pular para a próxima linha
 				}
 				
 				System.out.println(targetFileStr + " CREATED");
 				
 			} catch (IOException e) {
 				System.out.println("Error writing file: " + e.getMessage());
 			}
	 		
	 	} catch (IOException e) {
	 		System.out.println("Error writing file: " + e.getMessage());
	 	}
	
	sc.close();
	}
}