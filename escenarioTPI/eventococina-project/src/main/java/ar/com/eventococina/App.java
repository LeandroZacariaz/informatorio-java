package ar.com.eventococina;

import java.util.Scanner;

import ar.com.eventococina.service.archivos.ArchivosEventosService;
import ar.com.eventococina.service.archivos.impl.ArchivosEventosServiceImpl;
import ar.com.eventococina.service.chef.ChefService;
import ar.com.eventococina.service.chef.impl.ChefServiceImpl;
import ar.com.eventococina.service.eventogastronomico.EventoGastronomicoService;
import ar.com.eventococina.service.eventogastronomico.impl.EventoGastronomicoServiceImpl;
import ar.com.eventococina.service.menu.MenuService;
import ar.com.eventococina.service.menu.impl.MenuServiceImpl;
import ar.com.eventococina.service.participante.ParticipanteService;
import ar.com.eventococina.service.participante.impl.ParticipanteServiceImpl;
import ar.com.eventococina.service.resenia.ReseniaService;
import ar.com.eventococina.service.resenia.impl.ReseniaServiceImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ChefService chefService = new ChefServiceImpl();
        EventoGastronomicoService eventoGastronomicoService = new EventoGastronomicoServiceImpl(chefService);
        
        ParticipanteService participanteService = new ParticipanteServiceImpl(eventoGastronomicoService);
        ReseniaService reseniaService = new ReseniaServiceImpl(eventoGastronomicoService, participanteService);
        ArchivosEventosService archivosEventosService = new ArchivosEventosServiceImpl();
        MenuService menuService = new MenuServiceImpl(eventoGastronomicoService, chefService,participanteService, reseniaService, archivosEventosService);

        Scanner scanner = new Scanner(System.in);

        menuService.mostrarMenu(scanner);
        scanner.close();
  }
}
  
