package model;

public class Usuario {
	private Integer id;
	private String nome;
	private String email;
	private String sexo;
	private String dt_nascimento;
	private String cep;
	private String uf;
	private String logradouro;
	private String cidade;
	
	//Construtor vazio 
	public Usuario() {
	}
	
	//Construtor cheio
	public Usuario(Integer id, String nome, String email, String sexo, String dt_nascimento, String cep, String uf,
			String logradouro, String cidade) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.sexo = sexo;
		this.dt_nascimento = dt_nascimento;
		this.cep = cep;
		this.uf = uf;
		this.logradouro = logradouro;
		this.cidade = cidade;
	}

	//Métodos get e set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getNome() {
		return nome;
	}

	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDt_nascimento() {
		return dt_nascimento;
	}

	public void setDt_nascimento(String dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
}
