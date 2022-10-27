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
					Property property = new Property(Property.idIncrement(), data[0], data[1],
							Integer.parseInt(data[2]), Float.parseFloat(data[3]));
					property.addProperty();
					break;
				case 2:

					int idDel = menuProperty.selectDeleteProperty(Property.getAllProperties());
					Property.deleteProperty(idDel);
					break;
				case 3:

					int idMody = menuProperty.selectmodifyProperty(Property.getAllProperties());
					dataProperty = Property.filterProperty(idMody);
					dataProperty = menuProperty.newProperty(dataProperty);
					Property propertyMody = new Property(Integer.parseInt(dataProperty[0]), dataProperty[1], dataProperty[2],
							Integer.parseInt(dataProperty[3]), Float.parseFloat(dataProperty[4]));
					propertyMody.modifyProperty();
					break;
				case 4:

					MenuProperty.showsAllProperties(Property.getAllProperties());

				}

			}
			if (valueMenuMane == 2) {

				int valueMenuOccupant = menuOccupant.menuManeOccupant();
				switch (valueMenuOccupant) {
				case 1:
					String[] data1 = new String[3];
					data1 = menuOccupant.addOccupant();
					Occupant ocupant = new Occupant(Occupant.idIncrement(), Integer.parseInt(data1[0]), data1[1],
							Integer.parseInt(data1[2]));
					ocupant.addOccupant();
					break;
				case 2:
					int idDel = menuOccupant.selectDeleteOccupant(Occupant.getAllOccupant());
					Occupant.deleteOccupant(idDel);
					break;
				case 3:
					int idMody = menuOccupant.selectmodifyOccupant(Occupant.getAllOccupant());
					dataOccupant = Occupant.filterOccupant(idMody);
					dataOccupant = menuOccupant.newOccupant(dataOccupant);
					Occupant occupantMody = new Occupant(Integer.parseInt(dataOccupant[0]), Integer.parseInt(dataOccupant[1]),
							dataOccupant[2], Integer.parseInt(dataOccupant[3]));
					occupantMody.modifyOccupant();
					break;
				case 4:
					MenuOccupant.showsAllOccupants(Occupant.getAllOccupant());
					break;
				}
			}
			if (valueMenuMane == 3) {
				int[] dataContract = new int[6];
				dataContract = menuContract.AddContract(Occupant.getAllOccupant(), Property.getAllProperties());
				Contract contract = new Contract(Contract.id_Contract(), dataContract[0], dataContract[1],
						dataContract[2], dataContract[3], dataContract[4], dataContract[5]);
				contract.addContract();
			}
			if(valueMenuMane == 4) {
				menuContract.showsAllContract(Contract.getAllContracts());
			}
			if(valueMenuMane == 5) {
				int[] data2 = new int[2];
				data2 = menuReceipt.selectProperty(Property.getAllProperties());
				dataProperty = Property.filterProperty(data2[0]);
				Receipt receipt = new Receipt(Receipt.id_Receipt(),data2[0],data2[1],Float.parseFloat(dataProperty[4]));
			    receipt.addReceipt();
			}

			if (valueMenuMane == 6) {
				MenuReceipt.showsAllReceipt(Receipt.getAllReceipt());
			}
			if (valueMenuMane == 7) {
				state = false;
				vista.endProgram();
			}

		} while (state == true);
	}

}
