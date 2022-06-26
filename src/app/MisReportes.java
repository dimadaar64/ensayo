/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Armando
 */
public class MisReportes {
     public JasperPrint reporte_diario() throws JRException
    {
        String sourceFileName = "C:\\Users\\Armando\\Documents\\NetBeansProjects\\imprimir\\src\\reportes\\report28.jasper";        
        Map parameters = new HashMap();
        ArrayList<MisDatos> dataBeanList = new ArrayList<MisDatos>(); 
        
        dataBeanList.add(new MisDatos("999i9","Mescladora Lavamanos LG","100","0"));
        dataBeanList.add(new MisDatos("999i9","Mescladora Lavamanos LG","0","5"));
        dataBeanList.add( new MisDatos("9i988","Ducha","0","10") );
        dataBeanList.add( new MisDatos("87777","Set de Baño Kawaii","39","0") );
        dataBeanList.add( new MisDatos("9i988","Ducha","12","0") );
        dataBeanList.add( new MisDatos("9i988","Ducha","5","0") );
        dataBeanList.add( new MisDatos("13212","Regadea Economica","50","0") );
        dataBeanList.add( new MisDatos("9i988","Ducha","0","1") );
        dataBeanList.add( new MisDatos("76799","Espejo","1","1") );
        
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
        JasperPrint print = JasperFillManager.fillReport( sourceFileName, parameters, beanColDataSource );
        return print;
    }
}
