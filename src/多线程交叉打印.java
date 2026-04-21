public class 多线程交叉打印 {
    public static void main(String[] args) {
        AB ab = new AB();
        Thread t1 = new Thread(ab::printA);
        Thread t2 = new Thread(ab::printB);
        Thread t3 = new Thread(ab::printC);
        t1.start();
        t2.start();
        t3.start();
    }

    static class AB {
        private int state = 0;
        private int sum = 0;

        public synchronized void printA() {
            while (sum <= 100) {
                if (state == 0) {
                    System.out.println("A " + sum);
                    sum++;
                    state = 1;
                    notifyAll();
                } else {
                    waitSafely();
                }
            }
        }

        public synchronized void printB() {
            while (sum <= 100) {
                if (state == 1) {
                    System.out.println("B " + sum);
                    sum++;
                    state = 2;
                    notifyAll();
                } else {
                    waitSafely();
                }
            }
        }

        public synchronized void printC() {
            while (sum <= 100) {
                if (state == 2) {
                    System.out.println("C " + sum);
                    sum++;
                    state = 0;
                    notifyAll();
                } else {
                    waitSafely();
                }
            }
        }

        private void waitSafely() {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
    }
}
