public class Exercise22 {

    public static void main(String[] args) {
        String name = "Corbos";
        int milesToWork = 17;
        String transport = "helicopter";

        // 1. Use the variables above to construct a sentence in the form:
        // "Asma commutes with a bike. The commute is 3 miles each way."
        // Changing variable values should change the sentence.

        String sentence = name + " commutes with a " + transport + ". The commute is " + milesToWork + " miles each way.";
        System.out.println(sentence);
    }
}
