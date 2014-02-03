package smartsystem;

import javacard.framework.APDU;
import javacard.framework.Applet;
import javacard.framework.service.Dispatcher;
import javacard.framework.service.RMIService;
import javacard.framework.service.RemoteService;

/**
 * Applet de acesso � aplica��o.
 * 
 * @author Tiago
 * 
 */
public class SmartApplet extends Applet
{
	/**
	 * Dispatcher do servi�o RMI.
	 */
	private Dispatcher dispatcher;

	/**
	 * Construtor.
	 */
	private SmartApplet()
	{
		// Declara��o de vari�veis.
		RemoteService rmiPrincipal;

		// Aloca um dispatcher RMI.
		dispatcher = new Dispatcher((short) 1);

		// Inicia um servi�o RMI definindo a refer�ncia inicial.
		rmiPrincipal = new RMIService(new PrincipalImpl());

		dispatcher.addService(rmiPrincipal, Dispatcher.PROCESS_COMMAND);
	}

	public static void install(byte[] buffer, short offset, byte length)
	{
		// Aloca e registra o applet.
		(new SmartApplet()).register();
	}

	public void process(APDU apdu)
	{
		// Processa as requisi��es APDU.
		dispatcher.process(apdu);
	}
}
