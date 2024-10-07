public class MainApp extends Application {

    public MainApp(String appName, String version) {
        super(appName, version);
    }

    @Override
    public void onActivityStarted(Activity activity) {
        System.out.println("Активити " + activity + " начало выполнение.");
    }

    public static void main(String[] args) {
        MainApp app = new MainApp("DemoApp", "1.0");
        app.onStart("DemoApp");

        Activity mainActivity = new Activity(app, "MainActivity") {
            @Override
            public void onFragmentAttached(Fragment fragment) {
                System.out.println("Фрагмент " + fragment + " прикреплен.");
            }
        };

        mainActivity.onStart("MainActivity");

        FragmentWithListener fragment = new FragmentWithListener("MainFragment");
        fragment.onAttach(mainActivity);
        fragment.onStart("MainFragment");

        MyDialogFragment dialogFragment = new MyDialogFragment("DialogFragment", fragment);
        dialogFragment.show();
        dialogFragment.sendDataToFragment("Some data");

        dialogFragment.dismiss();
        fragment.onResume();
        mainActivity.onDestroy();
        app.onClose();
    }
}
