package smartsystem;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface para um m�dulo do sistema.
 * 
 * @author Tiago
 */
public interface IModulo extends Remote
{
	/**
	 * Tipo de login gerente.
	 */
	public static final byte GERENTE = 0x60;
	/**
	 * Tipo de login usu�rio.
	 */
	public static final byte USUARIO = 0x61;

	/**
	 * @return M�dulo do login.
	 * @throws RemoteException
	 */
	public Remote getModulo() throws RemoteException;

	/**
	 * @return Tipo de login.
	 * @throws RemoteException
	 */
	public byte getTipo() throws RemoteException;

}