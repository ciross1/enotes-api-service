package com.myself.Enotes.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Die Annotation @Bean
// Sagt Spring: "Die Rückgabe dieses Methodenaufrufs
// soll als Bean ins ApplicationContext aufgenommen werden."
//Bedeutet: Spring erzeugt beim Starten ein einziges
// ModelMapper-Objekt (Singleton), das dann überall injiziert werden kann.

// ModelMapper ist ein Framework, um Objekte automatisch ineinander
// zu konvertieren (z. B. UserEntity → UserDto).
//Statt in jeder Klasse mit new ModelMapper() neue Instanzen zu
// erzeugen, lässt man Spring die Kontrolle übernehmen.

@Configuration
public class ProjectConfig {
    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }
}
