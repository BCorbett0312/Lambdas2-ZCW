import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PersonUtils {
//    Not Needed
//    public static void printPersonOlderThan(List<Person> personList, Integer ageToCompare){
//        for (Person p : personList){
//            if(p.getAge() > ageToCompare){
//                p.printPerson();
//            }
//        }
//    }
//
//    public static void PrintPersonWithinAgeRange(List<Person> personList, Integer ageBegin, Integer ageEnd){
//        for(Person p : personList){
//            if(p.getAge() >ageBegin && p.getAge()<ageEnd){
//                p.printPerson();
//            }
//        }
//    }
//
//    public static void checkSpecificCriteria(List<Person> personList, CheckPerson toCheck){
//        for(Person p : personList){
//            if(toCheck.test(p)){
//                p.printPerson();
//            }
//        }
//    }
//
//
//    public static void checkAgeRangeLamdas(List<Person> personList, Integer ageBegin, Integer ageEnd){
//        personList.forEach(p -> {if (p.getAge() > ageBegin && p.getAge() < ageEnd) p.printPerson(); });
//
//    }
//
//    public static void printPersonsOlderThanLamdas(List<Person> personList, Integer ageToCompare){
//        personList.forEach(person -> {if (person.getAge() > ageToCompare) person.printPerson();});
//    }

    public static ArrayList<String> checkWithPredicate(List<Person> personList, CheckPerson toCompare){
        ArrayList<String> result = new ArrayList<>();
        personList.forEach(person -> {if (toCompare.test(person)) result.add(person.printPerson());});

        return result;
    }


    class Tester implements CheckPerson{

        Predicate predicate;

        Tester(Predicate predicate){
            this.predicate = predicate;
        }

        public boolean test(Person p){
            return predicate.test(p);
        }

    }




}
