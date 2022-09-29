package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Model {
	
	public static boolean filterProperty(String numberCadastralReturn){
		
		boolean state = false;
		for(int i=0;i< Model.showsListProperty().size();i++) {
			if(Model.showsListProperty().get(i).getCadastralNumber().equals(numberCadastralReturn)) {
				System.out.println(" El inmueble si existe "+"\n");
				state = true;
			}
	    }
		return state;
	}
	
	public static void creatListProperty(Property prop) {
	
		ArrayList<Property> properties = new ArrayList<Property>();
		properties.addAll(Model.showsListProperty());
		properties.add(prop);
		properties.trimToSize();
		
		try(FileOutputStream file = new FileOutputStream("Datas.txt");
		    ObjectOutputStream bridge = new ObjectOutputStream(file);){
			
		    bridge.writeObject(properties);
		    
		    
		}catch(FileNotFoundException e) {
			
			System.out.println(" El archivo de almacenamiento no existe en el disco. ");
			
		}catch(IOException e) {
			
			e.printStackTrace();
			System.out.println(" Se encontro un error de entrada/salida. ");
		}
		
		System.out.println(" ¡Los datos se han guardado correctamente! ");
		
	}
	
	public static ArrayList<Property> showsListProperty(){
		
		ArrayList<Property> properties1 = new ArrayList<Property>();
		try(FileInputStream file1 = new FileInputStream("Datas.txt");
				ObjectInputStream inputStream = new ObjectInputStream(file1);) {
				
				properties1 = (ArrayList<Property>) inputStream.readObject();
		}catch(FileNotFoundException e) {
			
			System.out.println(" El archivo de almacenamiento no existe en el disco. ");
			
		}catch(IOException e) {
			
			e.printStackTrace();
			System.out.println(" Se encontro un error de entrada/salida. ");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return properties1;
	}
	
	public static void deleteProperty(String numberCadastralReturned) {
		ArrayList<Property> properti2 = new ArrayList<Property>();
		for(int i=0;i<showsListProperty().size();i++) {
			if(showsListProperty().get(i).getCadastralNumber().equals(numberCadastralReturned)) {
				properti2.addAll((ArrayList<Property>)showsListProperty());
				properti2.remove(i);
				System.out.println(" El inmueble fue eliminado. ");
				properti2.forEach(System.out::println);
	
			}
		}
		Model.saveChange(properti2);
	}
	
	public static void modifyProperty(Property prop,String numberCadastralReturn) {
		ArrayList<Property> properti4 = new ArrayList<Property>();
		for(int i=0;i<Model.showsListProperty().size();i++) {
			
			if(Model.showsListProperty().get(i).getCadastralNumber().equals(numberCadastralReturn)) {
				properti4.addAll(showsListProperty());
				properti4.remove(i);
				properti4.add(prop);	
			}
		}
		Model.saveChange(properti4);
	}
	
	public static void saveChange(ArrayList<Property> change) {
		
		try(FileOutputStream file = new FileOutputStream("Datas.txt");
			    ObjectOutputStream bridgechange = new ObjectOutputStream(file);){
				
			    bridgechange.writeObject(change);
			    
			    
			}catch(FileNotFoundException e) {
				
				System.out.println(" El archivo de almacenamiento no existe en el disco. ");
				
			}catch(IOException e) {
				
				e.printStackTrace();
				System.out.println(" Se encontro un error de entrada/salida. ");
			}
			
			System.out.println(" ¡La modificacion se realizo correctamente! ");
			
	}


}
