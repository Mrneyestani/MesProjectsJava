package fr.doranco.jaxws.client.asynchrone;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

import fr.doranco.jaxws.webservice.AddEtudiantResponse;
import fr.doranco.jaxws.webservice.Etudiant;
import fr.doranco.jaxws.webservice.EtudiantService;
import fr.doranco.jaxws.webservice.EtudiantService_Service;

/**
 * @author Ryadh HADJ MOKHNECHE (rmokhneche@next-challenge.fr)
 */
public class ClientAsynchroneWithSwing extends JFrame {

	private static final long serialVersionUID = -8095150953761740313L;

	public ClientAsynchroneWithSwing() {
		super("NotebookWebServiceAsynchronous Client");

		JFrame frame = new JFrame("Ryadh HADJ MOKHNECHE / Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setLayout(new BorderLayout());
		final JButton startButton = new JButton("Call addEtudiant operation");
		frame.add(BorderLayout.NORTH, startButton);

		final JTextArea textArea = new JTextArea(20, 50);
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		frame.pack();
		frame.setLocationRelativeTo(null); // *** this will center your app ***
		frame.setVisible(true);

		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startButton.setEnabled(false);
				Etudiant etudiantToAdd = new Etudiant();
				etudiantToAdd.setNom("Paul");
				etudiantToAdd.setPrenom("SMITH");
				etudiantToAdd.setSpecialite("Mécanique");

				textArea.append("addEtudiant operation has been invoked.\n");

				// initialisation du service et du port.
				EtudiantService_Service service = new EtudiantService_Service();
				EtudiantService port = service.getEtudiantPort();

				/*
				 * Asynchronous with callback handler
				 */
				AsyncHandler<AddEtudiantResponse> asyncHandler = new AsyncHandler<AddEtudiantResponse>() {
					@Override
					public void handleResponse(Response<AddEtudiantResponse> res) {

						if (!res.isCancelled() && res.isDone()) {
							try {
								Etudiant etudiantAdded = res.get().getReturn();
								textArea.append("New Person added : " + etudiantAdded.getId() + " / "
										+ etudiantAdded.getNom() + " / " + etudiantAdded.getPrenom() + " / "
										+ etudiantAdded.getSpecialite() + "\n");
								startButton.setEnabled(true);
							} catch (InterruptedException e) {
								e.printStackTrace();
							} catch (ExecutionException e) {
								e.printStackTrace();
							}
						}
					}
				};
				port.addEtudiantAsync(etudiantToAdd, asyncHandler);
				
				/*
				 * Asynchronous with polling
				 */

			}
		});

		this.pack();
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ClientAsynchroneWithSwing();
	}
}
