abstract class DialogFragment extends Fragment {
    private boolean isDialogOpen;

    public DialogFragment(String fragmentName) {
        super(fragmentName);
        this.isDialogOpen = false;
    }

    public void show() {
        this.isDialogOpen = true;
        System.out.println("Диалог фрагмент открыт.");
        onPause(); // При открытии диалог фрагмента, основной фрагмент на паузе
    }

    public void dismiss() {
        this.isDialogOpen = false;
        System.out.println("Диалог фрагмент закрыт.");
        onResume(); // После закрытия диалог фрагмента, основной фрагмент возобновлен
    }
}
