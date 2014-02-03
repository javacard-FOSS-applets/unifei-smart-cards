package smartsystem;


/**
 * N� gen�rico de uma lista ligada simples.
 * 
 * @author Tiago
 * @see ListaLigada
 */
public class No
{
	/**
	 * Pr�ximo n� da lista.
	 */
	private No proximoNo;

	/**
	 * @return O pr�ximo n� da lista.
	 */
	No getProximoNo()
	{
		return proximoNo;
	}

	/**
	 * Define o pr�ximo n� da lista.
	 * 
	 * @param proximoNo
	 */
	void setProximoNo(No proximoNo)
	{
		this.proximoNo = proximoNo;
	}
}
