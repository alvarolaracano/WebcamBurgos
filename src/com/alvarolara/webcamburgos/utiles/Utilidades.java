package com.alvarolara.webcamburgos.utiles;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

/**
 * Utilidades Varias.
 * 
 * @author Alvaro Lara Cano
 * 
 */
public class Utilidades {

	/**
	 * Constante para almacenar el cache de la aplicacion.
	 */
	public static final String DIRECTORIO_APLICACION = "webcamburgos";

	/**
	 * Constantes para las URLS.
	 * 
	 */
	public static final String URL_WEBCAMS = "http://www.alvarolara.com/android/webcamburgos/webcams.xml";

	/**
	 * Definiciones XML para una WEBCAM.
	 */
	public static final String KEY_WEBCAM = "webcam";
	public static final String KEY_TITULO = "titulo";
	public static final String KEY_FOTO = "foto";
	public static final String KEY_VIDEO = "video";
	public static final String KEY_STREAM = "stream";

	/**
	 * Funcion que comprueba si hay internet o no.
	 * 
	 * @param salir
	 * @param actividad
	 */
	public static boolean hayInternet(Activity actividad, Boolean salir) {
		boolean hayWifi = false;
		boolean hayMobile = false;

		ConnectivityManager cm = (ConnectivityManager) actividad
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo[] netInfo = cm.getAllNetworkInfo();

		for (NetworkInfo ni : netInfo) {
			if (ni.getTypeName().equalsIgnoreCase("wifi"))
				if (ni.isConnected()) {
					hayWifi = true;
				}
			if (ni.getTypeName().equalsIgnoreCase("mobile"))
				if (ni.isConnected()) {
					hayMobile = true;
				}
		}

		// Si no hay wifi o no hay conexión de red, cerramos la aplicación.
		if (hayWifi == false && hayMobile == false) {
			Log.i("Utilidades", "no hay internet");
			Toast.makeText(actividad, "Debe disponer de conexión a internet",
					Toast.LENGTH_LONG).show();
			if (salir)
				((Activity) actividad).finish();
			return false;
		}
		return true;
	}
}
