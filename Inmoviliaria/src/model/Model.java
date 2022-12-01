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
import java.util.Collections;
import java.util.List;

public class Model {
	// Metodos para la clase Property
	public void addListProperty(Property prop) {

		ArrayList<Property> properties = new ArrayList<Property>();
		properties.addAll(getListProperty());
		if(properties.contains(prop)) {
			System.out.println("Ya existe ");
		}else {
			properties.add(prop);
			properties.trimToSize();
		}
		try (FileOutputStream file = new FileOutputStream("Properties.txt");
				ObjectOutputStream bridge = new ObjectOutputStream(file);) {

			bridge.writeObject(properties);
			file.close();
			bridge.close();
		} catch (FileNotFoundException e) {

			System.out.println(" El archivo de almacenamiento no existe en el disco. ");

		} catch (IOException e) {

			e.printStackTrace();
			System.out.println(" Se encontro un error de entrada/salida. ");
		}

	}

	public String addProperty(Property properti) {
		String message = "";
		try {
			Connection con = Singlet.getInstance();

			PreparedStatement pst = con.prepareStatement("INSERT INTO property VALUES(?,?,?,?,?)");
			pst.setString(1, properti.id);
			pst.setString(2, properti.cadastralNumber);
			pst.setString(3, properti.direction);
			pst.setInt(4, properti.postcard);
			pst.setFloat(5, properti.price);
			pst.executeUpdate();

		} catch (SQLException e) {
			message = "Error en la coneccion a la base de datos ";
		} finally {
			addListProperty(properti);
		}
		return message + "\n Inmueble añadido exitosamente";
	}

	public String[] filterProperty(String id) {

		String[] proper = new String[5];
		proper[1] = "El objeto no se encontro en el almacenamiento";
		CICLO_1: for (int i = 0; i < getListProperty().size(); i++) {
			if (getListProperty().get(i).getId().equals(id)) {
				proper[0] = getListProperty().get(i).getId();
				proper[1] = getListProperty().get(i).getCadastralNumber();
				proper[2] = getListProperty().get(i).getDirection();
				proper[3] = Integer.toString(getListProperty().get(i).getPostcard());
				proper[4] = Float.toString(getListProperty().get(i).getprice());
				break CICLO_1;
			}
		}
		return proper;
	}

