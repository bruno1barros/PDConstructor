/**
 * 
 */
package br.edu.ufrpe.uag.projetao.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import br.edu.ufrpe.uag.projetao.control.ControllerFactory;
import br.edu.ufrpe.uag.projetao.control.DetachedCriteriaFactory;
import br.edu.ufrpe.uag.projetao.control.UsuarioController;
import br.edu.ufrpe.uag.projetao.interfaces.InterfaceController;
import br.edu.ufrpe.uag.projetao.model.BaseTexto;
import br.edu.ufrpe.uag.projetao.view.GenericTable;
import br.edu.ufrpe.uag.projetao.view.jdialog.CriarBaseClassificacaoTextoJDialog;

/**
 * @author israel
 *
 */
public class NovaBaseTextoActionListener implements ActionListener {

    private GenericTable<BaseTexto> table;

    /**
     * @param table
     * 
     */
    public NovaBaseTextoActionListener(GenericTable<BaseTexto> table) {
	// TODO Auto-generated constructor stub S2
	this.table = table;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub S2
	new CriarBaseClassificacaoTextoJDialog().setVisible(true);
	table.clear();
	table.addAll(new LinkedList<>(
		((InterfaceController<BaseTexto>) ControllerFactory.getBaseTextoController()).getItemsFromCriteria(
			DetachedCriteriaFactory.getBasesTextoDoUsuario(UsuarioController.currrentSupervisor))));
    }

}
