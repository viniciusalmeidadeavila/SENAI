// Grupo: Vinicius Almeida, Marllon, Italo


programa {
  inclua biblioteca Texto --> texto
  funcao inicio() {
    cadeia senha
    inteiro quantidade_caracteres, posicao = 0, indice = 1
    logico temnumero
    caracter caracteratual
    faca{
      escreva("Informe sua senha\n")
      leia(senha)
      quantidade_caracteres = texto.numero_caracteres(senha)
      enquanto(indice <= quantidade_caracteres - 1){
        caracteratual = texto.obter_caracter(senha, indice)
        se(caracteratual >= 0 ou caracteratual <= 9){
          temnumero = verdadeiro
        }
        senao{
          temnumero = falso
        }
        indice++
      }
    se(quantidade_caracteres < 6){
      escreva("Senha muito curta, tente novamente\n")
    }
    }enquanto(quantidade_caracteres < 6)
    se(temnumero == verdadeiro){
      escreva("Senha cadastrada com sucesso!\n")
    }
    senao{
      escreva("Ausência de números, tente novamente\n")
      inicio()
    }
   }  
}
