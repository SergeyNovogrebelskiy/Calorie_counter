import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            // обработка разных случаев
            if (userInput == 1) {
                // 1 - Ввести количество шагов за определённый день
                System.out.print("Введите номер месяца от 0 до 11, где 0 это январь, а 11 это декабрь: ");
                int month = scanner.nextInt();
                if(month >= 0 && month < 12) {
                    System.out.print("Введите номер дня от 0 до 29, где 0 это 1 день месяца, а 29 это 30 день месяца: ");
                    int day = scanner.nextInt();
                    if(day >= 0 && day < 30){
                        System.out.print("Введите количество пройденных шагов за указанный день: ");
                        int steps = scanner.nextInt();
                        stepTracker.saveSteps(month, day, steps);
                        System.out.println("Значения сохранены.");
                    } else {
                        System.out.println("Введены неверные параметры! Попробуйте снова.");
                    }
                } else {
                    System.out.println("Введены неверные параметры! Попробуйте снова.");
                }
            } else if (userInput == 2) {
                // 2 - Напечатать статистику за определённый месяц
                if (userInput == 2) {
                    System.out.print("Введите номер месяца от 0 до 11, где 0 это январь, а 11 это декабрь: ");
                    int month = scanner.nextInt();
                    if(month >= 0 && month < 12) {
                        stepTracker.stepsPerDay(month); //Количество пройденных шагов по дням
                        stepTracker.stepsPerMonth(month); //Общее количество шагов за месяц
                        stepTracker.maxStepsPerMonth(month); //Максимальное пройденное количество шагов в месяце
                        stepTracker.meanSteps(month); //Среднее количество шагов
                        stepTracker.distanceTraveled(month); //Пройденная дистанция (в км)
                        stepTracker.caloriesBurned(month); //Количество сожжённых килокалорий
                        stepTracker.bestSeries(month); //Лучшая серия
                    } else {
                        System.out.println("Введены неверные параметры! Попробуйте снова.");
                    }
                }
            } else if (userInput == 3) {
                // 3 - Изменить цель по количеству шагов в день
                System.out.print("Введите новую цель по количеству шагов в день: ");
                int newStepsTarget = scanner.nextInt();
                if(newStepsTarget >= 0){
                    stepTracker.changeStepsTarget(newStepsTarget);
                } else {
                    System.out.println("Введены неверные параметры! Попробуйте снова.");
                }
            } else{
                System.out.println("Такой команды нет!");
            }

            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день.");
        System.out.println("2 - Напечатать статистику за определённый месяц.");
        System.out.println("3 - Изменить цель по количеству шагов в день.");
        System.out.println("0 - Выйти из приложения.");
        System.out.print("Введите команду: ");
    }
}