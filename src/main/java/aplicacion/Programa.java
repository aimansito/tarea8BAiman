/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import modelo.PersonaDAO;
import modelo.PersonaVO;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author J. Carlos F. Vico <jcarlosvico@maralboran.es>
 */
public class Programa {

    public static void main(String[] args) {
        
        
        PersonaDAO daoPersona = new PersonaDAO();
        List<PersonaVO> listaPersonas = new ArrayList<>();
        listaPersonas.add(new PersonaVO(1,"Hugo Weston", LocalDate.of(1997, 6, 6)));
        listaPersonas.add(new PersonaVO(2,"Maria Weston", LocalDate.of(1967, 6, 6)));
        listaPersonas.add(new PersonaVO(3,"Pablo Pérez", LocalDate.of(1997, 12, 5)));
        listaPersonas.add(new PersonaVO(4,"Maria Weston", LocalDate.of(2000, 6, 5)));
        listaPersonas.add(new PersonaVO(5,"Pedro Moreno", LocalDate.of(2001, 6, 15)));
        
        try {
            
            System.out.println("Nº personas insertadas " + daoPersona.insertPersona(listaPersonas));
            System.out.println("-----------------------------------------");
            System.out.println("Comprobamos en una nueva lista que se recogen los datos desde la tabla.");
            List<PersonaVO> nuevaLista = daoPersona.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
            System.out.println("Persona con primary key 1: ");
            System.out.println(daoPersona.findByPk(1));
            System.out.println("-----------------------------------------");
            System.out.println("Se va a borrar la persona con pk 3");
            System.out.println("Nº personas borradas " + 
                    daoPersona.deletePersona(new PersonaVO(3,"Pablo Pérez", LocalDate.of(1997, 12, 5))));
            System.out.println("-----------------------------------------");
            nuevaLista = daoPersona.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de borrar una persona -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
            System.out.println("Modificación de la persona con pk 5");
            System.out.println("Nº Personas modificadas " + 
                    daoPersona.updatePersona(5, new PersonaVO(7,"NuevoNombre", LocalDate.of(2019, 6, 5))));
            System.out.println("-----------------------------------------");
            nuevaLista = daoPersona.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de modificar una persona -------------");
            nuevaLista.forEach(System.out::println);
        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }
        System.out.println("-------- Lista original --------------------");
        listaPersonas.forEach(System.out::println);

    }

}
