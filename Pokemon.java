public class Pokemon {
    String name; //nombre
    int pokedexNumber; //El número de entrada del Pokémon en la Pokedex Nacional
    String type1; // Primary type
    String type2; //Secondary type
    String classi; //Clasificación
    double altura; //Altura promedio en m
    double peso; //Peso promedio en kg
    String habilidades; //Habilidades del pokemon
    int generation; //
    boolean legenStatus; //Si es legendario o no
    

    public Pokemon() {
    }

    public Pokemon(String name, int pokedexNumber, String type1, String type2, String classi, double altura,
            double peso, String habilidades, int generation, boolean legenStatus) {
        this.name = name;
        this.pokedexNumber = pokedexNumber;
        this.type1 = type1;
        this.type2 = type2;
        this.classi = classi;
        this.altura = altura;
        this.peso = peso;
        this.habilidades = habilidades;
        this.generation = generation;
        this.legenStatus = legenStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPokedexNumber() {
        return pokedexNumber;
    }

    public void setPokedexNumber(int pokedexNumber) {
        this.pokedexNumber = pokedexNumber;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getClassi() {
        return classi;
    }

    public void setClassi(String classi) {
        this.classi = classi;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public boolean isLegenStatus() {
        return legenStatus;
    }

    public void setLegenStatus(boolean legenStatus) {
        this.legenStatus = legenStatus;
    }

    @Override
    public String toString() {
        return "Pokemon [name=" + name + ", pokedexNumber=" + pokedexNumber + ", type1=" + type1 + ", type2=" + type2
                + ", classi=" + classi + ", altura=" + altura + ", peso=" + peso + ", habilidades=" + habilidades
                + ", generation=" + generation + ", legenStatus=" + legenStatus + "]";
    }

}
