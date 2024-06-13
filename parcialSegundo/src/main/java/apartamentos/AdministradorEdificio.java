package apartamentos;

import inquilino.Inquilino;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdministradorEdificio {

    private List<Apartamento> apartamentos;

    public AdministradorEdificio() {
        this.apartamentos = new ArrayList<>();
    }

    public void agregarApartamento(Apartamento apartamento) {
        apartamentos.add(apartamento);
    }

    public void generarInformeFinDeMes() throws IOException {
        File deudores = new File("./deudores.txt");
        File pazYSalvo = new File("./paz_y_salvo.txt");
        try ( BufferedWriter deudoresWriter = new BufferedWriter(new FileWriter(deudores));  BufferedWriter pazYSalvoWriter = new BufferedWriter(new FileWriter(pazYSalvo))) {
            for (Apartamento apartamento : apartamentos) {
                Inquilino inquilino = apartamento.getInquilino();
                String registro = "Inquilino: " + inquilino.getNombre() + " " + inquilino.getApellido()
                        + ", ID: " + inquilino.getId() + ", Apartamento: "
                        + apartamento.getNumero();
                if (inquilino.estaAlDia()) {
                    pazYSalvoWriter.write(registro + "\n");
                } else {
                    deudoresWriter.write(registro + "\n");
                }
            }
        }
    }

    public void cargarDatosInquilinosDesdeArchivo(String archivo) throws IOException {
        try ( BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombre = datos[0];
                String apellido = datos[1];
                String id = datos[2];
                int numeroApartamento = Integer.parseInt(datos[3]);
                Inquilino inquilino = new Inquilino(nombre, apellido, id);
                for (int i = 4; i < datos.length; i++) {
                    inquilino.agregarMovimiento(datos[i]);
                }
                Apartamento apartamento = new Apartamento(numeroApartamento, inquilino);
                agregarApartamento(apartamento);
            }
        }
    }

    public void guardarDatosInquilinosEnArchivo(String archivo) throws IOException {
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Apartamento apartamento : apartamentos) {
                Inquilino inquilino = apartamento.getInquilino();
                StringBuilder linea = new StringBuilder(inquilino.getNombre() + ","
                        + inquilino.getApellido() + ","
                        + inquilino.getId() + ","
                        + apartamento.getNumero());
                for (String movimiento : inquilino.getMovimientos()) {
                    linea.append(",").append(movimiento);
                }
                writer.write(linea.toString());
                writer.newLine();
            }
        }
    }
}    
