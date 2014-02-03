package smartsystem;


/**
 * Lista ligada simples de <code>No</code>s.
 * 
 * @author Tiago
 * @see No
 */
public class ListaLigada
{
	/**
	 * Primeiro n� da lista.
	 */
	private No noPrimeiro;
	/**
	 * Tamanho da lista.
	 */
	private byte tamanho;

	/**
	 * Insere um n� no final da lista.
	 * 
	 * @param noNovo
	 * @return Se a opera��o obteve sucesso.
	 */
	public boolean inserirNoFinal(No noNovo)
	{
		return inserir(noNovo, tamanho);
	}

	/**
	 * Insere um n� em uma posi��o da lista.
	 * 
	 * @param noNovo
	 * @param posicao
	 * @return Se a opera��o obteve sucesso.
	 */
	public boolean inserir(No noNovo, byte posicao)
	{
		// Declara��o de vari�veis.
		No noIterador, noAuxiliar;
		byte contador;

		// Verifica condi��es de inser��o.
		if (noNovo == null)
			return false;

		if (posicao > tamanho || posicao < 0)
			return false;

		// Inser��o no in�cio da lista.
		if (posicao == 0)
		{
			noNovo.setProximoNo(noPrimeiro);
			noPrimeiro = noNovo;

			tamanho++;
			return true;
		}

		// Inser��o no meio da lista.
		noIterador = noPrimeiro;
		noAuxiliar = noIterador.getProximoNo();

		// // Percorre a lista at� a posi��o e insere.
		for (contador = 1; noAuxiliar != null && contador <= posicao; contador++)
		{
			if (contador == posicao)
			{
				noIterador.setProximoNo(noNovo);
				noNovo.setProximoNo(noAuxiliar);

				tamanho++;
				return true;
			}

			noIterador = noAuxiliar;
			noAuxiliar = noAuxiliar.getProximoNo();
		}

		// // Realiza a inser��o no final.
		if (noAuxiliar == null && contador == posicao)
		{
			noIterador.setProximoNo(noNovo);
			noNovo.setProximoNo(null);

			tamanho++;
			return true;
		}

		return false;
	}

	/**
	 * Remove um n� da lista.
	 * 
	 * @param noARemover
	 * @return Se a opera��o obteve sucesso.
	 */
	public boolean remover(No noARemover)
	{
		// Declara��o de vari�veis.
		No noIterador, noAuxiliar;
		byte contador;

		// Verifica condi��es de remo��o.
		if (noARemover == null)
			return false;

		if (noARemover == noPrimeiro)
		{
			noPrimeiro = noPrimeiro.getProximoNo();

			tamanho--;
			return true;
		}

		// Remove o n� da lista.
		noIterador = noPrimeiro;

		// // Pesquisa o n� na lista, e remove.
		for (contador = 0; contador < tamanho; contador++)
		{
			if (noIterador.getProximoNo() == noARemover)
			{
				noAuxiliar = noARemover.getProximoNo();
				noIterador.setProximoNo(noAuxiliar);
				noARemover.setProximoNo(null);

				tamanho--;
				return true;
			}

			noIterador = noIterador.getProximoNo();
		}

		return false;
	}

	/**
	 * @param posicao
	 * @return O n� da posi��o desejada, ou <code>null</code> se n�o encontrou.
	 */
	public No get(byte posicao)
	{
		// Declara��o de vari�veis.
		No noIterador;
		byte contador;

		// Verifica condi��es de obten��o.
		if (posicao >= tamanho)
			return null;

		// Obt�m um n� da lista.
		noIterador = noPrimeiro;
		contador = 0;

		// // Pesquisa o n� da lista, e ao encontrar interrompe a busca.
		for (contador = 0; noIterador != null && contador <= posicao; contador++)
		{
			if (contador == posicao)
				break;
			noIterador = noIterador.getProximoNo();
		}

		return noIterador;
	}

	/**
	 * @return O primeiro n� da lista, ou <code>null</code> se n�o existir.
	 */
	public No getPrimeiro()
	{
		return noPrimeiro;
	}

	/**
	 * @param noIterador
	 * @return O pr�ximo n� da lista, ou <code>null</code> se n�o existir.
	 */
	public No getProximo(No noIterador)
	{
		return noIterador.getProximoNo();
	}

	/**
	 * @return O tamanho da lista.
	 */
	public byte getTamanho()
	{
		return tamanho;
	}

}
