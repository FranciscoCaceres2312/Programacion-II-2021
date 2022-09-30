package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

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
	
	public static ArrayList<Property> modifyProperty(Property prop,String numberCadastralReturn) {
		ArrayList<Property> properti4 = new ArrayList<Property>();
		for(int i=0;i<Model.showsListProperty().size();i++) {
			
			if(Model.showsListProperty().get(i).getCadastralNumber().equals(numberCadastralReturn)) {
				properti4.addAll(showsListProperty());
				properti4.remove(i);
				properti4.add(prop);	
			}
		}
		return properti4;
	}
	
	public static void creatListProperty(Property prop) {
	
		ArrayList<Property> properties = new ArrayList<Property>();
		properties.addAll(Model.showsListProperty());
		properties.add(prop);
		// Optimizacion de recursos tipo array
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
				//properties1.forEach(System.out::println);
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
	
	public static ArrayList<Property> deleteProperty(String numberCadastralReturned) {
		ArrayList<Property> properti2 = new ArrayList<Property>();
		for(int i=0;i<showsListProperty().size();i++) {
			if(showsListProperty().get(i).getCadastralNumber().equals(numberCadastralReturned)) {
				properti2.addAll((ArrayList<Property>)showsListProperty());
				properti2.remove(i);
				System.out.println(" El inmueble fue eliminado. ");
				//properti2.forEach(System.out::println);
	
			}
		}
		return properti2;
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
	//Metodos para la clase Occupant
	
	public static ArrayList<Occupant> getListOccupant(){
		
		ArrayList<Occupant> result = new ArrayList<Occupant>();
		try(FileInputStream file1 = new FileInputStream("dataOccupant.txt");
				ObjectInputStream inputStream = new ObjectInputStream(file1);) {
				
				result = (ArrayList<Occupant>) inputStream.readObject();
			
		}catch(FileNotFoundException e) {
			
			System.out.println(" El archivo de almacenamiento no existe en el disco. ");
			
		}catch(IOException e) {
			
			e.printStackTrace();
			System.out.println(" Se encontro un error de entrada/salida. ");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return result;
	}
	
	public static void creatListOccupant(Occupant occu) {
		
		ArrayList<Occupant> result = new ArrayList<Occupant>();
		//result.addAll(Model.getListOccupant());
		result.add(occu);
		result.trimToSize();
		
		try(FileOutputStream file = new FileOutputStream("dataOccupant.txt");
		    ObjectOutputStream bridge = new ObjectOutputStream(file);){
			
		    bridge.writeObject(result);
		    
		    
		}catch(FileNotFoundException e) {
			
			System.out.println(" El archivo de almacenamiento no existe en el disco. ");
			
		}catch(IOException e) {
			
			e.printStackTrace();
			System.out.println(" Se encontro un error de entrada/salida. ");
		}
		
		System.out.println(" ¡Los datos se han guardado correctamente! ");
		
	}
	
    public static boolean filterOccupant(int dni){
		
		boolean state = false;
		for(int i=0;i< Model.getListOccupant().size();i++) {
			if(Model.getListOccupant().get(i).getDNI() == dni) {
				System.out.println(" El inquilino si existe en el sistema "+"\n");
				state = true;
			}
	    }
		if(state == false) {
			System.out.println(" El Inquilino no existe en el sistema. ");
		}
		return state;
	}
    
    public static ArrayList<Occupant> deleteOccupant(int dni) {
		ArrayList<Occupant> result = new ArrayList<Occupant>();
		for(int i=0;i<getListOccupant().size();i++) {
			if(getListOccupant().get(i).getDNI() == dni) {
				result.addAll((ArrayList<Occupant>)getListOccupant());
				result.remove(i);
				System.out.println(" El inquilino fue eliminado del sistema. ");
	
			}
		}
		return result;
	}
    
    public static void saveChangeOccupant(ArrayList<Occupant> change) {
		
		try(FileOutputStream file = new FileOutputStream("dataOccupant.txt");
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

    public static ArrayList<Occupant> searchOccupant(int dni) {
    	
    	ArrayList<Occupant> result = new ArrayList<Occupant>();
    	for(int i=0;i< Model.getListOccupant().size();i++) {
			if(Model.getListOccupant().get(i).getDNI() == dni) {
				result.addAll(i, Model.getListOccupant());
			}
    	}
    	return result;
    }
}
