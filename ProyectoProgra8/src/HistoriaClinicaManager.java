import java.util.ArrayList;
import java.util.List;


public class HistoriaClinicaManager {
    private List<HistoriaClinica> historiasClinicas;

    public HistoriaClinicaManager() {
        this.historiasClinicas = new ArrayList<>();
    }

    public void crearHistoriaClinica(Paciente paciente, String historialMedico, String diagnosticos, String tratamientos) {
        HistoriaClinica historiaClinica = new HistoriaClinica(paciente, historialMedico, diagnosticos, tratamientos);
        historiasClinicas.add(historiaClinica);
    }

    public HistoriaClinica consultarHistoriaClinica(String numeroIdentificacion) {
        for (HistoriaClinica historiaClinica : historiasClinicas) {
            if (historiaClinica.getPaciente().getNumeroIdentificacion().equals(numeroIdentificacion)) {
                return historiaClinica;
            }
        }
        return null;
    }

    public boolean actualizarHistoriaClinica(String numeroIdentificacion, String historialMedico, String diagnosticos, String tratamientos) {
        for (HistoriaClinica historiaClinica : historiasClinicas) {
            if (historiaClinica.getPaciente().getNumeroIdentificacion().equals(numeroIdentificacion)) {
                historiaClinica = new HistoriaClinica(historiaClinica.getPaciente(), historialMedico, diagnosticos, tratamientos);
                return true;
            }
        }
        return false;
    }

    public String generarInformeHistoriasClinicas() {
        StringBuilder informe = new StringBuilder();
        informe.append("Informe de historias clínicas:\n");
        for (HistoriaClinica historiaClinica : historiasClinicas) {
            Paciente paciente = historiaClinica.getPaciente();
            if (paciente != null) {
                informe.append("Paciente: ").append(paciente.getNombre()).append("\n");
            }
            informe.append("Historial médico: ").append(historiaClinica.getHistorialMedico()).append("\n");
            informe.append("Diagnósticos: ").append(historiaClinica.getDiagnosticos()).append("\n");
            informe.append("Tratamientos: ").append(historiaClinica.getTratamientos()).append("\n\n");
        }
        return informe.toString();
    }

    public String calcularEstadisticasHistoriasClinicas() {
        int totalHistoriasClinicas = historiasClinicas.size();
        return "Total de historias clínicas: " + totalHistoriasClinicas;
    }
}


