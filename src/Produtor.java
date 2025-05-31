public class Produtor extends Thread {
    private final MonitorBuffer buffer;

    public Produtor(MonitorBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                buffer.produzir();
                Thread.sleep(1000); // simula tempo de produção
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}