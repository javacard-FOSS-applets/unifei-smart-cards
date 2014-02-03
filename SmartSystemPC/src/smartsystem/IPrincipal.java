package smartsystem;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface inicial de intera��o com um cliente, para realizar login.
 * 
 * @author Tiago
 */
public interface IPrincipal extends Remote
{
	/**
	 * Tenta fazer login com os dados fornecidos.
	 * 
	 * @param nome
	 * @param senha
	 * @return Um m�dulo de intera��o com o cliente correto, ou <code>null</code>
	 *         se o login estiver incorreto.
	 * @throws RemoteException
	 */
	public IModulo fazerLogin(byte[] nome, byte[] senha) throws RemoteException;
}