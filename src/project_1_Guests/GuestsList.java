package project_1_Guests;

import java.util.ArrayList;
import java.util.Scanner;

public class GuestsList {

    private int maxNoAvailable;
    private ArrayList<Guest> guestList;
    private ArrayList<Guest> waitingList;
    private static final Scanner sc = new Scanner(System.in);

    public ArrayList<Guest> getGuestList() {
        return guestList;
    }

    public ArrayList<Guest> getWaitingList() {
        return waitingList;
    }

    public GuestsList(int maxNoAvailable){
        this.maxNoAvailable = maxNoAvailable;
        this.guestList = new ArrayList<>(maxNoAvailable);
        this.waitingList = new ArrayList<>();
    }

    private static String option(){
        return sc.nextLine();
    }

    private boolean isOnGuestsList(Guest g) {
        if(guestList.size() == 0){
            return false;
        }
        for (Guest guest : guestList) {
            if (g.customEquals(guest))
                return true;
        }
        return false;
    }

    private boolean isOnWaitingList(Guest g){
        if(waitingList.size() == 0){
            return false;
        }
        for (Guest guest : waitingList) {
            if (g.customEquals(guest))
                return true;
        }
        return false;
    }

    public int add(Guest newGuest) {
        if(isOnGuestsList(newGuest)){
            System.out.println("Persoana se afla deja pe lista de participanti.");
            return -1;
        }else if(isOnWaitingList(newGuest)){
            System.out.println("Persoana se afla deja pe lista de asteptare pe locul: " + (waitingList.indexOf(newGuest)+1));
            return waitingList.indexOf(newGuest);
        }else if(guestList.size() >= maxNoAvailable){
            waitingList.add(newGuest);
            System.out.println("Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine "
                               + (waitingList.indexOf(newGuest)+ 1) + ". Te vom notifica daca un loc devine disponibil.");
            return waitingList.indexOf(newGuest);
        }else{
            guestList.add(newGuest);
            System.out.println("["+ newGuest.getFirstName() + " " + newGuest.getLastName() +"] " +
                                "Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
            return 0;
        }
    }

    public boolean check(Guest newGuest){
        if(isOnGuestsList(newGuest) || isOnWaitingList(newGuest)){
            System.out.println("Persoana este inscrisa la eveniment.");
            return true;
        }else{
            System.out.println("Persoana nu este inscrisa la eveniment");
            return false;
        }
    }

    public String displayDetails(Guest guest){
        return "Nume: " + guest.getLastName() + " " + guest.getFirstName() +
                ", Email: " + guest.getEmail() +
                ", Telefon: " + guest.getPhoneNumber();
    }

    public boolean remove (Guest guest){
        if(isOnGuestsList(guest)){  //daca se afla in guestList
            //System.out.println("A fost eliminata din lista de participanti persoana cu urmatoarele detalii: " + displayDetails(guest));
            guestList.remove(guest); //stergem participantul
            if(waitingList.size() > 0){
                guestList.add(waitingList.get(0)); // adaugam primul participant inscris in waitingList
                System.out.println("A fost adaugata in lista de participati persoana cu urmatoarele detalii: " + displayDetails(waitingList.get(0)));
                waitingList.remove(0); // stergem primul participant din waitingList, dupa care se muta automat cu o pozitie mai la stanga restul celor inscrisi
            }
            return true;
        }else if(isOnWaitingList(guest)){
            waitingList.remove(guest);
            return true;
        }else
            System.out.println("Persoana nu este inscrisa la eveniment.");
            return false;
    }

    public void update (Guest guest){
        System.out.println("Puteti actualiza urmatoarele campuri:" +
                "\n\t - prenume (optiunea 1)" +
                "\n\t - nume (optiunea 2)" +
                "\n\t - email (optiunea 3)" +
                "\n\t - numar de telefon (optiunea 4)" +
                "\nVa rugam sa introduceti optiunea dvs: ");
        String opt = option();
        switch (opt){
            case "1":
                System.out.println("Introduceti noul prenume:");
                guest.setFirstName(sc.nextLine());
                break;
            case "2":
                System.out.println("Introduceti noul nume:");
                guest.setLastName(sc.nextLine());
                break;
            case "3":
                System.out.println("Introduceti noul email:");
                guest.setEmail(sc.nextLine());
                break;
            case "4":
                System.out.println("Introduceti noul numar de telefon:");
                guest.setPhoneNumber(sc.nextLine());
                break;
        }
        System.out.println("Actualizarea s-a realizat cu succes!");

    }

    public void guests(){
        for (int i = 0; i <guestList.size(); i++) {
            System.out.println((i+1) + "." + displayDetails(guestList.get(i)));
            //System.out.println();
        }
    }

    public void waitlist(){
        for (int i = 0; i <waitingList.size(); i++) {
            System.out.println((i+1) + "." +displayDetails(waitingList.get(i)));
          //  System.out.println();
        }
    }

    public int available(){
        System.out.println(maxNoAvailable - guestList.size());
        return maxNoAvailable - guestList.size();
    }

    public int guests_no(){
        System.out.println(guestList.size());
        return guestList.size();
    }

    public int waitlist_no(){
        System.out.println(waitingList.size());
        return waitingList.size();
    }

    public int subscribe_no(){
        System.out.println(guestList.size() + waitingList.size());
        return guestList.size() + waitingList.size();
    }

    public void search(String str){

        boolean isOnGuestsList = false;
        boolean isOnWaitingList = false;

        for (int i = 0; i <guestList.size(); i++) {
            if (guestList.get(i).getFirstName().toLowerCase().contains(str.toLowerCase()) ||
                    guestList.get(i).getLastName().toLowerCase().contains(str.toLowerCase()) ||
                    guestList.get(i).getEmail().toLowerCase().contains(str.toLowerCase()) ||
                    guestList.get(i).getPhoneNumber().toLowerCase().contains(str.toLowerCase())) {
                System.out.print((i+1) + ".");
                System.out.println(displayDetails(guestList.get(i)));
                isOnGuestsList = true;
            }
        }
        if(!isOnGuestsList)
        System.out.println("Lista de participanti: 0 rezultate gasite.");

        for (int i = 0; i < waitingList.size(); i++) {
            if (waitingList.get(i).getFirstName().toLowerCase().contains(str.toLowerCase()) ||
                    waitingList.get(i).getLastName().toLowerCase().contains(str.toLowerCase()) ||
                    waitingList.get(i).getEmail().toLowerCase().contains(str.toLowerCase()) ||
                    waitingList.get(i).getPhoneNumber().toLowerCase().contains(str.toLowerCase())) {
                System.out.print((i+1) + ".");
                System.out.println(displayDetails(waitingList.get(i)));
               isOnWaitingList = true;
            }
        }if(!isOnWaitingList)
            System.out.println("Lista de asteptare: 0 rezultate gasite.");
    }

}
