package org.example.filtros;

public interface Filtro <I,O>{
    O processar(I entrada);
}
