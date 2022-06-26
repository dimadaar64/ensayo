package app;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperPrintManager;

import java.awt.GridLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
package app;
import net.sf.jasperreports.engine.JRException;
/**
 * @web https://www.jc-mouse.net/
 * @author Mouse
 */
public class Main {

    public static void main(String[] args) {
        
        
        
        
        
//        JPanel gui = new JPanel(new GridLayout(0, 1, 5, 5));
//
//        String[] speciesName = { "1", "2", "3" };
//        String[][] breedName = { { "A", "P", "A" }, { "B", "P", "S" }, { "DDo", "A", "P" } };
//        JComboBox<String> petSpecies = new JComboBox<>(speciesName);
//        JComboBox<String> petBreed = new JComboBox<>();
//        petSpecies.addItemListener(e -> {
//            int ii = petSpecies.getSelectedIndex();
//            ComboBoxModel cbm = new DefaultComboBoxModel(breedName[ii]);
//            petBreed.setModel(cbm);/* w  w  w  .   d e  m  o  2   s.    c o  m */
//            petBreed.requestFocusInWindow();
//        });
//        gui.add(petSpecies);
//        gui.add(petBreed);
//
//        JOptionPane.showMessageDialog(null, gui);
        

//        Impresora impresora = new Impresora();
//        try {
//            impresora.listar_impresoras();
//            MisReportes mr = new MisReportes();
//            JasperPrintManager.printReport(mr.reporte_diario(), true);
////            impresora.imprimir( mr.reporte_diario(), 2);
////            impresora.PrintReportToPrinter( mr.reporte_diario());
//        } catch (JRException ex) {
//            System.err.println(ex.getMessage());
//        }

    }    

}
