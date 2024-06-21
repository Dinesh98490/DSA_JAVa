import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneticAlgorithm {

    private static final String GENES =
"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOP" +
 "QRSTUVWXYZ 1234567890, .-;:_!\"#%&/()=?@${[]}";

 private static final String TARGET = "I love Programming";
 private static final int POPULATION_SIZE = 100;
 private List<Character> chromosome;
 private int fitness;
 public GeneticAlgorithm(List<Character> chromosome) {
 this.chromosome = chromosome;
 fitness = calculateFitness();
 }
 private static char mutatedGenes() {
    Random random = new Random();
    int index = random.nextInt(GENES.length());

    return GENES.charAt(index);
 }

 private static List<Character> createGnome() {
    List<Character> gnome = new ArrayList<>();
    for (int i = 0; i < TARGET.length(); i++) {
    gnome.add(mutatedGenes());
    }
    return gnome;
    }

    public GeneticAlgorithm mate(GeneticAlgorithm parent2) {
        List<Character> childChromosome = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < chromosome.size(); i++) {
        double p = random.nextDouble();
        if (p < 0.45) {
        childChromosome.add(chromosome.get(i));
        } else if (p < 0.90) {
       
       childChromosome.add(parent2.chromosome.get(i));
        } else {
        childChromosome.add(mutatedGenes());
        }
        }
        return new GeneticAlgorithm(childChromosome);
        }


        private int calculateFitness() {
            int fitness = 0;
            for (int i = 0; i < chromosome.size(); i++) {
            if (chromosome.get(i) != TARGET.charAt(i)) {
            fitness++;
            }
            }
            return fitness;
            }

            public int getFitness() {

                return fitness;
                }


                public List<Character> getChromosome() {
                    return chromosome;
                    }
                    public static void main(String[] args) {
                    int generation = 1;
                    boolean found = false;
                    List<GeneticAlgorithm> population = new
                   ArrayList<>();
                    for (int i = 0; i < POPULATION_SIZE; i++) {
                    List<Character> gnome = createGnome();
                    population.add(new GeneticAlgorithm(gnome));
                    }
                    while (!found) {
                    population.sort((ind1, ind2) ->
                   Integer.compare(ind1.getFitness(), ind2.getFitness()));
                    if (population.get(0).getFitness() <= 0) {
                    found = true;
                    break;
                    }

                    List<GeneticAlgorithm> newGeneration = new
                ArrayList<>();
                int elitismCount = (10 * POPULATION_SIZE) / 100;
                newGeneration.addAll(population.subList(0,
                elitismCount));
             int offspringCount = (90 * POPULATION_SIZE) /
            100;
            Random random = new Random();
            for (int i = 0; i < offspringCount; i++) {
            int indexParent1 = random.nextInt(50);
            
            int indexParent2 = random.nextInt(50);
            GeneticAlgorithm parent1 =
           population.get(indexParent1);
            GeneticAlgorithm parent2 =
           population.get(indexParent2);
            GeneticAlgorithm offspring =
           parent1.mate(parent2);
            newGeneration.add(offspring);
            }

            population = newGeneration;
 System.out.printf("Generation: %d\tString:%s\tFitness: %d%n",generation,

convertToString(population.get(0).getChromosome()),population.get(0).getFitness());
 generation++;
 }
 System.out.printf("Generation: %d\tString:%s\tFitness: %d%n",
 generation,

convertToString(population.get(0).getChromosome()),
 population.get(0).getFitness());
 }
 private static String convertToString(List<Character>
chromosome) {
 StringBuilder stringBuilder = new StringBuilder();
 for (Character gene : chromosome) {
 stringBuilder.append(gene);
 }
 return stringBuilder.toString();
}
    
}
