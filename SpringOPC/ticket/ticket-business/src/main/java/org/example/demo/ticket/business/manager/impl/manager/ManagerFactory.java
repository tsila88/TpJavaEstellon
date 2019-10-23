package org.example.demo.ticket.business.manager.impl.manager;

import org.example.demo.ticket.business.manager.TicketManager;
import org.example.demo.ticket.business.manager.contract.manager.ProjetManager;

public class ManagerFactory {
	// Ajout d'un attribut projetManager
	private ProjetManager projetManager;
	private TicketManager ticketManager;

	/** Instance unique de la classe (design pattern Singleton) */
	private static final ManagerFactory INSTANCE = new ManagerFactory();

	/**
	 * Constructeur.
	 */
	public ManagerFactory() {
		super();
	}

	/**
	 * Renvoie l'instance unique de la classe (design pattern Singleton).
	 *
	 * @return {@link ManagerFactory}
	 */
	public static ManagerFactory getInstance() {
		return ManagerFactory.INSTANCE;
	}

	// On renvoie désormais simplement l'attribut projetManager
	public ProjetManager getProjetManager() {
		return projetManager;
	}

	// Ajout d'un setter pour l'attribut projetManager
	public void setProjetManager(ProjetManager pProjetManager) {
		projetManager = pProjetManager;
	}

	public void setTicketManager(TicketManager pTicketManager) {
		// TODO Auto-generated method stub
		ticketManager = pTicketManager;

	}
}
