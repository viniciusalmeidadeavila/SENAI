// Membros do grupo: Vinicius Almeida, Marllon Italo, Nicolas
programa {
  funcao menuMoedaConversao(){
    escreva("Para qual moeda deseja fazer a conversão?\n")
    escreva("1-Dolar\n")
    escreva("2-Euro\n")
    escreva("3-Libra\n")
  }
  funcao inicio() {
    inteiro op, sequerconverter, sequersacar, valorestanteaposconversao
    real valorc, saque, saldoconta, conversao, dolar=5.45, euro=6.36, libra=7.33, valordolar, valorsaldo, saldorest
    escreva("=======BANCO DIGITAL========\n")
    escreva ("Digite o valor do depsosito: \n")
    leia(saldoconta)
    escreva ("O que você deseja fazer? \n")
    escreva ("1-Conversão Simples\n")
    escreva ("2-Saque\n")
    escreva ("3-Conversão + saldo final\n")
    escreva ("4-Conversão e saque condicional\n")
    leia(op)
    se(op == 1){
      menuMoedaConversao()
      leia(conversao)
      se (conversao==1){
        escreva("O valor da conversão é: " +saldoconta/dolar)
      }
      se (conversao==2){
        escreva("O valor da conversão é: " +saldoconta/euro)
      }
      se (conversao==3){
        escreva("O valor da conversão é:" +saldoconta/libra)
      }
    }
    se(op==2){
    escreva("Qual valor você deseja sacar: \n")
    escreva("R$ ")
    leia(saque)
    se(saque>saldoconta)
    escreva("OPERAÇÃO INVALIDA")
    senao {
      valorc= saldoconta-saque
      escreva("Voce sacou: R$" +saque +"\n")
      escreva("O valor da sua conta agora é: R$"+valorc+"\n")
      escreva("Você deseja converter o dinheiro que sobrou na sua conta? (1=SIM,2=NÃO)\n")
      leia(sequerconverter)
      se(sequerconverter==1){
        menuMoedaConversao()
        leia(conversao)
        se (conversao==1){
        saldorest = saque - valorc
        escreva("\n")
        escreva("Quantos reais você deseja converter?\n")
        leia(sequerconverter)
        se(sequerconverter > valorc){
          escreva("Não é possivel converter um valor maior que você tem na conta")
        }
        senao{
          saldorest = sequerconverter/dolar
          valorestanteaposconversao = valorc - sequerconverter
          escreva("Você converteu R$"+sequerconverter+" para "+saldorest+" dolares\n")
          escreva("Você tem R$"+valorestanteaposconversao+" na conta")
        }
        }
        senao se (conversao==2){
          saldorest = saque - valorc
          escreva("\n")
          escreva("Quantos reais você deseja converter?\n")
          leia(sequerconverter)
          se(sequerconverter > valorc){
            escreva("Não é possivel converter um valor maior que você tem na conta")
          }
          senao{
            saldorest = sequerconverter/euro
            valorestanteaposconversao = valorc - sequerconverter
            escreva("Você converteu R$"+sequerconverter+" para "+saldorest+" euros\n")
            escreva("Você tem R$"+valorestanteaposconversao+" na conta")
          }
        }
        senao se (conversao==3){
          saldorest = saque - valorc
          escreva("\n")
          escreva("Quantos reais você deseja converter?\n")
          leia(sequerconverter)
          se(sequerconverter > valorc){
            escreva("Não é possivel converter um valor maior que você tem na conta")
          }
          senao{
            saldorest = sequerconverter/libra
            valorestanteaposconversao = valorc - sequerconverter
            escreva("Você converteu R$"+sequerconverter+" para "+saldorest+" libras\n")
            escreva("Você tem R$"+valorestanteaposconversao+" na conta")
          }
        }
      }
      se(sequerconverter==2){
        inicio()
      }
    }
    }
    se(op==3){
      escreva("Qual valor deseja converter?\n")
      escreva("R$ ")
      leia(valorsaldo)
      menuMoedaConversao()
      leia(conversao)
      se (conversao==1){
        saldorest=saldoconta-valorsaldo
        escreva("O valor convertido em dolar é: " +valorsaldo/dolar)
        escreva("\n")
        escreva("O valor que sobrou na sua conta em reais é: R$"  +saldorest)
      }
      senao se (conversao==2){
        saldorest=saldoconta-valorsaldo
        escreva("O valor convertido em euro é: " +valorsaldo/euro)
        escreva("\n")
        escreva("O valor que sobrou na sua conta em reais é: R$"  +saldorest)
      }
      senao se (conversao==3){
        saldorest=saldoconta-valorsaldo
        escreva("O valor convertido em libra é:" +valorsaldo/libra)
        escreva("\n")
        escreva("O valor que sobrou na sua conta em reais é: R$"  +saldorest)
      }
      }
      se(op==4){
        escreva("Você quer converter seu dinheiro? (1=SIM, 2=NÃO)\n")
        leia(sequerconverter)
        se(sequerconverter == 1){
            menuMoedaConversao()
            leia(conversao)
            se (conversao==1){
              escreva("Qual o valor que você deseja converter?\n")
              escreva("R$ ")
              leia(valorsaldo)
              se(valorsaldo > saldoconta){
                escreva("Você não pode converter um valor maior do que tem na sua conta\n")
              }
              senao {
                  escreva("O valor convetido em dolar é: "+valorsaldo/dolar+"\n")
                  escreva("Você deseja sacar este valor em dolar? (1=SIM, 2=NÃO)\n")
                  leia(sequersacar)
                  saldorest=saldoconta-valorsaldo
                  se(sequersacar == 1){
                    escreva("Você sacou "+valorsaldo/dolar+" dolares\n")
                    escreva("O valor que sobrou na sua conta é: R$"+saldorest)
                  }
                  se(sequersacar == 2){
                    escreva("Seu saldo em reais é: R$"+saldorest+"\n")
                    escreva("Seu saldo em dolar é: "+valorsaldo/dolar+"\n")
                }
              }
            }
            se (conversao==2){
              escreva("Qual o valor que você deseja converter?\n")
              escreva("R$ ")
              leia(valorsaldo)
              se(valorsaldo > saldoconta){
                escreva("Você não pode converter um valor maior do que tem na sua conta\n")
              }
              senao {
                  escreva("O valor convetido em euro é: "+valorsaldo/euro+"\n")
                  escreva("Você deseja sacar este valor em euro? (1=SIM, 2=NÃO)\n")
                  leia(sequersacar)
                  saldorest=saldoconta-valorsaldo
                  se(sequersacar == 1){
                    escreva("Você sacou "+valorsaldo/euro+" euros\n")
                    escreva("O valor que sobrou na sua conta é: R$"+saldorest)
                  }
                  se(sequersacar == 2){
                    escreva("Seu saldo em reais é: R$"+saldorest+"\n")
                    escreva("Seu saldo em euro é: "+valorsaldo/euro+"\n")
                }
              }
            }
            se (conversao==3){
              escreva("Qual o valor que você deseja converter?\n")
              escreva("R$ ")
              leia(valorsaldo)
              se(valorsaldo > saldoconta){
                escreva("Você não pode converter um valor maior do que tem na sua conta\n")
              }
              senao {
                  escreva("O valor convetido em libras é: "+valorsaldo/libra+"\n")
                  escreva("Você deseja sacar este valor em libra? (1=SIM, 2=NÃO)\n")
                  leia(sequersacar)
                  saldorest=saldoconta-valorsaldo
                  se(sequersacar == 1){
                    escreva("Você sacou "+valorsaldo/libra+" libras\n")
                    escreva("O valor que sobrou na sua conta é: R$"+saldorest)
                  }
                  se(sequersacar == 2){
                    escreva("Seu saldo em reais é: R$"+saldorest+"\n")
                    escreva("Seu saldo em libras é: "+valorsaldo/libra+"\n")
                }
              }
            }
          }
          senao se(sequerconverter == 2){
            inicio()
          }
        }
    }
  }