import sortingAlgorithms.*;
import util.*;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main extends Dados{
      /**
       * ORDENAÇÕES: NAMES = vect[0]
       * RATINGS = vect[2]
       * INSTALLS = vect[5]
       * LAST_UPDATES = vect[10]
       * 
       */
  public static void main(String[] args){
    String path = "googleplaystore_date.csv";
    Dados[] list = new Dados[1];

    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      String line = br.readLine(); // linha 1 --> cabeçalho
      line = br.readLine();

      int i = 0;
      while (line != null) {
        String[] vect = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); //
        if (vect.length == 13) {
          String app = vect[0];
          String category = vect[1];
          String rating = vect[2];
          String reviews = vect[3];
          String size = vect[4];
          String installs = vect[5];
          String type = vect[6];
          String price = vect[7];
          String content_rating = vect[8];
          String genres = vect[9];
          String last_update = vect[10];
          //String last_update = tools.convertDateFormat(vect[10]);
          String current_ver = vect[11];
          String android_ver = vect[12];

          Dados dados = new Dados(app, category, rating, reviews, size, installs, type, price, content_rating, genres,
              last_update, current_ver, android_ver);

          list[i] = (dados);
          int newLength = list.length + 1;
          list = Arrays.copyOf(list, newLength);
          i++;

        } else { // encontrar a linha com erro que tava causando a exceção
          // 												
          String app = vect[0];                                       // Life Made WI-Fi Touchscreen Photo Frame
          String category = "UNCATEGORIZED";                          // UNCATEGORIZED          vect[1];  
          String rating = vect[1];                                    //1.9
          String reviews = vect[2];                                   //19
          String size = vect[3];                                      //3.0M
          String installs = vect[4];                                  //1,000+
          String type = vect[5];                                      //Free
          String price = vect[6];                                     //0
          String content_rating = vect[7];                            //Everyone
          String genres = "NO GENDER";                                // NO GENDER   vect[9]
          String last_update = tools.convertDateFormat(vect[9]);      //February 11, 2018    =>   TROCAR DATA
          String current_ver = vect[10];                              //1.0.19
          String android_ver = vect[11];                              //4.0 and up

          Dados dados = new Dados(app, category, rating, reviews, size, installs, type, price, content_rating, genres,
              last_update, current_ver, android_ver);

          list[i] = (dados);
          int newLength = list.length + 1;
          list = Arrays.copyOf(list, newLength);
          
          i++;
        }

        line = br.readLine(); // proxima linha
      }
      Scanner entrada = new Scanner(System.in);


      // ---------- MENU --------------

      tools.menu();
      int opcao = entrada.nextInt();
      switch (opcao) {
        case 1:  // Selection Sort
          selectionSort.Selection(list.clone());
          break;
        case 2:   // Insertion Sort
          insertionSort.insertion(list.clone());
          break;
        case 3:   // Merge Sort
          mergeSort.merge(list.clone());
          break;
        case 4:   // Quick Sort
          quickSort.quick(list.clone());
          break;
        case 5:   // Quick Sort com mediana de 3
          quicksortMedianaDeTres.quick3(list.clone());
          break;
        case 6:   // Counting Sort
          countingSort.counting(list.clone());
          break;
        case 7:   // Heap Sort
          heapSort.heap(list.clone());
          break;
        case 8 :  // Ordenar com todos os algortimos
          selectionSort.Selection(list.clone());
          insertionSort.insertion(list.clone());
          mergeSort.merge(list.clone());
          quickSort.quick(list.clone());
          quicksortMedianaDeTres.quick3(list.clone());
          countingSort.counting(list.clone());
          heapSort.heap(list.clone());
          break;
        default:
          break;
      }
      entrada.close();

    } catch (Exception e) {
      System.out.println("ERROR: " + e.getMessage());
    }
  }

}
