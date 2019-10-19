package api.model.entity;

public class Imagem {
	
	private String nome;
	private String url;
	private String numeroPatrimonio;

	public String getNumeroPatrimonio() {
		return numeroPatrimonio;
	}

	public void setNumeroPatrimonio(String numeroPatrimonio) {
		this.numeroPatrimonio = numeroPatrimonio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Imagem [nome=" + nome + ", url=" + url + ", numeroPatrimonio=" + numeroPatrimonio + "]";
	}
}
