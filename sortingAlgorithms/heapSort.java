package sortingAlgorithms;

import util.Dados;
import util.tools;

public class heapSort extends tools {
  public static void heap(Dados[] dados) {
    String[][] path = { { "googleplaystore_Names_heapSort_medioCaso.csv",
        "googleplaystore_Names_heapSort_melhorCaso.csv",
        "googleplaystore_Names_heapSort_piorCaso.csv" },

        { "googleplaystore_Ratings_heapSort_medioCaso.csv",
            "googleplaystore_Ratings_heapSort_melhorCaso.csv",
            "googleplaystore_Ratings_heapSort_piorCaso.csv" },

        { "googleplaystore_Installs_heapSort_medioCaso.csv",
            "googleplaystore_Installs_heapSort_melhorCaso.csv",
            "googleplaystore_Installs_heapSort_piorCaso.csv" },

        { "googleplaystore_LastUpdate_heapSort_medioCaso.csv",
            "googleplaystore_LastUpdate_heapSort_melhorCaso.csv",
            "googleplaystore_LastUpdate_heapSort_piorCaso.csv" } };

    System.out.println("\n--------------------------------------------------");
    System.out.printf("|%s %39s \n", "Heap Sort", "|");

    // Heap Sort - NAMES --
    System.out.println("--------------------------------------------------");
    System.out.printf("|%s %43s \n", "Names", "|");
    System.out.println("--------------------------------------------------");
    Dados[] arrayOrdenadoNAMES = heapSort.heapSortNames(dados.clone(), path[0][0], 1); // medio caso
    heapSort.heapSortNames(arrayOrdenadoNAMES.clone(), path[0][1], 0); // melhor caso
    Dados[] arrayInvertidoNAMES = tools.inverteArray(arrayOrdenadoNAMES);
    heapSort.heapSortNames(arrayInvertidoNAMES.clone(), path[0][2], 2); // pior caso

    // Heap Sort - RATINGS
    System.out.println("--------------------------------------------------");
    System.out.printf("|%s %41s \n", "Ratings", "|");
    System.out.println("--------------------------------------------------");
    Dados[] arrayOrdenadoRATINGS = heapSort.heapSortRatings(dados.clone(), path[1][0], 1); // medio caso
    heapSort.heapSortRatings(arrayOrdenadoRATINGS.clone(), path[1][1], 0); // melhor caso
    Dados[] arrayInvertidoRATINGS = tools.inverteArray(arrayOrdenadoRATINGS);
    heapSort.heapSortRatings(arrayInvertidoRATINGS.clone(), path[1][2], 2); // pior caso

    // Heap Sort - INSTALLS
    System.out.println("--------------------------------------------------");
    System.out.printf("|%s %40s \n", "Installs", "|");
    System.out.println("--------------------------------------------------");
    Dados[] arrayOrdenadoINSTALLS = heapSort.heapSortInstalls(dados.clone(), path[2][0], 1); // medio caso
    heapSort.heapSortInstalls(arrayOrdenadoINSTALLS.clone(), path[2][1], 0); // melhor caso
    Dados[] arrayInvertidoINSTALLS = tools.inverteArray(arrayOrdenadoINSTALLS);
    heapSort.heapSortInstalls(arrayInvertidoINSTALLS.clone(), path[2][2], 2); // pior caso

    // Heap Sort - LAST UPDATES
    System.out.println("--------------------------------------------------");
    System.out.printf("|%s %36s \n", "Last Updates", "|");
    System.out.println("--------------------------------------------------");
    Dados[] arrayOrdenadoLastUpdate = heapSort.heapSortLastUpdate(dados.clone(), path[3][0], 1); // medio caso
    heapSort.heapSortLastUpdate(arrayOrdenadoLastUpdate.clone(), path[3][1], 0); // melhor caso
    Dados[] arrayInvertido = tools.inverteArray(arrayOrdenadoLastUpdate);
    heapSort.heapSortLastUpdate(arrayInvertido.clone(), path[3][2], 2); // pior caso
    System.out.println("--------------------------------------------------");

  }

  static String[] caso = { "Melhor Caso", "Medio Caso", "Pior Caso" };

  // ------------------------ NAME -------------------------------------------

  public static Dados[] heapSortNames(Dados[] arr, String path, int indexCaso) {
    long timeStart = System.currentTimeMillis();

    int n = arr.length - 1;
    // Construir heap máximo
    for (int i = n / 2 - 1; i >= 0; i--) {
      heapifyNames(arr, n, i);
    }
    // Heap sort
    for (int i = n - 1; i >= 0; i--) {
      Dados temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;
      // Heapify elemento raiz
      heapifyNames(arr, i, 0);
    }

    long timeEnd = System.currentTimeMillis() - timeStart;
    System.out.format("|%s %11s %22s %5d  |%n", "Caso:", caso[indexCaso], "Tempo de execucao:", timeEnd);
    String name = path;
    tools.escreverCSV(arr, name);
    return arr;
  }

  public static void heapifyNames(Dados[] arr, int n, int i) {
    // Encontra o maior entre raiz, filho esquerdo e filho direito
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;
    /**
     * 0 se a string for igual à outra string
     * < 0 se a string for lexicograficamente menor que a outra string
     * > 0 se a string for lexicograficamente maior que a outra string (mais
     * caracteres)
     */

    if (l < n && ((arr[l].getApp()).compareToIgnoreCase(arr[largest].getApp()) > 0)) // > 0 arr[l] > arr[largest]
      largest = l;

    if (r < n && ((arr[r].getApp()).compareToIgnoreCase(arr[largest].getApp()) > 0)) // arr[r] > arr[largest]
      largest = r;

    // Troque e continue empilhando se a raiz não for maior
    if (largest != i) {
      Dados swap = arr[i];
      arr[i] = arr[largest];
      arr[largest] = swap;

      heapifyNames(arr, n, largest);
    }
  }

