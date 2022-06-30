package cinema;

import org.w3c.dom.ls.LSOutput;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args)  throws IndexOutOfBoundsException {

        System.out.println("Enter the number of rows:");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int b = scanner.nextInt();
        System.out.println();
        boolean test = true;
        int c = 0; int d = 0;
        int count = 0;
        double percentage = 0;
        int income = 0;
        int total = 0;


        String map[][] = new String[a][b];
        String mapTest[][] = new String[a][b];//alternate variant. Not used here

        do {  //loop for always view menu, until we choise exit

            Cinema.printMenu();//PrintMenu method for UserMenu for choise to do

            int e = scanner.nextInt(); //condition for exit from program
            if (e == 0) {
                test = false;
            }

            switch (e) {
                case 1:   //Show the seats. We draw it with free seats and bought seats

               System.out.println();
               System.out.println("Cinema:");
               System.out.print(" ");
               for (int i = 1; i<=b; i++) {
               System.out.print(" " + i);
               }
               System.out.println();

               try {    //maybe exception, and we catch it here
                   for (int i = 0; i < a; i++) {
                       System.out.print(i+1);
                       for (int j = 0; j < b; j++) {
                           if (i == c-1 && j == d-1) {
                               map[i][j] = "B";
                           } else {
                               if (map[i][j] != "B") {
                           map[i][j] = "S";}
                               else map[i][j] = "B";
                           }
                           System.out.print(" " + map[i][j]);
                       }
                       System.out.println();
                   }
                   System.out.println();

               }
               catch (ArrayIndexOutOfBoundsException o) {

               }
               break;

                case 2: //we are buying the ticket. we choose row and seat numbers

                    boolean tmp = true;

                    do {      //loop until we bay of ticket
                    try {       //catch situation when we choose non existing seats

                            c = Cinema.enterRow();
                            d = Cinema.enterSeat();


                            if (map[c - 1][d - 1] == "B") { //ticket maybe already purchased
                                System.out.println();
                                System.out.println("That ticket has already been purchased!");
                                //System.out.println();
                            } else {
                                System.out.println();
                                System.out.println("Ticket price: $" + Cinema.buyTicket(a, b, c, d));
                                System.out.println();
                                count = count + 1;
                                income = income + Cinema.buyTicket(a, b, c, d);
                                tmp = false;
                            }

                    } //try
                    catch (ArrayIndexOutOfBoundsException l) {
                        System.out.println();
                        System.out.println("Wrong input!");

                    }
                    } while (tmp);//while

                    for (int i = 0; i < a; i++) {    //we are checking if seat already used. "B" is used, "S" - is free.
                        //System.out.print(i + 1);
                        for (int j = 0; j < b; j++) {
                            if (i == c - 1 && j == d - 1) {
                                map[i][j] = "B";
                            } else {
                                if (map[i][j] != "B") {
                                    map[i][j] = "S";
                                } else map[i][j] = "B";
                            }

                        }

                    }

                    break;
                case 3: //Statistics
                    System.out.println();
                    System.out.println("Number of purchased tickets: " + count);

                    percentage = (count/(double)(a*b)) * 100;
                    String formattedDouble = new DecimalFormat("#0.00").format(percentage);
                    System.out.println("Percentage: " + formattedDouble + "%");

                    System.out.println("Current income: $" + income);
                    if ((a*b) < 60) {
                        System.out.println("Total income: $" + ((a*b)*10));
                    }
                    else {
                        System.out.println("Total income: $" + ((((a/2)*b)*10) + (((a - a/2)*b)*8)));
                    }
                    System.out.println();



                case 0:
                    break;


            }
        } while (test);

    }

    public static void printMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public static void showSeats(int a, int b) {

        System.out.println("Cinema:");
        System.out.print(" ");

        for (int i = 1; i <= b; i++) {
            System.out.print(" " + i);
        }
        System.out.println();

        for (int i = 1; i <= a; i++) {
            System.out.print(i);
            for (int j = 1; j <= b; j++) {
                System.out.print(" S");
            }
            System.out.println();
        }

    }

    public static void showNewSeats (int a, int b, int c, int d) {

        System.out.println("Cinema:");
        System.out.print(" ");

        for (int i = 1; i <= b; i++) {
            System.out.print(" " + i);
        }
        System.out.println();

        for (int i = 1; i<=a; i++) {
            System.out.print(i);
            for (int j = 1; j<=b; j++) {
                if (i == c && j == d) {
                    System.out.print(" B");
                } else
                    System.out.print(" S");
            }
            System.out.println();
        }
    }


        public static int buyTicket (int a, int b, int c, int d){
            int half1 = a / 2;
            int half2 = a - half1;
            int ticket = 0;
            int income = 0;
            int c_array[] = new int[a*b];
            int d_array[] = new int[a*b];
            String mapTest[][] = new String[a][b];
            String temp;

            if ((a * b) < 60) {
                //System.out.println("Ticket price: $10");
                ticket = 10;
                //income = income + 10;
            } else if (c <= half1) {
                //System.out.println("Ticket price: $10");
                //income = income + 10;
                ticket = 10;
            } else if (c > half1) {
                //System.out.println("Ticket price: $8");
                //income = income + 8;
                ticket = 8;
            }

            return (ticket);

        }


        public static int enterRow() {
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.println("Enter a row number:");
            int c = scanner.nextInt();
            return c;

        }
        public static int enterSeat() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a seat number in that row:");
            int d = scanner.nextInt();
            return d;
        }

    }



