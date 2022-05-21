package project_1_Guests;

import java.util.Scanner;

public class Main {
    //private static final GuestsList gL = new GuestsList(10);
    private static final GuestsList gL = new GuestsList(2);
    private static final Scanner sc = new Scanner(System.in);

    private static String option(){
        return sc.nextLine();
    }

    // DONE -  imi afiseaza -1 chiar daca persoana se afla pe lista de asteptare (OVERRIDE equals in guest)
    private static void add(){
        String firstName;
        String lastName;
        String email;
        String phoneNo;
        System.out.println("Introduceti prenumele: ");
        firstName = sc.nextLine();
        System.out.println("Introduceti numele: ");
        lastName = sc.nextLine();
        System.out.println("Introduceti adresa de email:");
        email = sc.nextLine();
        System.out.println("Introduceti numarul de telefon: ");
        phoneNo = sc.nextLine();
        Guest newGuest = new Guest(firstName, lastName, email, phoneNo);
        gL.add(newGuest);
    }
    private static void check(){
        String firstName;
        String lastName;
        String email;
        String phoneNo;
        System.out.println("Puteti cauta o persoana dupa urmatoarele criterii: " +
                "\n\t-nume si prenume (optiunea a)" +
                "\n\t-email (optiunea b)" +
                "\n\t-numar de telefon (optiunea c)" +
                "\nVa rugam sa introduceti optiunea dvs: ");
        String option = option();
        switch (option){
            case "a":
                System.out.println("Introduceti prenumele: ");
                firstName = sc.nextLine();
                System.out.println("Introduceti numele: ");
                lastName = sc.nextLine();
                Guest newGuest1 = new Guest(firstName, lastName, "defaultEmail", "defaultPhoneNo");
                gL.check(newGuest1);
                break;
            case "b":
                System.out.println("Introduceti adresa de email:");
                email = sc.nextLine();
                Guest newGuest2 = new Guest("defaultLastName", "defaultFirstName", email, "defaultPhoneNo");
                gL.check(newGuest2);
                break;
            case "c":
                System.out.println("Introduceti numarul de telefon: ");
                phoneNo = sc.nextLine();
                Guest newGuest3 = new Guest("defaultLastName", "defaultFirstName", "defaultEmail", phoneNo);
                gL.check(newGuest3);
                break;
            default:
                System.out.println("Persoana cautata nu este inscrisa.");
                break;
        }
    }

