package sortingAlgorithms;

import util.*;

public class quicksortMedianaDeTres extends tools {
  public static void quick3(Dados[] dados) {
    String[][] path = { { "googleplaystore_Names_quickM3_medioCaso.csv",
        "googleplaystore_Names_quickM3_melhorCaso.csv",
        "googleplaystore_Names_quickM3_piorCaso.csv" },

        { "googleplaystore_Ratings_quickM3_medioCaso.csv",
            "googleplaystore_Ratings_quickM3_melhorCaso.csv",
            "googleplaystore_Ratings_quickM3_piorCaso.csv" },

        { "googleplaystore_Installs_quickM3_medioCaso.csv",
            "googleplaystore_Installs_quickM3_melhorCaso.csv",
            "googleplaystore_Installs_quickM3_piorCaso.csv" },

        { "googleplaystore_LastUpdate_quickM3_medioCaso.csv",
            "googleplaystore_LastUpdate_quickM3_melhorCaso.csv",
            "googleplaystore_LastUpdate_quickM3_piorCaso.csv" } };

    System.out.println("\n--------------------------------------------------");
    System.out.printf("|%s %24s \n", "Quick Sort Mediana de 3 ", "|");

    // Quick3 Sort - NAMES --
    System.out.println("--------------------------------------------------");
    System.out.printf("|%s %43s \n", "Names", "|");
    System.out.println("--------------------------------------------------");
    Dados[] arrayOrdenadoNAMES = quickSort.quickSortNames(dados.clone(), path[0][0], 1); // medio caso
    quickSort.quickSortNames(arrayOrdenadoNAMES.clone(), path[0][1], 0); // melhor caso
    Dados[] arrayInvertidoNAMES = tools.inverteArray(arrayOrdenadoNAMES);
    quickSort.quickSortNames(arrayInvertidoNAMES.clone(), path[0][2], 2); // pior caso

    // Quick3 Sort - RATINGS
    System.out.println("--------------------------------------------------");
    System.out.printf("|%s %41s \n", "Ratings", "|");
    System.out.println("--------------------------------------------------");
    Dados[] arrayOrdenadoRATINGS = quickSort.quickSortRatings(dados.clone(), path[1][0], 1); // medio caso
    quickSort.quickSortRatings(arrayOrdenadoRATINGS.clone(), path[1][1], 0); // melhor caso
    Dados[] arrayInvertidoRATINGS = tools.inverteArray(arrayOrdenadoRATINGS);
    quickSort.quickSortRatings(arrayInvertidoRATINGS.clone(), path[1][2], 2); // pior caso

    // Quick3 Sort - INSTALLS
    System.out.println("--------------------------------------------------");
    System.out.printf("|%s %40s \n", "Installs", "|");
    System.out.println("--------------------------------------------------");
    Dados[] arrayOrdenadoINSTALLS = quickSort.quickSortInstalls(dados.clone(), path[2][0], 1); // medio caso
    quickSort.quickSortInstalls(arrayOrdenadoINSTALLS.clone(), path[2][1], 0); // melhor caso
    Dados[] arrayInvertidoINSTALLS = tools.inverteArray(arrayOrdenadoINSTALLS);
    quickSort.quickSortInstalls(arrayInvertidoINSTALLS.clone(), path[2][2], 2); // pior caso

    // Quick3 Sort - LAST UPDATES
    System.out.println("--------------------------------------------------");
    System.out.printf("|%s %36s \n", "Last Updates", "|");
    System.out.println("--------------------------------------------------");
    Dados[] arrayOrdenadoLastUpdate = quickSort.quickSortLastUpdate(dados.clone(), path[3][0], 1); // medio caso
    quickSort.quickSortLastUpdate(arrayOrdenadoLastUpdate.clone(), path[3][1], 0); // melhor caso
    Dados[] arrayInvertido = tools.inverteArray(arrayOrdenadoLastUpdate);
    quickSort.quickSortLastUpdate(arrayInvertido.clone(), path[3][2], 2); // pior caso
    System.out.println("--------------------------------------------------");

  }

  static String[] caso = { "Melhor Caso", "Medio Caso", "Pior Caso" };

  // ------------------------ NAMES -------------------------------------------

  public static Dados[] quickSortNames(Dados[] array, String path, int indexCaso) {
    long timeStart = System.currentTimeMillis();
    quickNames(array, 0, array.length - 2);
    long timeEnd = System.currentTimeMillis() - timeStart;
    System.out.format("|%s %11s %22s %5d  |%n", "Caso:", caso[indexCaso], "Tempo de execucao:", timeEnd);

    String name = path;
    tools.escreverCSV(array, name);
    return array;
  }

