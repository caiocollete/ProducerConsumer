public class Main {
    public static void main(String[] args) {
        MonitorBuffer buffer = new MonitorBuffer(5);

        Produtor produtor = new Produtor(buffer);
        Produtor produtor2 = new Produtor(buffer);
        Consumidor consumidor = new Consumidor(buffer);
        Consumidor consumidor2 = new Consumidor(buffer);

        produtor.setName("Produtor 1");
        produtor2.setName("Produtor 2");
        consumidor.setName("Consumidor 1");
        consumidor2.setName("Consumidor 2");

        produtor.start();
        produtor2.start();
        consumidor.start();
        //consumidor2.start();
    }
}