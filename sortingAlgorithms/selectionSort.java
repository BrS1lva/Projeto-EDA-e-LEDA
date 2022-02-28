package sortingAlgorithms;

import util.*;

public class selectionSort extends tools {

  public static void Selection(Dados[] dados) {
    String[][] path = { { "googleplaystore_Names_selectionSort_medioCaso.csv",
        "googleplaystore_Names_selectionSort_melhorCaso.csv",
        "googleplaystore_Names_selectionSort_piorCaso.csv" },

        { "googleplaystore_Ratings_selectionSort_medioCaso.csv",
            "googleplaystore_Ratings_selectionSort_melhorCaso.csv",
            "googleplaystore_Ratings_selectionSort_piorCaso.csv" },

        { "googleplaystore_Installs_selectionSort_medioCaso.csv",
            "googleplaystore_Installs_selectionSort_melhorCaso.csv",
            "googleplaystore_Installs_selectionSort_piorCaso.csv" },

        { "googleplaystore_LastUpdate_selectionSort_medioCaso.csv",
            "googleplaystore_LastUpdate_selectionSort_melhorCaso.csv",
            "googleplaystore_LastUpdate_selectionSort_piorCaso.csv" } };

    System.out.println("\n--------------------------------------------------");
    System.out.printf("|%s %34s \n", "Selection Sort", "|");

    // Selection Sort - NAMES --
    System.out.println("--------------------------------------------------");
    System.out.printf("|%s %43s \n", "Names", "|");
    System.out.println("--------------------------------------------------");
    Dados[] arrayOrdenadoNAMES = selectionSort.selectionSortNames(dados.clone(), path[0][0], 1); // medio caso
    selectionSort.selectionSortNames(arrayOrdenadoNAMES.clone(), path[0][1], 0); // melhor caso
    Dados[] arrayInvertidoNAMES = tools.inverteArray(arrayOrdenadoNAMES);
    selectionSort.selectionSortNames(arrayInvertidoNAMES.clone(), path[0][2], 2); // pior caso

    // Selection Sort - RATINGS
    System.out.println("--------------------------------------------------");
    System.out.printf("|%s %41s \n", "Ratings", "|");
    System.out.println("--------------------------------------------------");
    Dados[] arrayOrdenadoRATINGS = selectionSort.selectionSortRatings(dados.clone(), path[1][0], 1); // medio caso
    selectionSort.selectionSortRatings(arrayOrdenadoRATINGS.clone(), path[1][1], 0); // melhor caso
    Dados[] arrayInvertidoRATINGS = tools.inverteArray(arrayOrdenadoRATINGS);
    selectionSort.selectionSortRatings(arrayInvertidoRATINGS.clone(), path[1][2], 2); // pior caso

    // Selection Sort - INSTALLS
    System.out.println("--------------------------------------------------");
    System.out.printf("|%s %40s \n", "Installs", "|");
    System.out.println("--------------------------------------------------");
    Dados[] arrayOrdenadoINSTALLS = selectionSort.selectionSortInstalls(dados.clone(), path[2][0], 1); // medio caso
    selectionSort.selectionSortInstalls(arrayOrdenadoINSTALLS.clone(), path[2][1], 0); // melhor caso
    Dados[] arrayInvertidoINSTALLS = tools.inverteArray(arrayOrdenadoINSTALLS);
    selectionSort.selectionSortInstalls(arrayInvertidoINSTALLS.clone(), path[2][2], 2); // pior caso

    // Selection Sort - LAST UPDATES

    System.out.println("--------------------------------------------------");
    System.out.printf("|%s %36s \n", "Last Updates", "|");
    System.out.println("--------------------------------------------------");
    Dados[] arrayOrdenadoLastUpdate = selectionSort.selectionSortLastUpdates(dados.clone(), path[3][0], 1); // medio
                                                                                                            // caso
    selectionSort.selectionSortLastUpdates(arrayOrdenadoLastUpdate.clone(), path[3][1], 0); // melhor caso
    Dados[] arrayInvertido = tools.inverteArray(arrayOrdenadoLastUpdate);
    selectionSort.selectionSortLastUpdates(arrayInvertido.clone(), path[3][2], 2); // pior caso
    System.out.println("--------------------------------------------------");

  }

