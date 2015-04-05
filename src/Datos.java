/**
 * Created by Leslie on 27/08/2014.
 */
public class Datos {

    private String nombre;
    int carnet, semestre;
    Datos siguiente, temp;

    public Datos( int carnet, String nombre, int semestre){
        this.carnet = carnet;
        this.nombre = nombre;
        this.semestre = semestre;
        siguiente = null;
    }

    /////////////////////////////////////////////////////////////  OBTENER

    public Object obtenerValor(){
        return temp ;
    }

    public void enlazarSiguiente(Datos n){
        siguiente = n;
    }

    public Datos obtenerSiguiente(){
        return siguiente;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getCarnet(){
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public int getSemestre(){
        return semestre;
    }

    public void setSemestre(int semestre) {
      this.semestre = semestre;
    }
}