  // ------------------------ RATINGS ----------------------------------------

  public static Dados[] heapSortRatings(Dados[] arr, String path, int indexCaso) {
    long timeStart = System.currentTimeMillis();

    int n = arr.length - 1;
    // Construir heap máximo
    for (int i = n / 2 - 1; i >= 0; i--) {
      heapifyRatings(arr, n, i);
    }
    // Heap sort
    for (int i = n - 1; i >= 0; i--) {
      Dados temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;
      // Heapify elemento raiz
      heapifyRatings(arr, i, 0);
    }

    long timeEnd = System.currentTimeMillis() - timeStart;
    System.out.format("|%s %11s %22s %5d  |%n", "Caso:", caso[indexCaso], "Tempo de execucao:", timeEnd);
    String name = path;
    tools.escreverCSV(arr, name);
    return arr;
  }

  public static void heapifyRatings(Dados[] arr, int n, int i) {
    // Encontra o maior entre raiz, filho esquerdo e filho direito
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;

    if (l < n && transformRatings(arr[l].getRating()) > transformRatings(arr[largest].getRating())) // arr[l] >
                                                                                                    // arr[largest]
      largest = l;

    if (r < n && transformRatings(arr[r].getRating()) > transformRatings(arr[largest].getRating())) // arr[r] >
                                                                                                    // arr[largest]
      largest = r;

    // Troque e continue empilhando se a raiz não for maior
    if (largest != i) {
      Dados swap = arr[i];
      arr[i] = arr[largest];
      arr[largest] = swap;

      heapifyRatings(arr, n, largest);
    }
  }

  // ------------------------ INSTALLS ---------------------------------------

  public static Dados[] heapSortInstalls(Dados[] arr, String path, int indexCaso) {
    long timeStart = System.currentTimeMillis();

    int n = arr.length - 1;
    // Construir heap máximo
    for (int i = n / 2 - 1; i >= 0; i--) {
      heapifyInstalls(arr, n, i);
    }
    // Heap sort
    for (int i = n - 1; i >= 0; i--) {
      Dados temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;
      // Heapify elemento raiz
      heapifyInstalls(arr, i, 0);
    }

    long timeEnd = System.currentTimeMillis() - timeStart;
    System.out.format("|%s %11s %22s %5d  |%n", "Caso:", caso[indexCaso], "Tempo de execucao:", timeEnd);
    String name = path;
    tools.escreverCSV(arr, name);
    return arr;
  }

  public static void heapifyInstalls(Dados[] arr, int n, int i) {
    // Encontra o maior entre raiz, filho esquerdo e filho direito
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;

    if (l < n && (Integer.parseInt(arr[l].getInstalls().replace(",", "").replace("+", "").replace("\"", ""))) > (Integer
        .parseInt(arr[largest].getInstalls().replace(",", "").replace("+", "").replace("\"", "")))) // arr[l] >
                                                                                                    // arr[largest]
      largest = l;

    if (r < n && (Integer.parseInt(arr[r].getInstalls().replace(",", "").replace("+", "").replace("\"", ""))) > (Integer
        .parseInt(arr[largest].getInstalls().replace(",", "").replace("+", "").replace("\"", "")))) // arr[r] >
                                                                                                    // arr[largest]
      largest = r;

    // Troque e continue empilhando se a raiz não for maior
    if (largest != i) {
      Dados swap = arr[i];
      arr[i] = arr[largest];
      arr[largest] = swap;

      heapifyInstalls(arr, n, largest);
    }
  }

  // ------------------------ LAST UPDATE ------------------------------------

  public static Dados[] heapSortLastUpdate(Dados[] arr, String path, int indexCaso) {
    long timeStart = System.currentTimeMillis();

    int n = arr.length - 1;
    // Construir heap máximo
    for (int i = n / 2 - 1; i >= 0; i--) {
      heapifyLastUpdate(arr, n, i);
    }
    // Heap sort
    for (int i = n - 1; i >= 0; i--) {
      Dados temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;
      // Heapify elemento raiz
      heapifyLastUpdate(arr, i, 0);
    }

    long timeEnd = System.currentTimeMillis() - timeStart;
    System.out.format("|%s %11s %22s %5d  |%n", "Caso:", caso[indexCaso], "Tempo de execucao:", timeEnd);
    String name = path;
    tools.escreverCSV(arr, name);
    return arr;
  }

  public static void heapifyLastUpdate(Dados[] arr, int n, int i) {
    // Encontra o maior entre raiz, filho esquerdo e filho direito
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;

    // date1 é posterior por causa do ano = -1
    // date2 é posterior por causa do ano = 1
    // date1 == date2 = 0

    if (l < n && (dateComp(arr[l].getLast_update(), arr[largest].getLast_update())) < 0) // arr[l] > arr[largest]
      largest = l;

    if (r < n && (dateComp(arr[r].getLast_update(), arr[largest].getLast_update())) < 0) // arr[r] > arr[largest]
      largest = r;

    // Troque e continue empilhando se a raiz não for maior
    if (largest != i) {
      Dados swap = arr[i];
      arr[i] = arr[largest];
      arr[largest] = swap;

      heapifyLastUpdate(arr, n, largest);
    }
  }
}
