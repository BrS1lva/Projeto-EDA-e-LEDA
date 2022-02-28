package util;

import java.io.File;
import java.io.PrintWriter;
import java.text.*;
import java.util.*;
import static java.lang.Integer.*;


public class tools {
  public static String convertDateFormat(String data) throws ParseException {
    String input = data.replaceAll("^\"|\"$", ""); // remover as aspas
    TimeZone zone = TimeZone.getTimeZone("MST");
    SimpleDateFormat inputFormat = new SimpleDateFormat("MMMM dd, yyyy", Locale.US);
    inputFormat.setTimeZone(zone);
    SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
    outputFormat.setTimeZone(zone);

    Date date = inputFormat.parse(input);
    return outputFormat.format(date);
  }

  public static void escreverCSV(Dados[] array, String nameOfArchive) {
    String cabecalho = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", "App", "Category", "Ratings", "Reviews",
        "Size", "Installs", "Type", "Price", "Content Rating", "Genres", "Last Updated", "Current ve", "Android ver");

    try { 
      // pasta especifica
      //String sf1=String.format("src\\out\\%s",nameOfArchive);  
      //File csvFile = new File(sf1);
      File csvFile = new File(nameOfArchive);
      PrintWriter out = new PrintWriter(csvFile);
      out.println(cabecalho);

      for (Dados list : array) {
        out.println(list);

      }
      out.close();

    } catch (Exception e) {
      System.out.println("ERROR: " + e.getMessage());
      // TODO: handle exception
    }

  }

  public static void imprimeTempo(Long[] Array, String name) {
    System.out.println("----------------------------------------------------------------------------------------");
    System.out.printf("| %-84s |\n", name);
    System.out.println("----------------------------------------------------------------------------------------");
    String format = "|  %-14s: %-6sms |  %-14s:  %-6sms ||  %-14s:  %-6sms |\n";
    System.out.format(format, "Melhor Caso", Array[0], "Medio Caso", Array[1], "Pior Caso", Array[2]);
    System.out.println("----------------------------------------------------------------------------------------");

  }

  public static int CompareDatas(String data1, String data2) {
    int valor = 0;
    String[] dataSplit1 = data1.split("/");
    String[] dataSplit2 = data2.split("/");

    if (Integer.parseInt(dataSplit1[2]) > Integer.parseInt(dataSplit2[2])) { // ano
      return -1;
    } else if (Integer.parseInt(dataSplit1[2]) == Integer.parseInt(dataSplit2[2])) {
      if (Integer.parseInt(dataSplit1[1]) > Integer.parseInt(dataSplit2[1])) { // mes
        return -1;
      } else if (Integer.parseInt(dataSplit1[1]) == Integer.parseInt(dataSplit2[1])) {
        if (Integer.parseInt(dataSplit1[0]) > Integer.parseInt(dataSplit2[0])) { // dia
          return -1;
        }
      }
    }

    return valor;
    // valor = 1 =>> Troca

  }

  public static int dateComp(String date1, String date2) {
    String[] datecheck1 = date1.split("/");
    String[] datecheck2 = date2.split("/");

    // date1 é posterior por causa do ano => 1
    // date2 é posterior por causa do ano => -1
    // date1 == date2 => 0

    if (parseInt(datecheck1[2]) != parseInt(datecheck2[2]))// Year
    {
      if (parseInt(datecheck1[2]) > parseInt(datecheck2[2]))// date1 is later because of the year
      {
        return 1;
      } else {// the 2nd date is later because of the year
        return -1;
      }
      // return -1;
    } else {// same year
      if (parseInt(datecheck1[1]) != parseInt(datecheck2[1]))// if the month is different
      {
        if (parseInt(datecheck1[1]) > parseInt(datecheck2[1])) {
          return 1;
        } else {
          return -1;
        }
      } else {// same month
        if (parseInt(datecheck1[0]) != parseInt(datecheck2[0])) // if the day is different
        {
          if (parseInt(datecheck1[0]) > parseInt(datecheck2[0])) {
            return 1;
          } else {
            return -1;
          }
        } else {
          return 0;// if both dates are the same then it returns 0
        } // end of day
      } // end of month
    } // year
  }

  public static Dados[] inverteArray(Dados[] list) {
    int i = 0;
    Dados[] newList = new Dados[list.length];
    for (int j = list.length - 2; j >= 0; j--) { // inverte
      newList[i] = list[j];
      i++;
    }
    return newList;
  }

  public static Double transformRatings(String valor) {

    if (Double.isNaN(Double.parseDouble(valor)) == true) {
      return 9999999999.0;
    } else {
      Double valorDouble = Double.parseDouble(valor);
      return valorDouble;
    }
  }

  public static void menu() {
    System.out.println("|------------------------------------------------|");
    System.out.println("|-------------- Menu de Ordenação ---------------|");
    System.out.println("|------------------------------------------------|");
    System.out.printf("|%s %23s \n", " Opção 1 - Selection Sort", "|");
    System.out.printf("|%s %23s \n", " Opção 2 - Insertion Sort", "|");
    System.out.printf("|%s %27s \n", " Opção 3 - Merge Sort", "|");
    System.out.printf("|%s %27s \n", " Opção 4 - Quick Sort", "|");
    System.out.printf("|%s %11s \n", " Opção 5 - QuickSort com Mediana de 3", "|");
    System.out.printf("|%s %24s \n", " Opção 6 - Counting Sort", "|");
    System.out.printf("|%s %25s \n", " Opção 7 - HeapSortSort", "|");
    System.out.printf("| %48s \n", "|");
    System.out.printf("|%s %24s \n", " Opção 8 - Ordenar Todos", "|");
    System.out.println("--------------------------------------------------");
    System.out.print("Digite uma opção: ");
  }
}
