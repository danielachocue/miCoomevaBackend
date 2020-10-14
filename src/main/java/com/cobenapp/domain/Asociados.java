package com.cobenapp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="asociado",schema="public")
public class Asociados {

	
	
	@Id	
	@Column(name="documento", nullable=false, unique=true)
	private String documento;
	
	@Column(name="nickname", unique=true)
	private String nickname;
	
	@Column(name="nombre", unique=true)
	private String nombre;
	
	@Column(name="apellido", unique=true)
	private String apellido;
	
	@Column(name="contrasena", unique=true)
	private String contrasena;

	@Column(name="telefono", unique=true)
	private String telefono;
	
	@Column(name="puntos", unique=true)
	private String puntos;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idtipo")
	private TipoDocumentos tipoDocumentos;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "asociado")
	private List<UsoBeneficio> usobeneficios = new ArrayList<UsoBeneficio>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "asociado")
	private List<Preferencias> preferencias = new ArrayList<Preferencias>(0);
	
	
	public Asociados() {
		
	}


	public Asociados(String nickname, String nombre, String apellido, String documento,
			String contrasena, String telefono, String puntos, TipoDocumentos tipoDocumentos,
			List<UsoBeneficio> usobeneficios, List<Preferencias> preferencias) {
		super();

		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.contrasena = contrasena;
		this.telefono = telefono;
		this.puntos = puntos;
		this.tipoDocumentos = tipoDocumentos;
		this.usobeneficios = usobeneficios;
		this.preferencias = preferencias;
	}





	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getDocumento() {
		return documento;
	}


	public void setDocumento(String documento) {
		this.documento = documento;
	}


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getPuntos() {
		return puntos;
	}


	public void setPuntos(String puntos) {
		this.puntos = puntos;
	}


	public TipoDocumentos getTipoDocumentos() {
		return tipoDocumentos;
	}


	public void setTipoDocumentos(TipoDocumentos tipoDocumentos) {
		this.tipoDocumentos = tipoDocumentos;
	}


	public List<UsoBeneficio> getUsobeneficios() {
		return usobeneficios;
	}


	public void setUsobeneficios(List<UsoBeneficio> usobeneficios) {
		this.usobeneficios = usobeneficios;
	}


	public List<Preferencias> getPreferencias() {
		return preferencias;
	}


	public void setPreferencias(List<Preferencias> preferencias) {
		this.preferencias = preferencias;
	}
	
	
	
	
	
}
