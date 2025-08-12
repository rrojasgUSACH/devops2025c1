package com.example.romano.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/romano")
public class RomanoController {

    @GetMapping("/{numero}")
    public String convertirARomano(@PathVariable int numero) {
        if (numero <= 0 || numero > 3999) {
            return "Número fuera de rango (1-3999)";
        }
        return convertirNumeroRomano(numero);
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