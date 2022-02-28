package sortingAlgorithms;

import util.Dados;
import util.tools;

public class mergeSort extends tools {

  public static void merge(Dados[] dados) {
    String[][] path = { { "googleplaystore_Names_mergeSort_medioCaso.csv",
        "googleplaystore_Names_mergeSort_melhorCaso.csv",
        "googleplaystore_Names_mergeSort_piorCaso.csv" },

        { "googleplaystore_Ratings_mergeSort_medioCaso.csv",
            "googleplaystore_Ratings_mergeSort_melhorCaso.csv",
            "googleplaystore_Ratings_mergeSort_piorCaso.csv" },

        { "googleplaystore_Installs_mergeSort_medioCaso.csv",
            "googleplaystore_Installs_mergeSort_melhorCaso.csv",
            "googleplaystore_Installs_mergeSort_piorCaso.csv" },

        { "googleplaystore_LastUpdate_mergeSort_medioCaso.csv",
            "googleplaystore_LastUpdate_mergeSort_melhorCaso.csv",
            "googleplaystore_LastUpdate_mergeSort_piorCaso.csv" } };

    System.out.println("\n--------------------------------------------------");
    System.out.printf("|%s %38s \n", "Merge Sort", "|");

    // Merge Sort - NAMES --
    System.out.println("--------------------------------------------------");
    System.out.printf("|%s %43s \n", "Names", "|");
    System.out.println("--------------------------------------------------");
    Dados[] arrayOrdenadoNAMES = mergeSort.mergeNames(dados.clone(), path[0][0], 1); // medio caso
    mergeSort.mergeNames(arrayOrdenadoNAMES.clone(), path[0][1], 0); // melhor caso
    Dados[] arrayInvertidoNAMES = tools.inverteArray(arrayOrdenadoNAMES);
    mergeSort.mergeNames(arrayInvertidoNAMES.clone(), path[0][2], 2); // pior caso

    // Merge Sort - RATINGS
    System.out.println("--------------------------------------------------");
    System.out.printf("|%s %41s \n", "Ratings", "|");
    System.out.println("--------------------------------------------------");
    Dados[] arrayOrdenadoRATINGS = mergeSort.mergeRatings(dados.clone(), path[1][0], 1); // medio caso
    mergeSort.mergeRatings(arrayOrdenadoRATINGS.clone(), path[1][1], 0); // melhor caso
    Dados[] arrayInvertidoRATINGS = tools.inverteArray(arrayOrdenadoRATINGS);
    mergeSort.mergeRatings(arrayInvertidoRATINGS.clone(), path[1][2], 2); // pior caso

    // Merge Sort - INSTALLS
    System.out.println("--------------------------------------------------");
    System.out.printf("|%s %40s \n", "Installs", "|");
    System.out.println("--------------------------------------------------");
    Dados[] arrayOrdenadoINSTALLS = mergeSort.mergeInstalls(dados.clone(), path[2][0], 1); // medio caso
    mergeSort.mergeInstalls(arrayOrdenadoINSTALLS.clone(), path[2][1], 0); // melhor caso
    Dados[] arrayInvertidoINSTALLS = tools.inverteArray(arrayOrdenadoINSTALLS);
    mergeSort.mergeInstalls(arrayInvertidoINSTALLS.clone(), path[2][2], 2); // pior caso

    // Merge Sort - LAST UPDATES
    System.out.println("--------------------------------------------------");
    System.out.printf("|%s %36s \n", "Last Updates", "|");
    System.out.println("--------------------------------------------------");
    Dados[] arrayOrdenadoLastUpdate = mergeSort.mergeLastUpdate(dados.clone(), path[3][0], 1); // medio caso
    mergeSort.mergeLastUpdate(arrayOrdenadoLastUpdate.clone(), path[3][1], 0); // melhor caso
    Dados[] arrayInvertido = tools.inverteArray(arrayOrdenadoLastUpdate);
    mergeSort.mergeLastUpdate(arrayInvertido.clone(), path[3][2], 2); // pior caso
    System.out.println("--------------------------------------------------");

  }

  static String[] caso = { "Melhor Caso", "Medio Caso", "Pior Caso" };

