package org.JavaCar;

import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.Field;

public class CotxeTest {

    @Test
    public void testCreacioCotxe() {
        Cotxe cotxe = new Cotxe("1234ABC", "Toyota", "Corolla", 30, 5, null, null);
        
        assertEquals("1234ABC", cotxe.getMatricula());
        assertEquals("Toyota", cotxe.getMarca());
        assertEquals("Corolla", cotxe.getModel());
        assertEquals(30, cotxe.getPreuBase(), 0.01);
        assertEquals(5, cotxe.getNombrePlaces());
    }

    @Test
    public void testCalculPreuCotxe() {
        Cotxe cotxe = new Cotxe("5678DEF", "Ford", "Focus", 25, 5, null, null);
        assertEquals(75, cotxe.calcularPreu(3), 0.01); // 25 * 3 = 75
    }

    @Test
    public void testAtributPrivat() throws NoSuchFieldException {
        // Reflexió per accedir als atributs i verificar que són privats
        Field nombrePlacesField = Cotxe.class.getDeclaredField("nombrePlaces");


        assertTrue("L'atribut 'cilindrada' hauria de ser privat", 
                   java.lang.reflect.Modifier.isPrivate(nombrePlacesField.getModifiers()));
    }
}
