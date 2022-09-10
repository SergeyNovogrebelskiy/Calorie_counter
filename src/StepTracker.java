public class StepTracker {
    MonthData[] monthToData;
    int stepsTarget = 10000;
    Converter converter = new Converter();
    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
    class MonthData {
        int [] days;
        MonthData() {
        days = new int [30];
        }
    }
    void saveSteps(int month, int day, int steps) {
        monthToData[month].days[day] = steps;
    }
    void stepsPerDay(int month){
        // Количество пройденных шагов по дням
        for(int i = 0; i < 30; i++){
            System.out.print((i+1) + " день: " + monthToData[month].days[i] + ", ");
        }
        System.out.println();
    }
    void stepsPerMonth(int month){
        // Общее количество шагов за месяц
        int sumSteps = 0;
        for(int i = 0; i < 30; i++){
            sumSteps += monthToData[month].days[i];
        }
        System.out.println("Общее количество шагов за месяц: " + sumSteps);
    }
    void maxStepsPerMonth(int month){
        // Максимальное пройденное количество шагов в месяце
        int maxSteps = monthToData[month].days[0];
        for(int i = 1; i < 30; i++){
            if(monthToData[month].days[i] > maxSteps){
                maxSteps = monthToData[month].days[i];
            }
        }
        System.out.println("Максимальное пройденное количество шагов в месяце: " + maxSteps);
    }
    void meanSteps(int month){
        //Среднее количество шагов
        double sumSteps = 0;
        for(int i = 0; i < 30; i++){
            sumSteps += monthToData[month].days[i];
        }
        System.out.println("Среднее количество шагов: " + (sumSteps / 30));
    }
    void distanceTraveled (int month){
        //Пройденная дистанция (в км)
        int sumSteps = 0;
        for(int i = 0; i < 30; i++){
            sumSteps += monthToData[month].days[i];
        }
        double distance = converter.convStepsToDistance(sumSteps);
        System.out.println("Пройденная дистанция (в км): " + distance);
    }
    void caloriesBurned (int month){
        //Количество сожжённых килокалорий
        int sumSteps = 0;
        for(int i = 0; i < 30; i++){
            sumSteps += monthToData[month].days[i];
        }
        double calories = converter.convStepsToCalories(sumSteps);
        System.out.println("Количество сожжённых килокалорий: " + calories);
    }
    void bestSeries (int month){
        //Лучшая серия
        int countSeries = 0;
        int maxSeries = 0;
        for(int i = 0; i < 30; i++) {
            if(monthToData[month].days[i] >= stepsTarget){
                countSeries++;
                if(countSeries > maxSeries){
                    maxSeries = countSeries;
                }
            } else {
                countSeries = 0;
            }
        }
        System.out.println("Лучшая серия: " + maxSeries);
    }
    void changeStepsTarget(int newStepsTarget){
        // Изменить цель по количеству шагов в день
        stepsTarget = newStepsTarget;
        System.out.println("Цель по количеству шагов в день изменена!");
    }
}