  // ------------------------ NAME -------------------------------------------
  public static Dados[] mergeNames(Dados[] arr, String path, int indexCaso) {
    long timeStart = System.currentTimeMillis();

    mergeSortNames(arr, 0, arr.length - 1);

    long timeEnd = System.currentTimeMillis() - timeStart;
    System.out.format("|%s %11s %22s %5d  |%n", "Caso:", caso[indexCaso], "Tempo de execucao:", timeEnd);
    String name = path;
    tools.escreverCSV(arr, name);
    return arr;

  }

  public static void mergeSortNames(Dados[] array, int inicio, int fim) {
    if (inicio < fim - 1) {
      int meio = (inicio + fim) / 2;
      mergeSortNames(array, inicio, meio);
      mergeSortNames(array, meio, fim);
      intercalaNames(array, inicio, meio, fim);
    }
  }

  public static void intercalaNames(Dados[] array, int inicio, int meio, int fim) {

    Dados novoVetor[] = new Dados[fim - inicio];
    int i = inicio;
    int m = meio;
    int pos = 0;

    /*
     * Enquanto o inicio não chegar até o meio do vetor, ou o meio do vetor
     * não chegar até seu fim, compara os valores entre o inicio e o meio,
     * verificando em qual ordem vai guarda-los ordenado.
     */
    while (i < meio && m < fim) {
      /*
       * Se o vetor[i] for menor que o vetor[m], então guarda o valor do
       * vetor[i] pois este é menor.
       */
      if (array[i].getApp().compareToIgnoreCase(array[m].getApp()) <= 0) {
        novoVetor[pos] = array[i];
        pos = pos + 1;
        i = i + 1;
        // Senão guarda o valor do vetor[m] pois este é o menor.
      } else {
        novoVetor[pos] = array[m];
        pos = pos + 1;
        m = m + 1;
      }
    }
    // Adicionar no vetor os elementos que estão entre o inicio e meio,
    // que ainda não foram adicionados no vetor.
    while (i < meio) {
      novoVetor[pos] = array[i];
      pos = pos + 1;
      i = i + 1;
    }
    // Adicionar no vetor os elementos que estão entre o meio e o fim,
    // que ainda não foram adicionados no vetor.
    while (m < fim) {
      novoVetor[pos] = array[m];
      pos = pos + 1;
      m = m + 1;
    }

    // Coloca no vetor os valores já ordenados.
    for (pos = 0, i = inicio; i < fim; i++, pos++) {
      array[i] = novoVetor[pos];
    }
  }

  // ------------------------ RATINGS -------------------------------------------
  public static Dados[] mergeRatings(Dados[] arr, String path, int indexCaso) {
    long timeStart = System.currentTimeMillis();

    mergeSortRatings(arr, 0, arr.length - 1);

    long timeEnd = System.currentTimeMillis() - timeStart;
    System.out.format("|%s %11s %22s %5d  |%n", "Caso:", caso[indexCaso], "Tempo de execucao:", timeEnd);
    String name = path;
    tools.escreverCSV(arr, name);
    return arr;

  }

  public static void mergeSortRatings(Dados[] array, int inicio, int fim) {
    if (inicio < fim - 1) {
      int meio = (inicio + fim) / 2;
      mergeSortRatings(array, inicio, meio);
      mergeSortRatings(array, meio, fim);
      intercalaRatings(array, inicio, meio, fim);
    }
  }

  public static void intercalaRatings(Dados[] array, int inicio, int meio, int fim) {

    Dados novoVetor[] = new Dados[fim - inicio];
    int i = inicio;
    int m = meio;
    int pos = 0;
    while (i < meio && m < fim) {
      if (transformRatings(array[i].getRating()) <= transformRatings(array[m].getRating())) {
        novoVetor[pos] = array[i];
        pos = pos + 1;
        i = i + 1;
      } else {
        novoVetor[pos] = array[m];
        pos = pos + 1;
        m = m + 1;
      }
    }
    while (i < meio) {
      novoVetor[pos] = array[i];
      pos = pos + 1;
      i = i + 1;
    }
    while (m < fim) {
      novoVetor[pos] = array[m];
      pos = pos + 1;
      m = m + 1;
    }

    for (pos = 0, i = inicio; i < fim; i++, pos++) {
      array[i] = novoVetor[pos];
    }
  }

