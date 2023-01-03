package de.hebk;

public class Sorter {
    public int[] a;


    public void countSort(int[] array, int size) {
        int[] output = new int[size + 1];

        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max)
                max = array[i];
        }
        int[] count = new int[max + 1];

        // initialisiert alle Elemente mit '0'.
        for (int i = 0; i < max; ++i) {
            count[i] = 0;
        }

        // Jedem Element "Count" geben
        for (int i = 0; i < size; i++) {
            count[array[i]]++;
        }

        // Speichert den kumulativen "Count" von jedem Array
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Findet den Index von jedem Element von dem originalen Array in count Array, und
        // platziert die Elemente in output Array
        for (int i = size - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        // Das originale Array bekommt alle sortierten Elemente aus output Array
        for (int i = 0; i < size; i++) {
            array[i] = output[i];
        }
        a = array;
    }
}
