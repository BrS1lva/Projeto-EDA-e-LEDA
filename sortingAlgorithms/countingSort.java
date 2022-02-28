package sortingAlgorithms;

import util.*;

public class countingSort {
  public static void counting(Dados[] dados) {
    String[][] path = {
        { "googleplaystore_Ratings_countingSort_medioCaso.csv",
            "googleplaystore_Ratings_countingSort_melhorCaso.csv",
            "googleplaystore_Ratings_countingSort_piorCaso.csv" },

        { "googleplaystore_Installs_countingSort_medioCaso.csv",
            "googleplaystore_Installs_countingSort_melhorCaso.csv",
            "googleplaystore_Installs_countingSort_piorCaso.csv" } };

    System.out.println("\n--------------------------------------------------");
    System.out.printf("|%s %35s \n", "Counting Sort", "|");

    // Insertion Sort - NAMES --
    System.out.println("--------------------------------------------------");
    System.out.printf("|%s %43s \n", "Names", "|");
    System.out.println("--------------------------------------------------");
    printCasos();
    // Counting Sort - RATINGS
    System.out.println("--------------------------------------------------");
    System.out.printf("|%s %41s \n", "Ratings", "|");
    System.out.println("--------------------------------------------------");
    Dados[] arrayOrdenadoRATINGS = countingSort.countingRatings(dados.clone(), path[0][0], 1); // medio caso
    countingSort.countingRatings(arrayOrdenadoRATINGS.clone(), path[0][1], 0); // melhor caso
    Dados[] arrayInvertidoRATINGS = tools.inverteArray(arrayOrdenadoRATINGS);
    countingSort.countingRatings(arrayInvertidoRATINGS.clone(), path[0][2], 2); // pior caso

    // Counting Sort - INSTALLS
    System.out.println("--------------------------------------------------");
    System.out.printf("|%s %40s \n", "Installs", "|");
    System.out.println("--------------------------------------------------");
    Dados[] arrayOrdenadoINSTALLS = countingSort.countingInstalls(dados.clone(), path[1][0], 1); // medio caso
    countingSort.countingInstalls(arrayOrdenadoINSTALLS.clone(), path[1][1], 0); // melhor caso
    Dados[] arrayInvertidoINSTALLS = tools.inverteArray(arrayOrdenadoINSTALLS);
    countingSort.countingInstalls(arrayInvertidoINSTALLS.clone(), path[1][2], 2); // pior caso

    System.out.println("--------------------------------------------------");
    System.out.printf("|%s %36s \n", "Last Updates", "|");
    System.out.println("--------------------------------------------------");
    printCasos();
    System.out.println("--------------------------------------------------");
  }

  static String[] caso = { "Melhor Caso", "Medio Caso", "Pior Caso" };

  // ---------------- RATINGS -------------------------
  public static Dados[] countingRatings(Dados[] A, String path, int indexCaso) {
    long timeStart = System.currentTimeMillis();

    int size = A.length - 1;
    Dados[] resp = new Dados[size + 1];
    // preenche aux com zeros (java já faz isso automaticamente)

    int max = ratingsToInt(A[0].getRating()); // procurar // maior
    for (int i = 1; i < size; i++) {
      if (ratingsToInt(A[i].getRating()) > max) {
        max = ratingsToInt(A[i].getRating());
      }
    }
    int[] aux = new int[max + 1];

    for (int i = 0; i < size; i++) {
      aux[ratingsToInt(A[i].getRating())]++;
    }

    for (int i = 1; i <= max; i++) {
      aux[i] += aux[i - 1];
    }

    for (int i = size - 1; i >= 0; i--) {
      int Ai = ratingsToInt(A[i].getRating());
      resp[aux[Ai] - 1] = A[i];
      aux[Ai]--;
    }
    for (int i = 0; i < size; i++) {
      A[i] = resp[i];
    }
    long timeEnd = System.currentTimeMillis() - timeStart;

    System.out.format("|%s %11s %22s %5d  |%n", "Caso:", caso[indexCaso], "Tempo de execucao:", timeEnd);
    String name = path;
    tools.escreverCSV(A, name);
    return A;
  }

  // ----------------INSTALLS ------------------------

  public static Dados[] countingInstalls(Dados[] A, String path, int indexCaso) {

    long timeStart = System.currentTimeMillis();

    int size = A.length - 1;
    Dados[] resp = new Dados[size + 1];
    // preenche aux com zeros (java já faz isso automaticamente)

    int max = toInt(A[0].getInstalls()); // procurar // maior
    for (int i = 1; i < size; i++) {
      if (toInt(A[i].getInstalls()) > max) {
        max = toInt(A[i].getInstalls());
      }
    }
    int[] aux = new int[max + 1];

    for (int i = 0; i < size; i++) {
      aux[toInt(A[i].getInstalls())]++;
    }

    for (int i = 1; i <= max; i++) {
      aux[i] += aux[i - 1];
    }

    for (int i = size - 1; i >= 0; i--) {
      int Ai = toInt(A[i].getInstalls());
      resp[aux[Ai] - 1] = A[i];
      aux[Ai]--;
    }
    for (int i = 0; i < size; i++) {
      A[i] = resp[i];
    }
    long timeEnd = System.currentTimeMillis() - timeStart;

    System.out.format("|%s %11s %22s %5d  |%n", "Caso:", caso[indexCaso], "Tempo de execucao:", timeEnd);
    String name = path;
    tools.escreverCSV(A, name);
    return A;
  }

  public static int toInt(String palavra) {
    int result = Integer.parseInt(palavra
        .replace(",", "")
        .replace("+", "")
        .replace(".", "")
        .replace("\"", ""));
    return result;
  }

  public static void printCasos() {
    System.out.format("|%s %11s %22s %5s  |%n", "Caso:", caso[1], "Tempo de execucao:", "-");
    System.out.format("|%s %11s %22s %5s  |%n", "Caso:", caso[0], "Tempo de execucao:", "-");
    System.out.format("|%s %11s %22s %5s  |%n", "Caso:", caso[2], "Tempo de execucao:", "-");
  }

  public static int ratingsToInt(String valor) {
    if (Double.isNaN(Double.parseDouble(valor)) == true) {
      return 60;
    } else {
      int result = Integer.parseInt(valor
          .replace(",", "")
          .replace("+", "")
          .replace(".", "")
          .replace("\"", ""));
      return result;
    }
  }

}