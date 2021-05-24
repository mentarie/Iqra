package proyek.android.iqra.apihelper;

public interface Callback<T> {
    void callback(T response);
    void error();
}
