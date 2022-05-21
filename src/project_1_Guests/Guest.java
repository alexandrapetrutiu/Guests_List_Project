package project_1_Guests;

public class Guest {

    private String lastName;
    private String firstName;
    private String email;
    private String phoneNumber;


    public Guest(String firstName, String lastName, String email, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public boolean customEquals(Guest otherGuest){
        if((this.firstName.equalsIgnoreCase(otherGuest.firstName) && this.lastName.equalsIgnoreCase(otherGuest.lastName)) ||
            this.email.equalsIgnoreCase(otherGuest.email) || this.phoneNumber.equals(otherGuest.phoneNumber)){
            return true;
        } else
            return false;
    }

    //override equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Guest other = (Guest) obj;
        if (customEquals(other)) {
            return true;
        }
        return false;
    }
}
