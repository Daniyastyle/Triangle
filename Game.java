public class Game {
    // Свойства
    private boolean isRunning;
    private int fps;
    private boolean isMultiplayer;
    private String genre;
    private String company;
    private String distributor;
    private Thread gameThread;

    // Конструктор
    public Game(boolean isRunning, int fps, boolean isMultiplayer, String genre, String company, String distributor) {
        this.isRunning = isRunning;
        this.fps = fps;
        this.isMultiplayer = isMultiplayer;
        this.genre = genre;
        this.company = company;
        this.distributor = distributor;
    }

    // Геттеры и сеттеры
    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public int getFps() {
        return fps;
    }

    public void setFps(int fps) {
        this.fps = fps;
    }

    public boolean isMultiplayer() {
        return isMultiplayer;
    }

    public void setMultiplayer(boolean isMultiplayer) {
        this.isMultiplayer = isMultiplayer;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    // Метод для запуска игры
    public void start() {
        if (isRunning) {
            System.out.println("Игра уже запущена.");
            return;
        }

        isRunning = true;
        gameThread = new Thread(() -> {
            while (isRunning) {
                try {
                    System.out.println("Игра запущена.");
                    Thread.sleep(1000); // Выводим сообщение каждую секунду
                } catch (InterruptedException e) {
                    System.out.println("Ошибка в потоке игры: " + e.getMessage());
                }
            }
        });
        gameThread.start();
    }

    // Метод для остановки игры
    public void stop() {
        if (!isRunning) {
            System.out.println("Игра не запущена.");
            return;
        }

        isRunning = false;
        try {
            gameThread.join(); // Ожидаем завершения потока
            System.out.println("Игра остановлена.");
        } catch (InterruptedException e) {
            System.out.println("Ошибка при остановке игры: " + e.getMessage());
        }
    }

    // Метод для обработки ошибки
    public void error(String message) {
        System.out.println("Ошибка: " + message);
        stop();
    }

    // Тестовый запуск
    public static void main(String[] args) {
        Game game = new Game(false, 60, true, "Action", "Epic Games", "Steam");

        game.start();

        // Через некоторое время остановим игру
        try {
            Thread.sleep(5000); // Ждем 5 секунд
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        game.stop();
    }
}
