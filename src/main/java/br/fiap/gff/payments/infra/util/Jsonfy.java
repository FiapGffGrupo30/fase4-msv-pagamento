package br.fiap.gff.payments.infra.util;

import com.google.gson.Gson;

public class Jsonfy {
    private Jsonfy() {}

    public static String parse(Object o) {
        return new Gson().toJson(o);
    }
}
