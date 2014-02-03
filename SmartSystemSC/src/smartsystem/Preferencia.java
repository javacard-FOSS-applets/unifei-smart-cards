package smartsystem;


/**
 * Representa uma prefer�ncia de uma aplica��o.
 * 
 * @author Tiago
 */
public class Preferencia extends No
{
	/**
	 * Identificador da prefer�ncia.
	 */
	private byte id;
	/**
	 * Nome da prefer�ncia.
	 */
	private byte[] nome;
	/**
	 * Valor da prefer�ncia.
	 */
	private byte[] valor;

	/**
	 * Construtor.
	 * 
	 * @param id
	 * @param nome
	 * @param valor
	 */
	public Preferencia(byte id, byte[] nome, byte[] valor)
	{
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}

	public byte getId()
	{
		return id;
	}

	public byte[] getNome()
	{
		return nome;
	}

	public byte[] getValor()
	{
		return valor;
	}

	public void setValor(byte[] valor)
	{
		this.valor = valor;
	}

}
