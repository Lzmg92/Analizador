/**
 * Created by Leslie on 27/08/2014.
 */
public class Lista {

    Datos cabeza;
    Datos cola;
    int size;

    public Lista() {
        cabeza = null;
    }

    //////////////////////////////////////////////////////////// ESTADO VACIA

    public boolean estavacia(){
        return (cabeza==null)?true:false;
    }

    //////////////////////////////////////////////////////////// TAMAÑO

    public int tamañolista(){
        return size+1;
    }


    //////////////////////////////////////////////////////////// AGREGAR

    public void addregistro(int carnet, String nombre, int semestre)
    {
        if(cabeza==null)
        {
            cabeza = new Datos(carnet, nombre,  semestre);
            cola = cabeza;
            size = 0;
        }
        else
        {
            Datos nuevonodo=new Datos( carnet, nombre,semestre);
            cola.siguiente = nuevonodo;
            nuevonodo.siguiente = cola;
            cola = nuevonodo;
            size++;
        }     }

    /////////////////////////////////////////////////////////// OBTENER POR INDEX

    public Datos obtener(int index){
        int contador = 0;
        Datos temporal = cabeza;
        while (contador<index){
            temporal = temporal.obtenerSiguiente();
            contador++;}
        return temporal;
    }

    /////////////////////////////////////////////////////////// ELIMINAR

    public void eliminar(int index){
        if(index == 0){
            cabeza = cabeza.obtenerSiguiente();
        }
        else {
            int contador = 0;
            Datos temporal = cabeza;
            while (contador < index - 1) {
                temporal = temporal.obtenerSiguiente();
                contador++;
            }
            temporal.enlazarSiguiente(temporal.obtenerSiguiente().obtenerSiguiente());
        }
        size--;



    }


}
