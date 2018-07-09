jogoAdventure


Programação Orientada a Objetos
Professores: Bernardo Copstein 

Trabalho Final 2018/1

Título: 
Criação de um jogo tipo “Adventure”

Objetivos:
Desenvolver um jogo tipo “Adventure” a partir de um conjunto de classes fornecido pelo professor.
Explorar os conceitos de programação orientada a objetos desenvolvidos ao longo do semestre com destaque para o desenvolvimento de aplicações por derivação a partir de um framework.
Trabalhar os conceitos de reuso por herança, polimorfismo e explorar o uso da APIs de coleções disponíveis na linguagem Java conjuntamente com funções lambda.

Contextualização:
Um jogo de “Adventure” é um jogo onde o jogador controla um personagem que percorre um labirinto ou mundo imaginário buscando desvendar um enigma.
Neste trabalho deverá ser desenvolvido um jogo tipo “Adventure” simplificado. O labirinto será construído como um conjunto de salas interligadas umas as outras por portas (cada sala pode ter tantas portas quanto necessário). 
Cada sala deverá ter uma representação visual (imagem) e uma descrição textual associadas. Toda a vez que o personagem entra em uma sala tanto a imagem como a descrição textual são exibidas. O jogador poderá solicitar uma lista das ferramentas disponíveis na sala e optar ou não por recolher estas ferramentas. Toda ferramenta recolhida é guardada em sua mochila. Também deve ser possível listar os objetos disponíveis na sala. Os objetos podem sofrer ação de certas ferramentas. Cabe ao usuário optar por usar ou não as ferramentas sobre os objetos. Na medida que as ferramentas são usadas sobre os objetos da forma correta os objetos pode se modificar ou novos objetos e ferramentas podem surgir de maneira a ajudar o personagem a descobrir o mistério. 
O jogador através de seu personagem permanece percorrendo as diferentes salas do jogo até descobrir a solução do mistério. Só então o jogo acaba.

Classes disponibilizadas
Para o desenvolvimento deste trabalho é disponibilizado um projeto “Eclipse” com dois conjuntos de classes: um conjunto de classes básicas a partir das quais deve ser derivado o jogo que será desenvolvido. A qualidade da modelagem a partir destas classes básicas será considerada na avaliação do trabalho. O segundo conjunto de classes é um exemplo de jogo simples. Esta versão simplificada em modo texto serve apenas para oferecer uma ideia inicial de como as classes básicas fornecidas podem ser usadas para o desenvolvimento do trabalho.

Requisitos mínimos
O jogo apresentado deverá ter seu labirinto composto por no mínimo 5 salas onde devem estar distribuídos pelo menos 3 objetos e 3 ferramentas diferentes. Todas as salas, objetos e ferramentas devem ter de ser usados em algum momento de maneira a levar a conclusão da história. Os objetos e salas do exemplo fornecido pelo professor não podem ser reusados (apenas as classes básicas que são obrigatórias).

A interface com o usuário deverá ser gráfica sendo desenvolvida em JavaFX. Para cada sala do labirinto deve existir, pelo menos, uma representação visual.

Deve ser possível interromper o jogo a qualquer tempo e restaurar seu estado mais tarde. Um arquivo texto deve ser usado para tanto.

A criatividade da história, a qualidade da interface com o usuário, a modelagem das classes/arquitetura do sistema, o uso da API de coleções e o respeito as boas práticas de programação serão igualmente avaliados.



Entregáveis
Diagrama de classes;
Código fonte do sistema com instruções de compilação, configuração e execução;
Executável do sistema (capaz de executar fora do ambiente de um IDE);
Instruções de uso do jogo;
Orientações sobre como fazer para solucionar o enigma e encerrar o jogo.

Outras Informações
O trabalho deve ser feito em grupos de até 4 alunos ou individualmente até a data especificada.
Cada aluno ou grupo deverá entregar no Moodle um arquivo zip contendo todos os entregáveis listados anteriormente. Deve ser feito o upload deste arquivo na tarefa indicada para isto no Moodle até a data e horário especificados.
Os trabalhos deverão ser apresentados em sala de aula para os demais colegas. A apresentação deverá tratar dos seguintes tópicos:
Tema proposto
Desafio a ser vencido (no jogo)
Demonstração do jogo
Apresentação da arquitetura do sistema, diagrama de classes, estruturas utilizadas
Resumo dos desafios enfrentados para conseguir finalizar o trabalho
Os trabalhos não podem apresentar erros de compilação e as soluções de cada aluno ou grupo devem ser originais.




