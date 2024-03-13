import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        ArrayList<String> namesList = new ArrayList<>(); //для вывода списка позиций
        String name; //переменная для названий товаров
        double count; //переменная для цены товара
        String outOrNot; //переменная для завершения цикла добавления товаров
        double allCount = 0.00; //переменная отвечающая за общий счет
        int i; //переменная количества человек
        int n; //переменная для счетчика вывода списка товаров
        String text; //переменная отвечающая за вывод итоговой суммы на каждого в формате 10.45
        String text2 = null; //переменная отвечающая за вывод рубль/рубля/рублей
        double resultCount; //переменная отвечающая за разделение счета на каждого
        int l; //переменная которая определяет количество символов в счете на каждого см.text

        System.out.println("На скольких человек необходимо разделить счёт?");  //цикл с проверками на подходящее количество человек
        while (true) {
            if (scanner.hasNextInt()) {
                i = scanner.nextInt();
                if (i > 1) {
                    break;
                } else {
                    System.out.println("Ошибка! Введите корректное значение на скольких человек необходимо разделить счёт?");
                }
            } else {
                System.out.println("Ошибка! Введите целочисленное значение");
                scanner.next();
            }
        }

        do {
            System.out.println("Введите название товара"); //цикл для добавления товаров в ArrayList и сумирования их стоимости
            name = scanner.next();
            System.out.println("Введите стоимость этого товара");
            count = scanner.nextDouble();
            System.out.println("Товар успешно добавлен");
            namesList.add(name);
            allCount = allCount + count;
            System.out.println("Хотите ли добавить еще один товар?");
            outOrNot = scanner.next();
        } while (!"Завершить".equalsIgnoreCase(outOrNot));

        System.out.println("Добавленные товары:"); //Итоговый вывод товаров через счетчик
        for (n = 0; n < namesList.size(); n++) {
        System.out.println(namesList.get(n));
        }
        resultCount = (allCount / i);
        text = String.format("%.2f", resultCount);
        l = text.length();
        switch(text.substring(l-4,l-3)) { //свитч для определения правильного окончания
            case "1": text2 = "рубль";
                break;
            case "2":
            case "3":
            case "4": text2 = "рубля";
                break;
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":
                text2 = "рублей";
                break;
        }
        System.out.println(text + " " + text2); //итоговый вывод суммы на каждого в нужном формате и с правильным окончанием
    }
}



