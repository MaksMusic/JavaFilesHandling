package Tasks.projectTicket;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    private int balanc = 5000;
    private Scanner scanner = new Scanner(System.in);
    ArrayList<Ticket> ticket = new ArrayList();

    public void runTerminal() {
        Ticket.initMoviesTicket();
        System.out.println("1  посмотреть мои билеты");
        System.out.println("2  посмотреть список фильмов");
        String answer = scanner.nextLine();
        switch (answer) {
            case "1" -> {
                lockTicket();
                runTerminal();
            }
            case "2" -> {
                listMove();
                runTerminal();
            }
            default -> {
                runTerminal();
            }
        }

    }

    private void listMove() {
        Movie movie[] = Movie.values();
        for (Movie movie1 : movie) {
            System.out.println(movie1.name() + "(цена днем - " + movie1.getPriceDay() + " coin )" + "(цена вечер " + movie1.getPriceEvening() + "coin)");
        }
        shopTicket(movie);

    }

    private void shopTicket(Movie movie[]) {
        System.out.println("Введите название фильма");
        String nameMovie = scanner.nextLine();
        for (Movie movie1 : movie) {
            if (nameMovie.equals(movie1.name())) {
                System.out.println("Выберите время");
                System.out.println("1 день - " + movie1.getPriceDay() + " coin");
                System.out.println("2 вечер - " + movie1.getPriceEvening() + " coin");
                System.out.println("введите цисло");
                String n = scanner.nextLine();

                if (n.equals("1")) {
                    if (balanc >= movie1.getPriceDay()){
                        balanc -= movie1.getPriceDay();
                        check(movie1.getPriceDay(),nameMovie);
                    }else {
                        System.out.println("не достаточно средств");
                        runTerminal();
                    }

                } else if (n.equals("2")) {
                    if (balanc >= movie1.getPriceEvening()){
                        balanc -= movie1.getPriceEvening();
                        check(movie1.getPriceEvening(),nameMovie);
                    }else {
                        System.out.println("не достаточно средств");
                        runTerminal();
                    }
                } else {
                    System.out.println("вы ввели не верную команду");
                    runTerminal();
                }


                System.out.println("Спасибо за покупку");
            }
        }
    }

    private void check(int price,String nameMovie) {


        System.out.println("ведите имя");
        String name = scanner.nextLine();

        System.out.println("введите фамилию");
        String surName = scanner.nextLine();

        System.out.println("выберите место");
        String place = "";
        for (int i = 0; i < Ticket.getPlace().length; i++) {
            if (Ticket.getPlace()[i] == 0){
                System.out.println(i + " место свободно ");

            }
        }
        place =  scanner.nextLine();
        Ticket ticket = new Ticket(nameMovie,price);
        try {
            FileWriter writer = new FileWriter("Check.txt",false);
            writer.write("Билет номер " + ticket.id);
            writer.write("\nимя " + name);
            writer.write("\nфамилия  " + surName);
            writer.write("\nместо   " + place);
            writer.write("\nцена   " + price);
            writer.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private void lockTicket() {
        for (Ticket ticket1 : ticket) {
            System.out.println("Билет номер " + ticket1.id);
            System.out.println("Фильм: " + ticket1.moveName);
            System.out.println("Место: " + ticket1.placeClients);
            System.out.println("--------------------------------");
        }
    }

    private static class Ticket {
        private String moveName;

        private int id;
        private int price;
        private int placeClients;
        private static int[] place = new int[30];
        private static int idStatic = 1;

        public static int[] getPlace() {
            return Arrays.copyOf(place,place.length);
        }

        public static  void  initMoviesTicket(){
            for (int i = 0; i < place.length; i++) {
                place[i] = ++i;
            }
        }

        public Ticket(String moveName, int price) {
            this.price = price;
            this.moveName = moveName;
            this.id = Ticket.idStatic++;
            this.placeClients = generatePlase();


        }

        private int generatePlase() {
            for (int i = 0; i < place.length; i++) {
                if (place[i] != 0) {
                    place[i] = 1;
                    return place[i];
                }
            }
            return -1;
        }


    }


}