  // ------------------------ INSTALLS -------------------------------------------
  public static Dados[] mergeInstalls(Dados[] arr, String path, int indexCaso) {
    long timeStart = System.currentTimeMillis();

    mergeSortInstalls(arr, 0, arr.length - 1);

    long timeEnd = System.currentTimeMillis() - timeStart;
    System.out.format("|%s %11s %22s %5d  |%n", "Caso:", caso[indexCaso], "Tempo de execucao:", timeEnd);
    String name = path;
    tools.escreverCSV(arr, name);
    return arr;

  }

  public static void mergeSortInstalls(Dados[] array, int inicio, int fim) {
    if (inicio < fim - 1) {
      int meio = (inicio + fim) / 2;
      mergeSortInstalls(array, inicio, meio);
      mergeSortInstalls(array, meio, fim);
      intercalaInstalls(array, inicio, meio, fim);
    }
  }

  public static void intercalaInstalls(Dados[] array, int inicio, int meio, int fim) {

    Dados novoVetor[] = new Dados[fim - inicio];
    int i = inicio;
    int m = meio;
    int pos = 0;

    while (i < meio && m < fim) {

      int iTemp = Integer.parseInt(array[i].getInstalls().replace(",", "").replace("+", "").replace("\"", ""));
      int mTemp = Integer.parseInt(array[m].getInstalls().replace(",", "").replace("+", "").replace("\"", ""));

      if (iTemp <= mTemp) {
        novoVetor[pos] = array[i];
        pos = pos + 1;
        i = i + 1;
      } else {
        novoVetor[pos] = array[m];
        pos = pos + 1;
        m = m + 1;
      }
    }
    while (i < meio) {
      novoVetor[pos] = array[i];
      pos = pos + 1;
      i = i + 1;
    }
    while (m < fim) {
      novoVetor[pos] = array[m];
      pos = pos + 1;
      m = m + 1;
    }
    for (pos = 0, i = inicio; i < fim; i++, pos++) {
      array[i] = novoVetor[pos];
    }
  }

  // ------------------- LAST UPDATE----------------------------------------
  public static Dados[] mergeLastUpdate(Dados[] arr, String path, int indexCaso) {
    long timeStart = System.currentTimeMillis();

    mergeSortLastUpdate(arr, 0, arr.length - 1);

    long timeEnd = System.currentTimeMillis() - timeStart;
    System.out.format("|%s %11s %22s %5d  |%n", "Caso:", caso[indexCaso], "Tempo de execucao:", timeEnd);
    String name = path;
    tools.escreverCSV(arr, name);
    return arr;

  }

  public static void mergeSortLastUpdate(Dados[] array, int inicio, int fim) {
    if (inicio < fim - 1) {
      int meio = (inicio + fim) / 2;
      mergeSortLastUpdate(array, inicio, meio);
      mergeSortLastUpdate(array, meio, fim);
      intercalaLastUpdate(array, inicio, meio, fim);
    }
  }

  public static void intercalaLastUpdate(Dados[] array, int inicio, int meio, int fim) {

    Dados novoVetor[] = new Dados[fim - inicio];
    int i = inicio;
    int m = meio;
    int pos = 0;

    while (i < meio && m < fim) {
      /*
       * dateComp = return -1 : date1 > date2
       * return 1 : date1 < date2
       * return 0 : date1 == date2
       */
      if (dateComp(array[i].getLast_update(), array[m].getLast_update()) >= 0) {
        novoVetor[pos] = array[i];
        pos = pos + 1;
        i = i + 1;

      } else {
        novoVetor[pos] = array[m];
        pos = pos + 1;
        m = m + 1;
      }
    }
    while (i < meio) {
      novoVetor[pos] = array[i];
      pos = pos + 1;
      i = i + 1;
    }
    while (m < fim) {
      novoVetor[pos] = array[m];
      pos = pos + 1;
      m = m + 1;
    }
    for (pos = 0, i = inicio; i < fim; i++, pos++) {
      array[i] = novoVetor[pos];
    }
  }
}
