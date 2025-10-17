// Grupo: Vinicius Almeida, Italo Adriano, Gabriel Santos, Almir Junior e Thiago Aires

programa {
    inclua biblioteca Texto --> texto
    // --- VARIÁVEIS GLOBAIS ---
    // Todos os dados dos produtos ficam aqui para que todas as funções possam acessá-los.
    cadeia nomeProduto[10], nomeCadastro, email, emailCadastro, confirmacaoEmail, senha, senhaCadastro, enter, emailAdmin = "admin@email.com", senhaAdmin = "admin"
    inteiro codigoProduto[10]
    inteiro quantidadeEstoque[10]
    real preco[10]
    logico temFuncionarioCadastrado = falso
    inteiro qtd = 0 // Contador de quantos produtos estão realmente cadastrados. Começa em 0.

    funcao menu(){
        escreva("|==============================================================|\n")
        escreva("|                 MENU DE CONTROLE DE ESTOQUE                  |\n")
        escreva("|==============================================================|\n")
        escreva("| 1. Cadastrar produtos                                        |\n")
        escreva("| 2. Listar produtos cadastrados                               |\n")
        escreva("| 3. Atualizar estoque                                         |\n")
        escreva("| 4. Calcular o valor total do estoque                         |\n")
        escreva("| 5. Exibir o produto com maior e menor quantidade em estoque  |\n")
        escreva("| 6. Sair do sistema                                           |\n")
        escreva("|==============================================================|\n")
        escreva("\n")
    }

    funcao loginAdmin(){
        escreva("|==============================================================|\n")
        escreva("|                         ADMINISTRADOR                        |\n")
        escreva("|==============================================================|\n")
        escreva("Informe seu email: ")
        leia(email)
        escreva("Informe sua senha: ")
        leia(senha)
        se(email == emailAdmin e senha == senhaAdmin){
            escreva("✅ LOGIN REALIZADO COM SUCESSO!\n")
            escreva("\nPressione ENTER para continuar...")
            leia(enter) // Apenas uma pausa para o usuário ler a tela
            limpa()
        }
        senao{
            escreva("❌ ERRO: Email ou senha incorretos\n")
            escreva("\nPressione ENTER para continuar...")
            leia(enter) // Apenas uma pausa para o usuário ler a tela
            limpa()
            inicio()
            
        }
    }

    funcao fazerLoginOuCadastro(){
        inteiro opcao
        escreva("|==============================================================|\n")
        escreva("|                         US MALADIN                           |\n")
        escreva("|==============================================================|\n")
        escreva("Faça login ou realize seu cadastro para continuar\n1. REALIZAR CADASTRO\n2. FAZER LOGIN\n3. LOGAR COMO ADMINISTRADOR\n")
        escreva("OPÇÃO: ")
        leia(opcao)
        limpa()
        escolha(opcao){
            caso 1:
                cadastroFuncionario()
                pare
            caso 2:
                se(temFuncionarioCadastrado == falso){
                    escreva("❌ ERRO: Não tem funcionário cadastrado. Realize um cadastro\n")
                    escreva("\nPressione ENTER para continuar...")
                    leia(enter) // Apenas uma pausa para o usuário ler a tela
                    limpa()
                    inicio()
                }
                senao{
                    loginFuncionario()
                }
                pare
            caso 3:
                loginAdmin()
                pare
            caso contrario:
                escreva("❌ ERRO: Opção inválida.")
                pare
        }
    }

    funcao loginFuncionario(){
        escreva("|==============================================================|\n")
        escreva("|              FAÇA LOGIN PARA UTILIZAR O SISTEMA              |\n")
        escreva("|==============================================================|\n")
        faca{
            escreva("Informe seu email: ")
            leia(email)
            se(email != emailCadastro){
                escreva("❌ ERRO: Email incorreto. Tente novamente.\n")
            }
        }enquanto(email != emailCadastro)
        faca{
            escreva("Informe sua senha: ")
            leia(senha)
            se(senha != senhaCadastro){
                escreva("❌ ERRO: Senha incorreta. Tente novamente.\n")
            }
        }enquanto(senha != senhaCadastro)
        escreva("✅ LOGIN REALIZADO COM SUCESSO!\n")
        escreva("\nPressione ENTER para entrar no sistema...")
        leia(enter) // Apenas uma pausa para o usuário ler a tela
        limpa()
    }

    funcao cadastroFuncionario(){
        escreva("|==============================================================|\n")
        escreva("|                   CADASTRO DE FUNCIONÁRIO                    |\n")
        escreva("|==============================================================|\n")
        inteiro quantidade_caracteres_senha, posicao = 0, indice = 1
        logico temnumero, temespecial
        caracter caracteratual
        escreva("Informe o nome do funcionário: ")
        leia(nomeCadastro)
        faca {
          escreva("Informe a senha do funcionário: ")
          leia(senhaCadastro)

          quantidade_caracteres_senha = texto.numero_caracteres(senhaCadastro)
          inteiro indice = 0
          temnumero = falso
          temespecial = falso

          enquanto(indice < quantidade_caracteres_senha) {
              caracteratual = texto.obter_caracter(senhaCadastro, indice)

              // Verifica se tem número
              se(caracteratual >= '0' e caracteratual <= '9') {
                  temnumero = verdadeiro
              }

              // Verifica se tem caracter especial
              se(caracteratual == '!' ou caracteratual == '#' ou caracteratual == '$' ou caracteratual == '%' ou
                caracteratual == '&' ou caracteratual == '*' ou caracteratual == '(' ou caracteratual == ')' ou
                caracteratual == '+' ou caracteratual == '=' ou caracteratual == '/' ou caracteratual == '@') {
                  temespecial = verdadeiro
              }
              indice++
          }

          se(quantidade_caracteres_senha < 6) {
              escreva("Senha muito curta, tente novamente\n")
          }
          senao se(temnumero == falso) {
              escreva("Ausência de números, tente novamente\n")
          }
          senao se(temespecial == falso){
              escreva("A senha precisa ter pelo menos um caracter especial. Tente novamente\n")
          }

        } enquanto(quantidade_caracteres_senha < 6 ou temnumero == falso ou temespecial == falso)
        escreva("Informe seu email: ")
        leia(emailCadastro)
        faca{
            escreva("Repita o email: ")
            leia(confirmacaoEmail)
            se(confirmacaoEmail != emailCadastro){
                escreva("❌ ERRO: Email inválido. Tente novamente\n")
            }
        }enquanto(confirmacaoEmail != emailCadastro)
        escreva("✅ CADASTRO REALIZADO COM SUCESSO!")
        temFuncionarioCadastrado = verdadeiro
        escreva("\nPressione ENTER para realizar login...")
        leia(enter) // Apenas uma pausa para o usuário ler a tela
        limpa()
        loginFuncionario()
    }

    funcao cadastrarProduto(){
        inteiro novosProdutos, i

        escreva("----------  📦 Cadastro de Produtos 📦 ------------ \n")
        escreva("\n")
        escreva("Você já tem ", qtd, " produtos cadastrados.\n")
        escreva("Quantos novos produtos você deseja cadastrar? (Max ", 10 - qtd, ")\n")
        leia(novosProdutos)

        se(novosProdutos > 0 e (qtd + novosProdutos) <= 10){
            para (i = qtd; i < qtd + novosProdutos; i++){
                escreva("\nDigite o nome do ", i + 1, "º produto: ")
                leia(nomeProduto[i])
                escreva("Digite o código do produto: ")
                leia(codigoProduto[i])
                escreva("Digite a quantidade em estoque: ")
                leia(quantidadeEstoque[i])
                escreva("Digite o preço unitário do produto: ")
                leia(preco[i])
                escreva("--------------------------------------\n ")
            }
            qtd = qtd + novosProdutos // Atualiza o contador total de produtos
            escreva("\n✅ Produtos cadastrados com sucesso!\n")
        } senao {
            escreva("\n❌ Número inválido ou limite de estoque excedido!\n")
        }
    }

    funcao listarProdutosCadastrados(){
        escreva("------------------📝 Produtos Cadastrados 📝 -----------------\n")

        se (qtd == 0) {
            escreva("\nNenhum produto cadastrado ainda.\n")
        } senao {
            para (inteiro i = 0; i < qtd; i++) {
                escreva("\n----------------------------------\n")
                escreva("Produto ", i + 1, "\n")
                escreva("Nome: " , nomeProduto[i], "\n")
                escreva("Código: ", codigoProduto[i], "\n")
                escreva("Quantidade em Estoque: ", quantidadeEstoque[i], "\n")
                escreva("Preço Unitário: R$ ", preco[i], "\n")
            }
             escreva("----------------------------------\n")
        }
    }

    funcao atualizarEstoque(){
        inteiro codigoBusca, indiceEncontrado = -1, i
        inteiro opcao, quantidadeOperacao

        escreva("---------- 🔃 Atualização de Estoque 🔃 -----------\n")
        se (qtd == 0) {
            escreva("\nNenhum produto cadastrado para atualizar.\n")
            retorne
        }
        
        escreva("Digite o CÓDIGO do produto que deseja atualizar: ")
        leia(codigoBusca)

        // Procura o produto no vetor
        para(i = 0; i < qtd; i++){
            se(codigoProduto[i] == codigoBusca){
                indiceEncontrado = i
                pare
            }
        }

        // Verifica se encontrou
        se(indiceEncontrado != -1){
            escreva("\nProduto encontrado: ", nomeProduto[indiceEncontrado], "\n")
            escreva("Estoque atual: ", quantidadeEstoque[indiceEncontrado], "\n")
            
            escreva("\nO que você deseja fazer?\n1. Adicionar ao estoque\n2. Remover do estoque\n")
            escreva("OPÇÃO: ")
            leia(opcao)

            escolha(opcao){
                caso 1:
                    escreva("Digite a quantidade para ADICIONAR: ")
                    leia(quantidadeOperacao)
                    se(quantidadeOperacao > 0){
                        quantidadeEstoque[indiceEncontrado] = quantidadeEstoque[indiceEncontrado] + quantidadeOperacao
                        escreva("✅ Estoque atualizado com sucesso! Novo total: ", quantidadeEstoque[indiceEncontrado], "\n")
                    } senao {
                        escreva("❌ Quantidade inválida!\n")
                    }
                    pare
                caso 2:
                    escreva("Digite a quantidade para REMOVER: ")
                    leia(quantidadeOperacao)
                    se(quantidadeOperacao > 0 e quantidadeOperacao <= quantidadeEstoque[indiceEncontrado]){
                        quantidadeEstoque[indiceEncontrado] = quantidadeEstoque[indiceEncontrado] - quantidadeOperacao
                        escreva("✅ Estoque atualizado com sucesso! Novo total: ", quantidadeEstoque[indiceEncontrado], "\n")
                    } senao {
                        escreva("❌ Quantidade inválida ou maior que o estoque atual!\n")
                    }
                    pare
                caso contrario:
                    escreva("❌ OPÇÃO INVÁLIDA!\n")
            }
        } senao {
            escreva("\n❌ Produto com o código ", codigoBusca, " não foi encontrado!\n")
        }
    }

    // --- SUA NOVA FUNÇÃO INTEGRADA ---
    funcao calcularValorTotalEstoque() {
        real valorTotal = 0.0
        real valorProduto = 0.0
        
        escreva("========================================\n")
        escreva("      VALOR TOTAL DO ESTOQUE\n")
        escreva("========================================\n\n")

        se (qtd == 0) {
            escreva("Nenhum produto cadastrado no sistema!\n\n")
        }
        senao {
            escreva("DETALHAMENTO POR PRODUTO:\n")
            escreva("----------------------------------------\n") 
            
            para (inteiro i = 0; i < qtd; i++) {
                valorProduto = quantidadeEstoque[i] * preco[i]
                valorTotal = valorTotal + valorProduto
                
                escreva("Produto: ", nomeProduto[i], "\n")
                escreva("Código: ", codigoProduto[i], "\n")
                escreva("Quantidade: ", quantidadeEstoque[i], " unidades\n")
                escreva("Preço unitário: R$ ", preco[i], "\n")
                escreva("Valor em estoque: R$ ", valorProduto, "\n")
                escreva("----------------------------------------\n")
            }
            
            escreva("\n")
            escreva("========================================\n")
            escreva("VALOR TOTAL DO ESTOQUE: R$ ", valorTotal, "\n")
            escreva("========================================\n\n")
        }
    }

    funcao exibirProdutoComMaioreMenorQtdEstoque(){
        escreva("\n---------- 📊 Análise de Estoque 📊 ----------\n")
        
        se(qtd > 0){
            cadeia produtoMaiorEstoque = nomeProduto[0]
            inteiro maiorQuantidade = quantidadeEstoque[0]

            cadeia produtoMenorEstoque = nomeProduto[0]
            inteiro menorQuantidade = quantidadeEstoque[0]

            para(inteiro i = 1; i < qtd; i++){
                se(quantidadeEstoque[i] > maiorQuantidade){
                    maiorQuantidade = quantidadeEstoque[i]
                    produtoMaiorEstoque = nomeProduto[i]
                }
                se(quantidadeEstoque[i] < menorQuantidade){
                    menorQuantidade = quantidadeEstoque[i]
                    produtoMenorEstoque = nomeProduto[i]        
                }
            }
            
            escreva("\nProduto com MAIOR estoque:\n")
            escreva("PRODUTO: " + produtoMaiorEstoque + "\n")
            escreva("QUANTIDADE: " + maiorQuantidade + "\n")
            
            escreva("\nProduto com MENOR estoque:\n")
            escreva("PRODUTO: " + produtoMenorEstoque + "\n")
            escreva("QUANTIDADE: " + menorQuantidade + "\n")

        } senao {
            escreva("\nNENHUM PRODUTO FOI CADASTRADO PARA ANÁLISE.\n")
        }
    }

    funcao inicio() {
        inteiro opcaoMenu
        fazerLoginOuCadastro()
        se(email == emailAdmin e senha == senhaAdmin){
            escreva("Bem vindo(a) ao sistema, Administrador!\n")
        }
        senao{
            escreva("Bem vindo(a) ao sistema, ",nomeCadastro,"\n")
        }
        faca{
            menu()
            escreva("OPÇÃO: ")
            leia(opcaoMenu)
            
            limpa() // Limpa a tela para uma melhor visualização

            escolha(opcaoMenu){
                caso 1:
                    cadastrarProduto()
                    pare
                caso 2:
                    listarProdutosCadastrados()
                    pare
                caso 3:
                    atualizarEstoque()
                    pare
                caso 4:
                    calcularValorTotalEstoque()
                    pare
                caso 5:
                    exibirProdutoComMaioreMenorQtdEstoque()
                    pare
                caso 6:
                    escreva("Saindo do sistema... Até logo!\n")
                    pare
                caso contrario:
                    escreva("❌ OPÇÃO INVÁLIDA! Tente novamente.\n")
            }
            
            se (opcaoMenu != 6) {
                escreva("\nPressione ENTER para voltar ao menu...")
                leia(enter) // Apenas uma pausa para o usuário ler a tela
                limpa()
            }

        }enquanto(opcaoMenu != 6)
    }
}