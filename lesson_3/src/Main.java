import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] wordArr =
                {"Венансио", "Вениамин", "Венцеслав", "Верослав", "Викентий", "Виктор", "Виктор", "Викторин", "Вильгельм", "Винцас",
                        "Виссарион", "Виссарион", "Виталий", "Витаутас", "Вито", "Владимир", "Владислав", "Владислав", "Владлен", "Влас", "Волк"};

        Map<String, Integer> wordMap = new HashMap<>();
        for (String s : wordArr) {
            Integer val = wordMap.getOrDefault(s, 0);
            wordMap.put(s, val + 1);
        }
        System.out.println(wordMap);

        
        Phonebook.add("Петров", "9125465");
        Phonebook.add("Петров", "9125466");
        Phonebook.add("Иванов", "9125463");
        System.out.println(Phonebook.get("Семенов"));
        System.out.println(Phonebook.get("Петров"));
        Phonebook.info();
    }
}
