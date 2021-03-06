/**
 * 
 */
package br.edu.ufrpe.uag.projetao.interfaces;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 * @author israel
 *
 */
public interface InterfaceClassificacao<C extends Component, T extends InterfaceEntity> extends InterfaceWindow {

    /**
     * 
     * @return Botão de próxima classificação
     */
    JButton getProximoButton();

    /**
     * 
     * @return Botão sair
     */
    JButton getSairButton();

    /**
     * 
     * @return Botão de classificação anterior
     */
    JButton getAnteriorButton();

    /**
     * 
     * @return Combobox de opções de classificação
     */
    JComboBox<T> getClasseComboBox();

    /**
     * 
     * @return Painel dos componentes principais
     */
    C getMediaComponet();

    /**
     * Adiciona uma mídia de componentes principais
     * 
     * @param mediaComponent
     */
    void setMediaComponent(C mediaComponent);
}
