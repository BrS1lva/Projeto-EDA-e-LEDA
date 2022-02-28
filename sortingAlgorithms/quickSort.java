package sortingAlgorithms;

import util.*;

public class quickSort extends tools {
  public static void quick(Dados[] dados) {
    String[][] path = { { "googleplaystore_Names_quickSort_medioCaso.csv",
        "googleplaystore_Names_quickSort_melhorCaso.csv",
        "googleplaystore_Names_quickSort_piorCaso.csv" },

        { "googleplaystore_Ratings_quickSort_medioCaso.csv",
            "googleplaystore_Ratings_quickSort_melhorCaso.csv",
            "googleplaystore_Ratings_quickSort_piorCaso.csv" },

        { "googleplaystore_Installs_quickSort_medioCaso.csv",
            "googleplaystore_Installs_quickSort_melhorCaso.csv",
            "googleplaystore_Installs_quickSort_piorCaso.csv" },

        { "googleplaystore_LastUpdate_quickSort_medioCaso.csv",
            "googleplaystore_LastUpdate_quickSort_melhorCaso.csv",
            "googleplaystore_LastUpdate_quickSort_piorCaso.csv" } };

    System.out.println("\n--------------------------------------------------");
    System.out.printf("|%s %38s \n", "Quick Sort", "|");

    // Quick Sort - NAMES --
    System.out.println("--------------------------------------------------");
    System.out.printf("|%s %43s \n", "Names", "|");
    System.out.println("--------------------------------------------------");
    Dados[] arrayOrdenadoNAMES = quickSort.quickSortNames(dados.clone(), path[0][0], 1); // medio caso
    quickSort.quickSortNames(arrayOrdenadoNAMES.clone(), path[0][1], 0); // melhor caso
    Dados[] arrayInvertidoNAMES = tools.inverteArray(arrayOrdenadoNAMES);
    quickSort.quickSortNames(arrayInvertidoNAMES.clone(), path[0][2], 2); // pior caso

    // Quick Sort - RATINGS
    System.out.println("--------------------------------------------------");
    System.out.printf("|%s %41s \n", "Ratings", "|");
    System.out.println("--------------------------------------------------");
    Dados[] arrayOrdenadoRATINGS = quickSort.quickSortRatings(dados.clone(), path[1][0], 1); // medio caso
    quickSort.quickSortRatings(arrayOrdenadoRATINGS.clone(), path[1][1], 0); // melhor caso
    Dados[] arrayInvertidoRATINGS = tools.inverteArray(arrayOrdenadoRATINGS);
    quickSort.quickSortRatings(arrayInvertidoRATINGS.clone(), path[1][2], 2); // pior caso

    // Quick Sort - INSTALLS
    System.out.println("--------------------------------------------------");
    System.out.printf("|%s %40s \n", "Installs", "|");
    System.out.println("--------------------------------------------------");
    Dados[] arrayOrdenadoINSTALLS = quickSort.quickSortInstalls(dados.clone(), path[2][0], 1); // medio caso
    quickSort.quickSortInstalls(arrayOrdenadoINSTALLS.clone(), path[2][1], 0); // melhor caso
    Dados[] arrayInvertidoINSTALLS = tools.inverteArray(arrayOrdenadoINSTALLS);
    quickSort.quickSortInstalls(arrayInvertidoINSTALLS.clone(), path[2][2], 2); // pior caso

    // Quick Sort - LAST UPDATES
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
      // Chamada da rotina que ira dividir o vetor em 3 partes.
      int indexPivo = partitionNames(array, inicio, fim);
      /*
       * Chamada recursiva para redivisao do vetor de elementos menores
       * que o pivô.
       */
      quickNames(array, inicio, indexPivo - 1);
      /*
       * Chamada recursiva para redivisao do vetor de elementos maiores
       * que o pivô.
       */
      quickNames(array, indexPivo + 1, fim);
    }
  }

  private static int partitionNames(Dados[] arr, int begin, int end) {
    int pontDir = end;
    int pontEsq = begin + 1;
    String pivot = arr[begin].getApp();
    while (pontEsq <= pontDir) {
      while (pontEsq <= pontDir && (arr[pontEsq].getApp()).compareToIgnoreCase(pivot) <= 0) {
        pontEsq++;
      }
      while (pontDir >= pontEsq && (arr[pontDir].getApp()).compareToIgnoreCase(pivot) > 0) {
        pontDir--;
      }
      /*
       * Caso os ponteiros ainda nao tenham se cruzado, significa que valores
       * menores e maiores que o pivô foram localizados em ambos os lados.
       * Trocar estes elementos de lado.
       */
      if (pontEsq < pontDir) {
        trocar(arr, pontDir, pontEsq);
        pontEsq++;
        pontDir--;
      }
    }
    trocar(arr, begin, pontDir);
    return pontDir;
  }

  // ------------------------ Ratings -------------------------------------------

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
    int pontDir = end;
    int pontEsq = begin + 1;
    String pivot = arr[begin].getRating();
    while (pontEsq <= pontDir) {
      while (pontEsq <= pontDir && (transformRatings(arr[pontEsq].getRating())) <= transformRatings(pivot)) {
        pontEsq++;
      }
      while (pontDir >= pontEsq && transformRatings(arr[pontDir].getRating()) > transformRatings(pivot)) {
        pontDir--;
      }
      if (pontEsq < pontDir) {
        trocar(arr, pontDir, pontEsq);
        pontEsq++;
        pontDir--;
      }
    }
    trocar(arr, begin, pontDir);
    return pontDir;
  }

  // ------------------- INSTALLS ---------------------

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
    int pontDir = end;
    int pontEsq = begin + 1;
    int pivot = Integer.parseInt(arr[begin].getInstalls() // remover virgula, + e aspas
        .replace(",", "")
        .replace("+", "")
        .replace("\"", ""));
    while (pontEsq <= pontDir) {
      while (pontEsq <= pontDir && (Integer
          .parseInt(arr[pontEsq].getInstalls().replace(",", "").replace("+", "").replace("\"", ""))) <= pivot) {
        pontEsq++;
      }
      while (pontDir >= pontEsq && (Integer
          .parseInt(arr[pontDir].getInstalls().replace(",", "").replace("+", "").replace("\"", ""))) > pivot) {
        pontDir--;
      }
      if (pontEsq < pontDir) {
        trocar(arr, pontDir, pontEsq);
        pontEsq++;
        pontDir--;
      }
    }
    trocar(arr, begin, pontDir);
    return pontDir;
  }

  // ------------------- LAST UPDATE ---------------------

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
    int pontDir = end;
    int pontEsq = begin + 1;
    String pivot = arr[begin].getLast_update();
    while (pontEsq <= pontDir) {
      /**
       * dateComp = return -1 : date1 > date2
       * return 1 : date1 < date2
       * return 0 : date1 == date2
       */
      while (pontEsq <= pontDir && dateComp(arr[pontEsq].getLast_update(), pivot) >= 0) {
        pontEsq++;
      }
      while (pontDir >= pontEsq && dateComp(arr[pontDir].getLast_update(), pivot) == -1) {
        pontDir--;
      }
      if (pontEsq < pontDir) {
        trocar(arr, pontDir, pontEsq);
        pontEsq++;
        pontDir--;
      }
    }
    trocar(arr, begin, pontDir);
    return pontDir;
  }

  // -------------- Trocar --------------------------------

  private static void trocar(Dados[] vetor, int i, int j) {
    Dados temp = vetor[i];
    vetor[i] = vetor[j];
    vetor[j] = temp;
  }
}
