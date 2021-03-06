/**
 * 
 */
package br.edu.ufrpe.uag.projetao.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.edu.ufrpe.uag.projetao.control.ControllerFactory;
import br.edu.ufrpe.uag.projetao.control.hibernate.TransactionManager;
import br.edu.ufrpe.uag.projetao.interfaces.InterfaceController;
import br.edu.ufrpe.uag.projetao.interfaces.InterfaceCriaEAtualiza;
import br.edu.ufrpe.uag.projetao.model.BaseTexto;
import br.edu.ufrpe.uag.projetao.view.JPane.BaseTextoJPanel;

/**
 * @author israel
 *
 */
public class AtualizarBaseTextoActionListener implements ActionListener {

    private InterfaceCriaEAtualiza<BaseTextoJPanel> jdialog;

    public AtualizarBaseTextoActionListener(InterfaceCriaEAtualiza<BaseTextoJPanel> jdialog) {
	// TODO Auto-generated constructor stub
	this.jdialog = jdialog;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	InterfaceController<BaseTexto> baseTextoController = ControllerFactory.getBaseTextoController();

	TransactionManager.begin();

	baseTextoController.getSelected().setTitulo(jdialog.getMediaComponent().getTituloTextField().getText());
	baseTextoController.getSelected().setDescricao(jdialog.getMediaComponent().getDescricaoEditorPane().getText());

	baseTextoController.update();

	TransactionManager.end();

	jdialog.dispose();
	JOptionPane.showMessageDialog(null,
		"Base " + baseTextoController.getSelected().getId() + " atualizada com sucesso");
    }

}
