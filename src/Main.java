// criar um CRUD para cadastrar,
// exibir,
// atualizar
// e excluir alunos.
// Deve conter nome e idade.
// Sinalizar para sair

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> listaNomes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (true) {
            System.out.println("\n--- MENU DE CADASTRO ---");
            System.out.println("1 - Cadastrar nome");
            System.out.println("2 - Listar nomes cadastrados");
            System.out.println("3 - Atualizar um nome existente");
            System.out.println("4 - Remover um nome");
            System.out.println("5 - Sair do sistema");
            System.out.print("Escolha uma opção: ");


            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Por favor, digite apenas números.");
                scanner.nextLine(); // Limpa a entrada inválida
                continue; // Volta para o início do loop
            }

            switch (opcao) {
                case 1: // Cadastrar
                    System.out.print("Digite o nome para cadastrar: ");
                    String novoNome = scanner.nextLine();
                    listaNomes.add(novoNome);
                    System.out.println("Nome cadastrado com sucesso!");
                    break;

                case 2: // Listar
                    if (listaNomes.isEmpty()) {
                        System.out.println("A lista está vazia.");
                    } else {
                        System.out.println("\n--- Lista de Nomes ---");
                        for (int i = 0; i < listaNomes.size(); i++) {
                            System.out.println("Índice " + i + ": " + listaNomes.get(i));
                        }
                    }
                    break;

                case 3: // Atualizar
                    if (listaNomes.isEmpty()) {
                        System.out.println("Não há nomes para atualizar.");
                    } else {
                        System.out.print("Digite o índice do nome que deseja atualizar: ");
                        int indiceAtualizar = scanner.nextInt();
                        scanner.nextLine();

                        if (indiceAtualizar >= 0 && indiceAtualizar < listaNomes.size()) {
                            System.out.print("Digite o novo nome: ");
                            String nomeAtualizado = scanner.nextLine();
                            listaNomes.set(indiceAtualizar, nomeAtualizado);
                            System.out.println("Nome atualizado com sucesso!");
                        } else {
                            System.out.println("Índice inválido!");
                        }
                    }
                    break;

                case 4: // Remover
                    if (listaNomes.isEmpty()) {
                        System.out.println("Não há nomes para remover.");
                    } else {
                        System.out.print("Digite o índice do nome que deseja remover: ");
                        int indiceRemover = scanner.nextInt();
                        scanner.nextLine();

                        if (indiceRemover >= 0 && indiceRemover < listaNomes.size()) {
                            String nomeRemovido = listaNomes.remove(indiceRemover);
                            System.out.println("O nome '" + nomeRemovido + "' foi removido.");
                        } else {
                            System.out.println("Índice inválido!");
                        }
                    }
                    break;

                case 5: // Sair
                    System.out.println("Encerrando o sistema...");
                    scanner.close();
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        }
    }
}