	public String[] filterProperti(String id) {
		String filter[] = new String[5];
		try {
			Connection conn = Singlet.getInstance();
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM property WHERE id_Property=?");
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				filter[0] = rs.getString(1);
				filter[1] = rs.getString("cadastralNumber");
				filter[2] = rs.getString("direction");
				filter[3] = Integer.toString(rs.getInt("postcard"));
				filter[4] = Float.toString(rs.getFloat("price"));
			}
			if (filter[0] == null) {
				filter[1] = " El objeto no se encontro en la DB";
			}
		} catch (SQLException e) {
			System.out.println("Fallo en la coneccion a la base de datos. (SQLException)");
			filter = filterProperty(id);
		}
		return filter;
	}

	public ArrayList<Property> getListProperty() {

		ArrayList<Property> properties1 = new ArrayList<Property>();
		try (FileInputStream file1 = new FileInputStream("Properties.txt");
				ObjectInputStream inputStream = new ObjectInputStream(file1);) {

			properties1 = (ArrayList) inputStream.readObject();
		} catch (FileNotFoundException e) {

			System.out.println(" El archivo de almacenamiento no existe en el disco. ");

		} catch (IOException e) {

			System.out.println(" Se encontro un error de entrada/salida en almacenamiento en disco. ");
		} catch (ClassNotFoundException e) {

			System.out.println(" No se ha encontrado la clase");
		}
		return properties1;
	}

	public ArrayList<Property> getAllProperties() {
		ArrayList<Property> result = new ArrayList<Property>();
		try {
			Connection conn = Singlet.getInstance();
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM property");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Property prop = new Property(rs.getString("id_Property"), rs.getString("cadastralNumber"),
						rs.getString("direction"), rs.getInt("postcard"), rs.getFloat("price"));
				result.add(prop);
			}
		} catch (SQLException e) {

			System.out.println("Fallo en la coneccion a la base de datos");
			result.addAll(getListProperty());
		}
		Collections.sort(result);
		return result;
	}

	public void deleteProperti(String number) {
		ArrayList<Property> properti2 = new ArrayList<Property>();
		for (int i = 0; i < getListProperty().size(); i++) {
			if (getListProperty().get(i).cadastralNumber.equals(number)) {
				properti2.addAll((ArrayList<Property>) getListProperty());
				properti2.remove(i);
				System.out.println(" Se elimino el inmueble del sistema ");
				// properti2.forEach(System.out::println);

			}
		}
		Model.saveChange(properti2);
	}

	public void deleteProperty(String number) {

		try {
			Connection conn = Singlet.getInstance();
			PreparedStatement st = conn.prepareStatement("DELETE FROM `property` WHERE `property`.`cadastralNumber`=?");
			st.setString(1, number);
			st.executeUpdate();
			System.out.println(" Se elimino el inmueble del sistema");
		} catch (SQLException e) {

			System.out.println("Error en la coneccion a la base de datos ");
		} finally {
			deleteProperti(number);
		}

	}

	public void modifyProperty(Property prop, String id) {
		ArrayList<Property> properti4 = new ArrayList<Property>();
		for (int i = 0; i < getListProperty().size(); i++) {

			if (getListProperty().get(i).getId().equals(id)) {

				properti4.addAll(getListProperty());
				properti4.remove(i);
				properti4.add(prop);
			}
		}
		Model.saveChange(properti4);
	}

	public static void saveChange(ArrayList<Property> change) {

		try (FileOutputStream file = new FileOutputStream("Properties.txt");
				ObjectOutputStream bridgechange = new ObjectOutputStream(file);) {

			bridgechange.writeObject(change);

		} catch (FileNotFoundException e) {

			System.out.println(" El archivo de almacenamiento no existe en el disco. ");

		} catch (IOException e) {

			e.printStackTrace();
			System.out.println(" Se encontro un error de entrada/salida. ");
		}

		System.out.println(" ¡La modificacion se realizo correctamente! ");

	}

	public void modifyProperty(Property properti) {

		try {
			Connection con = Singlet.getInstance();

			PreparedStatement pst = con.prepareStatement(
					"UPDATE property SET id_Property=?,cadastralNumber=?,direction=?,postcard=?,price=? WHERE id_Property=?");
			pst.setString(1, properti.id);
			pst.setString(2, properti.cadastralNumber);
			pst.setString(3, properti.direction);
			pst.setInt(4, properti.postcard);
			pst.setFloat(5, properti.price);
			pst.setString(6, properti.id);
			pst.executeUpdate();
			System.out.println(" Inmueble modificado");
		} catch (SQLException e) {
			System.out.println("Error en la coneccion a la base de datos ");
		} finally {
			modifyProperty(properti, properti.id);
		}
	}

	public String synchronizeProperties() {
		String[] properti = new String[5];
		String[] proper = new String[5];
		String message = null;
		if (getAllProperties().equals(getListProperty())) {
			message = " El almacenamiento está sincronizado";
		}

		try {
			
			for (int i = 0; i < getListProperty().size(); i++) {
				Connection conn;
				conn = Singlet.getInstance();
				properti[0] = getListProperty().get(i).getId();
				properti[1] = getListProperty().get(i).getCadastralNumber();
				properti[2] = getListProperty().get(i).getDirection();
				properti[3] = Integer.toString(getListProperty().get(i).getPostcard());
				properti[4] = Float.toString(getListProperty().get(i).getprice());
				PreparedStatement pst = conn.prepareStatement("SELECT * FROM property WHERE id_Property=?");
				pst.setString(1, properti[0]);
				ResultSet rs = pst.executeQuery();
				while(i < getListProperty().size()) {
				while (rs.next()) {
					proper[0] = rs.getString(1);
					//if (proper[0].equals(null)) {
						Property prop = new Property(properti[0], properti[1], properti[2], Integer.parseInt(properti[3]),
								Float.parseFloat(properti[4]));
						addProperty(prop);
						//System.out.println(proper[0]);
					//}else {
						System.out.println(proper[0]+ getListProperty().size());
					//}
				}}

			}
			message = " El almacenamiento está sincronizado";
		} catch (SQLException e) {
			message = "Fallo en la coneccion a la base de datos";
		}
		return message;
	}

	//metodos para la clase Occupant
	public void addOccupant(Occupant ocupant) {
		
		try {
			Connection con = Singlet.getInstance();
		
			PreparedStatement pst = con.prepareStatement("INSERT INTO occupant VALUES(?,?,?,?)");
			pst.setString(1,ocupant.getId());				
			pst.setInt(2,ocupant.getDNI());
			pst.setString(3,ocupant.getName());
			pst.setInt(4,ocupant.getAge());		
			pst.executeUpdate();
			
			} catch (SQLException e) {
				System.out.println(" Fallo al guardar los datos.(SQLException)");
		}finally {
			addListOccupant(ocupant);
			System.out.println(" Inquilino añadido exitosamente");
		}		
	}
	public void addListOccupant(Occupant ocupant) {

		ArrayList<Occupant> ocupants = new ArrayList<Occupant>();
		ocupants.addAll(getListOccupant());
		if(ocupants.contains(ocupant)) {
			
		}else{
			ocupants.add(ocupant);
			ocupants.trimToSize();
		}
		try (FileOutputStream file = new FileOutputStream("Occupants.txt");
				ObjectOutputStream bridge = new ObjectOutputStream(file);) {

			bridge.writeObject(ocupants);
			file.close();
			bridge.close();
		} catch (FileNotFoundException e) {

			System.out.println(" El archivo de almacenamiento no existe en el disco.(FileNotFoundException) ");

		} catch (IOException e) {
			System.out.println(" Se encontro un error de entrada/salida.(IOException) ");
		}

	}
	public ArrayList<Occupant> getAllOccupant() {
    	ArrayList<Occupant> result = new ArrayList<Occupant>();
    	try {
			Connection conn = Singlet.getInstance();
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM occupant");
            ResultSet rs = pst.executeQuery();
            
			while(rs.next()) {
				
				Occupant occu = new Occupant(rs.getString(1), rs.getInt("dni"),rs.getString("name"),rs.getInt("age"));
				result.add(occu);  
			}
		} catch (SQLException e) {
			
			System.out.println(" Fallo al buscar los datos.(SQLException)"); 
			result = getListOccupant();
		}
    	Collections.sort(result);
    	return result; 
    }
	public ArrayList<Occupant> getListOccupant() {

		ArrayList<Occupant> ocupants1 = new ArrayList<Occupant>();
		try (FileInputStream file1 = new FileInputStream("Occupants.txt");
				ObjectInputStream inputStream = new ObjectInputStream(file1);) {

			ocupants1 = (ArrayList) inputStream.readObject();
		} catch (FileNotFoundException e) {

			System.out.println(" El archivo de almacenamiento no existe en el disco. ");

		} catch (IOException e) {

			System.out.println(" Se encontro un error de entrada/salida en almacenamiento en disco. ");
		} catch (ClassNotFoundException e) {

			System.out.println(" No se ha encontrado la clase");
		}
		return ocupants1;
	}
	
	public void deleteOccupant(String id) {

		try {
			Connection conn = Singlet.getInstance();
			PreparedStatement st = conn.prepareStatement(" DELETE FROM occupant WHERE id_Occupant=?");
			st.setString(1, id);
			st.executeUpdate();
			System.out.println(" Se elimino el inquilino del sistema");

		} catch (SQLException e) {
			System.out.println(" Fallo al buscar los datos.(SQLException)");
			
		}finally {
			deleteOccupan(id);
		}

	}

	public void deleteOccupan(String id) {
		ArrayList<Occupant> ocupant2 = new ArrayList<Occupant>();
		for (int i = 0; i < getListOccupant().size(); i++) {
			if (getListOccupant().get(i).getId().equals(id)) {
				ocupant2.addAll((ArrayList<Occupant>) getListOccupant());
				ocupant2.remove(i);
				System.out.println(" Se elimino el inquilino del sistema ");

			}
		}
		saveChangeOccupant(ocupant2);
	}

	public void saveChangeOccupant(ArrayList<Occupant> change) {

		try (FileOutputStream file = new FileOutputStream("Occupants.txt");
				ObjectOutputStream bridgechange = new ObjectOutputStream(file);) {

			bridgechange.writeObject(change);

		} catch (FileNotFoundException e) {

			System.out.println(" El archivo de almacenamiento no existe en el disco. ");

		} catch (IOException e) {

			e.printStackTrace();
			System.out.println(" Se encontro un error de entrada/salida. ");
		}

		System.out.println(" ¡La modificacion se realizo correctamente! ");

	}

	public String[] filterOccupant(String id) {
		String filter[] = new String[4];
		try {
			Connection conn = Singlet.getInstance();
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM occupant WHERE id_occupant=?");
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				filter[0] = rs.getString(1);
				filter[1] = Integer.toString(rs.getInt("dni"));
				filter[2] = rs.getString("name");
				filter[3] = Integer.toString(rs.getInt("age"));
			}
		} catch (SQLException e) {
			System.out.println(" Fallo al buscar datos.(SQLException)");
			filter = filterOccupants(id);
		}
		return filter;
	}

	public String[] filterOccupants(String id) {

		String[] ocupant = new String[4];
		//ocupant[1] = "El objeto no se encontro en el almacenamiento";
		CICLO_2: for (int i = 0; i < getListOccupant().size(); i++) {
			if (getListOccupant().get(i).getId().equals(id)) {
				System.out.println("prubeb");
				ocupant[0] = getListOccupant().get(i).getId();
				ocupant[1] = Integer.toString(getListOccupant().get(i).getDNI());
				ocupant[2] = getListOccupant().get(i).getName();
				ocupant[3] = Integer.toString(getListOccupant().get(i).getAge());
				break CICLO_2;
			
			}
		}
		System.out.println(ocupant[2] +"pruebaaaaa");
		return ocupant;
	}

	public void modifyOccupant(Occupant ocupant) {

		try {
			Connection con = Singlet.getInstance();

			PreparedStatement pst = con
					.prepareStatement("UPDATE occupant SET id_Occupant=?,dni=?,name=?,age=? WHERE id_Occupant=?");
			pst.setString(1, ocupant.getId());
			pst.setInt(2, ocupant.getDNI());
			pst.setString(3, ocupant.getName());
			pst.setInt(4, ocupant.getAge());
			pst.setString(5, ocupant.getId());
			pst.executeUpdate();
			System.out.println(" Inquilino modificado");
		} catch (SQLException e) {
			System.out.println("Error en la coneccion a la base de datos.(SQLException) ");
		}finally {
			modifyOcupantt(ocupant, ocupant.getId());
		}
	}

	public void modifyOcupantt(Occupant ocupant, String id) {
		ArrayList<Occupant> ocupant3 = new ArrayList<Occupant>();
		for (int i = 0; i < getListOccupant().size(); i++) {

			if (getListOccupant().get(i).getId().equals(id)) {

				ocupant3.addAll(getListOccupant());
				ocupant3.remove(i);
				ocupant3.add(ocupant);
			}
		}
		saveChangeOccupant(ocupant3);
	}
	public String synchronizeOccupants() {
		String[] ocupant = new String[5];
		String message = null;
		if (getAllOccupant().equals(getListOccupant())) {
			message = " El almacenamiento está sincronizado";
		}

		try {
			Connection conn;
			conn = Singlet.getInstance();
			for (int i = 0; i < getListOccupant().size(); i++) {
				ocupant[0] = getListOccupant().get(i).getId();
				ocupant[1] = Integer.toString(getListOccupant().get(i).getDNI());  
				ocupant[2] = getListOccupant().get(i).getName();
				ocupant[3] = Integer.toString(getListOccupant().get(i).getAge());
				PreparedStatement pst = conn.prepareStatement("SELECT * FROM occupant WHERE id_Occupant=?");
				pst.setString(1, ocupant[0]);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					ocupant[4] = rs.getString(1);
				}
				if (ocupant[4] == null) {
					Occupant ocu = new Occupant(ocupant[0],Integer.parseInt(ocupant[1]), ocupant[2], Integer.parseInt(ocupant[3]));
					addOccupant(ocu);
				}

			}
			message = " El almacenamiento está sincronizado";
		} catch (SQLException e) {
			message = "Fallo en la coneccion a la base de datos";
		}
		return message;
	}
	
	// metodos para clase Contract
	
	public String addContract(Contract contract) {
		String message = null;
		try {
			Connection con = Singlet.getInstance();

			PreparedStatement pst = con.prepareStatement("INSERT INTO contract VALUES(?,?,?,?,?,?)");
			pst.setString(1, contract.id_Contract);
			pst.setString(2, contract.startDate);
			pst.setString(3, contract.endDate);
			pst.setInt(4, contract.lapso);
			pst.setString(5, contract.id_Occupant);
			pst.setString(6, contract.id_Property);
			pst.executeUpdate();
		} catch (SQLException e) {
			message = "Fallo en la coneccion a la base de datos. (SQLException)";
		}finally {
			message = addListContracts(contract);
		
		}
		return message; 
	}
	public String addListContracts(Contract con) {

		ArrayList<Contract> contracts = new ArrayList<Contract>();
		contracts.addAll(getListContracts());
		contracts.add(con);
		contracts.trimToSize();
		String message = null;
		try (FileOutputStream file = new FileOutputStream("Contracts.txt");
				ObjectOutputStream bridge = new ObjectOutputStream(file);) {

			bridge.writeObject(contracts);
			file.close();
			bridge.close();
			message = " Contrato creado exitosamente";
		} catch (FileNotFoundException e) {

			message = " El archivo de almacenamiento no existe en el disco. ";

		} catch (IOException e) {
			message = " Se encontro un error de entrada/salida.(IOException) ";
		}
		return message;
	}
	
	public ArrayList<Contract> getAllContracts() {
		ArrayList<Contract> result = new ArrayList<Contract>();
		String[] contract = new String[6];
		String[] p = new String[5];
		String[] o = new String[4];
		try {
			Connection conn = Singlet.getInstance();
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM contract");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				contract[0] = rs.getString("id_Contract");
				contract[1] = rs.getString("startDate");
				contract[2] = rs.getString("endDate");
				contract[3] = Integer.toString(rs.getInt("lapso"));
				contract[4] = rs.getString("id_Occupant");
				contract[5] = rs.getString("id_Property");
				  p = filterProperti(contract[5]);
			        Property propert = new Property(p[0],p[1], p[2],
							Integer.parseInt(p[3]), Float.parseFloat(p[4]));
			        o = filterOccupant(contract[4]);
			        Occupant occup = new Occupant(o[0], Integer.parseInt(o[1]),
							o[2], Integer.parseInt(o[3]));
					Contract cont = new Contract(contract[1],contract[2],Integer.parseInt(contract[3]),propert,occup);

					result.add(cont);
			}
		} catch (SQLException e) {
		System.out.println("Fallo en la coneccion a la base de datos. (SQLException)");
		result.addAll(getListContracts());
		String[] pr = new String[5];
		String[] oc = new String[4];
        for(int i = 0; i < result.size(); i++) {
        	contract[0] = getListContracts().get(i).getId_Contract(); 
        	contract[1] = getListContracts().get(i).getStartDate();
        	contract[2] = getListContracts().get(i).getEndDate(); 
        	contract[3] = Integer.toString(getListContracts().get(i).getLapso()); 
        	contract[4] = getListContracts().get(i).getId_Occupant();
        	contract[5] = getListContracts().get(i).getId_Property();
        	System.out.println(getListContracts().get(i).getId_Occupant());
        	pr = filterProperti(contract[5]);
	        Property propert = new Property(pr[0],pr[1], pr[2],
					Integer.parseInt(pr[3]), Float.parseFloat(pr[4]));
	        oc = filterOccupant(contract[4]);
	        Occupant occup = new Occupant(oc[0], Integer.parseInt(oc[1]),
					oc[2], Integer.parseInt(oc[3]));
			Contract contrato = new Contract(contract[1],contract[2],Integer.parseInt(contract[3]),propert,occup);

			result.add(contrato);
        }
		}
			 
		return result;
	}
	public ArrayList<Contract> getListContracts() {

		ArrayList<Contract> contracts1 = new ArrayList<Contract>();
		try (FileInputStream file2 = new FileInputStream("Contracts.txt");
				ObjectInputStream inputStream = new ObjectInputStream(file2);) {

			contracts1 = (ArrayList) inputStream.readObject();
		} catch (FileNotFoundException e) {

			System.out.println(" El archivo de almacenamiento no existe en el disco. ");

		} catch (IOException e) {

			System.out.println(" Se encontro un error de entrada/salida en almacenamiento en disco. ");
		} catch (ClassNotFoundException e) {

			System.out.println(" No se ha encontrado la clase");
		}
		return contracts1;
	}
	public String synchronizeContracts() {
		String[] contract = new String[7];
		String message = null;
		if (getAllContracts().equals(getListContracts())) {
			message = " El almacenamiento está sincronizado";
		}

		try {
			Connection conn;
			conn = Singlet.getInstance();
			for (int i = 0; i < getListContracts().size(); i++) {
				contract[0] = getListContracts().get(i).getId_Contract();
				contract[1] = getListContracts().get(i).getStartDate();  
				contract[2] = getListContracts().get(i).getEndDate();
				contract[3] = Integer.toString(getListContracts().get(i).getLapso());
				contract[4] = getListContracts().get(i).getId_Occupant();
				contract[5] = getListContracts().get(i).getId_Property();
				int yearStart = Integer.parseInt(contract[1].substring(0, 3));
				int monthStart = Integer.parseInt(contract[1].substring(5, 6));
				int dayStart = Integer.parseInt(contract[1].substring(8));
				PreparedStatement pst = conn.prepareStatement("SELECT * FROM contract WHERE id_Contract=?");
				pst.setString(1, contract[0]);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					contract[6] = rs.getString(1);
				
				if (contract[6] == null) {
					Contract con = new Contract(contract[0], yearStart, monthStart, dayStart,
					Integer.parseInt(contract[3]),contract[4],contract[5]);
					addContract(con);
				}
				}
			}
			message = " El almacenamiento está sincronizado";
		} catch (SQLException e) {
			message = "Fallo en la coneccion a la base de datos";
		}
		return message;
	}
	// metodos para clase Receipt 
	
	public void addReceipt(Receipt receipt) {
		try {
			Connection conn = Singlet.getInstance();
			
			PreparedStatement pst = conn.prepareStatement("INSERT INTO receipt Values(?,?,?,?,?)");
		    pst.setString(1, receipt.getReceiptCode());
		    pst.setString(2, receipt.getIdProperty());
		    pst.setString(3, receipt.getDate());
		    pst.setInt(4, receipt.getIva());
		    pst.setFloat(5, receipt.getPrice());
		    pst.executeUpdate();
		    System.out.println(" Recibo generado exitosamente");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print(" Fallo al guardar los datos del recibo ");
		}
	}
	public ArrayList<Receipt> getAllReceipt(){
		ArrayList<Receipt> receipts = new ArrayList<Receipt>();
		Connection conn;
		try {
			conn = Singlet.getInstance();
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM receipt ORDER BY date desc");
	        ResultSet rs = pst.executeQuery();
            while(rs.next()) {
				
				Receipt receip = new Receipt(rs.getString("receiptCode"), rs.getString("id_Property"),rs.getString("date"),rs.getInt("iva"),rs.getFloat("price"));
                receipts.add(receip);            
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return receipts;
	}


}
