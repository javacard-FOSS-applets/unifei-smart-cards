package smartsystem;


/**
 * Representa uma aplica��o que ter� suas prefer�ncias gerenciadas.
 * 
 * @author Tiago
 */
public class Aplicacao extends No
{
	/**
	 * Indica se a aplica��o est� ativa.
	 */
	private boolean ativa;
	/**
	 * Identificador da aplica��o.
	 */
	private byte id;
	/**
	 * Nome da aplica��o.
	 */
	private byte[] nome;
	/**
	 * Lista de prefer�ncias da aplica��o.
	 */
	private ListaLigada listaPreferencias;

	/**
	 * Construtor.
	 * 
	 * @param id
	 * @param nome
	 * @param ativa
	 */
	public Aplicacao(byte id, byte[] nome, boolean ativa)
	{
		this.ativa = ativa;
		this.id = id;
		this.nome = nome;

		listaPreferencias = new ListaLigada();
	}

	public boolean getAtiva()
	{
		return ativa;
	}

	public byte getId()
	{
		return id;
	}

	public byte[] getNome()
	{
		return nome;
	}

	public void setAtiva(boolean ativa)
	{
		this.ativa = ativa;
	}

	public void setNome(byte[] nome)
	{
		this.nome = nome;
	}

	public ListaLigada getListaPreferencias()
	{
		return listaPreferencias;
	}

}
