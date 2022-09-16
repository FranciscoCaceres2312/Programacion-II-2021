package controller;

import java.util.ArrayList;

import model.Model;
import model.Property;
import views.MenuOccupant;
import views.MenuProperty;
import views.Vista;

public class Controller {

	public static void main(String[] args) {
		
		boolean state = true;
		do {
			
		    int valueMenuMane = Vista.menuMane();
		
			if(valueMenuMane == 1) {
				
				int valueMenuManeProperty = MenuProperty.menuManeProperty();
				
				switch(valueMenuManeProperty) {
				
				case 1:
					
					String[] data = new String[4];
				    data = MenuProperty.addProperty();
				    Property property = new Property(data[0],data[1],Integer.parseInt(data[2]),Float.parseFloat(data[3]));
				    Model.creatListProperty(property);
				    
				    break;
				case 2:
					
					String numberCadastralReturned = MenuProperty.selectDeleteProperty();
					boolean returnCD = Model.filterProperty(numberCadastralReturned);
					if(returnCD == true) {
						boolean returnDC = MenuProperty.confirmDelete(numberCadastralReturned);
						if(returnDC == true) {
							ArrayList<Property> properti3 = new ArrayList<>();
							properti3 = Model.deleteProperty(numberCadastralReturned);
							Model.saveChange(properti3);
						}
					}else {
						System.out.println(" No se ha encontrado este inmueble.");
					}
					break;
				case 3:
					
					String cadastralNumberReturned = MenuProperty.selectmodifyProperty();
					boolean stateFilter = Model.filterProperty(cadastralNumberReturned);
					if(stateFilter == true) {
						ArrayList<Property> properti5 = new ArrayList<Property>();
						String[] newData = new String[4];
						newData = MenuProperty.addProperty();
						Property properti = new Property(newData[0],newData[1],Integer.parseInt(newData[2]),Float.parseFloat(newData[3]));
						properti5 = Model.modifyProperty(properti,cadastralNumberReturned);
						Model.saveChange(properti5);
					}
					break;
				case 4: 
					
					ArrayList<Property> showsList = new ArrayList<Property>();
					showsList.addAll(Model.showsListProperty());
					//showsList.trimToSize();
					showsList.forEach(System.out::println);
				
				}
				
			}else {
				if(valueMenuMane == 2){
				MenuOccupant.menuManeOccupant();
			    }else {
			    	if(valueMenuMane == 3) {
			    		state = false;
			    		System.out.println(" El programa ha finalizado");
			    	}
			    }
			}
		}while(state == true);
	}
		
}
