import org.joda.time.LocalDate;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.*;

public class PersonUtilsTest {

    List<Person> personList = new ArrayList<>();
    Person person1 = new Person("Ben", new LocalDate(1985, 11, 29), Person.Sex.MALE);
    Person person2 = new Person("Bob", new LocalDate( 2000, 11, 29), Person.Sex.MALE);
    Person person3 = new Person("Claire", new LocalDate(2017, 11, 29), Person.Sex.FEMALE);
    Person person4 = new Person("Sarah" , new LocalDate(1986, 11, 07), Person.Sex.FEMALE);


    @Test
    public void checkWithPredicate() {
        personList.clear();

        Predicate<Person> predicate = person -> person.getAge() > 21;
        PersonUtils personUtils = new PersonUtils();

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);

        CheckPerson tester = personUtils.new Tester(predicate);



        Integer expected = 2;
        Integer actual = personUtils.checkWithPredicate(personList, tester).size();

        assertEquals(expected, actual);
    }

    @Test
    public void checkWithPredicate2(){
        personList.clear();

        Predicate<Person> predicate = person -> person.getAge() < 21;
        PersonUtils personUtils = new PersonUtils();

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);

        CheckPerson tester = personUtils.new Tester(predicate);

        Integer expected = 2;
        Integer actual = personUtils.checkWithPredicate(personList, tester).size();

        assertEquals(expected, actual);

    }


    @Test
    public void checkWithPredicate3(){
        personList.clear();

        Predicate<Person> predicate = person -> person.getAge() < 21 && person.getAge() > 5;
        PersonUtils personUtils = new PersonUtils();

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);

        CheckPerson tester = personUtils.new Tester(predicate);

        Integer expected = 1;
        Integer actual = personUtils.checkWithPredicate(personList, tester).size();

        assertEquals(expected, actual);




    }
}