  static String[] caso = { "Melhor Caso", "Medio Caso", "Pior Caso" };

  public static Dados[] selectionSortInstalls(Dados[] array, String path, int indexCaso) {
    long timeStart = System.currentTimeMillis();
    for (int i = 0; i < array.length - 1; i++) {
      int min = i;
      for (int j = min + 1; j < array.length - 1; j++) {

        String newvalorJ = array[j].getInstalls()
            .replace(",", "")
            .replace("+", "")
            .replace("\"", "");
        String newvalorMin = array[min].getInstalls()
            .replace(",", "")
            .replace("+", "")
            .replace("\"", "");

        int intJ = Integer.parseInt(newvalorJ);
        int intMin = Integer.parseInt(newvalorMin);
        if (intJ < intMin) {
          min = j;
        }
      }
      if (min != i) {
        Dados temp = array[i];
        array[i] = array[min];
        array[min] = temp;
      }
    }
    long timeEnd = System.currentTimeMillis() - timeStart;
    System.out.format("|%s %11s %22s %5d  |%n", "Caso:", caso[indexCaso], "Tempo de execucao:", timeEnd);
    String name = path;
    tools.escreverCSV(array, name);
    return array;
  }

  public static Dados[] selectionSortNames(Dados[] array, String path, int indexCaso) {
    long timeStart = System.currentTimeMillis();
    for (int i = 0; i < array.length - 1; i++) {
      int min = i;
      for (int j = min + 1; j < array.length - 1; j++) {
        if ((array[j].getApp()).compareToIgnoreCase(array[min].getApp()) < 0) {
          min = j;
        }
      }
      if (min != i) {
        Dados temp = array[i];
        array[i] = array[min];
        array[min] = temp;

      }
    }
    long timeEnd = System.currentTimeMillis() - timeStart;
    System.out.format("|%s %11s %22s %5d  |%n", "Caso:", caso[indexCaso], "Tempo de execucao:", timeEnd);

    String name = path;
    tools.escreverCSV(array, name);
    return array;

  }

  public static Dados[] selectionSortRatings(Dados[] array, String path, int indexCaso) {
    long timeStart = System.currentTimeMillis();
    for (int i = 0; i < array.length - 1; i++) {
      int min = i;
      for (int j = min + 1; j < array.length - 1; j++) {
        double toFloatJ = transformRatings(array[j].getRating());
        double toFloatMin = transformRatings(array[min].getRating());

        if (toFloatJ < toFloatMin) {
          min = j;
        }
      }
      if (min != i) {
        Dados temp = array[i];
        array[i] = array[min];
        array[min] = temp;

      }
    }
    long timeEnd = System.currentTimeMillis() - timeStart;
    System.out.format("|%s %11s %22s %5d  |%n", "Caso:", caso[indexCaso], "Tempo de execucao:", timeEnd);

    String name = path;
    tools.escreverCSV(array, name);
    return array;

  }

  public static Dados[] selectionSortLastUpdates(Dados[] array, String path, int indexCaso) {
    long timeStart = System.currentTimeMillis();
    for (int i = 0; i < array.length - 1; i++) {
      int min = i;
      for (int j = min + 1; j < array.length - 1; j++) {
        String dateMin = array[min].getLast_update();
        String dateJ = array[j].getLast_update();
        if (tools.dateComp(dateMin, dateJ) == -1) {
          min = j;
        }
      }
      if (min != i) {
        Dados temp = array[i];
        array[i] = array[min];
        array[min] = temp;
      }
    }
    long timeEnd = System.currentTimeMillis() - timeStart;
    System.out.format("|%s %11s %22s %5d  |%n", "Caso:", caso[indexCaso], "Tempo de execucao:", timeEnd);
    String name = path;
    tools.escreverCSV(array, name);
    return array;
  }
}
