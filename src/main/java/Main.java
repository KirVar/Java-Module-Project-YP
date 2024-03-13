import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        ArrayList<String> namesList = new ArrayList<>(); //для вывода списка позиций
        ArrayList<Double> countsList = new ArrayList<>(); //для вывода цены каждого товара
        String name; //переменная для названий товаров
        double count; //переменная для цены товара
        String outOrNot; //переменная для завершения цикла добавления товаров
        double allCount = 0.00; //переменная отвечающая за общий счет
        int i; //переменная количества человек
        int n; //переменная для счетчика вывода списка товаров и их цен
        String text; //переменная отвечающая за вывод итоговой суммы на каждого в формате 10.45
        String text2 = null; //переменная отвечающая за вывод рубль/рубля/рублей
        double resultCount; //переменная отвечающая за разделение счета на каждого
        int l; //переменная которая определяет количество символов в счете на каждого см.text
        String text3 = null; //переменная отвечающая за вывод рубль/рубля/рублей в каждом товаре
        String text4; //переменная для цикла вывода  рубль/рубля/рублей в каждом товаре

        System.out.println("На скольких человек необходимо разделить счёт?");  //цикл с проверками на подходящее количество человек
        while (true) {
            if (scanner.hasNextInt()) {
                i = scanner.nextInt();
                if (i > 1) {
                    break;
                } else {
                    System.out.println("Ошибка! Введите корректное значение на скольких человек необходимо разделить счёт");
                }
            } else {
                System.out.println("Ошибка! Введите целочисленное значение больше 1");
                scanner.next();
            }
        }

        do {
            System.out.println("Введите название товара"); //цикл для добавления товаров в ArrayList и сумирования их стоимости
            name = scanner.next();
            System.out.println("Введите стоимость этого товара");
            while (true) {
                if (scanner.hasNextDouble()) {
                    count = scanner.nextDouble();
                    if (count >= 0.01) {
                        break;
                    } else {
                        System.out.println("Ошибка! Введите цену товара больше 0");
                    }
                } else {
                    System.out.println("Ошибка! Введите цену товара числом");
                    scanner.next();
                }
            }
            System.out.println("Товар успешно добавлен");
            namesList.add(name);
            countsList.add(count);
            allCount = allCount + count;
            System.out.println("Хотите ли добавить еще один товар?");
            outOrNot = scanner.next();
        } while (!"Завершить".equalsIgnoreCase(outOrNot));

        System.out.println("Добавленные товары:"); //Итоговый вывод товаров через счетчик
        for (n = 0; n < namesList.size(); n++) {

            if ((countsList.get(n)%100 >= 11.00) && (countsList.get(n)%100 <= 19.99)) {
                text3 = "рублей";
            } else {
                text4 = String.format("%.2f", countsList.get(n));
                l = text4.length();
                switch (text4.substring(l - 4, l - 3)) { //свитч для определения правильного окончания
                    case "1":
                        text3 = "рубль";
                        break;
                    case "2":
                    case "3":
                    case "4":
                        text3 = "рубля";
                        break;
                    case "5":
                    case "6":
                    case "7":
                    case "8":
                    case "9":
                    case "0":
                        text3 = "рублей";
                        break;
                }
            }
            System.out.println(namesList.get(n) + " " + countsList.get(n) + " " + text3);

        }
        resultCount = (allCount / i);
        text = String.format("%.2f", resultCount);
        if ((resultCount%100 >= 11.00) && (resultCount%100 <= 19.99)) {
            text2 = "рублей";
        } else {
            l = text.length();
            switch (text.substring(l - 4, l - 3)) { //свитч для определения правильного окончания
                case "1":
                    text2 = "рубль";
                    break;
                case "2":
                case "3":
                case "4":
                    text2 = "рубля";
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
        }
        System.out.println("Доля суммы всех товаров на каждого равна: " + text + " " + text2); //итоговый вывод суммы на каждого в нужном формате и с правильным окончанием
    }
}



