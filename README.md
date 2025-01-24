<h1>Manipulando arquivos e pastas com Java</h1>
Fazer um programa para ler o caminho de umarquivo .csv contendo os dados de itens vendidos. Cada item possui um nome, preço unitário e quantidade, separados por vírgula.Você deve gerar um novo arquivo chamado "summary.csv", localizado em uma subpasta chamada "out" a partir da pasta original do arquivo de origem, contendo apenas o nome e o valor total para aquele item (preço unitário multiplicado pela quantidade), conforme exemplo.
 Source file:
 TV LED, 1290.99, 1
 Video Game Chair, 350.50, 3
 Iphone X, 900.00, 2
 Samsung Galaxy 9, 850.00, 2

 Output file (out/summary.csv):
 TV LED, 1290.99
 VideoGame Chair, 1051.50
 Iphone X, 1800.00
 Samsung Galaxy9, 1700.00

 Usei uma lógica bem fácil pra chegar no resultado final. O arquivo de leitura de entrada.csv eu criei pelo  eclipse usando vetores, depois eu mandei o programa ler esse arquivo e gerar o arquivo de saída.csv dentro de uma subpasta no mesmo local onde está o arquivo de origem como manda o exercício
