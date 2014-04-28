package dados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbc.DBConnection;

public class Cidade {
	private DBConnection dbcConnection;
	private String name;

	public Cidade(DBConnection dbcConnection) {
		super();
		this.dbcConnection = dbcConnection;
	}

	public Cidade(String name) {
		super();
		this.name = name;
	}

	public ArrayList<Cidade> getCidades() {

		ArrayList<Cidade> cidades = new ArrayList<Cidade>();

		ResultSet resultSet = dbcConnection.select("SELECT * FROM Cidade");

		try {
			while (resultSet.next()) {
				String name = resultSet.getString("cidade");
				cidades.add(new Cidade(name));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cidades;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}