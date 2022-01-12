import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import javax.swing.JOptionPane;

public class Paciente extends Pessoa{
    //atributos
    private String vacina;
    private String dose;
    private String data;
    
    //construtor
    public Paciente(){
    }
    public Paciente(String vacina, String dose, String data, String nome, String cpf, int idade, char sexo){
        super(nome, cpf, idade, sexo);
        this.vacina = vacina;
        this.dose = dose;
        this.data = data;
    }

    //metodos de acesso
    public String getData() {
        return data;
    }
    public String getDose() {
        return dose;
    }
    public String getVacina() {
        return vacina;
    }
    public void setData(String data) {
        this.data = data;
    }
    public void setDose(String dose) {
        this.dose = dose;
    }
    public void setVacina(String vacina) {
        this.vacina = vacina;
    }
    
    //metodo de string, retorno uma string com as informaçõs da pessoa
    public String formatoString() {
        String nome, cpf, idade, sexo, vacina, dose, data;
        nome ="\nNOME: "+ getNome();
        cpf = "\nCPF: "+ getCpf();
        idade = "\nIDADE: "+getIdade();
        sexo = "\nSEXO: "+ getSexo();
        vacina ="\nVACINA: " + getVacina();
        dose ="\nDOSE: " +  getDose();
        data ="\nDATA: "+ getData();

        return nome + cpf + idade + sexo + vacina + dose + data;
    }
    //metodo de cadastro
    public void cadastraPaciente(){
        //criando objeto para registro de data automaticamente
        Date dt = new Date();
        SimpleDateFormat sd= new SimpleDateFormat("dd/MM/yyyy");
        //usando variaveis de apoio para criação de um menu
        int opcao, loop;
        loop = 1;
        //cadatrando o usuario
        setNome(JOptionPane.showInputDialog("Digite o nome"));
        if(verificaNome() == true){
            while(loop == 1){
                setNome(JOptionPane.showInputDialog("NOME é um campo obrigatório\n"+
                                                    "Por favor digite o nome"));
                if(verificaNome()==false){
                    loop = 2;
                }
            }
        }
        loop = 1;
        setCpf(JOptionPane.showInputDialog("Digite o CPF"));
        if(verificaCpf() == true){
            while(loop == 1){
                setCpf(JOptionPane.showInputDialog("CPF é um campo obrigatório\n"+
                                            "Por favor digite o CPF"));
                if(verificaCpf()==false){
                    loop = 2;
                }
            }
        }
        
        setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite a idade")));
        setSexo(JOptionPane.showInputDialog("Digite o sexo").charAt(0));
        do{
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Ecolha a vacina "+
                                                                "\n1 - CoronaVac    2 - Pfizer"+
                                                                "\n3 - Astrazeneca   4 - Jansen"));
            if(opcao == 1 ){
                setVacina("CoronaVac");
                loop = 2;
            }
            else if(opcao == 2 ){
                setVacina("Pfizer");
                loop = 2;
            }
            else if(opcao == 3 ){
                setVacina("Astrazeneca");
                loop = 2;
            }
            else if(opcao == 4 ){
                setVacina("Jansen");
                loop = 2;
            }
            else if(opcao != 1 || opcao != 2 || opcao != 3 || opcao != 4)
            JOptionPane.showMessageDialog(null,"Opção Inválida");
            }while(loop == 1);
    
            setDose("Primeira");
            setData(""+sd.format(dt));
    }
    //metodo buscar
    public Paciente buscar(ArrayList<Paciente> lista, String id){
        Paciente p = new Paciente();
        for(int i = 0; i<lista.size();i++){
            if(lista.get(i).getCpf().equals(id)){
                p.setNome(lista.get(i).getNome());
                p.setCpf(lista.get(i).getCpf());
                p.setIdade(lista.get(i).getIdade());
                p.setSexo(lista.get(i).getSexo());
                p.setVacina(lista.get(i).getVacina());
                p.setDose(lista.get(i).getDose());
                p.setData(lista.get(i).getData());
            }
        }
        return p;
    }
    

}