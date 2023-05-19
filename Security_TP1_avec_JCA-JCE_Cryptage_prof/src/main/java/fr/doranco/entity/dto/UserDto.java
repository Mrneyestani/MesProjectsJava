package fr.doranco.entity.dto;

public class UserDto {

	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private CartePaiementDto cartePaiementDto;

	public UserDto() {
	}

	public UserDto(String nom, String prenom, String email, String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CartePaiementDto getCartePaiementDto() {
		return cartePaiementDto;
	}

	public void setCartePaiementDto(CartePaiementDto cartePaiementDto) {
		this.cartePaiementDto = cartePaiementDto;
	}

}
