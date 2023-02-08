package hibernate.hibernate02;

import javax.persistence.*;

@Entity
@Table(name="persona")
public class Persona {
    public Persona() {
    }

    public Persona(String nombre, String f_nac, Double altura, Double peso) {
        this.nombre = nombre;
        this.f_nac = f_nac;
        this.altura = altura;
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", f_nac='" + f_nac + '\'' +
                ", altura=" + altura +
                ", peso=" + peso +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getF_nac() {
        return f_nac;
    }

    public void setF_nac(String f_nac) {
        this.f_nac = f_nac;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    @Id
    @Column(name="id")
    int id;
    @Column(name="nombre")
    String nombre;
    @Column(name="f_nac")
    String f_nac;
    @Column(name="altura")
    Double altura;
    @Column(name="peso")
    Double peso;

}
