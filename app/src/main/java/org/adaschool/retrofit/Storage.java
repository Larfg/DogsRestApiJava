package org.adaschool.retrofit;

public interface Storage {
    void saveToken(String token);
    String getToken();
    void clear();
}
