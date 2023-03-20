package urnaEletronica;

import java.util.Arrays;
import java.util.Scanner;

public class UrnaClass {

	public static void main(String[] args) throws InterruptedException {
        /* - Candidatos - */
        int votosCandidato1 = 0, votosCandidato2 = 0, votosCandidato3 = 0, votosCandidato4 = 0, votosNulos=0, votosBranco=0;

        Scanner ler = new Scanner(System.in);
        /* */
        int contagemVotos =0;      
        int sel=90;
        
        
        do { /* Loop inicializacao */
            menuSelecao();
            sel = ler.nextInt();

            switch(sel){ /* Menu de Selecao */
                case(1):
                    System.out.println("VOTO SELECIONADO - FABIANA");
                    votosCandidato1 ++;
                    contagemVotos ++;
                    Thread.sleep(1000);
                    break;
                case(2):
                    System.out.println("VOTO SELECIONADO - FELIPE");
                    votosCandidato2 ++;
                    contagemVotos ++;
                    Thread.sleep(1000);
                    break;
                case(3):
                    System.out.println("VOTO SELECIONADO - RAFAELA ");
                    votosCandidato3 ++;
                    contagemVotos ++;
                    Thread.sleep(1000);
                    break;
                case(4):
                    System.out.println("VOTO SELECIONADO - ROBSON ");
                    votosCandidato4 ++;
                    contagemVotos ++;
                    Thread.sleep(1000);
                    break;
                case(5):
                    System.out.println("VOTO SELECIONADO - NULO ");
                    votosNulos ++;
                    contagemVotos ++;
                    Thread.sleep(1000);
                    break;
                
                case(6):
                    System.out.println("VOTO SELECIONADO - BRANCO");
                    votosBranco ++;
                    contagemVotos ++;
                    Thread.sleep(1000);
                    break;   
                case(7):
                    System.out.println("ZERÉSIMA - SELECIONADA");
                    Thread.sleep(400);
                    if (votosCandidato1 == 0 && votosCandidato2 == 0 && votosCandidato3 == 0  &&votosCandidato4 == 0 &&  votosNulos==0 &&  votosBranco==0) {
                        System.out.print("FABIANA  :" + votosCandidato1 + " / "); 
                        System.out.println("FELIPE :" + votosCandidato2 + " / ");
                        System.out.print("RAFAELA  :" + votosCandidato3 + " / ");
                        System.out.println("ROBSON  :" + votosCandidato4 + " / ");
                        System.out.print("NULOS :" + votosCandidato1 + " / ");
                        System.out.println("BRANCO  :" + votosCandidato1 + " / ");
                        Thread.sleep(2000);
                        break;
                    } else {
                        System.out.println("Zerésima não pode ser iniciada -- Votação já iniciada!");
                        break;
                    }
                case(0):
                    System.out.println("[0] - Finalizar Votação");
                    System.out.println("Iniciando boletim de urna");
                    System.out.print(".");
                    Thread.sleep(300);
                    System.out.print(".");
                    Thread.sleep(300);
                    System.out.print(".");
                    Thread.sleep(300);
                    System.out.println("--Resultado Da Votação");
                    System.out.println("Total de Votos : " +  contagemVotos + " = 100%");

                    // Inicialização e criação das Arrays para Contagem e Ordenação Porteriormente
                    
                    String candidatos[] = new String[4];
                    candidatos[0] = "FABIANA";
                    candidatos[1] = "FELIPE";
                    candidatos[2] = "RAFAELA";
                    candidatos[3] = "ROBSON";
                    int vetorVotos[] = new int[4];
                    vetorVotos[0] = votosCandidato1;
                    vetorVotos[1] = votosCandidato2;
                    vetorVotos[2] = votosCandidato3;
                    vetorVotos[3] = votosCandidato4;

                    // Variaveis para Porcentagem
                    double porcCandidato1 = (vetorVotos[0] * 100)/ contagemVotos;
                    double porcCandidato2 = (vetorVotos[1] * 100)/ contagemVotos;
                    double porcCandidato3 = (vetorVotos[2] * 100)/ contagemVotos;
                    double porcCandidato4 = (vetorVotos[3] * 100)/ contagemVotos;
                    double porcBrancos = (votosBranco * 100)/ contagemVotos;
                    double porcNulos = (votosNulos * 100)/ contagemVotos;

                    boolean troca;
                    do{
                        troca = false;
                        for(int i = 1 ; i < vetorVotos.length ; i++){
                            for (int j = 0 ; j < i ; j++){
                                if(vetorVotos[i] > vetorVotos[j]){                      
                                    int a = vetorVotos[i]; //variavel para auxiliar a troca dos valores
                                    String b = candidatos[i];
                                    vetorVotos[i] = vetorVotos[j];
                                    candidatos[i] = candidatos[j];
                                    vetorVotos[j] = a;
                                    candidatos[j] = b;
                                    troca = true;
                                }
                            }
                        }
                    }while(troca);

                    System.out.println(candidatos[0] + " = " + vetorVotos[0] + " / "  + String.format("%.2f", porcCandidato1) +  "% " + " - Candidato Vencedor!");
                    System.out.println(candidatos[1] + " = " + vetorVotos[1] + " / " +  String.format("%.2f", porcCandidato2) +  "% ");
                    System.out.println(candidatos[2] + " = " + vetorVotos[2] + " / " +  String.format("%.2f", porcCandidato3) +  "% ");
                    System.out.println(candidatos[3] + " = " + vetorVotos[3] + " / " +  String.format("%.2f", porcCandidato4) +  "% ");
                    System.out.println("Total de votos Brancos :" + votosBranco + " / " + String.format("%.2f", porcBrancos) +  "% ");
                    System.out.println("Total de votos Nulos :" + votosNulos + " / " + String.format("%.2f", porcNulos) +  "% ");
                    Thread.sleep(2000);

                    break;      
                }
        } while(sel != 0);

    }

    private static void menuSelecao() {
        System.out.println("Menu Urna Eletronica");
        System.out.println("Digite a opcao desejada > ");
        System.out.println("");
        System.out.println("");
        System.out.println("[1] - FABIANA");
        System.out.println("[2] - FELIPE");
        System.out.println("[3] - RAFAELA ");
        System.out.println("[4] - ROBSON ");
        System.out.println("[5] - BRANCO");
        System.out.println("[6] - NULO ");
        System.out.println("[7] - Zerésima");
        System.out.println("[0] - Finalizar Votação");
    }
  }

