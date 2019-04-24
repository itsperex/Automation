package gestionDatos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import gherkin.deps.com.google.gson.Gson;
import managers.FileReaderManager;
import clasesRepresentacionDatos.Cliente;

public class JsonDataReader {
	private final String customerFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath()
			+ "Clientes.json";
	private List<Cliente> clientList;

	public JsonDataReader() {
		clientList = getClientList();
	}

	private List<Cliente> getClientList() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(customerFilePath));
			Cliente[] clients = gson.fromJson(bufferReader, Cliente[].class);
			return Arrays.asList(clients);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + customerFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	public final Cliente getClientName(String nombreCliente) {
		return clientList.stream().filter(x -> x.nombre.equalsIgnoreCase(nombreCliente)).findAny().get();
	}
}