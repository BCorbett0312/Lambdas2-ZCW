

import org.joda.time.LocalDate;
import org.joda.time.Years;
import java.util.List;


public class Person {




    public enum Sex{
        MALE,
        FEMALE,
        DEFAULT
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress = "none@none.com";

    public Person(){
        this.name = "Blank Name";
        this.birthday = LocalDate.now();
        this.gender = Sex.DEFAULT;

    }


    public Person(String name, LocalDate dob, Sex gender){
        this.name = name;
        this.birthday = dob;
        this.gender = gender;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }



    public Integer getAge(){
        LocalDate now = LocalDate.now();
        Years age = Years.yearsBetween(birthday, now);

        return age.getYears();
    }


    public String printPerson(){
        String result = "Name: " + this.name + " is " + this.getAge() + " years old.";
        System.out.println(result);
        return result;
    }

    public static void printPersonOlderThan(List<Person> personList, Integer ageToCompare){
        for (Person p : personList){
            if(p.getAge() > ageToCompare){
                p.printPerson();
            }
        }
    }







}
