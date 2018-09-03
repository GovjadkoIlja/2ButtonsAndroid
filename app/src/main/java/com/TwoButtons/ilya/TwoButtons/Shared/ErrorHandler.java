package com.TwoButtons.ilya.TwoButtons.Shared;

/**
 * Created by Ilya on 13.07.2018.
 */

/*
    1 - Серверная ошибка
    2 - Нет интернета
 */

public class ErrorHandler {
    public static int getErrorType(Throwable e) {

        System.out.println(e.toString());

        if (e.toString().startsWith("java.io.IOException") || e.toString().startsWith("java.io.EOFException"))
            return 1;
        else if (e.toString().startsWith("java.net.SocketTimeoutException"))
            return 2;

        return 0;
    }
}