  private static void quickNames(Dados[] array, int inicio, int fim) {
    if (fim > inicio) {
      int indexPivo = partitionNames(array, inicio, fim);
      quickNames(array, inicio, indexPivo - 1);
      quickNames(array, indexPivo + 1, fim);
    }
  }

  private static int partitionNames(Dados[] arr, int begin, int end) {
    int pivot = (begin + end) / 2;
    String a = arr[begin].getApp();
    String b = arr[pivot].getApp();
    String c = arr[end].getApp();
    int medianaIndice; // índice da mediana
    // A sequência de if...else a seguir verifica qual é a mediana
    if (a.compareToIgnoreCase(b) < 0) {
      if (b.compareToIgnoreCase(c) < 0) {
        // a < b && b < c
        medianaIndice = pivot;
      } else {
        if (a.compareToIgnoreCase(c) < 0) {
          // a < c && c <= b
          medianaIndice = pivot;
        } else {
          // c <= a && a < b
          medianaIndice = begin;
        }
      }
    } else {
      if (c.compareTo(b) < 0) {
        // c < b && b <= a
        medianaIndice = pivot;
      } else {
        if (c.compareTo(a) < 0) {
          // b <= c && c < a
          medianaIndice = end;
        } else {
          // b <= a && a <= c
          medianaIndice = begin;
        }
      }
    }
    // coloca o elemento da mediana no fim para poder usar o Quicksort de Cormen
    trocar(arr, medianaIndice, end);

    // *******************ALGORITMO DE PARTIÇÃO DE CORMEN*********************
    // o pivo é o elemento final
    Dados pivo = arr[end];
    int i = begin - 1;
    /*
     * Este laço irá varrer os vetores da esquerda para direira
     * procurando os elementos que são menores ou iguais ao pivô.
     * Esses elementos são colocados na partição esquerda.
     */
    for (int j = begin; j <= end - 1; j++) {
      if ((arr[j].getApp()).compareToIgnoreCase(pivo.getApp()) < 0) { // arr[j] <= pivo
        i = i + 1;
        trocar(arr, i, j);
      }
    }
    // coloca o pivô na posição de ordenação
    trocar(arr, i + 1, end);
    return i + 1; // retorna a posição do pivô
  }

  // ------------------------- RATINGS ----------------------------------

  public static Dados[] quickSortRatings(Dados[] array, String path, int indexCaso) {
    long timeStart = System.currentTimeMillis();
    quickRatings(array, 0, array.length - 2);
    long timeEnd = System.currentTimeMillis() - timeStart;
    System.out.format("|%s %11s %22s %5d  |%n", "Caso:", caso[indexCaso], "Tempo de execucao:", timeEnd);

    String name = path;
    tools.escreverCSV(array, name);
    return array;
  }

  private static void quickRatings(Dados[] array, int inicio, int fim) {
    if (fim > inicio) {
      int indexPivo = partitionRatings(array, inicio, fim);
      quickRatings(array, inicio, indexPivo - 1);
      quickRatings(array, indexPivo + 1, fim);
    }
  }

  private static int partitionRatings(Dados[] arr, int begin, int end) {
    int pivot = (begin + end) / 2;
    String a = arr[begin].getApp();
    String b = arr[pivot].getApp();
    String c = arr[end].getApp();
    int medianaIndice;
    if (transformRatings(a) < transformRatings(b)) {
      if (transformRatings(b) < transformRatings(c)) {
        medianaIndice = pivot;
      } else {
        if (transformRatings(a) < transformRatings(c)) {
          medianaIndice = pivot;
        } else {
          medianaIndice = begin;
        }
      }
    } else {
      if (transformRatings(c) < transformRatings(b)) {
        medianaIndice = pivot;
      } else {
        if (transformRatings(c) < transformRatings(a)) {
          medianaIndice = end;
        } else {
          medianaIndice = begin;
        }
      }
    }
    trocar(arr, medianaIndice, end);
    Dados pivo = arr[end];
    int i = begin - 1;
    for (int j = begin; j <= end - 1; j++) {
      if (transformRatings(arr[j].getRating()) <= transformRatings(pivo.getRating())) { // arr[j] <= pivo
        i = i + 1;
        trocar(arr, i, j);
      }
    }
    trocar(arr, i + 1, end);
    return i + 1;
  }

  // ------------------------ INSTALLS ----------------------------------

