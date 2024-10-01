
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Executa {


    public static void main(String[] args) {

        //criando arraylists para controle
        ArrayList<Paciente> lista_paciente = new ArrayList<Paciente>();
        ArrayList<String> lista_vacinas = new ArrayList<String>();

        //criando objetos de datas para a atualização da dose
        Date data = new Date();
        SimpleDateFormat simpleData= new SimpleDateFormat("dd/MM/yyyy");

        //declarando objetos 
        
        Paciente paciente, paciente2;

        //Adicionando valores ao array de vacinas
        lista_vacinas.add("CoronaVac");
        lista_vacinas.add("Jansen");
        lista_vacinas.add("Astrazeneca");
        lista_vacinas.add("Pfizer");
        

        //criando variaveis de suporte
        int opt;
        

        //Mostrando mensagem de boas vindas para o usuario, e informando como funciona sistema
        JOptionPane.showMessageDialog(null,"BEM VINDO AO SISTEMAS DE VACINAS\n"+
                                            "    Esse sistema tem como objetivo\n"+
                                            "    gerenciar a aplicação de vacinas"); 

        JOptionPane.showMessageDialog(null,"O modelo foi criado com base \n"+
                                            "nas vacinas contra COVID - 19");
        
        JOptionPane.showMessageDialog(null,"O sistema funciona em forma de menu\n"+
                                            "digite o número da opção desejada.");

        //iniciando loop do while para a criação de um menu
        do{
            //Instanciando o objeto paciente a partir do construtor padrão
            paciente = new Paciente();
            

            //iniciando o menu
            opt =Integer.parseInt(JOptionPane.showInputDialog("Selecione a opção desejada\n"+
                                                "1 - Cadastro de novo usuário\n"+
                                                "2 - Acesso a lista de usuários\n"+
                                                "3 - Acesso a lista de Vacinas\n"+
                                                "9 - Sair"));

                //verificando os cases
                switch(opt){
                    //cadastro de usuario
                    case 1: 
                        //chamando o metodo para cadastrar usuário
                        paciente.cadastraPaciente();
                        //adicionando o usuário a lista
                        lista_paciente.add(paciente);
                        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
                        break;

                    case 2:
                        //acesso a lista de usuarios
                        String pacientes = "";
                        //pegando informações da lista e colocando numa String
                        for (int i = 0; i < lista_paciente.size(); i++){
                            if (lista_paciente.get(i).validar()){
                            pacientes += "\n"+lista_paciente.get(i).formatoString();
                            }
                        }
                        //mostrando a lista de usuários
                        JOptionPane.showMessageDialog(null,"Lista de Usuários"+
                                                            "\n"+pacientes);

                        
                        do{
                            opt = Integer.parseInt(JOptionPane.showInputDialog("Selecione a opção desejada"+
						                                    "\n1 - Buscar Usuario"+
						                                    "\n0 - Voltar ao menu anterior"));
						    

                            switch(opt){

                                //bucando usuário
                                case 1: 
                                    //criando objeto para copia do retorno da lista
                                    paciente2 = new Paciente();
                                    String id;
                                    id = JOptionPane.showInputDialog("Digite o CPF que deseja buscar");
                                    paciente2.setCpf(id);
                                    //vendo se o usuário está cadastrado
                                for(int j = 0; j<lista_paciente.size();j++){
                                    if(lista_paciente.get(j).getCpf().equals(id)){
                                    //"clonando" usuário para manuseio de dados

                                    paciente2.setNome(paciente.buscar(lista_paciente, id).getNome());
                                    paciente2.setCpf(paciente.buscar(lista_paciente, id).getCpf());
                                    paciente2.setIdade(paciente.buscar(lista_paciente, id).getIdade());
                                    paciente2.setSexo(paciente.buscar(lista_paciente, id).getSexo());
                                    paciente2.setVacina(paciente.buscar(lista_paciente, id).getVacina());
                                    paciente2.setDose(paciente.buscar(lista_paciente, id).getDose());
                                    paciente2.setData(paciente.buscar(lista_paciente, id).getData());

                                   
                                    do{
                                        opt = Integer.parseInt(JOptionPane.showInputDialog("Selecione a opção desejada"+
                                                                                        "\n1 - Remover usuário"+
                                                                                        "\n2 - Editar usuário"+
                                                                                        "\n3 - Cadastrar Segunda Dose\n"+
                                                                                        "\n0 - Retornar ao menu anterior"));
                                        
                                        switch(opt){
                                            //remover
                                            case 1: 
                                                //varrendo a lista para procurar o usuário a ser deletado
                                                for(int i = 0; i<lista_paciente.size();i++){
                                                    if(lista_paciente.get(i).getCpf().equals(id)){
                                                        lista_paciente.remove(lista_paciente.indexOf(paciente.buscar(lista_paciente, id)));
                                                    }
                                                }
                                                JOptionPane.showMessageDialog(null, "Usuário deletado");
                                            break;

                                            //Editar
                                            case 2:
                                            int confirm;
                                            //perguntando ao usuário o que ele deseja ou não alterar
                                            confirm =Integer.parseInt(JOptionPane.showInputDialog("Deseja alterar o nome?\n 1 - Sim     2 - Não"));
                                            if(confirm == 1){
                                                paciente2.setNome(JOptionPane.showInputDialog("Digite o nome"));
                                                JOptionPane.showMessageDialog(null,"Nome alterado");
                                            }
                                            confirm =Integer.parseInt(JOptionPane.showInputDialog("Deseja alterar o CPF?\n 1 - Sim     2 - Não"));
                                            if(confirm == 1){
                                                paciente2.setCpf(JOptionPane.showInputDialog("Digite o CPF"));
                                                JOptionPane.showMessageDialog(null,"CPF alterado");
                                            } 
                                            confirm =Integer.parseInt(JOptionPane.showInputDialog("Deseja alterar a Idade?\n 1 - Sim     2 - Não"));
                                            if(confirm == 1){
                                                paciente2.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite a idade")));
                                                JOptionPane.showMessageDialog(null,"Idade alterada");
                                            }
                                            confirm =Integer.parseInt(JOptionPane.showInputDialog("Deseja alterar o Sexo?\n 1 - Sim     2 - Não"));
                                            if(confirm == 1){
                                                paciente2.setSexo(JOptionPane.showInputDialog("Digite o Sexo").charAt(0));
                                                JOptionPane.showMessageDialog(null,"Sexo alterado");
                                            }
                                            //alterando o usuário dentro da lista
                                            lista_paciente.set(lista_paciente.indexOf(paciente.buscar(lista_paciente, id)),paciente2);
                                            break;

                                            //cadastrar segunda dose
                                            case 3:
                                            //perguntando ao usuário se ele deseja ou não cadastrar uma segunda dose
                                            confirm =Integer.parseInt(JOptionPane.showInputDialog("Cadastrar segunda dose?\n 1 - Sim     2 - Não"));
                                            if(confirm == 1){
                                                //atualizando dose e data da vacina
                                                paciente2.setDose("Segunda dose");
                                                paciente2.setData(""+simpleData.format(data));
                                                //atualizando o usuário com novas doses e datas
                                                lista_paciente.set(lista_paciente.indexOf(paciente.buscar(lista_paciente, id)),paciente2);
                                                JOptionPane.showMessageDialog(null,"Segunda dose cadastrada");
                                            }
                                            break;
                                            //retornar ao menu anterior
                                            case 0:
                                            break;

                                            default: JOptionPane.showMessageDialog(null,"Opção Inválida");
                                        }
                                        
                                    }while (opt!=0);
                                    }else{
                                    JOptionPane.showMessageDialog(null, "Usuário não cadastrado");
                                    }
                                }
                                break;
                                //retornar ao menu anterior
                                case 0:
                                break;

                                default: JOptionPane.showMessageDialog(null,"Opção Inválida");

                            }
                        }while(opt!=0);
                        break;
                    //mostrando a lista de vacinas
                    case 3:
                        String vacinas = "";
                        for (int i = 0; i < lista_vacinas.size(); i++){
                            vacinas += "\n"+lista_vacinas.get(i);
                        }
                        JOptionPane.showMessageDialog(null,"LISTA DE VACINAS"+vacinas);
                        break;
                    //fechando o lopp
                    case 9:
                        //perguntando se o uruario deseja realmente sair
                        int cond;
                        if(opt == 9){
                            cond = Integer.parseInt(JOptionPane.showInputDialog(" Deseja Sair?\n"+
                                                        "1-SIM   2-Não"));
                            if(cond == 1){
                                opt = 9;
                                JOptionPane.showMessageDialog(null, "SISTEMA DE VACINAS"+
                                                            "\nObrigado e até logo");
                            }
                        }
                        break;
                    default:JOptionPane.showMessageDialog(null,"Opção Inválida"); 
                }
        }while(opt!=9);
        //FIM!
        JOptionPane.showMessageDialog(null, "Fim do Programa!");
    }   
}
