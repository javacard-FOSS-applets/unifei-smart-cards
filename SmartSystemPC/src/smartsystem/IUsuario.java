package smartsystem;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface de intera��o com um cliente Usuario.
 * 
 * @author Tiago
 */
public interface IUsuario extends Remote
{
	/**
	 * Altera seu nome de usu�rio.
	 * 
	 * @param nome
	 * @throws RemoteException
	 */
	public void alterarNome(byte[] nome) throws RemoteException;

	/**
	 * Altera sua senha.
	 * 
	 * @param antigaSenha
	 * @param novaSenha
	 * @return Se a opera��o teve sucesso.
	 * @throws RemoteException
	 */
	public boolean alterarSenha(byte[] antigaSenha, byte[] novaSenha)
			throws RemoteException;

	/**
	 * Insere uma prefer�ncia em uma aplica��o.
	 * 
	 * @param idAplicacao
	 * @param nome
	 * @param valor
	 * @return Se a opera��o teve sucesso.
	 * @throws RemoteException
	 */
	public byte inserirPreferencia(byte idAplicacao, byte[] nome, byte[] valor)
			throws RemoteException;

	/**
	 * Altera uma prefer�ncia de uma aplica��o.
	 * 
	 * @param idAplicacao
	 * @param idPreferencia
	 * @param novoValor
	 * @return Se a opera��o teve sucesso.
	 * @throws RemoteException
	 */
	public boolean alterarPreferencia(byte idAplicacao, byte idPreferencia,
			byte[] novoValor) throws RemoteException;

	/**
	 * Remove uma prefer�ncia de uma aplica��o.
	 * 
	 * @param idAplicacao
	 * @param idPreferencia
	 * @return Se a opera��o teve sucesso.
	 * @throws RemoteException
	 */
	public boolean removerPreferencia(byte idAplicacao, byte idPreferencia)
			throws RemoteException;

	/**
	 * Obt�m os ids das prefer�ncias de uma aplica��o.
	 * 
	 * @param idAplicacao
	 * @return Um vetor com ids, onde cada posi��o � um id.
	 * @throws RemoteException
	 */
	public byte[] getPreferenciaIds(byte idAplicacao) throws RemoteException;

	/**
	 * @param idAplicacao
	 * @param idPreferencia
	 * @return O nome da prefer�ncia de uma aplica��o.
	 * @throws RemoteException
	 */
	public byte[] getPreferenciaNome(byte idAplicacao, byte idPreferencia)
			throws RemoteException;

	/**
	 * @return Se o usu�rio est� ativo.
	 * @throws RemoteException
	 */
	public boolean isAtivo() throws RemoteException;

	/**
	 * Define a atividade de um usu�rio.
	 * 
	 * @param ativo
	 * @throws RemoteException
	 */
	public void setAtivo(boolean ativo) throws RemoteException;

	/**
	 * @return O vCard do usu�rio.
	 * @throws RemoteException
	 */
	public IVCard getVCard() throws RemoteException;
}