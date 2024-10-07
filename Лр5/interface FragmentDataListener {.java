interface FragmentDataListener {
    void onDataReceived(String data);
}

class FragmentWithListener extends Fragment implements FragmentDataListener {
    public FragmentWithListener(String fragmentName) {
        super(fragmentName);
    }

    @Override
    public void onDataReceived(String data) {
        System.out.println("Фрагмент получил данные: " + data);
    }
}

class MyDialogFragment extends DialogFragment {
    private FragmentDataListener listener;

    public MyDialogFragment(String fragmentName, FragmentDataListener listener) {
        super(fragmentName);
        this.listener = listener;
    }

    public void sendDataToFragment(String data) {
        System.out.println("Диалог фрагмент отправляет данные: " + data);
        listener.onDataReceived(data);
    }
}
