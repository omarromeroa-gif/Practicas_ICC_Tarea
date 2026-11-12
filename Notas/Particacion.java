public class Pokemon {
    private String nombre;
    private int hp;

    public Pokemon(String nombre, int hp) {
        this.nombre = nombre;
        // (A) El constructor guarda la vida que llega como parámetro.
        this.hp = hp; 
    }

    public String getNombre() {
        return nombre;
    }

    // (B) Falta el getter de hp.
    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        // (C) setHp solo acepta 0 o más; si llega negativo imprime "HP invalido".
        if (hp >= 0) {
            this.hp = hp;
        } else {
            System.out.println("HP invalido");
        }
    }

    public void recibirAtaque(int danio) {
        // (D) recibirAtaque le resta el daño a la vida.
        this.hp -= danio;
    }
}
public class Batalla {
    public static void main(String[] args) {
        // Se crea el objeto Pikachu con 100 de vida inicial
        Pokemon p = new Pokemon("Pikachu", 100);
        
        // Ciclo de 3 turnos recibiendo 30 de daño por turno
        for (int i = 1; i <= 3; i++) {
            p.recibirAtaque(30);
            System.out.println("Turno " + i + ": HP = " + p.getHp());
        }
        
        // Intento inválido de asignar vida negativa
        p.setHp(-5);
        
        // Asignación válida de vida
        p.setHp(80);
        
        // Impresión del resultado final
        System.out.println(p.getNombre() + " termina con " + p.getHp());
    }
}