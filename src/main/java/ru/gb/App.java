package ru.gb;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    public static double oW;
    public static double nW;

    public static void main( String[] args ) {


        for (int i = 0; i < 1000; i++) {
            List<String> element = new ArrayList<>();
            String A = "false";
            String B = "false";
            String C = "false";
            element.add(A);
            element.add(B);
            element.add(C);
            System.out.println("****************************************");
            List<String> newElems = values(element);
            oldChoise(newElems);
            System.out.println("wins в случае сохранения выбора: " + oW);
            newChoise(newElems);
            System.out.println("wins в случае изменения выбора: " + nW);
            System.out.println("****************************************");
        }
        System.out.println("wins в случае сохранения выбора: " + oW);
        System.out.println("wins в случае изменения выбора: " + nW);

        System.out.println();

        System.out.println("ВЫигрышей при сохранении выбора: " + oW/10 + "%");
        System.out.println("ВЫигрышей при изменении выбора: " + nW/10 + "%");
    }

    public static List<String> values(List<String> element){
        System.out.println("Изначальный лист: ");
        System.out.println(element);
        Random random = new Random();
        int count = random.nextInt(0, 3);
        System.out.println("count: " + count);
        element.set(count, "true");
        System.out.println("Новый лист: ");
        System.out.println(element);
        return element;
    }

    public static void oldChoise(List<String> element){
        System.out.println("Не изменяем выбор");
        Random random = new Random();
        int choise = random.nextInt(0, element.size());
        System.out.println("ВЫбор игрока: " + choise);
        for (int i = 0; i < element.size(); i++) {
            if(element.get(i).equals("true") && i == choise){
                oW++;
            }
        }
    }

    public static void newChoise(List<String> element){
        System.out.println("Изменяем выбор");
        Random random = new Random();
        int choise = random.nextInt(0, element.size());
        System.out.println("ВЫбор игрока: " + choise);
        for (int i = 0; i < element.size(); i++) {
            if(!(element.get(i).equals("true")) && i != choise){
                element.set(i, "null");
            }
        }
        System.out.println("Открыли одну из дверей");
        System.out.println(element);
        for (int i = 0; i < element.size(); i++) {
            if(!(element.get(i).equals("null")) && i != choise){
                choise = i;
            }
        }
        if(element.get(choise).equals("true")){
            nW++;
        }
    }

}
