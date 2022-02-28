package sortingAlgorithms;

import util.*;

public class insertionSort extends tools {

  public static void insertion(Dados[] dados) {
    String[][] path = { { "googleplaystore_Names_insertionSort_medioCaso.csv",
        "googleplaystore_Names_insertionSort_melhorCaso.csv",
        "googleplaystore_Names_insertionSort_piorCaso.csv" },

        { "googleplaystore_Ratings_insertionSort_medioCaso.csv",
            "googleplaystore_Ratings_insertionSort_melhorCaso.csv",
            "googleplaystore_Ratings_insertionSort_piorCaso.csv" },

        { "googleplaystore_Installs_insertionSort_medioCaso.csv",
            "googleplaystore_Installs_insertionSort_melhorCaso.csv",
            "googleplaystore_Installs_insertionSort_piorCaso.csv" },

        { "googleplaystore_LastUpdate_insertionSort_medioCaso.csv",
            "googleplaystore_LastUpdate_insertionSort_melhorCaso.csv",
            "googleplaystore_LastUpdate_insertionSort_piorCaso.csv" } };

    System.out.println("\n--------------------------------------------------");
    System.out.printf("|%s %34s \n", "Insertion Sort", "|");

    // Insertion Sort - NAMES --
    System.out.println("--------------------------------------------------");
    System.out.printf("|%s %43s \n", "Names", "|");
    System.out.println("--------------------------------------------------");
    Dados[] arrayOrdenadoNAMES = insertionSort.insertionSortNames(dados.clone(), path[0][0], 1); // medio caso
    insertionSort.insertionSortNames(arrayOrdenadoNAMES.clone(), path[0][1], 0); // melhor caso
    Dados[] arrayInvertidoNAMES = tools.inverteArray(arrayOrdenadoNAMES);
    insertionSort.insertionSortNames(arrayInvertidoNAMES.clone(), path[0][2], 2); // pior caso

    // Insertion Sort - RATINGS
    System.out.println("--------------------------------------------------");
    System.out.printf("|%s %41s \n", "Ratings", "|");
    System.out.println("--------------------------------------------------");
    Dados[] arrayOrdenadoRATINGS = insertionSort.insertionSortRatings(dados.clone(), path[1][0], 1); // medio caso
    insertionSort.insertionSortRatings(arrayOrdenadoRATINGS.clone(), path[1][1], 0); // melhor caso
    Dados[] arrayInvertidoRATINGS = tools.inverteArray(arrayOrdenadoRATINGS);
    insertionSort.insertionSortRatings(arrayInvertidoRATINGS.clone(), path[1][2], 2); // pior caso

    // Insertion Sort - INSTALLS
    System.out.println("--------------------------------------------------");
    System.out.printf("|%s %40s \n", "Installs", "|");
    System.out.println("--------------------------------------------------");
    Dados[] arrayOrdenadoINSTALLS = insertionSort.insertionSortInstalls(dados.clone(), path[2][0], 1); // medio caso
    insertionSort.insertionSortInstalls(arrayOrdenadoINSTALLS.clone(), path[2][1], 0); // melhor caso
    Dados[] arrayInvertidoINSTALLS = tools.inverteArray(arrayOrdenadoINSTALLS);
    insertionSort.insertionSortInstalls(arrayInvertidoINSTALLS.clone(), path[2][2], 2); // pior caso

    // Insertion Sort - LAST UPDATES
    System.out.println("--------------------------------------------------");
    System.out.printf("|%s %36s \n", "Last Updates", "|");
    System.out.println("--------------------------------------------------");
    Dados[] arrayOrdenadoLastUpdate = insertionSort.insertionSortLastUpdate(dados.clone(), path[3][0], 1); // medio caso
    insertionSort.insertionSortLastUpdate(arrayOrdenadoLastUpdate.clone(), path[3][1], 0); // melhor caso
    Dados[] arrayInvertido = tools.inverteArray(arrayOrdenadoLastUpdate);
    insertionSort.insertionSortLastUpdate(arrayInvertido.clone(), path[3][2], 2); // pior caso
    System.out.println("--------------------------------------------------");

  }

