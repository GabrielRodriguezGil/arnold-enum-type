package edu.teamrocket;

import edu.teamrocket.logica.Planeta;
import java.util.Optional;

public class ArnoldMain {

    public static void main(String[] args) {

        Optional<Double> peso = Optional.empty();
        Optional<Planeta> pluto = Optional.empty();

        if (args.length != 2) {
            System.out.println("Please provide your weight and a planet as arguments:\n > java ArnoldMain 70 Earth\n");
        }

        try {
            peso = Optional.of(Double.parseDouble(args[0]));
            pluto = Optional.of(Planeta.valueOf(args[1]));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(
                    "\nPlease provide both your weight and a planet as arguments. Using default values of 1.0 kg and Earth.");
        } catch (NumberFormatException e) {
            System.out.println(
                    "\nThe first argument must be a number representing your weight in kg. Using default value of 1.0 kg.");
        } catch (IllegalArgumentException e) {
            System.out.println("\nThe second argument must be a valid planet name. Using default value of Earth.");
        }

        System.out.printf("\nYour weight on %s is %f N%n", pluto.orElse(Planeta.EARTH),
                pluto.orElse(Planeta.EARTH).pesoSuperficie(peso.orElse(1.0)));

        System.out.println("\nYour weight only on the terrestrial planets: ");
        for (Planeta planeta : Planeta.getPlanetasTerrestres()) {
            System.out.printf("Your weight on %s is %f N%n", planeta.name(), planeta.pesoSuperficie(peso.orElse(1.0)));
        }

        System.out.println("\nYour weight only on the gas giant planets: ");
        for (Planeta planeta : Planeta.getGigantesGaseosos()) {
            System.out.printf("Your weight on %s is %f N%n", planeta.name(), planeta.pesoSuperficie(peso.orElse(1.0)));
        }
    }
}