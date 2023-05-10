package Aplicativos;


import java.io.IOException;
import java.util.Scanner;
import Classes.Aeronave;
import Classes.Pessoa;
import Classes.Piloto;

public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        final int MAX_ELEMENTOS = 10;
        int opcao, qtdCadastrados = 0;
        Pessoa[] pilotos = new Pessoa[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);
        String CPF="";

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Cadastrar aeronave");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {
                // Se não tem mais espaço no vetor, saio do cadastro
                Piloto pilot=new Piloto();
                if (qtdCadastrados == MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                }
                    else{
                        System.out.println("Por favor entre com o nome do Piloto");
                        pilot.setNome(in.nextLine());
                        System.out.println("Por favor entre com o CPF do Piloto");
                        CPF=in.nextLine();
                        if(CPF.length()==11){
                        pilot.setCPF(CPF);
                        System.out.println("Por favor entre com o Breve do Piloto");
                        pilot.setBreve(in.nextLine());
                        pilotos[qtdCadastrados]=pilot;
                        qtdCadastrados++;
                        System.out.println("\nPiloto cadastrado com sucesso.");
                        }
                        else{
                            System.out.println("O número de digitos está incorreto!");
                        }
                    
                        
                    }
                
                voltarMenu(in);
            } else if (opcao == 2) {
                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há pilotos cadastrados para exibir.");
                    voltarMenu(in);
                }
                    else{
                        for (Pessoa pilot : pilotos) {
                            if(pilot != null){
                                System.out.println(pilot);
                            }
                        }
                    }

                voltarMenu(in);
            } else if (opcao == 3) {
                Boolean achou = false;
                    System.out.println("Informe o CPF do Piloto:");
                    CPF = in.nextLine();
                    for (Pessoa pilot : pilotos){
                        if(pilot != null && CPF.equals(pilot.getCPF())){
                            System.out.println(pilot);
                            achou = true;
                        }
                    }
                    if(!achou){
                        System.out.println("CPF não encontrado.");
                    }
                    voltarMenu(in);

            } else if (opcao == 4) {
                 // Se não tem ninguém cadastrado no vetor, caio fora
                 if (qtdCadastrados == 0) {
                    System.out.println("\nSem pilotos, não há como cadastrar uma aeronave");
                    voltarMenu(in);
                }
                else{
                    System.out.println("Informe o CPF do Piloto:");
                    CPF = in.nextLine();
                    for (Pessoa pilot : pilotos){
                        if(pilot != null && CPF.equals(pilot.getCPF())){
                            System.out.println(pilot);
                            System.out.println("Vamos cadastrar uma aeronve para o piloto?");
                            Aeronave aero=new Aeronave();
                            System.out.println("Por favor digite o modelo da aeronave: ");
                            aero.setModelo(in.nextLine());
                            System.out.println("Por favor digite a serie da aeronave: ");
                            aero.setNumeroSerie(in.nextLine());
                            pilot.setAero(aero);
                             
                            System.out.println("\nAeronave cadastrada com sucesso."); 
                        System.out.println(aero);
                                         
                }


                //Solicite ao usuário o piloto
                //Crie a aeronave vinculando-a ao piloto
                
                
                //Exiba os dados da aeronave
                voltarMenu(in);
            }
        }
    }
            else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}