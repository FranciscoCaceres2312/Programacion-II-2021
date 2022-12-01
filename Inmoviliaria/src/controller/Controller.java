package controller;

import model.Contract;
import model.Model;
import model.Occupant;
import model.Property;
import model.Receipt;
import views.MenuContract;
import views.MenuOccupant;
import views.MenuProperty;
import views.MenuReceipt;
import views.Vista;

public class Controller {

	public static void main(String[] args) {

		boolean state = true;
		Vista vista = new Vista();
		MenuProperty menuProperty = new MenuProperty();
		MenuOccupant menuOccupant = new MenuOccupant();
		MenuContract menuContract = new MenuContract();
		MenuReceipt menuReceipt = new MenuReceipt();
		Model model = new Model();
		String[] dataProperty = new String[5];
		String[] dataOccupant = new String[4];
		do {

			int valueMenuMane = vista.menuMane();

			if (valueMenuMane == 1) {

				int valueMenuManeProperty = menuProperty.menuManeProperty();

				switch (valueMenuManeProperty) {

				case 1:

					String[] data = new String[4];
					data = menuProperty.addProperty();
					Property property = new Property(Property.idProperty(), data[0], data[1],
							Integer.parseInt(data[2]), Float.parseFloat(data[3]));
					menuProperty.showMessages(model.addProperty(property)); 
					break;
				case 2:

					String idDel = menuProperty.selectDeleteProperty(model.getAllProperties());
					model.deleteProperty(idDel);
					break;
				case 3:
					do {
						String number = menuProperty.selectmodifyProperty(model.getAllProperties());
						dataProperty = model.filterProperti(number);
						if(dataProperty[0] != null) {
							dataProperty = menuProperty.newProperty(dataProperty);
							Property propertyMody = new Property(dataProperty[0],dataProperty[1], dataProperty[2],
									Integer.parseInt(dataProperty[3]), Float.parseFloat(dataProperty[4]));
							model.modifyProperty(propertyMody);
						}else {
							menuProperty.showMessages(dataProperty[1]);
						}
					}while(dataProperty[0] == null);
					break;
				case 4:

					MenuProperty.showsAllProperties(model.getAllProperties());

				}

			}
			if (valueMenuMane == 2) {

				int valueMenuOccupant = menuOccupant.menuManeOccupant();
				switch (valueMenuOccupant) {
				case 1:
					String[] data1 = new String[3];
					data1 = menuOccupant.addOccupant();
					Occupant ocupant = new Occupant(Occupant.idOccupant(), Integer.parseInt(data1[0]), data1[1],
							Integer.parseInt(data1[2]));
					model.addOccupant(ocupant);
					break;
				case 2:
					String idDel = menuOccupant.selectDeleteOccupant(model.getAllOccupant());
					model.deleteOccupant(idDel);
					break;
				case 3:
					String idMody = menuOccupant.selectmodifyOccupant(model.getAllOccupant());
					dataOccupant = model.filterOccupant(idMody);
					dataOccupant = menuOccupant.newOccupant(dataOccupant);
					Occupant occupantMody = new Occupant(dataOccupant[0], Integer.parseInt(dataOccupant[1]),
							dataOccupant[2], Integer.parseInt(dataOccupant[3]));
					model.modifyOccupant(occupantMody);
					break;
				case 4:
					MenuOccupant.showsAllOccupants(model.getAllOccupant());
					break;
				}
			}
			if (valueMenuMane == 3) {
				String[] dataContract = new String[6];
				dataContract = menuContract.AddContract(model.getAllOccupant(), model.getAllProperties());
				Contract contract = new Contract(Contract.idContract(),Integer.parseInt(dataContract[0]), Integer.parseInt(dataContract[1]),
						Integer.parseInt(dataContract[2]), Integer.parseInt(dataContract[3]), dataContract[4], dataContract[5]);
				model.addContract(contract);
			}
			if(valueMenuMane == 4) {
				menuContract.showsAllContract(model.getAllContracts());
				
			}
			if(valueMenuMane == 5) {
				String[] data2 = new String[2];
				data2 = menuReceipt.selectProperty(model.getAllProperties());
				dataProperty = model.filterProperty(data2[0]);
				Receipt receipt = new Receipt(Receipt.id_Receipt(),data2[0],Integer.parseInt(data2[1]),Float.parseFloat(dataProperty[4]));
			    model.addReceipt(receipt);
			}

			if (valueMenuMane == 6) {
				MenuReceipt.showsAllReceipt(model.getAllReceipt());
			}
			if (valueMenuMane == 7) {
				menuProperty.showMessages( model.synchronizeProperties());
			}
			if (valueMenuMane == 8) {
				model.synchronizeOccupants();
			}
			if (valueMenuMane == 9) {
				model.synchronizeContracts();
			}
			if (valueMenuMane == 10) {
				state = false;
				vista.endProgram();
			}

		} while (state == true);
	}

}
