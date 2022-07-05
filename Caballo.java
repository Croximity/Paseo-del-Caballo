public class Caballo {

    private int[][] tablero = new int[8][8]; // tablero en el que se llevara el registro del recorrido del caballo

    public Caballo() {
    }

    public boolean MoviValido(int i, int j) {
        boolean Resultado = false;
        if (i >= 0 && j >= 0 && i < tablero[0].length && j < tablero[0].length) {
            if (tablero[i][j] == 0) {
                Resultado = true; // metodo que valida la posición a la
            } // que intenta moverse el caballo
        }
        return Resultado;
    }

    public boolean recorre(int i, int j, int cont) {
        boolean Resultado = false;
        tablero[i][j] = cont; // metodo que lleva a
        if (cont == 64) { // cabo el recorrido
            Resultado = true; // del caballo por el
        } // tablero y revisando
        if (MoviValido(i - 1, j + 2)) { // la posición a la
            if (recorre(i - 1, j + 2, cont + 1)) { // cual es mas factible
                Resultado = true; // moverse revisando
            } // las posibles posiciones
        } // a la cuales puede
        if (MoviValido(i - 2, j + 1)) { // moverse el caballo
            if (recorre(i - 2, j + 1, cont + 1)) { // de la siguiente manera
                Resultado = true; // 3 2
            } // 4 1
        } // X
        if (MoviValido(i - 2, j - 1)) { // 5 8
            if (recorre(i - 2, j - 1, cont + 1)) { // 6 7
                Resultado = true;
            }
        }
        if (MoviValido(i - 1, j - 2)) {
            if (recorre(i - 1, j - 2, cont + 1)) {
                Resultado = true;
            }
        }
        if (MoviValido(i + 1, j - 2)) {
            if (recorre(i + 1, j - 2, cont + 1)) {
                Resultado = true;
            }
        }
        if (MoviValido(i + 2, j - 1)) {
            if (recorre(i + 2, j - 1, cont + 1)) {
                Resultado = true;
            }
        }
        if (MoviValido(i + 2, j + 1)) {
            if (recorre(i + 2, j + 1, cont + 1)) {
                Resultado = true;
            }
        }
        if (MoviValido(i + 1, j + 2)) {
            if (recorre(i + 1, j + 2, cont + 1)) {
                Resultado = true;
            }
        }
        if (!Resultado) {
            tablero[i][j] = 0;
        }
        return Resultado;
    }

    public void ImprimirResul() {
        for (int i = 0; i < tablero.length; i++) { // metodo que imprime
            for (int j = 0; j < tablero[0].length; j++) { // el tablero para
                System.out.print(tablero[i][j] + "\t"); // mostrar el recorrido
                if (j == 7) { // que llevo a cabo el
                    System.out.println("\n"); // caballo una vez que
                } // este a finalizado su
            } // recorrido por el tablero
        }
    }

}