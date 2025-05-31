public class Consumidor extends Thread {
    private final MonitorBuffer buffer;

    public Consumidor(MonitorBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                buffer.consumir();
                Thread.sleep(1500); // simula tempo de consumo
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
