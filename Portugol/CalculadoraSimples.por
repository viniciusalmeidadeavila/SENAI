/* 
De: Vinicius Almeida de Avila

Este é um código de uma calculadora simples feito em portugol para estudo de Lógica de Programação
*/

programa {
  inclua biblioteca Matematica --> MAT
  funcao inicio() {
    real soma, subtracao, divisao, multiplica,modulo,raiz,potencia,num1, num2, valorEntrada, resultadoRaiz
    inteiro op
    escreva("-------------CALCULADORA-----------------\n")
    escreva("1 =--(+)---- SOMA ---\n")
    escreva("2 =--(-)---- SUBTRACÃO---\n")
    escreva("3 =--(*)---- MULTIPLICAÇÃO---\n")
    escreva("4 =--(/)---- DIVISÂO---\n")
    escreva("5 =--(%)---- MODULO---\n")
    escreva("6 =--(Raiz Quadrada)---- RAIZ QUADRADA---\n")
    escreva("7 =--(Potência)---- POTÊNCIA---\n")
    escreva("8 =--(Raiz Cúbica)---- RAIZ CÚBICA---\n")
    escreva("9 =--------- SAIR DO PROGRAMA---\n")
    escreva("-----------------------------------------\n")
    escreva("Qual operação você quer fazer?\n")
    leia(op)
    se(op == 1){
      escreva("Digite o primeiro valor\n")
      leia(num1)
      escreva("Digite o segundo valor\n")
      leia(num2)
      soma = num1 + num2
      escreva("A soma de "+num1+" por "+num2+" é: "+soma, "\n\n")
      escreva("\n")
      inicio()
    }
    se(op == 2){
      escreva("Digite o primeiro valor\n")
      leia(num1)
      escreva("Digite o segundo valor\n")
      leia(num2)
      subtracao = num1 - num2
      escreva("A subtração de "+num1+" por "+num2+" é: "+subtracao, "\n\n")
      escreva("\n")
      inicio()
    }
    se(op == 3){
      escreva("Digite o primeiro valor\n")
      leia(num1)
      escreva("Digite o segundo valor\n")
      leia(num2)
      multiplica = num1 * num2
      escreva("A multiplicação de "+num1+" por "+num2+" é: "+multiplica, "\n\n")
      escreva("\n")
      inicio()
    }
    se(op == 4){
      escreva("Digite o primeiro valor\n")
      leia(num1)
      escreva("Digite o segundo valor\n")
      leia(num2)
      divisao = num1 / num2
      escreva("A divisão de "+num1+" por "+num2+" é: "+divisao, "\n\n")
      escreva("\n")
      inicio()
    }
    se(op == 5){
      escreva("Digite o primeiro valor\n")
      leia(num1)
      escreva("Digite o segundo valor\n")
      leia(num2)
      modulo = num1 % num2
      escreva("O módulo de "+num1+" por "+num2+" é: "+modulo, "\n\n")
      escreva("\n")
      inicio()
    }
    se(op == 6){
      escreva("Qual número você deseja calcular a raiz quadrada?\n")
      leia(raiz)
      resultadoRaiz = MAT.raiz(raiz, 2)
      escreva("A raiz quadrada de "+raiz+" é: "+resultadoRaiz)
      escreva(num1)
      escreva("\n")
      inicio()
    }
    se(op == 7){
      potencia = MAT.potencia(num1,num2)
      escreva("A potência de "+num1+" por "+num2+" é: "+potencia, "\n\n")
      escreva("\n")
      inicio()
    }
    se(op == 8){
      escreva("Qual número você deseja calcular a raiz cúbica?\n")
      leia(raiz)
      resultadoRaiz = MAT.raiz(raiz, 3)
      escreva("A raiz cúbica de "+raiz+" é: "+resultadoRaiz)
      inicio()
    }
    se(op == 9){
      escreva("FIM DO PROGRAMA")
    }
    se(op > 9 ou op <1){
      escreva("OPÇÃO INVÁLIDA, TENTE NOVAMENTE\n")
      inicio()
    }
  }
}