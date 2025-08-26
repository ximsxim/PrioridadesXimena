import java.util.Random;

public class Main {

    public static void ejemploPriorityQueue() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Random rand = new Random();
        int cantidad = 20;

        System.out.println("Agregando valores aleatorios a la PriorityQueue:");
        for (int i = 0; i < cantidad; i++) {
            int valor = rand.nextInt(100) + 1; 
            pq.push(valor, valor);            
            System.out.print(valor + " ");
        }

        System.out.println("\n\nMostrando en orden ascendente de prioridad:");
        pq.showAscending();
    }

    public static void main(String[] args) {
        ejemploPriorityQueue();
    }
}
