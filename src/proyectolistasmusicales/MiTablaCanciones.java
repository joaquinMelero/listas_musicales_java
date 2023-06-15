package proyectolistasmusicales;


import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;


class MiTablaCanciones extends AbstractTableModel {
    
    //atributo listaCanciones que es un arrayList para guardar las canciones
    private ArrayList<Cancion> listaMusica;

    //atributo de la clase que define l nombre de las columnas
    private final String[] nombreColumnas = {"Título", "Ruta", "Duración"};

    
    //constructor por defecto. Se crea el ArrayList que tendrá las canciones
    public MiTablaCanciones(){
        
        this.listaMusica = new ArrayList<>();
        
    }
    
    //método para añadir las canciones a la lista
     public void añadirCancion(Cancion c){
        this.listaMusica.add(c);
        
    }
     
    //método para elimar las canciones de la lista
     public void elimarCancion(int indexFila){
         
         
         listaMusica.remove(indexFila);
     }

    
     //
    @Override
    public String getColumnName(int index){
        return this.nombreColumnas[index];
    }
    
    //método heredado de la clase abstracta que devuelve el número de filas. Será el nº de objetos de la lista
    @Override
    public int getRowCount() {
        return this.listaMusica.size();
    }
    
    //devuelve el número de columnos
    @Override
    public int getColumnCount() {
        return 3;
    }

    //nos devuelve el valor del dato 
    @Override
    public Object getValueAt(int row, int column) {
        Cancion c = listaMusica.get(row);
        Object value = null;
        switch(column){
            case 0:
                value = c.getTitulo();
                break;
            case 1: 
                value = c.getRuta();
                break;
            case 2:
                value = c.getDuracion();
                break;
        }
        return value;
    }
    
    //cambia el valor del capo seleccionado
    public MiTablaCanciones modificarCamposTabla(String valor, int row, int column, MiTablaCanciones t) {

        if (row >= 0) {

            Cancion c = listaMusica.get(row);

            //recorro la lista de canciones
            for (int i = 0; i < t.getRowCount(); i++) {

                //cuando i=a la fila se situa en el objeto del arraylist
                if (i == row) {

                    //dependiedno de la posicion de la columna se cambia el objeto
                    switch (column) {
                        case 0:
                            c.setTitulo(valor);
                            break;
                        case 1:
                            c.setRuta(valor);
                            break;
                        case 2:
                            int valorInt = validarINT(valor);

                            //si es 0 o menor no cambia el dato
                            if (valorInt > 0) {

                                c.setDuracion(valorInt);
                                break;
                            }
                    }

                }
            }

        }

        return t;

    }
    
    public int validarINT(String numero) {

        int valorInt = 0;

        if (!numero.matches("^([0-9]){3}$")){

            JOptionPane.showMessageDialog(null, "Introduce un número entero, formato 3 dígitos");

        }

        if (numero.matches("^([0-9]){3}$")) {

            valorInt = Integer.valueOf(numero);

        }

        return valorInt;
    }
    
    //devuelve el arrayList
    public ArrayList darListaCanciones(){
        
        return listaMusica;
    }

    @Override
    public String toString() {
        return "MiTablaCanciones{" + "listaMusica=" + listaMusica + '}' ;
    }
    
    
    
}
