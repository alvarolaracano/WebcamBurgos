package com.alvarolara.webcamburgos.clases;

import java.io.Serializable;

public class Webcam implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Titulo.
	 */
	private String titulo;
	
	/**
	 * Foto de la webcam.
	 */
	private String foto;
	
	/**
	 * Video publicitario.
	 */
	private String video;
	
	/**
	 * Stream de la webcam.
	 */
	private String stream;
	
	
	/**
	 * Constructor vacio.
	 */
	public Webcam(){
		
	}

	
	/**
	 * Constructor con parametros.
	 * @param titulo
	 * @param foto
	 * @param video
	 * @param stream
	 */
	public Webcam(String titulo, String foto, String video, String stream) {
		this.titulo = titulo;
		this.foto = foto;
		this.video = video;
		this.stream = stream;
	}

	/**
	 * Devuelve el titulo.
	 * @return titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Establece el titulo.
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Devuelve la foto.
	 * @return foto
	 */
	public String getFoto() {
		return foto;
	}

	/**
	 * Establece la foto.
	 * @param foto
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}

	/**
	 * Devuelve el video.
	 * @return video
	 */
	public String getVideo() {
		return video;
	}

	/**
	 * Establece el video.
	 * @param video
	 */
	public void setVideo(String video) {
		this.video = video;
	}

	/**
	 * Devuelve el stream.
	 * @return stream
	 */
	public String getStream() {
		return stream;
	}

	/**
	 * Establece el stream.
	 * @param stream
	 */
	public void setStream(String stream) {
		this.stream = stream;
	}
	
}
