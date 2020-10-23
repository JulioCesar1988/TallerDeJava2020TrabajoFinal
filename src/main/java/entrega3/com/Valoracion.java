package entrega3.com;
import java.util.ArrayList;
import java.util.Date;
public class Valoracion {
public int limpieza;
public int simpatia;
public int calidad;
public int precio;
public int sabor;
public int disenio;
public Date fechaValoracion;
public ArrayList<Evento> valoracionEvento;
public  ArrayList<FoodTruck> valoracionFoodTruck;
public  ArrayList<FoodTruck> valoracionFood;

    public Valoracion(int limpieza, int simpatia, int calidad, int precio, int sabor, int disenio, Date fechaValoracion, ArrayList<Evento> valoracionEvento, ArrayList<FoodTruck> valoracionFoodTruck, ArrayList<FoodTruck> valoracionFood) {
        this.limpieza = limpieza;
        this.simpatia = simpatia;
        this.calidad = calidad;
        this.precio = precio;
        this.sabor = sabor;
        this.disenio = disenio;
        this.fechaValoracion = fechaValoracion;
        this.valoracionEvento = valoracionEvento;
        this.valoracionFoodTruck = valoracionFoodTruck;
        this.valoracionFood = valoracionFood;
    }

    public int getLimpieza() {
        return limpieza;
    }

    public void setLimpieza(int limpieza) {
        this.limpieza = limpieza;
    }

    public int getSimpatia() {
        return simpatia;
    }

    public void setSimpatia(int simpatia) {
        this.simpatia = simpatia;
    }

    public int getCalidad() {
        return calidad;
    }

    public void setCalidad(int calidad) {
        this.calidad = calidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getSabor() {
        return sabor;
    }

    public void setSabor(int sabor) {
        this.sabor = sabor;
    }

    public int getDisenio() {
        return disenio;
    }

    public void setDisenio(int disenio) {
        this.disenio = disenio;
    }

    public Date getFechaValoracion() {
        return fechaValoracion;
    }

    public void setFechaValoracion(Date fechaValoracion) {
        this.fechaValoracion = fechaValoracion;
    }

    public ArrayList<Evento> getValoracionEvento() {
        return valoracionEvento;
    }

    public void setValoracionEvento(ArrayList<Evento> valoracionEvento) {
        this.valoracionEvento = valoracionEvento;
    }

    public ArrayList<FoodTruck> getValoracionFoodTruck() {
        return valoracionFoodTruck;
    }

    public void setValoracionFoodTruck(ArrayList<FoodTruck> valoracionFoodTruck) {
        this.valoracionFoodTruck = valoracionFoodTruck;
    }

    public ArrayList<FoodTruck> getValoracionFood() {
        return valoracionFood;
    }

    public void setValoracionFood(ArrayList<FoodTruck> valoracionFood) {
        this.valoracionFood = valoracionFood;
    }
}
