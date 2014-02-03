package smartsystem;

import java.rmi.RemoteException;

import javacard.framework.service.CardRemoteObject;

/**
 * Implementa��o de Principal.
 * 
 * @author Tiago
 */
public class PrincipalImpl extends CardRemoteObject implements IPrincipal
{
	/**
	 * Lista de logins v�lidos.
	 */
	private ListaLigada listaLogin;

	/**
	 * Construtor.
	 */
	public PrincipalImpl()
	{
		super();

		// Declara��o de vari�veis. 
		GerenteImpl loginGerente;
		UsuarioImpl loginUsuario;
		
		// Inicializa��o.
		listaLogin = new ListaLigada();

		byte[] stringGerente =
		{ 103, 101, 114, 101, 110, 116, 101 };
		byte[] stringUsuario =
		{ 117, 115, 117, 97, 114, 105, 111 };

		// Configura��o dos logins.
		loginGerente = new GerenteImpl(stringGerente, stringGerente, this);
		loginUsuario = new UsuarioImpl(stringUsuario, stringUsuario, loginGerente);

		listaLogin.inserirNoFinal(loginGerente);
		listaLogin.inserirNoFinal(loginUsuario);
	}

	/**
	 * @see modelo.IPrincipal#fazerLogin(byte[], byte[])
	 */
	public IModulo fazerLogin(byte[] nome, byte[] senha) throws RemoteException
	{
		// Declara��o de vari�veis. 
		IModulo modulo;
		Login noIterador;
		byte[] cadeia;
		boolean corresponde;
		byte i;

		modulo = null;

		// Percorre a lista de logins.
		noIterador = (Login) listaLogin.getPrimeiro();
		while (noIterador != null)
		{
			corresponde = true;

			// Verifica se o login est� ativo.
			if (noIterador.getModulo().getTipo() == IModulo.USUARIO)
				if (((IUsuario) noIterador).isAtivo() == false)
				{
					noIterador = (Login) listaLogin.getProximo(noIterador);
					continue;
				}

			// Verifica o nome de login.
			cadeia = noIterador.getId();
			for (i = 0; i < cadeia.length && corresponde == true; i++)
			{
				if (cadeia[i] != nome[i])
					corresponde = false;
			}

			if (corresponde == false)
			{
				noIterador = (Login) listaLogin.getProximo(noIterador);
				continue;
			}

			// Verifica a senha de login.
			cadeia = noIterador.getSenha();
			for (i = 0; i < cadeia.length && corresponde == true; i++)
			{
				if (cadeia[i] != senha[i])
					corresponde = false;
			}

			if (corresponde == true)
			{
				modulo = noIterador.getModulo();
				noIterador = null;
			} else
				noIterador = (Login) listaLogin.getProximo(noIterador);
		}

		return modulo;
	}

	ListaLigada getListaLogin()
	{
		return listaLogin;
	}

}
