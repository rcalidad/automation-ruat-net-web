package main.tasks.tasas.common;

import java.util.List;
import java.util.Map;

public class DebtType {
    public static String allDebts = "TODOS";
    public static String all = "TODOS";
    public static Map<String, String> debtType = Map.of("TACE", "TASA",
                                                        "TAME", "PATENTE",
                                                        "TAAR", "ALQUILER ARBITRIO",
                                                        "TAPU", "PATENTE",
                                                        "OP", "",
                                                        "OM", "",
                                                        "MICE", "MIDF",
                                                        "MIME", "MIDF",
                                                        "MIPU", "MIDF",
                                                        "TS", "");
    public static List<String> otherConcepts = List.of("No existen los parámetros",
                                                       "ALQUILER SEPULTURA");
}
