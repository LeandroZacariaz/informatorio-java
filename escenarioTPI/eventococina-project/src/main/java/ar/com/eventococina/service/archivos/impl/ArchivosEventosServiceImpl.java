package ar.com.eventococina.service.archivos.impl;

import java.io.IOException;
import java.util.List;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import ar.com.eventococina.domain.EventoGastronomico;
import ar.com.eventococina.service.archivos.ArchivosEventosService;

public class ArchivosEventosServiceImpl implements ArchivosEventosService{
    private final String UBICACION_ARCHIVO = "\\eventococina-project\\src\\main\\java\\ar\\com\\eventococina\\recursos\\";

    CSVWriter csvWriter;

    @Override
    public void exportarCursosCsv(List<EventoGastronomico> eventos) {
        String ruta = System.getProperty("user.dir").concat(UBICACION_ARCHIVO).concat("eventos-llenos.csv");

        try{
            this.csvWriter = new CSVWriter(new FileWriter(ruta));
            //Creamos encabezado
            String[] encabezado = {"ID","NOMBRE","FECHA Y HORA","UBICACION"};
            this.csvWriter.writeNext(encabezado);

            for (EventoGastronomico eventoGastronomico : eventos) {
                if(eventoGastronomico.getParticipantes().size()==eventoGastronomico.getCapacidad()){
                    String[] datos = {
                        eventoGastronomico.getId_evento().toString(),
                        eventoGastronomico.getNombre().toString(),
                        eventoGastronomico.getFecha_hora().toString(),
                        eventoGastronomico.getUbicacion().toString()
                    };
                    this.csvWriter.writeNext(datos);
                };
            }

            //Cerrar el csvWriter
            cerrarWriter();
            System.out.println("Exportacion exitosa");

        }catch (IOException e){
            System.out.println("Algo salio mal motivo :" + e.getMessage().concat(" Ubicacion archivo : " + ruta));
        } 
        
    }
    @Override
    public void cerrarWriter() {
        if (this.csvWriter != null){
            try{
                this.csvWriter.close();
            }catch (IOException e){
                System.out.println("Algo salio mal motivo :" + e.getMessage());
            }
        }
    }
    
}
