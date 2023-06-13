import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PacienteManager {
    private List<Paciente> pacientes;

    public PacienteManager() {
        pacientes = new ArrayList<>();
    }

    public void registrarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void modificarPaciente(String numeroIdentificacion, Paciente pacienteModificado) {
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getNumeroIdentificacion().equals(numeroIdentificacion)) {
                pacientes.set(i, pacienteModificado);
                break;
            }
        }
    }

    public Paciente buscarPacientePorNombre(String nombre) {
        for (Paciente paciente : pacientes) {
            if (paciente.getNombre().equalsIgnoreCase(nombre)) {
                return paciente;
            }
        }
        return null; // Si no se encuentra el paciente
    }

    public List<Paciente> buscarPacientesPorNombre(String nombre) {
        return pacientes.stream()
                .filter(paciente -> paciente.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Paciente> ordenarPacientesPorNombre() {
        return pacientes.stream()
                .sorted(Comparator.comparing(Paciente::getNombre))
                .collect(Collectors.toList());
    }

    public List<Paciente> ordenarPacientesPorFechaNacimiento() {
        return pacientes.stream()
                .sorted(Comparator.comparing(Paciente::getFechaNacimiento))
                .collect(Collectors.toList());
    }

    public void generarInformePacientes() {
        // Implementar la generación de informes y estadísticas de pacientes atendidos
    }
}
