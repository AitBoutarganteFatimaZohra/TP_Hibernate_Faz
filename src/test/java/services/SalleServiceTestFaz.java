package services;

import entities.SalleFaz;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SalleServiceTestFaz {

    @Test
    public void testInsertionSalleFaz() {
        SalleServiceFaz service = new SalleServiceFaz();
        SalleFaz salleTest = new SalleFaz("S_TEST", "Salle de Test JUnit");

        boolean resultat = service.insererFaz(salleTest);

        Assertions.assertTrue(resultat, "L'insertion de la salle doit réussir.");
        Assertions.assertTrue(salleTest.getId() > 0, "L'ID doit être généré.");
    }
}