  public static Dados[] quickSortInstalls(Dados[] array, String path, int indexCaso) {
    long timeStart = System.currentTimeMillis();
    quickInstalls(array, 0, array.length - 2);
    long timeEnd = System.currentTimeMillis() - timeStart;
    System.out.format("|%s %11s %22s %5d  |%n", "Caso:", caso[indexCaso], "Tempo de execucao:", timeEnd);

    String name = path;
    tools.escreverCSV(array, name);
    return array;
  }

  private static void quickInstalls(Dados[] array, int inicio, int fim) {
    if (fim > inicio) {
      int indexPivo = partitionInstalls(array, inicio, fim);
      quickInstalls(array, inicio, indexPivo - 1);
      quickInstalls(array, indexPivo + 1, fim);
    }
  }

  private static int partitionInstalls(Dados[] arr, int begin, int end) {
    int pivot = (begin + end) / 2;
    int a = Integer.parseInt(arr[begin].getInstalls().replace(",", "").replace("+", "").replace("\"", "")); // arr[begin].getApp();
    int b = Integer.parseInt(arr[pivot].getInstalls().replace(",", "").replace("+", "").replace("\"", "")); // arr[pivot].getApp();
    int c = Integer.parseInt(arr[end].getInstalls().replace(",", "").replace("+", "").replace("\"", "")); // arr[end].getApp();
    int medianaIndice;
    if (a < b) {
      if (b < c) {
        medianaIndice = pivot;
      } else {
        if (a < c) {
          medianaIndice = pivot;
        } else {
          medianaIndice = begin;
        }
      }
    } else {
      if (c < b) {
        medianaIndice = pivot;
      } else {
        if (c < a) {
          medianaIndice = end;
        } else {
          medianaIndice = begin;
        }
      }
    }
    trocar(arr, medianaIndice, end);
    Dados pivo = arr[end];
    int i = begin - 1;
    for (int j = begin; j <= end - 1; j++) {
      int aux = Integer.parseInt(arr[j].getInstalls().replace(",", "").replace("+", "").replace("\"", ""));
      if (aux <= Integer.parseInt(pivo.getLast_update().replace(",", "").replace("+", "").replace("\"", ""))) { // arr[j]
                                                                                                                // <=
                                                                                                                // pivo
        i = i + 1;
        trocar(arr, i, j);
      }
    }
    trocar(arr, i + 1, end);
    return i + 1;
  }

  // ---------------------- LAST UPDATE ---------------------------------

  public static Dados[] quickSortLastUpdate(Dados[] array, String path, int indexCaso) {
    long timeStart = System.currentTimeMillis();
    quickLastUpdate(array, 0, array.length - 2);
    long timeEnd = System.currentTimeMillis() - timeStart;
    System.out.format("|%s %11s %22s %5d  |%n", "Caso:", caso[indexCaso], "Tempo de execucao:", timeEnd);

    String name = path;
    tools.escreverCSV(array, name);
    return array;
  }

  private static void quickLastUpdate(Dados[] array, int inicio, int fim) {
    if (fim > inicio) {
      int indexPivo = partitionLastUpdate(array, inicio, fim);
      quickLastUpdate(array, inicio, indexPivo - 1);
      quickLastUpdate(array, indexPivo + 1, fim);
    }
  }

  private static int partitionLastUpdate(Dados[] arr, int begin, int end) {
    int pivot = (begin + end) / 2;
    String a = arr[begin].getLast_update();
    String b = arr[pivot].getLast_update();
    String c = arr[end].getLast_update();
    int medianaIndice;

    // ------------- DATE COMP ----------------
    // date1 é posterior por causa do ano = -1
    // date2 é posterior por causa do ano = 1
    // date1 == date2
    if (dateComp(a, b) == 1) {
      if (dateComp(b, c) == 1) {
        medianaIndice = pivot;
      } else {
        if (dateComp(a, c) == 1) {
          medianaIndice = pivot;
        } else {
          medianaIndice = begin;
        }
      }
    } else {
      if (dateComp(c, b) == 1) {
        medianaIndice = pivot;
      } else {
        if (dateComp(c, a) == 1) {
          medianaIndice = end;
        } else {
          medianaIndice = begin;
        }
      }
    }
    trocar(arr, medianaIndice, end);
    Dados pivo = arr[end];
    int i = begin - 1;
    for (int j = begin; j <= end - 1; j++) {
      if (dateComp(arr[j].getLast_update(), pivo.getLast_update()) >= 0) { // arr[j] <= pivo
        i = i + 1;
        trocar(arr, i, j);
      }
    }
    trocar(arr, i + 1, end);
    return i + 1;
  }

  // -------------- Trocar --------------------------------

  private static void trocar(Dados[] vetor, int i, int j) {
    Dados temp = vetor[i];
    vetor[i] = vetor[j];
    vetor[j] = temp;
  }
}
