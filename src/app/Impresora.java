package app;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.PrintServiceAttributeSet;
import javax.print.attribute.standard.Chromaticity;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import javax.print.attribute.standard.PrintQuality;
import javax.print.attribute.standard.PrinterName;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimplePrintServiceExporterConfiguration;
/**
 * @web https://www.jc-mouse.net/
 * @author Mouse
 */
public class Impresora {

    /**
 * Imprime un reporte
 * @param print JasperPrint 
 * @param selectedService int impresora
 */
    public void imprimir(JasperPrint print, int selectedService) throws JRException{

        PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
        //atributos de impresion
        PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();        
        //Orientación de pagina
        printRequestAttributeSet.add(OrientationRequested.PORTRAIT);//LANDSCAPE
        //Tamaño de hoja
        printRequestAttributeSet.add(MediaSizeName.NA_LETTER);//carta 
        //Margenes (izquiero, superior, ancho , alto , unidades )
        int width = Math.round(MediaSize.NA.LETTER .getX(MediaSize.MM));//ancho de pagina
        int height = Math.round(MediaSize.NA.LETTER.getY(MediaSize.MM));//alto de pagina 
        printRequestAttributeSet.add(new MediaPrintableArea(20, 20, width-40, height-40, MediaPrintableArea.MM ));
        //Calidad de impresión
        printRequestAttributeSet.add(PrintQuality.NORMAL);
        //impresion a color
        printRequestAttributeSet.add(Chromaticity.COLOR);
        //Cantidad de copias
        printRequestAttributeSet.add(new Copies(1));     
        //----------------- 
        JRPrintServiceExporter exporter = new JRPrintServiceExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);

        //se selecciona servicio y se pasa atributos de impresion 
        exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, services[selectedService]);
        exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, services[selectedService].getAttributes());
        exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, printRequestAttributeSet);
        exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
        //si es falso, imprimira directamente segun los parametros pasados mas arriba
        exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);                
        exporter.exportReport();
    }
    
    public void PrintReportToPrinter(JasperPrint jasperPrint) throws JRException {

        //Get the printers names
        PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);

        //Lets set the printer name based on the registered printers driver name (you can see the printer names in the services variable at debugging) 
        String selectedPrinter = "Microsoft XPS Document Writer";   
        // String selectedPrinter = "\\\\S-BPPRINT\\HP Color LaserJet 4700"; // examlpe to network shared printer

        System.out.println("Number of print services: " + services.length);
        PrintService selectedService = null;

        //Set the printing settings
        PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
        printRequestAttributeSet.add(MediaSizeName.ISO_A4);
        printRequestAttributeSet.add(new Copies(1));
        if (jasperPrint.getOrientationValue() == net.sf.jasperreports.engine.type.OrientationEnum.LANDSCAPE) { 
          printRequestAttributeSet.add(OrientationRequested.LANDSCAPE); 
        } else { 
          printRequestAttributeSet.add(OrientationRequested.PORTRAIT); 
        } 
        PrintServiceAttributeSet printServiceAttributeSet = new HashPrintServiceAttributeSet();
        printServiceAttributeSet.add(new PrinterName(selectedPrinter, null));

        JRPrintServiceExporter exporter = new JRPrintServiceExporter();
        SimplePrintServiceExporterConfiguration configuration = new SimplePrintServiceExporterConfiguration();
        configuration.setPrintRequestAttributeSet(printRequestAttributeSet);
        configuration.setPrintServiceAttributeSet(printServiceAttributeSet);
        configuration.setDisplayPageDialog(false);
        configuration.setDisplayPrintDialog(false);

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setConfiguration(configuration);

        //Iterate through available printer, and once matched with our <selectedPrinter>, go ahead and print!
        if(services != null && services.length != 0){
          for(PrintService service : services){
              String existingPrinter = service.getName();
              if(existingPrinter.equals(selectedPrinter))
              {
                  selectedService = service;
                  break;
              }
          }
        }
        if(selectedService != null)
        {   
          try{
              //Lets the printer do its magic!
              exporter.exportReport();
          }catch(Exception e){
        System.out.println("JasperReport Error: "+e.getMessage());
          }
        }else{
          System.out.println("JasperReport Error: Printer not found!");
}}

    /**
 * Muestra las impresoas instaladas
 */
    public void listar_impresoras()
    {
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
        System.out.println("Impresoras disponibles: " + printServices.length);
        for (PrintService printer : printServices)
            System.out.println("> Nombre: " + printer.getName() ); 
    }
}//end:Impresora
