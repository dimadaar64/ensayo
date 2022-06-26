package app;
/**
 * @web https://www.jc-mouse.net/
 * @author Mouse
 */
public class MisDatos {

    private String codigo="0";
    private String item="";
    private String entrada="0.0";
    private String salida="0.0";

    /** Constructor de clase */
    public MisDatos(String c, String i, String e,String s){
        codigo=c;
        item=i;
        entrada=e;
        salida=s;
    }

   

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

}
