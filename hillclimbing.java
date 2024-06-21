import java.util.Random;
public class hillclimbing {
    public static void main(String[] args) {
        char[] best = generateRandomSolution(13);
        int bestScore = evaluate(best);

    while (true) {
        System.out.println("Best score so far: " + bestScore + "Solution:" + new String(best));
        
         if (bestScore == 0) {
         break;
         }
        
         char[] newSolution = best.clone();
         mutateSolution(newSolution);
        
         int score = evaluate(newSolution);
        
         if (score < bestScore) {
         best = newSolution;
         bestScore = score;
         }
         }
         }


         public static char[] generateRandomSolution(int length) {
            char[] solution = new char[length];
            Random random = new Random();
           
            for (int i = 0; i < length; i++) {
            solution[i] = (char) (random.nextInt(94) + 32);
            }
           
            return solution;
            }


            public static int evaluate(char[] solution) {
                String target = "Hello, world!";
                int diff = 0;
               
                for (int i = 0; i < target.length(); i++) {
                char s = solution[i];
                char t = target.charAt(i);
                diff += Math.abs((int) s - (int) t);
                }
               
                return diff;
                }
               
                public static void mutateSolution(char[] solution) {
                Random random = new Random();
                int index = random.nextInt(solution.length);
                solution[index] = (char) (random.nextInt(94) + 32);
                }

    
}
