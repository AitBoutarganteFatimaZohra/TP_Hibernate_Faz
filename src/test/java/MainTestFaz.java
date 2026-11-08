package test;

import entities.MachineFaz;
import entities.SalleFaz;
import services.MachineServiceFaz;
import services.SalleServiceFaz;
import java.util.Date;

public class MainTestFaz {
    public static void main(String[] args) {
        System.out.println("--- Démarrage du Test Principal ---");

        SalleServiceFaz salleService = new SalleServiceFaz();
        MachineServiceFaz machineService = new MachineServiceFaz();

        // 1. Création d'une Salle
        SalleFaz salleA = new SalleFaz("S1", "Salle Informatique Faz");
        salleService.insererFaz(salleA);
        System.out.println("Salle insérée avec ID : " + salleA.getId());

        // 2. Création de Machines liées à cette Salle
        MachineFaz machine1 = new MachineFaz("M-101", "Dell", new Date());
        machine1.setPrix(1500.0);
        machine1.setSalleFaz(salleA);
        machineService.insererFaz(machine1);

        MachineFaz machine2 = new MachineFaz("M-102", "HP", new Date());
        machine2.setPrix(800.0);
        machine2.setSalleFaz(salleA);
        machineService.insererFaz(machine2);

        System.out.println("Machines insérées avec succès !");

        // 3. Test des requêtes HQL
        System.out.println("\n--- Test HQL : Machines de la salle S1 ---");
        machineService.trouverMachinesParCodeSalleFaz("S1")
                .forEach(m -> System.out.println("Trouvée : " + m.getRef() + " - " + m.getMarque()));

        System.out.println("\n--- Test HQL : Machines > 1000 DH ---");
        machineService.trouverMachinesPlusCheresFaz(1000.0)
                .forEach(m -> System.out.println("Trouvée : " + m.getRef() + " - " + m.getPrix() + " DH"));

        System.out.println("\n--- Test méthode métier ---");
        salleA.afficherDetailsSalleFaz();
    }
}