    /* DONE - as vrea sa folosesc check() de mai sus...se poate? - da, este folosit in REMOVE si UPDATE)
        * dupa ce sterge persoana din lista..imi afiseaza detaliile defaultName etc..am cum sa fac sa imi afiseze detaliile complete?
     */
    /* DONE - dupa ce sterg o pers din guestsList si adaug prima pers din waiting list (INDEX 0) in ea..nu mai tine cont de
              capacitatea initiala a ArrayListului guests..ma lasa sa adaug oricati paricipanti -
              (stergeam userul creat pt comparatie, nu pe cel din guestsList sau waitingList)
     */
    private static void remove(){
        String firstName;
        String lastName;
        String email;
        String phoneNo;
        System.out.println("Puteti cauta o persoana dupa urmatoarele criterii: " +
                "\n\t-nume si prenume (optiunea a)" +
                "\n\t-email (optiunea b)" +
                "\n\t-numar de telefon (optiunea c)" +
                "\nVa rugam sa introduceti optiunea dvs: ");
        String option = option();
        switch (option){
            case "a":
                System.out.println("Introduceti prenumele: ");
                firstName = sc.nextLine();
                System.out.println("Introduceti numele: ");
                lastName = sc.nextLine();
                Guest newGuest1 = new Guest(firstName, lastName, "defaultEmail", "defaultPhoneNo");
                if(gL.check(newGuest1)){
                    for(int i = 0; i < gL.getGuestList().size(); i++){
                        if(gL.getGuestList().get(i).equals(newGuest1)){
                            System.out.println("A fost eliminata din lista de participanti persoana cu urmatoarele detalii: " + gL.displayDetails(gL.getGuestList().get(i)));
                            gL.remove(gL.getGuestList().get(i));
                        }
                    }
                    for(int i = 0; i < gL.getWaitingList().size(); i++){
                        if(gL.getWaitingList().get(i).equals(newGuest1)){
                            gL.remove(gL.getWaitingList().get(i));
                        }
                    }
                }
                break;
            case "b":
                System.out.println("Introduceti adresa de email:");
                email = sc.nextLine();
                Guest newGuest2 = new Guest("defaultLastName", "defaultFirstName", email, "defaultPhoneNo");
                if(gL.check(newGuest2)){
                    for(int i = 0; i < gL.getGuestList().size(); i++){
                        if(gL.getGuestList().get(i).equals(newGuest2)){
                            System.out.println("A fost eliminata din lista de participanti persoana cu urmatoarele detalii: " + gL.displayDetails(gL.getGuestList().get(i)));
                            gL.remove(gL.getGuestList().get(i));
                        }
                    }
                    for(int i = 0; i < gL.getWaitingList().size(); i++){
                        if(gL.getWaitingList().get(i).equals(newGuest2)){
                            gL.remove(gL.getWaitingList().get(i));
                        }
                    }
                }
                break;
            case "c":
                System.out.println("Introduceti numarul de telefon: ");
                phoneNo = sc.nextLine();
                Guest newGuest3 = new Guest("defaultLastName", "defaultFirstName", "defaultEmail", phoneNo);
                if(gL.check(newGuest3)){
                    for(int i = 0; i < gL.getGuestList().size(); i++){
                        if(gL.getGuestList().get(i).equals(newGuest3)){
                            System.out.println("A fost eliminata din lista de participanti persoana cu urmatoarele detalii: " + gL.displayDetails(gL.getGuestList().get(i)));
                            gL.remove(gL.getGuestList().get(i));
                        }
                    }
                    for(int i = 0; i < gL.getWaitingList().size(); i++){
                        if(gL.getWaitingList().get(i).equals(newGuest3)){
                            gL.remove(gL.getWaitingList().get(i));
                        }
                    }
                }
                break;
            default:
                System.out.println("Persoana cautata nu este inscrisa.");
                break;
        }
    }

    private static void listOfOptions(){
        System.out.println("help -  Afiseaza aceasta lista de comenzi " +
                         "\nadd - Adauga o noua persoana (inscriere)" +
                         "\ncheck - Verifica daca o persoana este inscrisa la eveniment" +
                         "\nremove - Sterge o persoana existenta din lista" +
                         "\nupdate - Actualizeaza detaliile unei persoane" +
                         "\nguests - Lista de persoane care participa la eveniment" +
                         "\nwaitlist - Persoanele din lista de asteptare" +
                         "\navailable - Numarul de locuri libere" +
                         "\nguests_no - Numarul de persoane care participa la eveniment" +
                         "\nwaitlist_no - Numarul de persoane din lista de asteptare" +
                         "\nsubscribe_no - Numarul total de persoane inscrise" +
                         "\nsearch - Cauta toti invitatii conform sirului de caractere introdus" +
                         "\nquit - Inchide aplicatia");
    }

   /* DONE - dupa ce actualizez de ex, emailul, imi arata ca s-a realizat cu succes actualizarea, dar cand caut din nou
      persoana dupa vechiul email, inca o gaseste in lista. - DONE (imi modifica userul creat pt comparatie, nu pe cel din arrayList)..
    */

