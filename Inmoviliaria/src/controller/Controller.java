package controller;

import java.util.ArrayList;

import model.Model;
import model.Occupant;
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
					Property property = new Property(Property.idIncrement(),data[0],data[1],Integer.parseInt(data[2]), Float.parseFloat(data[3]));
				    //Model.creatListProperty(property);
				    property.addProperty();
				    break;
				case 2:
					
					int idDel = MenuProperty.selectDeleteProperty();
					Property.filterProperty(idDel);
					
					/*String numberCadastralReturned = MenuProperty.selectDeleteProperty();
					boolean returnCD = Model.filterProperty(numberCadastralReturned);
					if(returnCD == true) {
						boolean returnDC = MenuProperty.confirmDelete(numberCadastralReturned);
						if(returnDC == true) {
							Model.deleteProperty(numberCadastralReturned);
						}
					}else {
						System.out.println(" No se ha encontrado este inmueble.");
					}*/
					break;
				case 3:
					
					String[] newData = new String[5];
					int idMody = MenuProperty.selectmodifyProperty();
					newData = Property.filterProperty(idMody);
					newData = MenuProperty.newProperty(newData);
					Property propertyMody = new Property(Integer.parseInt(newData[0]),newData[1],newData[2],Integer.parseInt(newData[3]), Float.parseFloat(newData[4]));
					propertyMody.modifyProperty();
					/*String cadastralNumberReturned = MenuProperty.selectmodifyProperty();
					boolean stateFilter = Model.filterProperty(cadastralNumberReturned);
					if(stateFilter == true) {
						String[] newData = new String[5];
						newData = MenuProperty.addProperty();
						Property propertyMody = new Property(Integer.parseInt(newData[0]),newData[1],newData[2],Integer.parseInt(newData[3]), Float.parseFloat(newData[4]));
						Model.modifyProperty(propertyMody,cadastralNumberReturned);
					}*/
					break;
				case 4: 
					
					Property.showsProperty();
					/*ArrayList<Property> showsList = new ArrayList<Property>();
					showsList.addAll(Model.showsListProperty());
					showsList.trimToSize();
					showsList.forEach(System.out::println);*/
				
				}
				
			}else {
				if(valueMenuMane == 2){
					Occupant.idIncrement();
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
