package week2;

/*
Write the definition of a class Telephone that contains:
• An instance variable areaCode
• An instance variable number
• A static variable numberOfTelephoneObject that keeps track of the number of Telephone
objects created
• A constructor that accepts two arguments used to initialize the two instance variables
• The accessor and mutator methods for areaCode and number
• A method makeFullNumber that does not accept any argument, concatenates areaCode
and number with a dash in between, and returns the resultant String.*/


class Telephone{
    private String areaCode;
    private String number;
    private int numberOfTelephoneObject;

    public Telephone(String areaCode, String number){
        this.areaCode = areaCode;
        this.number = number;
        numberOfTelephoneObject++;
    }
    public Telephone(){
        this.areaCode = null;
        this.number = null;
        numberOfTelephoneObject++;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String makeFullNumber(){
        return areaCode + "-" + number;
    }
}
class T1Q1{
    public static void main(String[] args) {
        Telephone[] phones = new Telephone[5];
        int a = 79676300;
        for (int i = 0; i < phones.length; i++) {
            phones[i] = new Telephone("03",Integer.toString(a));
            a++;
        }

        for (int i = 0; i < phones.length; i++) {
            System.out.println(phones[i].makeFullNumber());
        }
    }
}