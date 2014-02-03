package smartsystem;

import java.rmi.Remote;
import java.rmi.RemoteException;

import javacard.framework.UserException;

/**
 * Interface de intera��o com um cliente Gerente.
 * 
 * @author Tiago
 */
public interface IGerente extends Remote
{
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
	 * Define um usu�rio e o ativa.
	 * 
	 * @param nome
	 * @return Se a opera��o teve sucesso.
	 * @throws RemoteException
	 */
	public boolean definirUsuario(byte[] nome) throws RemoteException;

	/**
	 * Insere uma aplica��o a ser gerenciada.
	 * 
	 * @param nome
	 * @throws RemoteException
	 */
	public byte inserirAplicacao(byte[] nome) throws RemoteException;

	/**
	 * Remove uma aplica��o.
	 * 
	 * @param id
	 * @return Se a opera��o teve sucesso.
	 * @throws RemoteException
	 */
	public boolean removerAplicacao(byte id) throws RemoteException;

	/**
	 * Obt�m os ids de todas as aplica��es.
	 * 
	 * @return Um vetor de ids, sendo um id por posi��o do vetor.
	 * @throws RemoteException
	 */
	public byte[] getIds() throws RemoteException;

	/**
	 * Obt�m o nome de uma aplica��o a partir de seu id.
	 * 
	 * @param id
	 * @return O nome da aplica��o, ou <code>null</code> se n�o encontrou.
	 * @throws RemoteException
	 */
	public byte[] getNomeAplicacao(byte id) throws RemoteException;

	/**
	 * Ativa uma aplica��o a partir de seu id.
	 * 
	 * @param id
	 * @param ativa
	 * @return Se a opera��o teve sucesso.
	 * @throws RemoteException
	 */
	public boolean ativarAplicacao(byte id, boolean ativa)
			throws RemoteException;
	
	/**
	 * @return Se o usu�rio est� ativo. 
	 * @throws RemoteException
	 */
	public boolean isUsuarioAtivo() throws RemoteException, UserException;
}