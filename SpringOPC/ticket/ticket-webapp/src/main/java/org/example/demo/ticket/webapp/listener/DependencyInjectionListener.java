package org.example.demo.ticket.webapp.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


import org.example.demo.ticket.business.manager.TicketManager;
import org.example.demo.ticket.business.manager.impl.manager.ManagerFactory;
import org.example.demo.ticket.business.manager.impl.manager.ProjetManagerImpl;
import org.example.demo.ticket.webapp.rest.resource.projet.AbstractResource;

public class DependencyInjectionListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent pServletContextEvent) {
		// Création de l'instance de ManagerFactory
		ManagerFactory vManagerFactory = new ManagerFactory();

		// Injection de l'instance de ManagerFactory dans la classe AbstractResource
		AbstractResource.setManagerFactory(vManagerFactory);

		// On ajoute l'injection des Managers dans la ManagerFactory
		vManagerFactory.setProjetManager(new ProjetManagerImpl());
		vManagerFactory.setTicketManager(new TicketManager());
	}

	@Override
	public void contextDestroyed(ServletContextEvent pServletContextEvent) {
		// NOP
	}
}
