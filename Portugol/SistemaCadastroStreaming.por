programa {
  inclua biblioteca Texto --> texto
  funcao inicio() {
    inteiro jatemcadastro, quantidade_caracteres_email, quantidade_caracteres_cpf,quantidade_caracteres_senha,ano_atual, anonascimento, dianascimento, mesnascimento, tipoassinatura
    cadeia email, emailcadastro, nomecadastro, cpf, senha, senhacadastro, nomeassinatura
    logico temarroba, temnumero, temespecial
    caracter caracteratual
    ano_atual = 2025
    // LOOP PRINCIPAL
    enquanto(jatemcadastro != 0) {
      escreva("==========DevFlix==========\n")
      escreva("Você já tem cadastro? (1 = SIM, 2 = NÃO, 0 = SAIR)\n")
      escreva("1- Realizar login\n")
      escreva("2- Realizar Cadastro\n")
      escreva("0- Sair\n")
      leia(jatemcadastro)

      // SAIR
      se(jatemcadastro == 0){
        escreva("Saindo do sistema...\n")
        pare
      }

      // CADASTRO
      se(jatemcadastro == 2){
        // Nome
        escreva("==CADASTRO==\n")
        escreva("Insira seu nome completo\n")
        leia(nomecadastro)

        // Email
        faca{
          escreva("Insira seu email\n")
          leia(emailcadastro)
          inteiro indice = 0
          quantidade_caracteres_email = texto.numero_caracteres(emailcadastro)
          temarroba = falso
          enquanto(indice < quantidade_caracteres_email){
            caracteratual = texto.obter_caracter(emailcadastro, indice)
            se(caracteratual == '@'){
              temarroba = verdadeiro
            }
            indice++
          }
          se(temarroba == falso){
            escreva("Email inválido, precisa ter um @. Tente novamente\n")
          }
        } enquanto(temarroba == falso)

        // CPF
        faca{
          escreva("Insira seu CPF\n")
          leia(cpf)
          quantidade_caracteres_cpf = texto.numero_caracteres(cpf)
          se(quantidade_caracteres_cpf != 11){
            escreva("CPF Inválido, tente novamente.\n")
          }
        } enquanto(quantidade_caracteres_cpf != 11)


        // Data de Nascimento
        escreva("DATA DE NASCIMENTO\n")
        faca{
          escreva("Insira o dia que você nasceu\n")
          leia(dianascimento)
          se(dianascimento > 31 ou dianascimento < 1){
            escreva("DIA INVÁLIDO. Tente novamente\n")
          }
        }enquanto(dianascimento > 31 ou dianascimento < 1)
        faca{
          escreva("Insira o mes que você nasceu\n")
          leia(mesnascimento)
          se(mesnascimento > 12 ou mesnascimento < 1){
            escreva("MES INVÁLIDO. Tente novamente\n")
          }
        }enquanto(mesnascimento > 12 ou mesnascimento < 1)
        faca{
          escreva("Insira o ano que você nasceu\n")
          leia(anonascimento)
          se(ano_atual - anonascimento < 18){
            escreva("Você é menor de idade. Não é possível acessar o sistema.\n")
          }
        }enquanto(ano_atual - anonascimento < 18)

        escreva("Data de nascimento: ",dianascimento,"/",mesnascimento,"/",anonascimento,"\n")
        // Senha
        faca {
          escreva("Informe sua senha\n")
          leia(senhacadastro)

          quantidade_caracteres_senha = texto.numero_caracteres(senhacadastro)
          inteiro indice = 0
          temnumero = falso
          temespecial = falso

          enquanto(indice < quantidade_caracteres_senha) {
              caracteratual = texto.obter_caracter(senhacadastro, indice)

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
        escreva("Qual é o tipo de assinatura que você deseja? (1 = ANUAL, 2 = MENSAL)\n")
        escreva("ANUAL - R$ 199,99\n")
        escreva("MENSAL - R$ 19,99\n")
        leia(tipoassinatura)
        se(tipoassinatura == 1){
          escreva("Você escolheu a assinatura ANUAL, que é no valor de R$ 199,99\n")
          nomeassinatura = "Assinatura Anual"
        }
        se(tipoassinatura == 2){
          escreva("Você escolheu a assinatura MENSAL, que é no valor de R$ 19,99\n")
          nomeassinatura = "Assinatura Mensal"
        }
        escreva("Cadastro concluído com sucesso!\n")
        // Depois do cadastro, volta automaticamente pro menu principal
      }

      // LOGIN
      se(jatemcadastro == 1){
        escreva("==LOGIN==\n")
        faca{
          escreva("Digite seu email: ")
          leia(email)
          se(email != emailcadastro){
            escreva("Email incorreto. Tente novamente\n")
          }
        } enquanto(email != emailcadastro)

        faca{
          escreva("Digite sua senha: ")
          leia(senha)
          se(senha != senhacadastro){
            escreva("Você digitou a senha errada. Tente novamente\n")
          }
        } enquanto(senha != senhacadastro)

        escreva("Login realizado com sucesso!\n")
        escreva("Bem-vindo, ", nomecadastro, "\n")
      }
    }
  }
}