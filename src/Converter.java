public class Converter {
    double distance;
    double calories;
    double convStepsToDistance (int steps){
        distance = steps * 0.00075;
        return distance;
    }
    double convStepsToCalories (int steps){
        calories = steps * 0.05;
        return calories;
    }
}