    private static void update(){
        String firstName;
        String lastName;
        String email;
        String phoneNo;
        System.out.println("Puteti cauta o persoana dupa urmatoarele criterii: " +
                "\n\t-nume si prenume (optiunea a)" +
                "\n\t-email (optiunea b)" +
                "\n\t-numar de telefon (optiunea c)" +
                "\nVa rugam sa introduceti optiunea dvs: ");
        String option = option();
        switch (option){
            case "a":
                System.out.println("Introduceti prenumele: ");
                firstName = sc.nextLine();
                System.out.println("Introduceti numele: ");
                lastName = sc.nextLine();
                Guest newGuest1 = new Guest(firstName, lastName, "defaultEmail", "defaultPhoneNo");
                if(gL.check(newGuest1)){ //daca a fost gasita persoana, alegem ce campuri dorim sa actualizam
                    //trebuie sa aduc aici din guests/waiting list persoana ale carei detalii vreau sa le modific
                    //metoda care returneaza un obiect -- getter
                    for(int i = 0; i < gL.getGuestList().size(); i++){
                        if(gL.getGuestList().get(i).equals(newGuest1)){
                            gL.update(gL.getGuestList().get(i));
                        }
                    }
                    for(int i = 0; i < gL.getWaitingList().size(); i++){
                        if(gL.getWaitingList().get(i).equals(newGuest1)){
                            gL.update(gL.getWaitingList().get(i));
                        }
                    }
                }
                break;
            case "b":
                System.out.println("Introduceti adresa de email:");
                email = sc.nextLine();
                Guest newGuest2 = new Guest("defaultLastName", "defaultFirstName", email, "defaultPhoneNo");
                if(gL.check(newGuest2)){
                    for(int i = 0; i < gL.getGuestList().size(); i++){
                        if(gL.getGuestList().get(i).equals(newGuest2)){
                            gL.update(gL.getGuestList().get(i));
                        }
                    }
                    for(int i = 0; i < gL.getWaitingList().size(); i++){
                        if(gL.getWaitingList().get(i).equals(newGuest2)){
                            gL.update(gL.getWaitingList().get(i));
                        }
                    }
                }
                break;
            case "c":
                System.out.println("Introduceti numarul de telefon: ");
                phoneNo = sc.nextLine();
                Guest newGuest3 = new Guest("defaultLastName", "defaultFirstName", "defaultEmail", phoneNo);
                if(gL.check(newGuest3)){
                    for(int i = 0; i < gL.getGuestList().size(); i++){
                        if(gL.getGuestList().get(i).equals(newGuest3)){
                            gL.update(gL.getGuestList().get(i));
                        }
                    }
                    for(int i = 0; i < gL.getWaitingList().size(); i++){
                        if(gL.getWaitingList().get(i).equals(newGuest3)){
                            gL.update(gL.getWaitingList().get(i));
                        }
                    }
                }
                break;
            default:
                System.out.println("Persoana cautata nu este inscrisa.");
                break;
        }
    }

    private static void guests(){
        gL.guests();
    }

    private static void waitlist(){
        gL.waitlist();
    }

    private static void available(){
        gL.available();
    }

    private static void guests_no(){
        gL.guests_no();
    }

    private static void waitlist_no(){
        gL.waitlist_no();
    }

    private static void subscribe_no(){
        gL.subscribe_no();
    }

    private static void search(){
        System.out.println("Introduceti sirul de caractere dupa care doriti sa faceti cautarea:");
        String str = sc.nextLine();
        gL.search(str);
    }

    public static void main(String[] args) {
//        System.out.println("Introduceti numarul de locuri disponibile:");
//        gL = new GuestsList(sc.nextInt());
//        sc.nextLine();
        System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
        String option = option();

        while(!option.equals("quit")){

            switch(option){

                case "help":
                    listOfOptions();
                    break;

                case "add":
                    add();
                    System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
                    break;

                case "check":
                    check();
                    System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
                    break;

                case "remove":
                    remove();
                    System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
                    break;

                case "update":
                    update();
                    System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
                    break;

                case "guests":
                    guests();
                    System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
                    break;

                case "waitlist":
                    waitlist();
                    System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
                    break;

                case "available":
                    available();
                    System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
                    break;

                case "guests_no":
                    guests_no();
                    System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
                    break;

                case "waitlist_no":
                    waitlist_no();
                    System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
                    break;

                case "subscribe_no":
                    subscribe_no();
                    System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
                    break;

                case "search":
                    search();
                    System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
                    break;

                case "quit":
                    break;

                default:
                    System.out.println("Optiunea introdusa nu exista in lista. Va rugam sa reintroduceti optiunea dvs");
                    break;
            }
            option = option();
        }
    }
}
