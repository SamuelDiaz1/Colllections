public class App {
    public static void main(String[] args) {
        LaboratorioSistemas lab = new LaboratorioSistemas();

        lab.ingresar("Juan", false);
        lab.ingresar("Ana", false);
        lab.ingresar("Carlos", true); // preferencial
        lab.ingresar("Sofía", false);

        lab.mostrarFila(); // [Carlos, Juan, Ana, Sofía]

        lab.atender(); // Atiende a Carlos
        lab.mostrarFila(); // [Juan, Ana, Sofía]
    }
}
