import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Interfaz extends JFrame {
    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JTextField textIngresonombre;
    private JTextField textNumIdentificacion;
    private JTextField textFechaNacimiento;
    private JTextArea textAmostrar;
    private JButton agregarButton;
    private JButton quemarDatosButton;
    private JButton limpiarButton;
    private JTextField textModifNombre;
    private JButton buscarModifButton;
    private JTextField textModifDireccion;
    private JTextField textModifCorreo;
    private JButton modificarButton;
    private JTextArea textAmodif;
    private JComboBox comboBox1;
    private JButton mostrarButton;
    private JButton buscarButton1;
    private JTextField textField8;
    private JTextArea textArea3;
    private JTextField textDireccion;
    private JTextField textGenero;
    private JTextField textCorreo;
    private JButton limpiarButton1;
    private PacienteManager pacienteManager;

    public Interfaz() {
        pacienteManager = new PacienteManager();
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textIngresonombre.getText();
                String numeroIdentificacion = textNumIdentificacion.getText();
                LocalDate fechaNacimiento = LocalDate.parse(textFechaNacimiento.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                String direccion = textDireccion.getText();
                boolean genero = Boolean.parseBoolean(textGenero.getText());
                String correo = textCorreo.getText();

                // Determinar el valor del género a mostrar
                String generoTexto = genero ? "Femenino" : "Masculino";

                // Crear un nuevo objeto Paciente con los datos ingresados
                Paciente paciente = new Paciente(nombre, numeroIdentificacion, fechaNacimiento, direccion, correo, genero);
                pacienteManager.registrarPaciente(paciente);

                textAmostrar.append("Paciente ingresado:\n"
                        + "Nombre: " + paciente.getNombre() + "\n"
                        + "Número de Identificación: " + paciente.getNumeroIdentificacion() + "\n"
                        + "Fecha de Nacimiento: " + paciente.getFechaNacimiento() + "\n"
                        + "Dirección: " + paciente.getDireccion() + "\n"
                        + "Correo: " + paciente.getCorreo() + "\n"
                        + "Género: " + generoTexto + "\n\n");
            }
        });

        quemarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Paciente paciente1 = new Paciente("Maria", "1763023231", LocalDate.of(1988, 4, 2), "La pradera", "maria@gmail.com", true);
                Paciente paciente2 = new Paciente("Luis", "1750731263", LocalDate.of(2014, 5, 3), "El bosque", "luis@gmail.com", false);
                Paciente paciente3 = new Paciente("Juan", "1800216327", LocalDate.of(2002, 1, 21), "La Armenia", "juan@gmail.com", false);
                Paciente paciente4 = new Paciente("Melany", "1416278926", LocalDate.of(1999, 6, 25), "Chillogallo", "melany@gmail.com", true);
                Paciente paciente5 = new Paciente("Roberto", "1286342722", LocalDate.of(2000, 4, 15), "Atahualpa", "roberto@gmail.com", false);

                pacienteManager.registrarPaciente(paciente1);
                pacienteManager.registrarPaciente(paciente2);
                pacienteManager.registrarPaciente(paciente3);
                pacienteManager.registrarPaciente(paciente4);
                pacienteManager.registrarPaciente(paciente5);

                textAmostrar.append("Datos quemados agregados:\n"
                        + paciente1.toString() + "\n"
                        + paciente2.toString() + "\n"
                        + paciente3.toString() + "\n"
                        + paciente4.toString() + "\n"
                        + paciente5.toString() + "\n");
            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Limpiar los campos de texto y el área de texto
                textIngresonombre.setText("");
                textNumIdentificacion.setText("");
                textFechaNacimiento.setText("");
                textDireccion.setText("");
                textGenero.setText("");
                textCorreo.setText("");
                textAmostrar.setText("");
            }
        });

        buscarModifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textModifNombre.getText();
                Paciente paciente = pacienteManager.buscarPacientePorNombre(nombre);

                if (paciente != null) {
                    textModifDireccion.setText(paciente.getDireccion());
                    textModifCorreo.setText(paciente.getCorreo());
                    textModifDireccion.setEditable(true);
                    textModifCorreo.setEditable(true);
                } else {
                    textAmodif.append("Paciente no encontrado.\n");
                }
            }
        });

        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textModifNombre.getText();
                Paciente paciente = pacienteManager.buscarPacientePorNombre(nombre);

                if (paciente != null) {
                    String nuevaDireccion = textModifDireccion.getText();
                    String nuevoCorreo = textModifCorreo.getText();
                    paciente.setDireccion(nuevaDireccion);
                    paciente.setCorreo(nuevoCorreo);
                    textAmodif.append("Paciente modificado:\n"
                            + "Nombre: " + paciente.getNombre() + "\n"
                            + "Dirección modificada: " + paciente.getDireccion() + "\n"
                            + "Correo modificado: " + paciente.getCorreo() + "\n\n");
                    // Limpiar los campos de texto y deshabilitar la edición
                    textModifNombre.setText("");
                    textModifDireccion.setText("");
                    textModifCorreo.setText("");
                    textModifDireccion.setEditable(false);
                    textModifCorreo.setEditable(false);
                } else {
                    textAmodif.append("Paciente no encontrado.\n");
                }
            }
        });
        limpiarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textModifNombre.setText("");
                textModifDireccion.setText("");
                textModifCorreo.setText("");
                textAmodif.setText("");

            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}

