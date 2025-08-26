public class PriorityQueue<dataType> {

    public static final int CAPACITY = 1000;

    private int size = 0;
    private PriorityNode<dataType>[] data;

    @SuppressWarnings("unchecked")
    public PriorityQueue() {
        data = (PriorityNode<dataType>[]) new PriorityNode[CAPACITY + 1];
    }

    public void push(int priority, dataType value) {
        if (size + 1 > CAPACITY) {
            throw new IllegalStateException("Se superó la capacidad de la PriorityQueue");
        }

        PriorityNode<dataType> nodeToInsert = new PriorityNode<>(priority, value);
        int myPosition = ++size;
        data[myPosition] = nodeToInsert;

        while (myPosition > 1) {
            int myParentPosition = myPosition / 2;
            PriorityNode<dataType> myParent = data[myParentPosition];

            if (myParent.getPriority() <= nodeToInsert.getPriority()) break;

            data[myPosition] = myParent;
            data[myParentPosition] = nodeToInsert;
            myPosition = myParentPosition;
        }
    }

    public void showAscending() {
        if (size == 0) {
            System.out.println("La cola está vacía.");
            return;
        }
        int[] priorities = new int[size];
        for (int i = 1; i <= size; i++) {
            priorities[i - 1] = data[i].getPriority();
        }
        java.util.Arrays.sort(priorities);

        System.out.println("Elementos en orden ascendente de prioridad:");
        for (int p : priorities) {
            System.out.print(p + " ");
        }
        System.out.println();
    }
}
