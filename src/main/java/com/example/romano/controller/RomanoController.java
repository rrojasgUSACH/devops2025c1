package com.example.romano.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/romano")
public class RomanoController {

    @GetMapping("/{numero}")
    public String convertirARomano(@PathVariable int numero) {
        if (numero <= 0 || numero > 3999) {
            return "Number out of range (1-3999)";
        }
        return convertirNumeroRomano(numero);
    }
    @GetMapping("/convertir/{romano}")
    public String convertirAEntero(@PathVariable String romano) {
        try {
            return String.valueOf(convertirRomanoAEntero(romano));
        } catch (IllegalArgumentException e) {
            return "Número romano inválido";
        }
    }

    private int convertirRomanoAEntero(String romano) {
        int resultado = 0;
        int anterior = 0;

        for (int i = romano.length() - 1; i >= 0; i--) {
            int valor = valorRomano(romano.charAt(i));
            if (valor < anterior) {
                resultado -= valor;
            } else {
                resultado += valor;
            }
            anterior = valor;
        }

        return resultado;
    }

    private int valorRomano(char caracter) {
        switch (caracter) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: throw new IllegalArgumentException("Carácter romano inválido: " + caracter);
        }
    }
    private String convertirNumeroRomano(int numero) {
        String[] miles = {"", "M", "MM", "MMM"};
        String[] centenas = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] decenas = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] unidades = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return miles[numero / 1000] +
               centenas[(numero % 1000) / 100] +
               decenas[(numero % 100) / 10] +
               unidades[numero % 10];
    }
}