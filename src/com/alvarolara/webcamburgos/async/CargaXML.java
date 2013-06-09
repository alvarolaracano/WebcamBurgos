package com.alvarolara.webcamburgos.async;

import java.util.ArrayList;

import org.w3c.dom.Element;


import com.alvarolara.webcamburgos.clases.Webcam;
import com.alvarolara.webcamburgos.utiles.ParseadorXML;
import com.alvarolara.webcamburgos.utiles.Utilidades;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

/**
 * AsynTask para parsear el XML.
 * @author Alvaro Lara Cano
 *
 */
public class CargaXML extends AsyncTask<Void, Void, Void> {

	/**
	 * Contexto de la Activity.
	 */
	private Context contexto;
	
	/**
	 * URL de donde obtener los datos.
	 */
	private String URL = "";
	
	/**
	 * ProgressDialog cargando datos.
	 */
	private ProgressDialog progress;

	/**
	 * Arraylist para los elementos.
	 */
	ArrayList<Webcam> menuItems;

	/**
	 * Variable donde se guardara el XML.
	 */
	String xml = "";

	/**
	 * Variable para saber si ha habido algun error.
	 */
	boolean error = false;

	
	/**
	 * Constructor del AsycTask.
	 * 
	 * @param contexto
	 */
	public CargaXML(Context contexto, String URL) {
		this.contexto = contexto;
		this.URL = URL;
		Log.i("CargaXML", "entra al carga xml");

		// Preparar el ProgressDialog.
		muestraProgress();
	}
	
	
	/**
	 * Constructor de clase simple.
	 */
	public CargaXML(String URL){
		this.URL = URL;
		
	}

	
	/**
	 * Antes de ejecutarse.
	 */
	@Override
	protected void onPreExecute() {
		progress.show();
	}

	@Override
	protected Void doInBackground(Void... params) {

		Log.i("CargaXML", "proceso en background");
		
		menuItems = parsea();
		
		return null;
	}

	@Override
	/**
	 * Cuando acabe de ejecutarse todo.
	 */
	protected void onPostExecute(Void params) {

		// Ocultar el ProgressDialog.
		if (progress != null && progress.isShowing()) {
			progress.dismiss();
		}

		if (!error) {
			Log.i("CargaXML","llama a la siguiente activity");
			// Llamar a la activity.
			/*Intent in = new Intent(contexto.getApplicationContext(),
					WebcamListaActivity.class);
			in.putExtra("xml", menuItems);
			contexto.startActivity(in);*/

		}
	}
	
	
	/**
	 * Parsea los objetos.
	 * @return menuItems
	 */
	public ArrayList<Webcam> parsea(){
		menuItems = new ArrayList<Webcam>();

		ParseadorXML parser = new ParseadorXML(URL, Utilidades.KEY_WEBCAM);

		try {

			// Si la longitud del nodelist es 0 al buscar la clave 'item',
			// lanzamos excepcion para que aparezca ErrorActivity.
			if (parser.getNodeList().getLength() == 0) {
				throw new Exception();
			} else {
				Log.i("CargaXML", "ejecuta el for");
				// Todos los <item>.
				for (int i = 0; i < parser.getNodeList().getLength(); i++) {
					
					//ELemento actual.
					Element e = (Element) parser.getNodeList().item(i);
					
					// Nuevo Objeto auxiliar.
					Webcam aux = new Webcam(parser.getValor(e, Utilidades.KEY_TITULO), parser.getValor(e, Utilidades.KEY_FOTO), parser.getValor(e, Utilidades.KEY_VIDEO), parser.getValor(e, Utilidades.KEY_STREAM));

					// Añadir el Objeto al ArrayList.
					menuItems.add(aux);
				}
				Log.i("CargaXML", "acaba el for");
			}
		} catch (Exception e) {
			error = true;
			
		}
		return menuItems;
	}
	
	
	/**
	 * Muestra el progress.
	 */
	public void muestraProgress(){
		progress = new ProgressDialog(contexto);
		progress.setCancelable(false);
		progress.setMessage("Obteniendo datos...");
		progress.setTitle("Por favor, espere");
		progress.setIndeterminate(true);
	}
	
	
	/**
	 * Oculta el progress.
	 */
	private void ocultaProgress(){
		if (progress != null && progress.isShowing()) {
			progress.dismiss();
		}
	}
}
