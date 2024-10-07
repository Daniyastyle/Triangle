abstract class Fragment {
    private String fragmentName;
    private Activity activity;
    private View view;

    public Fragment(String fragmentName) {
        this.fragmentName = fragmentName;
    }

    // Жизненный цикл фрагмента
    public void onAttach(Activity activity) {
        this.activity = activity;
        System.out.println("Фрагмент " + fragmentName + " прикреплен к активити.");
    }

    public void onStart(String nameFragment) {
        System.out.println("Фрагмент " + nameFragment + " запущен.");
    }

    public View onCreateView() {
        this.view = new View();
        System.out.println("Создание представления для фрагмента " + fragmentName);
        return view;
    }

    public void onViewCreated(View view) {
        System.out.println("Представление для фрагмента " + fragmentName + " создано.");
    }

    public void onDestroyView() {
        System.out.println("Представление для фрагмента " + fragmentName + " уничтожено.");
    }

    public void onPause() {
        System.out.println("Фрагмент " + fragmentName + " на паузе.");
    }

    public void onResume() {
        System.out.println("Фрагмент " + fragmentName + " возобновлен.");
    }

    public void onDetach() {
        System.out.println("Фрагмент " + fragmentName + " откреплен от активити.");
    }

    public void onDestroy() {
        System.out.println("Фрагмент " + fragmentName + " уничтожен.");
    }
}
