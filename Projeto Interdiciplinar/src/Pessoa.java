public class Pessoa implements Seguranca {
    //atributos
    private String nome;
    private String cpf;
    private int idade;
    private char sexo;

    //contrutores
    public Pessoa(){

    }
    public Pessoa(String nome, String cpf, int idade, char sexo){
        this.nome = nome;
        this.cpf = cpf;
        this.idade =  idade;
        this.sexo = sexo;
    }
    //metodos de acesso
    public String getCpf() {
        return cpf;
    }
    public int getIdade() {
        return idade;
    }
    public String getNome() {
        return nome;
    }
    public char getSexo() {
        return sexo;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    //metodos de verificação

    //verificando CPF
    public boolean verificaCpf(){
        if(getCpf() ==""){
            return true;
        }
        return false;
    }
    //verificando nome
    public boolean verificaNome(){
        if(getNome() ==""){
            return true;
        }
        return false;
    }
    //metodo equals
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Paciente other = (Paciente) obj;
        if (cpf != other.getCpf())
            return false;
        return true;
    }
    //metodo da interface
    public boolean validar() {
        return !(getNome().equals("")||getCpf().equals(""));                   
    }
    
    
    
}
