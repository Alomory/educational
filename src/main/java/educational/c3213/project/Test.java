package educational.c3213.project;

public class Test {
    public static void main(String[] args) {
        Process p1 = new Process(0, 3);
        Process p2 = new Process(2, 6);
        Process p3 = new Process(4, 4);
        Process p4 = new Process(6, 5);
        Process p5 = new Process(8, 2);
        HighestResponseRatioNext hrrn = new HighestResponseRatioNext(p1, p2, p3, p4, p5);
        while (!hrrn.waitingQueue.isEmpty() || !hrrn.readyQueue.isEmpty() || hrrn.currentProcess != null)
            System.out.println(hrrn.next());
    }
}
