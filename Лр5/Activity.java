abstract class Activity {
    private String activityName;
    private Application app;
    private boolean isRunning;

    public Activity(Application app, String activityName) {
        this.app = app;
        this.activityName = activityName;
    }

    // Жизненный цикл активности
    public void onStart(String nameActivity) {
        this.isRunning = true;
        System.out.println("Активити " + nameActivity + " запущено.");
        onCreate(null); // Пример создания без фрагмента
    }

    public Activity onCreate(Fragment fragment) {
        System.out.println("Создание фрагментов для активити " + activityName);
        return this;
    }

    public void onPause() {
        System.out.println("Активити " + activityName + " на паузе.");
    }

    public void onStop() {
        System.out.println("Активити " + activityName + " остановлено.");
    }

    public void onResume(Fragment fragment) {
        System.out.println("Активити " + activityName + " возобновлено с фрагментом.");
    }

    public void onDestroy() {
        System.out.println("Активити " + activityName + " уничтожено.");
        this.isRunning = false;
    }

    public abstract void onFragmentAttached(Fragment fragment);
}
