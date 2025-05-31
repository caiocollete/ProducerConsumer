public class MonitorBuffer {
    private final int[] buffer;
    private int count = 0, in = 0, out = 0;
    private int itemCounter = 0;

    public MonitorBuffer(int size) {
        buffer = new int[size];
    }

    // Metodo do produtor
    public synchronized void produzir() throws InterruptedException {
        while (count == buffer.length) {
            // buffer cheio, espera
            System.out.println("Buffer cheio: " + Thread.currentThread().getName() + " esperando..." );
            wait();
        }

        int item = itemCounter++;
        buffer[in] = item;
        in = (in + 1) % buffer.length;
        count++;

        System.out.println(Thread.currentThread().getName() + " produziu: " + item);
        // notifica os consumidores
        notifyAll();
    }

    // Metodo do consumidor
    public synchronized int consumir() throws InterruptedException {
        while (count == 0) {
            System.out.println("Buffer vazio: " + Thread.currentThread().getName() + " esperando..." );
            wait();
        }
        int item = buffer[out];
        out = (out + 1) % buffer.length;
        count--;
        System.out.println(Thread.currentThread().getName() + " consumiu: " + item);
        notifyAll();
        return item;
    }
}