  // ----------------- Ordenações -----------------------

  static String[] caso = { "Melhor Caso", "Medio Caso", "Pior Caso" };

  // -------------------- NAMES --------------------------
  public static Dados[] insertionSortNames(Dados[] array, String path, int indexCaso) {
    long timeStart = System.currentTimeMillis();
    int n = array.length - 1;
    for (int j = 1; j < n; j++) {
      Dados key = array[j];
      int i = j - 1;
      while ((i >= 0) && ((key.getApp()).compareToIgnoreCase(array[i].getApp()) < 0)) {
        array[i + 1] = array[i];
        i--;
      }
      array[i + 1] = key;
    }
    long timeEnd = System.currentTimeMillis() - timeStart;
    System.out.format("|%s %11s %22s %5d  |%n", "Caso:", caso[indexCaso], "Tempo de execucao:", timeEnd);

    String name = path;
    tools.escreverCSV(array, name);
    return array;
  }

  // -------------------- RATINGS --------------------------

  public static Dados[] insertionSortRatings(Dados[] array, String path, int indexCaso) {
    long timeStart = System.currentTimeMillis();
    int n = array.length - 1;
    for (int j = 1; j < n; j++) {
      Dados key = array[j];
      int i = j - 1;
      // System.out.println(Double.isNaN(Double.parseDouble(key.getRating())));
      double toDoubleKey = transformRatings(key.getRating());
      // double toFloatI = Double.parseDouble(array[i].getRating());
      while ((i >= 0) && toDoubleKey < (transformRatings(array[i].getRating()))) {
        array[i + 1] = array[i];
        i--;
      }
      array[i + 1] = key;
    }
    long timeEnd = System.currentTimeMillis() - timeStart;
    System.out.format("|%s %11s %22s %5d  |%n", "Caso:", caso[indexCaso], "Tempo de execucao:", timeEnd);

    String name = path;
    tools.escreverCSV(array, name);
    return array;

  }

  public static Dados[] insertionSortInstalls(Dados[] array, String path, int indexCaso) {
    long timeStart = System.currentTimeMillis();
    int n = array.length - 1; // -1
    for (int j = 1; j < n; j++) {

      Dados key = array[j];
      int i = j - 1;
      String newValorKey = key.getInstalls()
          .replace(",", "")
          .replace("+", "")
          .replace("\"", "");
      int intKey = Integer.parseInt(newValorKey);
      while ((i >= 0)
          && intKey < Integer.parseInt(array[i].getInstalls().replace(",", "").replace("+", "").replace("\"", ""))) { //
        array[i + 1] = array[i];
        i--;
      }
      array[i + 1] = key;
    }
    long timeEnd = System.currentTimeMillis() - timeStart;
    System.out.format("|%s %11s %22s %5d  |%n", "Caso:", caso[indexCaso], "Tempo de execucao:", timeEnd);

    String name = path;
    tools.escreverCSV(array, name);
    return array;

  }

  public static Dados[] insertionSortLastUpdate(Dados[] array, String path, int indexCaso) {
    long timeStart = System.currentTimeMillis();
    int n = array.length - 1;
    for (int j = 1; j < n; j++) {
      Dados key = array[j];
      int i = j - 1;
      String dateKey = key.getLast_update();
      // String dateI = array[i].getLast_update();
      while ((i >= 0) && (tools.dateComp(dateKey, array[i].getLast_update()) == 1)) { //
        array[i + 1] = array[i];
        i--;
      }
      array[i + 1] = key;
    }
    long timeEnd = System.currentTimeMillis() - timeStart;
    System.out.format("|%s %11s %22s %5d  |%n", "Caso:", caso[indexCaso], "Tempo de execucao:", timeEnd);

    String name = path;
    tools.escreverCSV(array, name);
    return array;

  }
}
