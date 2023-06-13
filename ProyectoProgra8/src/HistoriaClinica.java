public class HistoriaClinica {
    private Paciente paciente;
    private String historialMedico;
    private String diagnosticos;
    private String tratamientos;

    public HistoriaClinica(Paciente paciente, String historialMedico, String diagnosticos, String tratamientos) {
        this.paciente = paciente;
        this.historialMedico = historialMedico;
        this.diagnosticos = diagnosticos;
        this.tratamientos = tratamientos;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(String historialMedico) {
        this.historialMedico = historialMedico;
    }

    public String getDiagnosticos() {
        return diagnosticos;
    }

    public void setDiagnosticos(String diagnosticos) {
        this.diagnosticos = diagnosticos;
    }

    public String getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(String tratamientos) {
        this.tratamientos = tratamientos;
    }
}
