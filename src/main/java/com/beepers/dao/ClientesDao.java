package com.beepers.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.beepers.interfaces.ClientesInterface;
import com.beepers.pojo.Clientes;
import com.beepers.util.executeQueryBD;

public class ClientesDao implements ClientesInterface{

	executeQueryBD query = new executeQueryBD();
	ResultSet resulSelect;
	@Override
	public List<Clientes> devolverListaClientes(String tipo,String numero) throws Exception {
	
		List<Clientes> cliente = new ArrayList<>();
		
		cliente.add(new Clientes(1,"C", "23445322", "juan","contreras","3160405672","Calle 168A - 73A - 96","BOGOTA"));
        cliente.add(new Clientes(2,"P", "41410371", "raul","pina","3160405672","Calle FALSA - 73 - 96","MEDELLIN"));
        cliente.add(new Clientes(3,"C", "54345621", "german","santos","3160405672","Calle EML - 73B - 96","CALI"));
        
        List<Clientes> clienteEncontrado = buscarClienteTipoNumero(cliente,tipo, numero);

		return clienteEncontrado;
	}
	
	   public List<Clientes> buscarClienteTipoNumero(List<Clientes> cliente,String tipo, String numero) {
			ArrayList<Clientes> list = new ArrayList<>();
		   
		   for (Clientes cliE : cliente) {
	        	
	            if (cliE.getNúmeroDocumento().equalsIgnoreCase(numero)  && cliE.getTipo().equalsIgnoreCase(tipo)) {
	            	Clientes cli = new Clientes();
	            	cli.setTipo(cliE.getTipo());
	    			cli.setNúmeroDocumento(cliE.getNúmeroDocumento());
	    			cli.setPriNombre(cliE.getPriNombre());
	    			cli.setSegNombre(cliE.getSegNombre());
	    			cli.setTelefono(cliE.getTelefono());
	    			cli.setDireccion(cliE.getDireccion());
	    			cli.setCiudad(cliE.getCiudad());
	    			list.add(cli);
	            }
	        }
	        return list; 
	    }

	@Override
	public List<Clientes> devolverClienteById(int id) throws Exception {
		ArrayList<Clientes> list = new ArrayList<>();
		String sql = "select * from clientes where cli_id = '" + id + "' ";
		resulSelect = query.executeSelectBd(sql);
		while (resulSelect.next()) {
			Clientes cli = new Clientes();
        	cli.setTipo(resulSelect.getString("tipo"));
			cli.setNúmeroDocumento(resulSelect.getString("numdoc"));
			cli.setPriNombre(resulSelect.getString("prinombres"));
			cli.setSegNombre(resulSelect.getString("segnombres"));
			cli.setTelefono(resulSelect.getString("telefono"));
			cli.setDireccion(resulSelect.getString("direccion"));
			cli.setCiudad(resulSelect.getString("ciudad"));
			list.add(cli);
		}
		return list;
	}

	@Override
	public Clientes buscarClientePorDato(Clientes datos) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String agregarCliente(Clientes cli) throws Exception {
		// TODO Auto-generated method stub
		String validaIngreso;
		String sql = "insert into  clientes (tipo,numdoc,prinombres,segnombres,telefono"
				+ ",direccion,ciudad) " + "values('" + cli.getTipo() + "','" + cli.getNúmeroDocumento() + "','"
				+ cli.getPriNombre() + "'," + "'" + cli.getSegNombre() + "'," + cli.getTelefono() + "," + cli.getDireccion() + ","
				+ cli.getCiudad() + ")  ";
		
		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			validaIngreso = "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue ingresado De Manera Correcta\"}";
		} else {
			validaIngreso = "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue ingresado De Manera Correcta\"}";
		}
		return validaIngreso;
	}

	@Override
	public String actualizarCliente(Clientes cli) throws Exception {
		String validaIngreso;
		String sql = "Update   clientes SET "
				+ "cli_nombres = '" + cli.getTipo() + "',"
				+ "cli_correo = '" + cli.getNúmeroDocumento() + "',"
				+ "cli_celular = '" + cli.getPriNombre() + "',"
				+ "cli_direccion = '" + cli.getSegNombre() + "',"
				+ "cli_ciudad = '" + cli.getTelefono() + "',"
				+ "cli_estado = '" + cli.getCiudad() + "' "
				+ " WHERE cli_id = " + cli.getId() + " ";
		
		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			validaIngreso = "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue EDITADO De Manera Correcta\"}";
		} else {
			validaIngreso = "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue EDITADO De Manera Correcta\"}";
		}
		return validaIngreso;
	}

	@Override
	public String eliminarCliente(int id) throws Exception {
		String validaIngreso;
		String sql = "Delete from  clientes "
				+ " WHERE cli_id = " + id + " ";

		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			validaIngreso = "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue eliminado De Manera Correcta\"}";
		} else {
			validaIngreso = "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue eliminado De Manera Correcta\"}";
		}
		return validaIngreso;
	}

}
