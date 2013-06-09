package com.alvarolara.webcamburgos;

import com.alvarolara.webcamburgos.R;
import com.alvarolara.webcamburgos.async.CargaXML;
import com.alvarolara.webcamburgos.utiles.Utilidades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Window;

/**
 * Splash con el logo de la aplicacion.
 * @author Alvaro Lara Cano
 *
 */
public class SplashActivity extends Activity {

	/**
	 * Valores para el timmer.
	 */
	private boolean activo = true;
	private int tiempo = 2000;

	/**
	 * Llamado cuando se crea la actividad.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.splash);

		// Tread que controla el tiempo de la pantalla.
		/*Thread splashTread = new Thread() {
			@Override
			public void run() {
				try {
					int waited = 0;
					while (activo && (waited < tiempo)) {
						sleep(100);
						if (activo) {
							waited += 100;
						}
					}
				} catch (InterruptedException e) {
					// do nothing
				} finally {
					
					if (Utilidades.hayInternet(SplashActivity.this, false)) {
						//Parsear el XML.
						new CargaXML(SplashActivity.this, Utilidades.URL_WEBCAMS).execute();
						
					}
					
				}
			}
		};

		// Comenzar el Thread.
		splashTread.start();*/
		
		//new CargaXML(SplashActivity.this, Utilidades.URL_WEBCAMS).execute();
		
		/*Intent in = new Intent(getApplicationContext(),MainActivity.class);
		Log.i("splash", "splash");
		startActivity(in);*/
	}

	/**
	 * Aunque toques la pantalla, que siga mostrando el splash.
	 */
	/*@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			activo = true;
		}
		return true;
	}*/

}